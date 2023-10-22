package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AssertionUtils {
    public static void assertTextEquals(String expected, String actual) {
        org.junit.Assert.assertEquals(expected, actual);
    }

    public static void assertTrue(Boolean expected) {
        org.junit.Assert.assertTrue(expected);
    }

    public static void assertFalse(Boolean expected) {
        org.junit.Assert.assertFalse(expected);
    }

    public static boolean isElementPresent(WebDriver webDriver, By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
