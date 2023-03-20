package net.seamlessly.pages;

import net.seamlessly.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    public LogoutPage() { PageFactory.initElements(Driver.getDriver(),this);   }

    @FindBy(xpath = "//*[@id=\"expand\"]/div/img")
    public WebElement logoutImage;

    @FindBy(xpath = "//*[@id=\"expanddiv\"]/ul/li[5]/a")
    public WebElement logoutButton;


}
