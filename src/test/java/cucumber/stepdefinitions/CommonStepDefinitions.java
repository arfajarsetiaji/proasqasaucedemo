package cucumber.stepdefinitions;

import constants.SharedString;
import pages.LoginPage;
import pages.standarduser.ProductPage;

import static utils.AssertionUtils.*;

public class CommonStepDefinitions {
    public static void theUserIsLoggedInAsStandardUser(LoginPage loginPage) {
        loginPage.navigateToLoginPage();
        loginPage.enterUsername(SharedString.standardUserUsername);
        loginPage.enterPassword(SharedString.standardUserPassword);
        loginPage.clickLoginButton();
    }

    public static void theUserIsOnTheLoginPage(LoginPage loginPage) {
        loginPage.navigateToLoginPage();

        assertTrue(loginPage.loginLogoIsPresent());
        assertTextEquals(SharedString.appLogoText, loginPage.getLoginLogoText());

        assertTrue(loginPage.usernameInputIsPresent());
        assertTrue(loginPage.passwordInputIsPresent());
        assertTrue(loginPage.loginButtonIsPresent());
    }

    public static void theUserIsOnTheProductPage(ProductPage productPage) {
        productPage.navigateToInventoryPage();

        assertTrue(productPage.sidebarMenuButtonIsPresent());

        assertTrue(productPage.appLogoIsPresent());
        assertTextEquals(SharedString.appLogoText, productPage.getAppLogoText());

        assertTrue(productPage.shoppingCartContainerIsPresent());
        assertFalse(productPage.shoppingCartBadgeIsPresent());

        assertTrue(productPage.pageTitleIsPresent());
        assertTextEquals(SharedString.inventoryPageTitleText, productPage.getPageTitleText());
        
        assertTrue(productPage.inventoryContainerIsPresent());
        assertTrue(productPage.inventoryListIsPresent());

        assertTrue(productPage.socialTwitterIsPresent());
        assertTrue(productPage.socialTwitterLinkIsPresent());
        assertTrue(productPage.socialFacebookIsPresent());
        assertTrue(productPage.socialFacebookLinkIsPresent());
        assertTrue(productPage.socialLinkedinIsPresent());
        assertTrue(productPage.socialLinkedinLinkIsPresent());
    }
}
