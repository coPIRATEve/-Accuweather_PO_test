package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class MainPage extends Form {

    private final IButton btnConsent = getElementFactory().getButton(
            By.xpath("//div[contains(@class,'policy-accept')]"), "Consent Button");
    private final ITextBox searchBox = getElementFactory().getTextBox(
            By.cssSelector("input.search-input"), "Search Input Box");
    private final By searchResultsLocator = By.xpath("//div[contains(@class,'source-radar')]");
    private final ILabel searchResultsListLabel = getElementFactory()
            .getLabel(searchResultsLocator, "Search Results List");

    public MainPage() {
        super(By.xpath("//a[@class='header-logo' and @href='/']"), "Main Page");
    }

    public void acceptConsent() {
        btnConsent.click();
    }

    public void searchCity(String city) {
        searchBox.clearAndType(city);
    }

    private List<ILabel> getSearchResultsList() {
        waitForSearchResults();
        return getElementFactory().findElements(searchResultsLocator, ElementType.LABEL);
    }

    public boolean waitForSearchResults() {
        return searchResultsListLabel.state().waitForDisplayed();
    }

    public void clickFirstSearchResult() {
        getSearchResultsList().get(0).click();
    }
}
