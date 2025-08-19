package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUsername(String userName) {
        waitElementClickable(driver, AdminLoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXTBOX, userName);
    }

    public void enterToPassword(String password) {
        waitElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminDashboardPO clickToLoginButton() {
        waitElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(AdminDashboardPO.class, driver);
    }
}
