package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class SignInStepDefs extends AbstractStepDefs{

    @And("the Sign In Button is clicked")
    public void theSignInButtonIsClicked() {
        homePage.clickSigninBtn();
    }

    @When("Create an account Button is clicked")
    public void createAnAccountButtonIsClicked() {
        homePage.clickCreateAccountBtn();
    }

    @Given("the {string} is filled with {string}")
    public void theEmail_fieldIsFilledWithEmail_input(String field, String input) {
        homePage.fillField(field, input);
    }

    @Given("email address is filled with {string}")
    public void emailAddressIsFilledWithInvalid_address(String input) {
        homePage.fillField("email_create", input);
    }

    @Then("the {string} error message is shown")
    public void theMsgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getCreateAccountError(); //TODO RENAME METHOD IN MAIN
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }

    @Given("correct email address is entered")
    public void correctEmailAddressIsEntered() {
        homePage.fillField("email", "gerics11@gmail.com");
    }

    @And("correct password is entered")
    public void correctPasswordIsEntered() {
        homePage.fillField("passwd", "03090309");
    }

    @When("submit sign in with credetials button is clicked")
    public void submitSigninButtonIsClicked() {
        homePage.clickSubmitSigninBtn();
    }

    @Then("account page is shown")
    public void accountPageIsShown() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://automationpractice.com/index.php?controller=my-account");
    }

    @And("sign out button is clicked")
    public void signOutButtonIsClicked() {
        homePage.clickSignoutBtn();
    }

    @Then("sign in page is shown")
    public void signInPageIsShown() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,"http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}
