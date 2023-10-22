package cucumber.webdrivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ChromeWebDriver {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private ChromeWebDriver() {
    }

    public static WebDriver getInstance() {
        if (webDriverThreadLocal.get() == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            ChromeDriver webDriver = new ChromeDriver(chromeOptions);
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            webDriverThreadLocal.set(webDriver);
        }
        return webDriverThreadLocal.get();
    }

    public static void quit() {
        if (webDriverThreadLocal.get() != null) {
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }

    private static void clearLocalStorage() {
        JavascriptExecutor js = (JavascriptExecutor) webDriverThreadLocal.get();
        js.executeScript("window.localStorage.clear();");
    }

    private static void clearSessionStorage() {
        JavascriptExecutor js = (JavascriptExecutor) webDriverThreadLocal.get();
        js.executeScript("window.sessionStorage.clear();");
    }
}
