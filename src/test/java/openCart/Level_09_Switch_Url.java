package openCart;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserRegisterPO;
import pageUIs.openCart.user.UserHomePageUI;
import pageUIs.openCart.user.UserLoginPageUI;
import pageUIs.openCart.user.UserRegisterPageUI;

public class Level_09_Switch_Url extends BaseTest {
    private WebDriver driver;
    private String userUrl, adminUrl;
    String adminUsername, adminPassword;
    String userFirstName, userLastName, userEmailAddress, userPassword;


    @Parameters({"userUrl", "adminUrl", "browser"})
    @BeforeClass
    public void BeforeClass(String userUrl, String adminUrl, String browserName) {
        this.userUrl = userUrl;
        this.adminUrl = adminUrl;

        //Mo browser len se la trang user
        driver = getBrowserNameDriver(userUrl, browserName);

        userHomePage = PageGenerator.getPage(UserHomePO.class, driver);

        adminUsername = "automationfc";
        adminPassword = "Auto222$$$";
        userFirstName = "Duy";
        userLastName = "Khanh";
        userEmailAddress = "khanh@gmail.com";
        userPassword = "123456";
    }

    @Test
    public void OpenCart_01() {
        userLoginPage = userHomePage.clickToMyAccount();

        userRegisterPage = userLoginPage.clickToContinueButton();

        userRegisterPage.enterToFirstName(userFirstName);
        userRegisterPage.enterToLastName(userLastName);
        userRegisterPage.enterToEmailAddress(userEmailAddress);
        userRegisterPage.enterToPassword(userPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButton();

        userHomePage = userLoginPage.clickToLogoutUserSite(driver);

        adminLoginPage = userRegisterPage.openAdminSite(driver, adminUrl);

        adminLoginPage.enterToUsername(adminUsername);
        adminLoginPage.enterToPassword(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        adminCustomerPage = adminDashboardPage.openCustomerPage();
        adminLoginPage = adminCustomerPage.clickToLogoutAdminSite(driver);

        userHomePage = adminLoginPage.openUserSite(driver, userUrl);
    }

    @Test
    public void Employee_02_Page_Navigator() {
    }


    @AfterClass
    public void AfterClass() {
        closeBrowser();
    }

    private AdminLoginPO adminLoginPage;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
}
