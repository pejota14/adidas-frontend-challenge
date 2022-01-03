package org.adidas.frontend.supportFunctions;

import net.serenitybdd.core.Serenity;
import org.adidas.frontend.config.LocatorTypes;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.List;

public class CommonsModule {
    public static <T> T getSessionVariable(String key) {
        return Serenity.sessionVariableCalled(key);
    }

    public static <T> void setSessionVariable(String key, T value) {
        Serenity.setSessionVariable(key).to(value);
    }

    public WebElement findWebElement(WebDriver driver, String locator, LocatorTypes locatorType) {
        By byLocator = null;
        switch (locatorType) {
            case CSS:
                byLocator = new By.ByCssSelector(locator);
                break;
            case XPATH:
                byLocator = new By.ByXPath(locator);
                break;
        }
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
            return waiter.until(ExpectedConditions.presenceOfElementLocated(byLocator));
        } catch (NoSuchElementException exception) {
            Assert.fail("Element searched by reference: '" + locator + "' as '" + locatorType + "' was not found.");
            return null;
        }
    }

    public List<WebElement> findWebElements(WebDriver driver, String locator, LocatorTypes locatorType) {
        By byLocator = null;
        switch (locatorType) {
            case CSS:
                byLocator = new By.ByCssSelector(locator);
                break;
            case XPATH:
                byLocator = new By.ByXPath(locator);
                break;
        }
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
            return waiter.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byLocator));
        } catch (NoSuchElementException exception) {
            Assert.fail("Elements searched by reference: '" + locator + "' as '" + locatorType + "' was not found.");
            return null;
        }
    }

    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception exception) {
            Assert.fail("Fail to click element");
        }
    }

    public void inputText(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (IllegalArgumentException ignored) {
            Assert.fail("Input text is not defined");
        } catch (Exception exception) {
            Assert.fail("Fail to input text");
        }
    }

    public void acceptAlert(WebDriver driver) {
        try {
            WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
            waiter.until(ExpectedConditions.alertIsPresent()).accept();
        } catch (NoAlertPresentException exception) {
            Assert.fail("No alert is present.");
        }
    }

    public int searchElementIndex(List<WebElement> elementList, String key) {
        for (int index = 0; index < elementList.size(); index++) {
            if (elementList.get(index).getText().matches(key)) {
                return index;
            }
        }
        Assert.fail(key + " has not been found in the element list");
        return -1;
    }

    public boolean verifyElementExist(WebDriver driver, String locator, LocatorTypes locatorType) {
        By byLocator = null;
        switch (locatorType) {
            case CSS:
                byLocator = new By.ByCssSelector(locator);
                break;
            case XPATH:
                byLocator = new By.ByXPath(locator);
                break;
        }
        try {
            driver.findElement(byLocator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void appendLineToFile(String filePath, String text) {
        try {
            File logFile = new File(filePath);
            logFile.getParentFile().mkdirs();
            FileWriter fileWriter = new FileWriter(logFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(text);
            fileWriter.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            Assert.fail("File not found: " + filePath);
        } catch (UnsupportedEncodingException e) {
            Assert.fail("Unsupported Encoding Exception: " + filePath);
        } catch (IOException e) {
            Assert.fail("Error writing in file: " + filePath);
        }
    }
}
