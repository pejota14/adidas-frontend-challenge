package org.adidas.frontend.pages;

import org.adidas.frontend.config.Configuration;
import org.adidas.frontend.supportFunctions.CommonsModule;
import org.adidas.frontend.config.LocatorTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private static final String addToCartLocator = Configuration.ADD_TO_CART_LOCATOR;
    CommonsModule commonsModule = new CommonsModule();
    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart() {
        WebElement addToCartButton = commonsModule.findWebElement(driver, addToCartLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(addToCartButton);
    }

    public void confirmProductAdded() {
        commonsModule.acceptAlert(driver);
    }
}
