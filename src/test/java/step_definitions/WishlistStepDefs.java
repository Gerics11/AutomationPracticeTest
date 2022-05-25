package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WishlistStepDefs extends AbstractStepDefs{
    @When("add to wishlist button is clicked")
    public void addToWishlistButtonIsClicked() {
        homePage.addSearchFirstResultToWishlist();
    }

    @Then("add to wishlist success message is shown")
    public void addToWishlistSuccessMessageIsShown() {
        Assert.assertTrue(homePage.isWishlistAlertVisible());
    }
}
