package pageObjects.orangeHrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHrm.editNavigation.PersonalDetailPageObject;
import pageUIs.orangehrm.AddEmployeePageUI;

public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;
    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.FIRST_NAME_TEXTBOX, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX);
        sendkeyToElement(driver, AddEmployeePageUI.LAST_NAME_TEXTBOX, lastName);
    }

    public String getEmployeeID() {
        waitElementVisible(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver, AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX, "value");
    }

    public PersonalDetailPageObject clickToSaveButton() {
        waitElementClickable(driver, AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver, AddEmployeePageUI.SAVE_BUTTON);
        waitListElementInvisible(driver, AddEmployeePageUI.SPINNER_ICON);
        return PageGenerator.getPage(PersonalDetailPageObject.class, driver);
    }
}
