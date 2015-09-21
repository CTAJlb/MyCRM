package ui_Layer.blocks;

import core.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Libe on 20.09.2015.
 */
public class UserPage extends PageFactorySettings {

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

//    Section profile
    /** DDL profile */
    @FindBy(css = ".dropdown-toggle.crm-user-color")
    private WebElement profileDDL;

    @FindBy(xpath = "//a[text()='Sign out']")
    private WebElement signOut;

    

    public UserPage logout() {
        wait.until(ExpectedConditions.visibilityOf(profileDDL));
        profileDDL.click();
        wait.until(ExpectedConditions.visibilityOf(signOut));
        signOut.click();
        return new UserPage();
    }
}
