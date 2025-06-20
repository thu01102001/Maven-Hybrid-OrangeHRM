package pageUIs;

public class AddEmployeePageUI {
    private static final String FIRST_NAME_TEXTBOX = "//input[@name= 'firstName']";
    private static final String LAST_NAME_TEXTBOX = "//input[@name= 'lastName']";
    private static final String EMPLOYEE_ID_TEXTBOX = "//label[text() = 'Employee Id']/parent::div/following-sibling::div/input";
    private static final String SAVE_BUTTON = "//button[contains(string(), 'Save')]";
}
