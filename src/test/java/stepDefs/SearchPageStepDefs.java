package stepDefs;

import io.cucumber.java.en.Then;
import pages.SearchPage;
import utilities.BrowserUtils;

public class SearchPageStepDefs {

    SearchPage searchPage = new SearchPage();

    @Then("user should see {string} results found on search page")
    public void user_should_see_results_found_on_search_page(String text) {
        BrowserUtils.getElementText(searchPage.numberResultsFoundLabel).contains(text);
    }

    @Then("user should see {string} on search page")
    public void user_should_see(String text) {
        BrowserUtils.verifyElementDisplayed(searchPage.gebWebElementWithGivenTextInSearchResult(text));
    }
}
