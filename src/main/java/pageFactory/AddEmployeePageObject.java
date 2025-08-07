package pageFactory;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.AddEmployeePageUI;

import java.util.List;

public class AddEmployeePageObject extends BasePageFactory {
    private WebDriver driver;

    @CacheLookup
    @FindBy(xpath = "//input[@name= 'firstName']")
    private WebElement firstNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//input[@name= 'lastName']")
    private WebElement lastNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//label[text() = 'Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIDTextbox;

    @CacheLookup
    @FindBy(xpath = "//button[contains(string(), 'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToFirstNameTextbox(String firstName) {
        waitElementVisible(driver, firstNameTextbox);
        sendkeyToElement(driver, firstNameTextbox, firstName);
    }

    public void enterToLastNameTextbox(String lastName) {
        waitElementVisible(driver, lastNameTextbox);
        sendkeyToElement(driver, lastNameTextbox, lastName);
    }

    public String getEmployeeID() {
        waitElementVisible(driver, employeeIDTextbox);
        return getElementDomProperty(driver, employeeIDTextbox, "value");
    }

    public void clickToSaveButton() {
        waitElementClickable(driver, saveButton);
        clickToElement(driver, saveButton);
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
