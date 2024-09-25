package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

public class WeatherSearchTest extends BaseTest {

    private static final String SEARCH_CITY = "New York";

    @Test
    public void testSearchCityWeather() {
        mainPage.acceptConsent();
        mainPage.searchCity(SEARCH_CITY);

        Assert.assertTrue(mainPage.waitForSearchResults(), "Search results list is not displayed.");

        mainPage.clickFirstSearchResult();

        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.getCityHeaderText().contains(SEARCH_CITY), "City name in header is not as expected.");
    }
}
