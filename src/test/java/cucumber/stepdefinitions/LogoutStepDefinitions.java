package cucumber.stepdefinitions;

import constants.SharedString;
import cucumber.webdrivers.ChromeWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.standarduser.ProductPage;

import static utils.AssertionUtils.assertTextEquals;
import static utils.AssertionUtils.assertTrue;

public class LogoutStepDefinitions {

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

    @Given("the user is logged in as standard user log out from sauce demo website")
    public void theUserIsLoggedInAsStandardUserLogOutFromSauceDemoWebsite() {
        CommonStepDefinitions.theUserIsLoggedInAsStandardUser(loginPage);
    }

    @When("the user clicks sidebar menu button")
    public void theUserClicksSidebarMenuButton() {
        productPage.clickSidebarMenuButton();
    }

    @And("the user clicks logout menu item")
    public void theUserClicksLogoutMenuItem() {
        assertTrue(productPage.logoutSidebarMenuLinkIsPresent());
        productPage.clickLogoutSidebarMenuItem();
    }

    @Then("the user should be logged out and redirected to login page")
    public void theUserShouldBeLoggedOutAndRedirectedToLoginPage() {
        assertTextEquals(SharedString.baseUrl, ChromeWebDriver.getInstance().getCurrentUrl());
    }
}
