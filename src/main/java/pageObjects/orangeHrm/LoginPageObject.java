package pageObjects.orangeHrm;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangehrm.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;
    //hàm khởi tạo Contructor method
    // Map driver từ test class qua bên page object class
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Sẽ đc chạy đầu tiên khi class này đc gọi tới
    // Nếu ko viết hàm khởi tạo thì trình biên dịch sẽ tạo ra cho class này  1 hàm khởi tạo rỗng
    // Nếu viết thì nó sẽ dùng hàm do mình define (user define)
    // Dùng tên với tên class chứa nó
    // Ko có giá trị trả về
    /// Có 1 hoặc nhiều tham số / có 1 hoặc nhiều hàm khởi tạo
    // Thể hiện cho tính chất đa hình trong OOP

    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver, LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX, username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(DashboardPageObject.class, driver);
    }
}
