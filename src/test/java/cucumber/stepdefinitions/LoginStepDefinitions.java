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

import static utils.AssertionUtils.assertTextEquals;

public class LoginStepDefinitions {
    private LoginPage loginPage;

    @Before
    public void setup() {
        loginPage = new LoginPage();
    }

    @After
    public void teardown() {
        ChromeWebDriver.quit();
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        CommonStepDefinitions.theUserIsOnTheLoginPage(loginPage);
    }

    @When("the user enters {string} as username and {string} as password")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        assertTextEquals("", loginPage.getUsernameValue());
        loginPage.enterUsername(username);
        assertTextEquals(username, loginPage.getUsernameValue());

        assertTextEquals("", loginPage.getPasswordValue());
        loginPage.enterPassword(password);
        assertTextEquals(password, loginPage.getPasswordValue());
    }

    @And("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the login should be {string}")
    public void theLoginShouldBe(String status) {
        if (status.equalsIgnoreCase(SharedString.loginStatusSuccess)) {
            assertTextEquals(SharedString.productUrl, ChromeWebDriver.getInstance().getCurrentUrl());
        }
        if (status.equalsIgnoreCase(SharedString.loginStatusLockedOut)) {
            assertTextEquals(SharedString.loginLockedOutAlertText, loginPage.getLoginErrorAlertText());
        }
        if (status.equalsIgnoreCase(SharedString.loginStatusFailed)) {
            assertTextEquals(SharedString.loginErrorAlertText, loginPage.getLoginErrorAlertText());
        }
    }
}
