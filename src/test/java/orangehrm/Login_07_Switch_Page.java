package orangehrm;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class Login_07_Switch_Page extends BaseTest {
    private WebDriver driver;
    private String appUrl;
    String adminUsername, adminPassword, employeeFirstName, employeeLastName;

    @Parameters({"appUrl", "browser"})
    @BeforeClass
    public void BeforeClass(String appUrl, String browserName) {
        this.appUrl = appUrl;
        driver = getBrowserNameDriver(appUrl, browserName);

        loginPage = PageGeneratorGeneric.getPage(LoginPageObject.class, driver);
        adminUsername = "automationfc";
        adminPassword = "Auto222$$$";
        employeeFirstName = "Nguyen";
        employeeLastName = "Thu";
    }

    @Test
    public void Employee_01_CreateNewEmployee() {
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);

        dashboardPage = loginPage.clickToLoginButton();
        Assert.assertTrue(dashboardPage.isLoadingSpinnerDisappear(driver));

        employeeListPage = dashboardPage.clickToPIMModule();
        Assert.assertTrue(employeeListPage.isLoadingSpinnerDisappear(driver));

        addEmployeePage = employeeListPage.clickToAddEmployeeButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        addEmployeePage.enterToFirstNameTextbox(employeeFirstName);
        addEmployeePage.enterToLastNameTextbox(employeeLastName);
        employeeID = addEmployeePage.getEmployeeID();

        personalDetailPage = addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isLoadingSpinnerDisappear(driver));

        Assert.assertTrue(personalDetailPage.isLoadingSpinnerDisappear(driver));
        personalDetailPage.sleepInSecond(2);

        Assert.assertEquals(personalDetailPage.getFirstNameTextboxValue(), employeeFirstName);
        Assert.assertEquals(personalDetailPage.getLastNameTextboxValue(), employeeLastName);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(), employeeID);
    }

    @Test
    public void Employee_02_Switch_Page() {
        //Personal > Contact
        contactDetailPage = personalDetailPage.openContactDetailPage(driver);

        //Contact > Job
        jobPage = contactDetailPage.openJobPage(driver);

        //Job > Dependent
        dependentsPage = jobPage.openDependentPage(driver);

        //Dependent > Personal
        personalDetailPage = dependentsPage.openPersonalPage(driver);

        //Personal > Job
        jobPage = personalDetailPage.openJobPage(driver);
    }


    @AfterClass
    public void AfterClass() {
        closeBrowser();
    }

    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private PersonalDetailPageObject personalDetailPage;
    private AddEmployeePageObject addEmployeePage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentsPage;
    private String employeeID;
}
