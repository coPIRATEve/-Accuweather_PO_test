package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SearchResultsPage extends Form {

    private final ILabel cityHeader = getElementFactory().getLabel(
            By.xpath("//a[contains(@href, '/weather-forecast')]/h1"), "City Header");

    public SearchResultsPage() {
        super(By.xpath("//div[@class='card-header spaced-content']"), "Search Results Page");
    }

    public String getCityHeaderText() {
        cityHeader.state().waitForDisplayed();
        return cityHeader.getText();
    }
}
