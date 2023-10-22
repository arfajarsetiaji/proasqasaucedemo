package cucumber.stepdefinitions;

import cucumber.webdrivers.ChromeWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.standarduser.ProductPage;

import static utils.AssertionUtils.*;

public class AddToCartStepDefinitions {
    private LoginPage loginPage;
    private ProductPage productPage;

    @Before
    public void setup() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @After
    public void teardown() {
        ChromeWebDriver.quit();
    }

    @Given("the user is logged in as standard user for adding to cart")
    public void theUserIsLoggedInAsStandardUserForAddingToCart() {
        CommonStepDefinitions.theUserIsLoggedInAsStandardUser(loginPage);
    }

    @Given("the user is on the product page for adding to cart")
    public void theUserIsOnTheProductPageForAddingToCart() {
        CommonStepDefinitions.theUserIsOnTheProductPage(productPage);
    }

    @And("the user see the {string} item")
    public void theUserSeeTheItem(String productName) {
        assertTrue(productPage.inventoryItemNameIsPresent(productName));
        assertTrue(productPage.productAddToCartButtonIsPresent(productName));
        assertFalse(productPage.productRemoveFromCartButtonIsPresent(productName));
    }

    @When("the user clicks the {string} Add to Cart button")
    public void theUserClicksTheAddToCartButton(String productName) {
        productPage.clickProductAddToCartButton(productName);
    }

    @Then("the cart should display 1 item")
    public void theCartShouldDisplay1Item() {
        assertTrue(productPage.shoppingCartBadgeIsPresent());
        assertTextEquals("1", productPage.getShoppingCartBadgeText());
    }

    @And("the {string} Add to Cart button should not present")
    public void theAddToCartButtonShouldNotPresent(String productName) {
        assertFalse(productPage.productAddToCartButtonIsPresent(productName));
    }

    @And("the {string} Remove from Cart button should present")
    public void theRemoveFromCartButtonShouldPresent(String productName) {
        assertTrue(productPage.productRemoveFromCartButtonIsPresent(productName));
    }
}
