package orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private String appUrl;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void BeforeClass(String appUrl, String browserName) {
        this.appUrl = appUrl;
        basePage = BasePage.getInstance();
        driver = getBrowserNameDriver(appUrl, browserName);

    }

    @Test
    public void Login_01_Empty() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "");
        basePage.clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver, "//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver, "//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "thu@gmail.com");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "123456");
        basePage.clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver, "//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "admin123$%^&*");
        basePage.clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver, "//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_user_Password() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "admin123");
        basePage.clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        Assert.assertEquals(basePage.getElementText(driver, "//div[@class='oxd-topbar-header-title']//h6"), "Dashboard");
    }

    public boolean isAllLoadingSpinnerInvisible() {
        return basePage.waitListElementInvisible(driver, "//div[@class = 'oxd-loading-spinne']");
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

}
