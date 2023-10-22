package pages;

import constants.SharedString;
import cucumber.webdrivers.ChromeWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.AssertionUtils.isElementPresent;

public class LoginPage {
    private final WebDriver webDriver;
    private final String baseUrl;
    private final By loginLogo = By.className("login_logo");
    private final By usernameInput = By.cssSelector("[data-test='username']");
    private final By passwordInput = By.cssSelector("[data-test='password']");
    private final By errorAlertText = By.cssSelector("[data-test='error']");
    private final By loginButton = By.cssSelector("[data-test='login-button']");

    public LoginPage() {
        this.webDriver = ChromeWebDriver.getInstance();
        this.baseUrl = SharedString.baseUrl;
    }

    public void navigateToLoginPage() {
        webDriver.get(baseUrl);
    }

    public boolean loginLogoIsPresent() {
        return isElementPresent(webDriver, loginLogo);
    }

    public boolean usernameInputIsPresent() {
        return isElementPresent(webDriver, usernameInput);
    }

    public boolean passwordInputIsPresent() {
        return isElementPresent(webDriver, passwordInput);
    }

    public boolean errorAlertTextIsPresent() {
        return isElementPresent(webDriver, errorAlertText);
    }

    public boolean loginButtonIsPresent() {
        return isElementPresent(webDriver, loginButton);
    }

    public String getLoginLogoText() {
        return webDriver.findElement(loginLogo).getText();
    }

    public void enterUsername(String username) {
        webDriver.findElement(usernameInput).sendKeys(username);
    }

    public String getUsernameValue() {
        return webDriver.findElement(usernameInput).getAttribute("value");
    }

    public void enterPassword(String password) {
        webDriver.findElement(passwordInput).sendKeys(password);
    }

    public String getPasswordValue() {
        return webDriver.findElement(passwordInput).getAttribute("value");
    }

    public String getLoginErrorAlertText() {
        return webDriver.findElement(errorAlertText).getText();
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }
}

