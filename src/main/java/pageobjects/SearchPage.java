package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements
    @FindBy(id = "stops-legend")
    private WebElement stopPanelTitle;

    @FindBy(id = "airlines-included-legend")
    private WebElement airlinesIncludedPanelTitle;

    @FindBy(id = "legal")
    private WebElement legalText;

    // Functions
    public String getPrice(int indexOfResult) {
        List<WebElement> priceList = driver.findElements(By.cssSelector("span.full-bold.no-wrap"));
         return priceList.get(indexOfResult).getText();
    }

    public  String getStopPanelTitle() {
        return stopPanelTitle.getText();
    }

    public String getAirlinesIncludedPanelTitle() {
        return airlinesIncludedPanelTitle.getText();
    }

    public String getLegalText() {
        return legalText.getText();
    }
}
