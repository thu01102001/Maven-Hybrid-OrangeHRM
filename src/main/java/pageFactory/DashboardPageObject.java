package pageFactory;

import core.BasePage;
import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageUIs.DashboardPageUI;

import java.util.List;

public class DashboardPageObject extends BasePageFactory {
    private WebDriver driver;
    //hàm khởi tạo Contructor method
    // Map driver từ test class qua bên page object class

    @CacheLookup
    @FindBy(xpath = "//span[text() = 'PIM']/parent::a")
    private WebElement pimModule;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public DashboardPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToPIMModule() {
        waitElementClickable(driver, pimModule);
        clickToElement(driver, pimModule);
    }

    public boolean isLoadingSpinnerDisappear() {
        return waitListElementInvisible(driver, loadingSpinner);
    }
}
