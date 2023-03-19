package net.seamlessly.step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import net.seamlessly.utility.BrowserUtils;
import net.seamlessly.utility.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {




//    @Before(value = "@validCridentials", order = 2)
//    public void beforeValidCridentials() {
//        LoginPage loginPage = new LoginPage();
//        loginPage.userName.sendKeys("Employee170");
//        loginPage.inputPassword.sendKeys("Employee123");
//    }


        @After
        public void teardownScenario(Scenario scenario){

            //when scenario failed
            if (scenario.isFailed()){
                byte[] screenshot=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png", scenario.getName());

            }



            //System.out.println("===closing browser using @After");
            //System.out.println("======Scenario ended/Take screenshot if failed");
            Driver.closeDriver();
        }
       /* @After
        public void closeBrowser() {
            Driver.closeDriver();
        }*/
}
