package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseFunc {

    public WebDriver driver;
    private WebDriverWait wait;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
    }

    public void openPage(String url) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        Assert.assertFalse("Element is not found!", isElementPresent(locator));
        return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator) {
        Assert.assertFalse(driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public void waitForElement(By locator) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public boolean isElementPresent(By locator) {
        waitForElement(locator);
        return getElements(locator).isEmpty();
    }

//    public List<WebElement> getElements(By locator) {
//        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
//        return driver.findElements(locator);
//    }
//
//    public WebElement getElement(By locator) {
//        try {
//            return driver.findElement(locator);
//        } catch (NoSuchElementException e) {
//            Assert.fail("Element not found");
//            return null;
//        }
//    }

    public static void moveToElement(WebDriver driver, WebElement webElement) {
        scrollToElement(driver, webElement);
        new Actions(driver).moveToElement(webElement).build().perform();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", element);
    }

    public void closePage() {
        driver.quit();
    }
}
