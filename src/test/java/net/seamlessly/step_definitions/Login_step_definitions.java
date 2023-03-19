package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.LoginPage;
import net.seamlessly.utility.BrowserUtils;
import net.seamlessly.utility.ConfigurationReader;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Login_step_definitions {
    LoginPage loginPage=new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
    }
    @When("user can write valid username")
    public void user_can_write_valid_username() {
        loginPage.userName.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("user can write valid password")
    public void user_can_write_valid_password() {
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("user can click login button")
    public void user_can_click_login_button() {
        loginPage.loginButton.click();
    }
    @Then("user can see dashboard")
    public void user_can_see_dashboard() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }

    @And("user can press enter")
    public void userCanPressEnter() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }

    @When("user write invalid username {string}")
    public void user_write_invalid_username(String username) {
        loginPage.userName.sendKeys(username);
    }
    @When("user write invalid password {string}")
    public void user_write_invalid_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("user should see {string}")
    public void user_should_see(String string) {
Assert.assertEquals(loginPage.wrongPassword.getText(),string);
    }


    @Then("user should see warning message if username or password is empty warning message")
    public void userShouldSeeWarningMessageIfUsernameOrPasswordIsEmpty() {
        if (loginPage.userName.getAttribute("value").isEmpty()){
            Assert.assertEquals(loginPage.userName.getAttribute("validationMessaage"),"Please fill out this field.");
        }if (loginPage.inputPassword.getAttribute("value").isEmpty()){
            BrowserUtils.waitFor(3);
            Assert.assertEquals(loginPage.inputPassword.getAttribute("validationMessage"),"Please fill out this field.");

        }
    }

    @Then("user see the password in a form of dots by default")
    public void userSeeThePasswordInAFormOfDotsByDefault() {
       if( loginPage.inputPassword.getAttribute("type").equals("password")){
           Assert.assertEquals(loginPage.inputPassword.getAttribute("value"),"Employee123");
       }
    }

    @And("user click the toggle button")
    public void userClickTheToggleButton() {
        loginPage.toggleButton.click();
    }

    @Then("user see the password explictly")
    public void userSeeThePasswordExplictly() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("value"),"Employee123");
    }

    @When("user should see the {string} link")
    public void userShouldSeeTheLink(String string) {

        String expectedText="Forgot password?";
        String actualText=loginPage.forgotPassword.getText();
        //System.out.println(actualText);
        Assert.assertEquals(actualText,expectedText);
    }

    @When("user click the forgot password button")
    public void userClickTheForgotPasswordButton() {
        loginPage.forgotPassword.click();
    }

    @Then("user should see the Reset password button")
    public void userShouldSeeThe() {
        String expectedText="Reset password";
        String actualText=loginPage.resetPassword.getText();
        System.out.println("expectedText = " + expectedText);
        System.out.println("actualText = " + actualText);
        BrowserUtils.waitFor(5);
        Assert.assertEquals(actualText,expectedText);

    }

    @Then("user can see valid placeholders on Username fields")
    public void userCanSeeValidPlaceholdersOnUsernameFields() {
        Assert.assertEquals(loginPage.userName.getAttribute("placeholder"),"Username or email");
    }

    @And("user can see valid placeholders on Password fields")
    public void userCanSeeValidPlaceholdersOnPasswordFields() {
        Assert.assertEquals(loginPage.inputPassword.getAttribute("placeholder"),"Password");
    }
}
