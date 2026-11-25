package demo.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wrappers {
    /*
     * Write your selenium wrappers here
     */

    private static final Duration TIMEOUT = Duration.ofSeconds(15);

    public static void navigateTo(WebDriver driver, String url) {
        driver.get(url);
    }

    public static void clickElement(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated (locator));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public static void clickElement(WebDriver driver, By locator) {
        clickElement(driver, locator, 15);
    }

    public static boolean clickIfPresent(WebDriver driver, By locator, int seconds) {
        try {
            clickElement(driver, locator, seconds);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static void clickWebElement(WebDriver driver, WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public static void typeText(WebDriver driver, By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));
        input.clear();
        input.sendKeys(text);
    }

    public static void pressEnter(WebDriver driver, By locator) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator))
                .sendKeys(Keys.ENTER);
    }

    public static WebElement waitForElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static boolean waitForUrlContains(WebDriver driver, String fragment) {
        try {
            return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.urlContains(fragment));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static List<WebElement> findAll(WebDriver driver, By locator) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public static String getText(WebDriver driver, By locator) {
        return waitForElement(driver, locator).getText().trim();
    }

    public static String textOf(WebElement element) {
        return element.getText().trim();
    }

    public static String childText(WebElement parent, By... locators) {
        for (By locator : locators) {
            List<WebElement> found = parent.findElements(locator);
            if (!found.isEmpty() && !found.get(0).getText().trim().isEmpty()) {
                return found.get(0).getText().trim();
            }
        }
        return "";
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }

    public static void scrollToBottom(WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");
    }

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static long parseCount(String text) {
        if (text == null) {
            return 0;
        }
        Matcher m = Pattern.compile("([0-9][0-9,]*\\.?[0-9]*)\\s*(lakh|crore|cr|k|m|b)?",
                Pattern.CASE_INSENSITIVE).matcher(text.trim());
        if (!m.find()) {
            return 0;
        }
        double value = Double.parseDouble(m.group(1).replace(",", ""));
        String unit = m.group(2) == null ? "" : m.group(2).toLowerCase();
        switch (unit) {
            case "k":
                return Math.round(value * 1000);
            case "m":
                return Math.round(value * 1000000);
            case "b":
                return Math.round(value * 1000000000);
            case "lakh":
                return Math.round(value * 100000);
            case "crore":
            case "cr":
                return Math.round(value * 10000000);
            default:
                return Math.round(value);
        }
    }
}