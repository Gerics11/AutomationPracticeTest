package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CartStepDefs extends AbstractStepDefs {

    @When("cart button is clicked")
    public void cartButtonIsClicked() {
        homePage.clickCartBtn();
    }

    @Then("{string} alert message is shown")
    public void yourShoppingCartIsEmptyAlertMessageIsShown(String alert) {
        Assert.assertEquals(homePage.getAlertMessage(), alert);
    }

    @Given("item is added to cart")
    public void itemIsAddedToCart() {
        homePage.addFirstProductToCart();
    }

    @And("proceed to checkout button is clicked")
    public void proceedToCheckoutButtonIsClicked() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getProceedToCheckoutBtn()));
        homePage.getProceedToCheckoutBtn().click();
    }

    @And("proceed to checkout is clicked on cart summary page")
    public void proceedToCheckoutIsClickedOnCartSummaryPage() {
        homePage.clickCartSummaryCheckoutBtn();
    }

    @Then("authentication page is opened")
    public void authenticationPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getCreateAccountBtn()));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.matches("^http://automationpractice\\.com/index\\.php\\?controller=authentication.*"));
    }

    @Then("proceed to checkout button is active")
    public void proceedToCheckoutButtonIsActive() {
        Assert.assertTrue(homePage.isCartSummaryCheckoutBtnActive());
    }

    @And("quantity is set to one")
    public void quantityIsSetToOne() {
        homePage.setProductQuantity(1);
    }

    @When("quantity of product is incremented")
    public void quantityOfProductIsIncremented() {
        homePage.clickIncreaseQuantityBtn();
    }

    @Then("shopping cart total increased by one")
    public void shoppingCartTotalIncreasedByOne() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(homePage.getTotalCartQuantity(), "2 Products"));
        Assert.assertEquals(2, homePage.getProductQuantity());
    }

    @Then("address page is shown")
    public void addressPageIsShown() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getAddAddressBtn()));
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.matches("^http://automationpractice\\.com/index\\.php\\?controller=order&step=1.*"));
    }
}
