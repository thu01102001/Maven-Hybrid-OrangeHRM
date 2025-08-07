package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageFactory.*;


public class Login_05_Page_Factory extends BaseTest {
    private WebDriver driver;
    private String appUrl;
    String adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void BeforeClass(String appUrl, String browserName) {
        this.appUrl = appUrl;
        driver = getBrowserNameDriver(appUrl, browserName);

        loginPage = new LoginPageObject(driver);
        adminUsername = "automationfc";
        adminPassword = "Auto222$$$";
        employeeFirstName = "Nguyen";
        employeeLastName = "Thu";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);

        loginPage.clickToLoginButton();
        dashboardPage = new DashboardPageObject(driver);
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear());

        dashboardPage.clickToPIMModule();
        employeeListPage = new EmployeeListPageObject(driver);
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear());

        employeeListPage.clickToAddEmployeeButton();
        addEmployeePage = new AddEmployeePageObject(driver);
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear());

        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();

        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear());

        personalDetailPage = new PersonalDetailPageObject(driver);
        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear());

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), employeeLastName);
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
        closeBrowser();
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private AddEmployeePageObject addEmployeePage;
    private String employeeID;

}
