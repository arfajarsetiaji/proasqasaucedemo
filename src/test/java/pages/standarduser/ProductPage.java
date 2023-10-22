package pages.standarduser;

import constants.SharedString;
import cucumber.webdrivers.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.AssertionUtils.isElementPresent;
import static utils.StringUtils.toKebabCase;

public class ProductPage {
    private final WebDriver webDriver;
    private final String baseUrl;
    private final By sidebarMenuButton = By.id("react-burger-menu-btn");
    private final By logoutSidebarMenuLink = By.id("logout_sidebar_link");
    private final By appLogo = By.className("app_logo");
    private final By pageTitle = By.className("title");
    private final By shoppingCartContainer = By.id("shopping_cart_container");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By inventoryContainer = By.className("inventory_container");
    private final By inventoryList = By.className("inventory_list");
    private final By socialTwitter = By.className("social_twitter");
    private final By socialTwitterLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[1]/a");
    private final By socialFacebook = By.className("social_facebook");
    private final By socialFacebookLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[2]/a");
    private final By socialLinkedin = By.className("social_linkedin");
    private final By socialLinkedinLink = By.xpath("//*[@id=\"page_wrapper\"]/footer/ul/li[3]/a");

    public ProductPage() {
        this.webDriver = ChromeWebDriver.getInstance();
        this.baseUrl = SharedString.productUrl;
        PageFactory.initElements(ChromeWebDriver.getInstance(), this);
    }

    public void navigateToInventoryPage() {
        webDriver.get(baseUrl);
    }

    public boolean sidebarMenuButtonIsPresent() {
        return isElementPresent(webDriver, sidebarMenuButton);
    }

    public boolean logoutSidebarMenuLinkIsPresent() {
        return isElementPresent(webDriver, logoutSidebarMenuLink);
    }

    public boolean appLogoIsPresent() {
        return isElementPresent(webDriver, appLogo);
    }

    public boolean pageTitleIsPresent() {
        return isElementPresent(webDriver, pageTitle);
    }

    public boolean shoppingCartContainerIsPresent() {
        return isElementPresent(webDriver, shoppingCartContainer);
    }

    public boolean shoppingCartBadgeIsPresent() {
        return isElementPresent(webDriver, shoppingCartBadge);
    }

    public boolean inventoryContainerIsPresent() {
        return isElementPresent(webDriver, inventoryContainer);
    }

    public boolean inventoryListIsPresent() {
        return isElementPresent(webDriver, inventoryList);
    }

    public boolean inventoryItemNameIsPresent(String productName) {
        List<WebElement> inventoryItems = webDriver.findElements(By.className("inventory_item_name"));

        for (WebElement item : inventoryItems) {
            String itemText = item.getText();
            if (itemText.equals(productName)) {
                return true;
            }
        }

        return false;
    }

    public boolean productAddToCartButtonIsPresent(String productName) {
        return isElementPresent(webDriver, By.cssSelector(
                SharedString.dataTestAttributePrefix + SharedString.addToCartDataTestPrefix + toKebabCase(productName) + SharedString.dataTestAttributeSuffix));
    }

    public boolean productRemoveFromCartButtonIsPresent(String productName) {
        return isElementPresent(webDriver, By.cssSelector(
                SharedString.dataTestAttributePrefix + SharedString.removeFromCartDataTestPrefix + toKebabCase(productName) + SharedString.dataTestAttributeSuffix));
    }

    public boolean socialTwitterIsPresent() {
        return isElementPresent(webDriver, socialTwitter);
    }

    public boolean socialTwitterLinkIsPresent() {
        return isElementPresent(webDriver, socialTwitterLink);
    }

    public boolean socialFacebookIsPresent() {
        return isElementPresent(webDriver, socialFacebook);
    }

    public boolean socialFacebookLinkIsPresent() {
        return isElementPresent(webDriver, socialFacebookLink);
    }

    public boolean socialLinkedinIsPresent() {
        return isElementPresent(webDriver, socialLinkedin);
    }

    public boolean socialLinkedinLinkIsPresent() {
        return isElementPresent(webDriver, socialLinkedinLink);
    }

    public void clickSidebarMenuButton() {
        webDriver.findElement(sidebarMenuButton).click();
    }

    public void clickLogoutSidebarMenuItem() {
        webDriver.findElement(logoutSidebarMenuLink).click();
    }

    public String getAppLogoText() {
        return webDriver.findElement(appLogo).getText();
    }

    public String getPageTitleText() {
        return webDriver.findElement(pageTitle).getText();
    }

    public String getShoppingCartBadgeText() {
        return webDriver.findElement(shoppingCartBadge).getText();
    }

    public void clickProductAddToCartButton(String productName) {
        webDriver.findElement(By.cssSelector(
                SharedString.dataTestAttributePrefix + SharedString.addToCartDataTestPrefix + toKebabCase(productName) + SharedString.dataTestAttributeSuffix)).click();
    }

    public void clickProductRemoveFromCartButton(String productName) {
        webDriver.findElement(By.className(
                SharedString.dataTestAttributePrefix + SharedString.removeFromCartDataTestPrefix + toKebabCase(productName) + SharedString.dataTestAttributeSuffix)).click();
    }

    public void clickTwitterLink() {
        webDriver.findElement(socialTwitterLink).click();
    }

    public void clickFacebookLink() {
        webDriver.findElement(socialFacebookLink).click();
    }

    public void clickLinkedinLink() {
        webDriver.findElement(socialLinkedinLink).click();
    }
}
