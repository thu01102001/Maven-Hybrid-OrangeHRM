package pageObjects.orangeHrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangehrm.DashboardPageUI;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;
    //hàm khởi tạo Contructor method
    // Map driver từ test class qua bên page object class
    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public EmployeeListPageObject clickToPIMModule() {
        waitElementClickable(driver, DashboardPageUI.PIM_MODULE);
        clickToElement(driver, DashboardPageUI.PIM_MODULE);
        return PageGenerator.getPage(EmployeeListPageObject.class, driver);
    }
}
