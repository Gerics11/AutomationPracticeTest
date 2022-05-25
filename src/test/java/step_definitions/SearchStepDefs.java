package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchStepDefs extends AbstractStepDefs{
    @Given("the search bar is filled with {string}")
    public void theSearchBarIsFilledWith(String input) {
        homePage.fillField("search_query_top", input);
    }

    @And("the search button is clicked")
    public void theSearchButtonIsClicked() {
        homePage.clickSearchBtn();
    }

    @Then("{string} result is found")
    public void result_countResultIsFound(String count) {
        Assert.assertEquals(homePage.getResultCount(), Integer.parseInt(count));
    }
}
