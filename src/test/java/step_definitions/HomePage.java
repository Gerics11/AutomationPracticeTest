package step_definitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final By CREATEACCOUNT_ERROR = By.cssSelector("#create_account_error > ol > li");
    private static final By NEWSLETTER_ERROR = By.className("alert-danger");

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(className = "login")
    private WebElement signInBtn;

    @FindBy(id = "SubmitLogin")
    private WebElement submitSigninBtn;

    @FindBy(className = "logout")
    private WebElement signoutBtn;

    @FindBy(className = "button-search")
    private WebElement searchBtn;

    @FindBy(className = "heading-counter")
    private WebElement resultCounter;

    @FindBy(css = ".shopping_cart > a:nth-child(1)")
    private WebElement cartBtn;

    @FindBy(className = "alert")
    private WebElement alertMessage;

    @FindBy(css = "#homefeatured > li:nth-child(1) > div:nth-child(1)")
    private WebElement firstProduct;

    @FindBy(className = "button-medium")
    private WebElement proceedToCheckoutBtn;

    @FindBy(className = "standard-checkout")
    private WebElement cartSummaryCheckoutBtn;

    @FindBy(css = "button.btn:nth-child(2)")
    private WebElement newsLetterSubmit;

    @FindBy(className = "alert-success")
    private WebElement newsLetterSuccessAlert;

    @FindBy(className = "cart_quantity_input")
    private WebElement cartQuantityField;

    @FindBy(id = "cart_quantity_up_1_1_0_0")
    private WebElement increaseQuantityBtn;

    @FindBy(id= "summary_products_quantity")
    private WebElement totalCartQuantity;

    @FindBy(className = "address_add")
    private WebElement addAddressBtn;

    @FindBy(css = "#center_column > ul > li > div")
    private WebElement searchFirstResult;

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage() {
        driver.get("http://automationpractice.com/");
        PageFactory.initElements(driver, this);
    }

    public void fillField(String field, String value) {
        WebElement editText = getField(By.id(field));
        editText.clear();
        editText.sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public Optional<String> getCreateAccountError() {
        return getErrorMessage(CREATEACCOUNT_ERROR);
    }

    public Optional<String> getNewsLetterError() {
        return getErrorMessage(NEWSLETTER_ERROR);
    }

    public void clickSigninBtn() {
        signInBtn.click();
    }

    public void clickCreateAccountBtn() {
        createAccountBtn.click();
    }

    public WebElement getCreateAccountBtn() {
        return createAccountBtn;
    }

    public void clickSubmitSigninBtn(){
        submitSigninBtn.click();
    }

    public void clickSignoutBtn() {
        signoutBtn.click();
    }

    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    public int getResultCount() {
        String resultText = resultCounter.getText();
        return Integer.parseInt(resultText.substring(0, resultText.indexOf(' ')));
    }

    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public void addFirstProductToCart() {
        Actions action = new Actions(driver);
        action.moveToElement(firstProduct).perform();
        WebElement subElement = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[2]/a[1]"));
        subElement.click();
    }

    public void addSearchFirstResultToWishlist() {
        Actions action = new Actions(driver);
        action.moveToElement(searchFirstResult).perform();
        WebElement subElement = driver.findElement(By.className("addToWishlist"));
        subElement.click();
    }

    public boolean isWishlistAlertVisible() {
        return !driver.findElements(By.className("fancybox-error")).isEmpty();
    }

    public WebElement getProceedToCheckoutBtn() {
        return proceedToCheckoutBtn;
    }

    public void clickCartSummaryCheckoutBtn() {
        cartSummaryCheckoutBtn.click();
    }

    public boolean isCartSummaryCheckoutBtnActive() {
        return cartSummaryCheckoutBtn.isDisplayed();
    }

    public void clickNewsLetterSubmit() {
        newsLetterSubmit.click();
    }

    public String getSuccessAlertMessage() {
        return newsLetterSuccessAlert.getText();
    }

    public void clickIncreaseQuantityBtn() {
        increaseQuantityBtn.click();
    }

    public void setProductQuantity(int quantity){
        cartQuantityField.clear();
        cartQuantityField.sendKeys(String.valueOf(quantity));
    }

    public int getProductQuantity() {
        String text = totalCartQuantity.getText();
        return Integer.parseInt(text.substring(0, text.indexOf(' ')));
    }

    public WebElement getTotalCartQuantity() {
        return totalCartQuantity;
    }

    public WebElement getAddAddressBtn() {
        return addAddressBtn;
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}
