package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.DashboardPageUI;

public class DashboardPageObject extends BasePage {
    private WebDriver driver;
    //hàm khởi tạo Contructor method
    // Map driver từ test class qua bên page object class
    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToPIMModule() {
        waitElementClickable(driver, DashboardPageUI.PIM_MODULE);
        clickToElement(driver, DashboardPageUI.PIM_MODULE);
    }
}
