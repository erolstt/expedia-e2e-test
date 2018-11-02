package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Webelements
    @FindBy(id = "primary-header-flight")
    private WebElement flightsTab;

    @FindBy(css = ".clear-btn-input.gcw-storeable.text.gcw-origin.gcw-required.gcw-distinct-locations")
    private WebElement flyingFromTextbox;

    @FindBy(css = "a#aria-option-1")
    private WebElement firstAirportResult;

    @FindBy(css = ".clear-btn-input.gcw-storeable.text.gcw-destination.gcw-required.gcw-distinct-locations")
    private WebElement flyingToTextbox;

    @FindBy(id = "flight-departing-flp")
    private WebElement departingDatePanel;

    @FindBy(id = "flight-returning-flp")
    private WebElement returningDatePanel;

    @FindBy (css = "#traveler-selector-flp .dropdown-toggle")
    private WebElement travelersPanel;

    @FindBy (css = "button.uitk-step-input-button.uitk-step-input-plus > span.uitk-icon > svg.uitk-icon-svg.uitk-step-input-icon")
    private WebElement travelersPlusIcon;

    @FindBy (css = ".gcw-submit")
    private WebElement searchButton;

    @FindBy (css = ".btn-secondary.btn-action.t-select-btn")
    private WebElement selectButton;


    // Functions
    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public HomePage clickFlightsTab() {
        flightsTab.click();
        return this;
    }

    public HomePage typeFlyingFrom(String flyingFrom) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(flyingFromTextbox));
        flyingFromTextbox.clear();
        flyingFromTextbox.sendKeys(flyingFrom);
        return this;
    }

    public HomePage typeFlyingTo( String flyingTo) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(flyingToTextbox));
        flyingToTextbox.clear();;
        flyingToTextbox.sendKeys(flyingTo);
        return this;
    }

    public HomePage flyingFrom(String city, String airport) {
        String airportCode = null;
        switch (airport.toLowerCase()) {
            case  "heathrow" : airportCode = "LHR";
            break;
            case "gatwick" : airportCode = "LGW";
            break;
            default:
                System.out.println("invalid airport !" + airportCode);
                break;
        }
        typeFlyingFrom(city);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(firstAirportResult));
        WebElement apCode = driver.findElement(By.xpath("//ap[contains(text(),'" + airportCode + "')]"));
        apCode.click();
        return this;
    }

    public HomePage flyingTo(String city, String airport) {
        String airportCode = null;

        switch (airport.toLowerCase()) {
            case "dublin" : airportCode = "DUB";
            break;
            default:
                System.out.println("invalid airport !" + airportCode);
                break;
        }
        typeFlyingTo(city);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(firstAirportResult));
        WebElement apCode = driver.findElement(By.xpath("//b[contains(text(),'" + airportCode + "')]"));
        apCode.click();
        return this;
    }

    public HomePage departingDate(String date) {
        departingDatePanel.click();
        departingDatePanel.sendKeys(date);
        return this;
    }

    public HomePage returningDate(String date) {
        returningDatePanel.click();
        returningDatePanel.sendKeys(date);
        return this;
    }

    public HomePage clickTravelers() {
        travelersPanel.click();
        return this;
    }

    public HomePage selectNumberOfTravelers(int numberOfTraveller) {
        clickTravelers();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(travelersPlusIcon));
        for (int i = 1; i < numberOfTraveller; i++) {
            travelersPlusIcon.click();
        }
        return this;
    }

    public SearchPage search() {
        searchButton.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(selectButton));
        return new SearchPage(driver);
    }

}
