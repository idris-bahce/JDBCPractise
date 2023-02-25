package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageSetup {

    @FindBy(xpath = "//a[@href='#start']")
    public WebElement learnMoreButton;

    @FindBy(xpath = "//h3[.='Services']")
    public WebElement servicesLabel;
}
