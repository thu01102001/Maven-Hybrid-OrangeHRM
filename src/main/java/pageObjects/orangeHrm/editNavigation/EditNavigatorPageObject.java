package pageObjects.orangeHrm.editNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangehrm.editNavigation.EditNavigatorPageUI;

public class EditNavigatorPageObject extends BasePage {
    WebDriver driver;

    public EditNavigatorPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public JobPageObject openJobPage() {
        waitElementClickable(driver, EditNavigatorPageUI.JOB_LINK);
        clickToElement(driver, EditNavigatorPageUI.JOB_LINK);
        return PageGenerator.getPage(JobPageObject.class, driver);
    }

    public PersonalDetailPageObject openPersonalPage() {
        waitElementClickable(driver, EditNavigatorPageUI.PERSONAL_DETAILLINK);
        clickToElement(driver, EditNavigatorPageUI.PERSONAL_DETAILLINK);
        return PageGenerator.getPage(PersonalDetailPageObject.class, driver);
    }

    public DependentsPageObject openDependentPage() {
        waitElementClickable(driver, EditNavigatorPageUI.DEPENDENTS_LINK);
        clickToElement(driver, EditNavigatorPageUI.DEPENDENTS_LINK);
        return PageGenerator.getPage(DependentsPageObject.class, driver);
    }

    public ContactDetailPageObject openContactDetailPage() {
        waitElementClickable(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        clickToElement(driver, EditNavigatorPageUI.CONTACT_DETAIL_LINK);
        return PageGenerator.getPage(ContactDetailPageObject.class, driver);
    }
}
