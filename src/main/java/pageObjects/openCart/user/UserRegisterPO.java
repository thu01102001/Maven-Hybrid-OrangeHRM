package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminLoginPO;
import pageUIs.openCart.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;
    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstName(String firstName) {
        waitElementClickable(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastName(String lastName) {
        waitElementClickable(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public void enterToEmailAddress(String emailAddress) {
        waitElementClickable(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void enterToPassword(String password) {
        waitElementClickable(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void acceptPrivacyCheckbox() {
        waitElementClickable(driver, UserRegisterPageUI.PRIVACY_POLICY_BUTTON);
        clickToElement(driver, UserRegisterPageUI.PRIVACY_POLICY_BUTTON);
    }


    public void clickContinueButton() {
        waitElementClickable(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
    }

}
