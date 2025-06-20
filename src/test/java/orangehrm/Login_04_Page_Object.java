package orangehrm;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageUIs.DashboardPageUI;
import pageUIs.EmployeeListPageUI;

public class Login_04_Page_Object extends BaseTest {
    private WebDriver driver;
    private String appUrl;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void BeforeClass(String appUrl, String browserName) {
        this.appUrl = appUrl;
        driver = getBrowserNameDriver(appUrl, browserName);

        loginPage = new LoginPageObject();
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        loginPage.enterToUsernameTextbox("Admin");
        loginPage.enterToPasswordTextbox("admin123");
        loginPage.clickToLoginButton();

        dashboardPage = new DashboardPageObject();
        dashboardPage.clickToPIMModule();

        employeeListPage = new EmployeeListPageObject();
        employeeListPage.clickToAddEmployeeButton();

        addEmployeePage = new AddEmployeePageObject();
        addEmployeePage.enterToFirstNameTextbox("");
        addEmployeePage.enterToLastNameTextbox("");
        employeeID = addEmployeePage.getEmployeeID();
        addEmployeePage.clickToSaveButton();

        personalDetailPage = new PersonalDetailPageObject();
        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), "");
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), "");
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_EditEmployee() {

    }


//    public boolean isAllLoadingSpinnerInvisible() {
//        return basePage.waitListElementInvisible(driver, "//div[@class = 'oxd-loading-spinne']");
//    }

    @AfterClass
    public void AfterClass() {
        driver.quit();
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private AddEmployeePageObject addEmployeePage;
    private String employeeID;

}
