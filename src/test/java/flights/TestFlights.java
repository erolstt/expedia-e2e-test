package flights;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestFlights extends BaseTest{

    @Parameters({ "base-url" })
    @Test
    public void testBookOnlyFlight(String baseURL) {
        HomePage homePage = new HomePage(driver);
        homePage.open(baseURL)
                .clickFlightsTab()
                .flyingFrom(flights.getFlyingFromCity(), flights.getFlyingFromAirport())
                .flyingTo(flights.getFlyingToCity(), flights.getFlyingToAirport())
                .departingDate(flights.getDepartingDate()) // date format is mm/dd/yyyy
                .returningDate(flights.getReturningDate())
                .selectNumberOfTravelers(2)
                .search();
        SearchPage searchPage = new SearchPage(driver);
        assertNotEquals(searchPage.getPrice(0), "$0.92");
        assertEquals(searchPage.getPrice(0), "$279");
        assertEquals(searchPage.getStopPanelTitle(), "Stops");
        assertEquals(searchPage.getAirlinesIncludedPanelTitle(), "Airlines included");
        assertEquals(searchPage.getLegalText(), "Expedia, Inc. is not responsible for content on external Web sites. ©2018 Expedia, Inc. All rights reserved.");
    }
}
