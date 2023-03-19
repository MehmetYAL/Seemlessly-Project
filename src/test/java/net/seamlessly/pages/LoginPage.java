package net.seamlessly.pages;

import net.seamlessly.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    public void login(String username, String password) {
        userName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

@FindBy(css = "p.warning.wrongPasswordMsg")
    public WebElement wrongPassword;

    @FindBy(xpath = "//a[@class='toggle-password']")
    public WebElement toggleButton;

    @FindBy(id="lost-password")
    public WebElement forgotPassword;

    @FindBy(xpath = "//input[@id='reset-password-submit']")
    public WebElement resetPassword;

}
