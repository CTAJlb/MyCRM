package ui_Layer.blocks;

import core.BaseTest;
import core.Config;
import core.Driver;
import javafx.beans.value.WeakChangeListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by Libe on 20.09.2015.
 */
public class HomePage extends PageFactorySettings {

    private WebDriverWait wait = new WebDriverWait(Driver.get(), 10);

    @FindBy(xpath = "//img[@alt='Logo']")
    private WebElement logoTypeCRM;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitAuth;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement erroAuthMessage;





    public void openHomePage() {
        Driver.get().get(Config.getProperty("test.baseURL"));
        Assert.assertTrue(logoTypeCRM.isDisplayed());
    }

    public HomePage authorization(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(emailField));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitAuth.click();
        return new HomePage();
    }

    public void checkErrorAuth(String expMessage) {
        Assert.assertEquals(erroAuthMessage.getText(), expMessage, "Message is not display");
    }
}
