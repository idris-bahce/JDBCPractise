package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.Constants;

public class SearchPage extends PageSetup{
    @FindBy(xpath = "//a[.='Automate Your Life with Cypress']")
    public WebElement automateYourLifeWithCypress;

    @FindBy(xpath = "//span[contains(text(), 'results found')]")
    public WebElement numberResultsFoundLabel;

    public WebElement gebWebElementWithGivenTextInSearchResult(String text) {
        return driver.findElement(By.xpath(Constants.XPATH_START_HYPERLINK +
                Constants.XPATH_TEXT_ATT_EQ + text + Constants.XPATH_ENDING));
    }
}
