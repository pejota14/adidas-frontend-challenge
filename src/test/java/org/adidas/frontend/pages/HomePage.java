package org.adidas.frontend.pages;

import org.adidas.frontend.config.Configuration;
import org.adidas.frontend.supportFunctions.CommonsModule;
import org.adidas.frontend.supportFunctions.LocatorTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private static final String categoryLocator = Configuration.CATEGORY_LOCATOR;
    private static final String productLocator = Configuration.PRODUCT_LOCATOR;
    CommonsModule commonsModule = new CommonsModule();
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchCategory(String category) {
        String categoryLocator = HomePage.categoryLocator.replace("%s", category);
        WebElement categoryElement = commonsModule.findWebElement(driver, categoryLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(categoryElement);
    }

    public void selectProduct(String product) {
        String productLocator = HomePage.productLocator.replace("%s", product);
        WebElement productElement = commonsModule.findWebElement(driver, productLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(productElement);
    }
}
