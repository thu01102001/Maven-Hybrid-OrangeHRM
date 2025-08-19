package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminCustomerPageUI;

public class AdminCustomerPO extends BasePage {
    WebDriver driver;
    public AdminCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminLoginPO clickToLogoutLink() {
        waitElementClickable(driver, AdminCustomerPageUI.LOGOUT_LINK);
        clickToElement(driver, AdminCustomerPageUI.LOGOUT_LINK);
        return PageGenerator.getPage(AdminLoginPO.class, driver);
    }
}
