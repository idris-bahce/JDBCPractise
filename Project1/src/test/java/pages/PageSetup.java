package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Constants;
import utilities.Driver;


public class PageSetup {

    public final WebDriver driver;

    public PageSetup(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@id='logo']//..")
    public WebElement logo;

    @FindBy(id = "search-btn")
    public WebElement searchBox;

    @FindBy(xpath = "//input")
    public WebElement searchInput;


    private WebElement getOptionWithSpanText(String option) {
        return driver.findElement(By.xpath(Constants.XPATH_START_SPAN +
                Constants.XPATH_TEXT_ATT_EQ + option + Constants.XPATH_ENDING));
    }

    public WebElement getWebElementFromMenuItemsOnTop(String option) {
        return getOptionWithSpanText(option);
    }

    public WebElement getWebElementFromDropDown(String option) {
        return getOptionWithSpanText(option);
    }
}
