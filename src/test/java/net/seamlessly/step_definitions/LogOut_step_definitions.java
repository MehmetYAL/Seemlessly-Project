package net.seamlessly.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.LogoutPage;
import net.seamlessly.utility.ConfigurationReader;
import net.seamlessly.utility.Driver;
import org.junit.Assert;

public class LogOut_step_definitions {
LogoutPage logoutPage=new LogoutPage();
    @When("click log out image")
    public void click_log_out_image() {
        logoutPage.logoutImage.click();

    }
    @When("click log out")
    public void click_log_out() {
        logoutPage.logoutButton.click();
    }
    @And("user can logout successfully")
    public void userCanLogoutSuccessfully() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Seamlessly") );
    }
    @And("user click the step back button")
    public void userClickTheStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user can not go to home page again")
    public void userCanNotGoToHomePageAgain() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Seamlessly") );
    }


}
