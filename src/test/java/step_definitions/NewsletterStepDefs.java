package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Optional;

import static org.junit.Assert.fail;

public class NewsletterStepDefs extends AbstractStepDefs{
    @Given("newsletter email input is filled with correct email")
    public void newsletterEmailInputIsFilledWithCorrectEmail() {
        //nincs unsubscribe funkció, ezért újat generálok tesztenként
        int randInt = (int) Math.floor(Math.random() * 10000);
        String randomMail = "gerics" + randInt + "@gmail.com";
        homePage.fillField("newsletter-input", randomMail);
    }

    @When("submit button is clicked")
    public void submitButtonIsClicked() {
        homePage.clickNewsLetterSubmit();
    }

    @Then("success alert message is shown")
    public void successAlertMessageIsShown() {
        Assert.assertEquals(homePage.getSuccessAlertMessage(), "Newsletter : You have successfully subscribed to this newsletter.");
    }

    @Then("{string} error message is shown")
    public void err_msgErrorMessageIsShown(String msg) {
        Optional<String> errorMessage = homePage.getNewsLetterError();
        if (errorMessage.isPresent()) {
            Assert.assertEquals(msg, errorMessage.get());
        } else {
            fail();
        }
    }
}
