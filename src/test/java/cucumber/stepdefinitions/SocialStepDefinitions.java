package cucumber.stepdefinitions;

import constants.SharedString;
import cucumber.webdrivers.ChromeWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.standarduser.ProductPage;

import java.util.ArrayList;

import static utils.AssertionUtils.assertTextEquals;

public class SocialStepDefinitions {
    private LoginPage loginPage;
    private ProductPage productPage;
    private String parentTab;

    @Before
    public void setup() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
    }

    @After
    public void teardown() {
        ChromeWebDriver.quit();
    }

    @Given("the user is logged in as standard user for visiting social account")
    public void theUserIsLoggedInAsStandardUserForVisitingSocialAccount() {
        CommonStepDefinitions.theUserIsLoggedInAsStandardUser(loginPage);
    }

    @Given("the user is on the product page for visiting social account")
    public void theUserIsOnTheProductPageForVisitingSocialAccount() {
        CommonStepDefinitions.theUserIsOnTheProductPage(productPage);
    }

    @When("the user click Twitter link on the footer")
    public void theUserClickTwitterLinkOnTheFooter() {
        parentTab = ChromeWebDriver.getInstance().getWindowHandle();
        productPage.clickTwitterLink();
        ArrayList<String> tabs = new ArrayList<>(ChromeWebDriver.getInstance().getWindowHandles());
        tabs.remove(parentTab);
        ChromeWebDriver.getInstance().switchTo().window(tabs.get(0));
    }

    @Then("the user should be redirected to Sauce Labs Twitter account")
    public void theUserShouldBeRedirectedToSauceLabsTwitterAccount() {
        assertTextEquals(SharedString.socialTwitterUrl, ChromeWebDriver.getInstance().getCurrentUrl());
    }

    @When("the user click Facebook link on the footer")
    public void theUserClickFacebookLinkOnTheFooter() {
        parentTab = ChromeWebDriver.getInstance().getWindowHandle();
        productPage.clickFacebookLink();
        ArrayList<String> tabs = new ArrayList<>(ChromeWebDriver.getInstance().getWindowHandles());
        tabs.remove(parentTab);
        ChromeWebDriver.getInstance().switchTo().window(tabs.get(0));
    }

    @Then("the user should be redirected to Sauce Labs Facebook account")
    public void theUserShouldBeRedirectedToSauceLabsFacebookAccount() {
        assertTextEquals(SharedString.socialFacebookUrl, ChromeWebDriver.getInstance().getCurrentUrl());
    }

    @When("the user click Linkedin link on the footer")
    public void theUserClickLinkedinLinkOnTheFooter() {
        parentTab = ChromeWebDriver.getInstance().getWindowHandle();
        productPage.clickLinkedinLink();
        ArrayList<String> tabs = new ArrayList<>(ChromeWebDriver.getInstance().getWindowHandles());
        tabs.remove(parentTab);
        ChromeWebDriver.getInstance().switchTo().window(tabs.get(0));
    }

    @Then("the user should be redirected to Sauce Labs Linkedin account")
    public void theUserShouldBeRedirectedToSauceLabsLinkedinAccount() {
        assertTextEquals(SharedString.socialLinkedinUrl, ChromeWebDriver.getInstance().getCurrentUrl());
    }
}
