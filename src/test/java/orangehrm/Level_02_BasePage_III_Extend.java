package orangehrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Level_02_BasePage_III_Extend extends BasePage{
    private WebDriver driver;
    private String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @BeforeClass
    public void BeforeClass() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void Login_01_Empty() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "");
        sendkeyToElement(driver, "//input[@name='password']", "");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(getElementText(driver, "//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void Login_02_Invalid_Username() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "thu@gmail.com");
        sendkeyToElement(driver, "//input[@name='password']", "123456");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_03_Invalid_Password() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "admin123$%^&*");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//p[contains(@class, 'oxd-alert-content-text')]"), "Invalid credentials");
    }

    @Test
    public void Login_04_Valid_user_Password() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver, "//button[contains(@class, 'orangehrm-login-button')]");

        Assert.assertTrue(isAllLoadingSpinnerInvisible());

        Assert.assertEquals(getElementText(driver, "//div[@class='oxd-topbar-header-title']//h6"), "Dashboard");
    }

    public boolean isAllLoadingSpinnerInvisible() {
        return waitListElementInvisible(driver, "//div[@class = 'oxd-loading-spinne']");
    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

}
