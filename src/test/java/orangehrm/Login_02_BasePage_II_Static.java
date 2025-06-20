package orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_02_BasePage_II_Static {
    private WebDriver driver;
    private BasePage basePage;
    private String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();
        basePage = BasePage.getInstance();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
