package org.adidas.frontend.pages;

import io.cucumber.datatable.DataTable;
import org.adidas.frontend.config.Configuration;
import org.adidas.frontend.config.LocatorTypes;
import org.adidas.frontend.supportFunctions.CommonsModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;

public class CartPage {
    // XPATHs
    private static final String productListLocator = Configuration.PRODUCT_LIST_LOCATOR;
    private static final String deleteListLocator = Configuration.DELETE_LIST_LOCATOR;
    private static final String placeOrderLocator = Configuration.PLACE_ORDER_LOCATOR;
    private static final String placeOrderTextLocator = Configuration.PLACE_ORDER_TEXT_LOCATOR;
    private static final String creditCardInputLocator = Configuration.CREDIT_CARD_INPUT_LOCATOR;
    private static final String monthInputLocator = Configuration.MONTH_INPUT_LOCATOR;
    private static final String yearInputLocator = Configuration.YEAR_INPUT_LOCATOR;
    private static final String nameInputLocator = Configuration.NAME_INPUT_LOCATOR;
    private static final String countryInputLocator = Configuration.COUNTRY_INPUT_LOCATOR;
    private static final String cityInputLocator = Configuration.CITY_INPUT_LOCATOR;
    private static final String purchaseOrderLocator = Configuration.PURCHASE_ORDER_LOCATOR;
    private static final String purchaseLocator = Configuration.PURCHASE_LOCATOR;
    private static final String totalAmountLocator = Configuration.TOTAL_AMOUNT_LOCATOR;
    private static final String okButtonLocator = Configuration.OK_BUTTON_LOCATOR;

    // FILES
    private static final String purchaseLogFilePath = Configuration.PURCHASE_LOG_FILE_PATH;

    CommonsModule commonsModule = new CommonsModule();
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteProductFromBasket(String product) {
        List<WebElement> productList = commonsModule.findWebElements(driver, productListLocator, LocatorTypes.XPATH);
        List<WebElement> deleteFromBasketList = commonsModule.findWebElements(driver, deleteListLocator, LocatorTypes.XPATH);
        int searchedProductIndex = commonsModule.searchElementIndex(productList, product);
        commonsModule.clickElement(deleteFromBasketList.get(searchedProductIndex));
        int counter = 0;
        while (counter < 100) {
            List<WebElement> currentProductList = commonsModule.findWebElements(driver, deleteListLocator, LocatorTypes.XPATH);
            if (currentProductList.size() != productList.size() && !(currentProductList.size() == 0 && productList.size() != 1)) {
                break;
            }
            counter++;
        }
    }

    public int countBasketProducts() {
        List<WebElement> productList = commonsModule.findWebElements(driver, productListLocator, LocatorTypes.XPATH);
        return productList.size();
    }

    public void placeOrder() {
        WebElement placeOrderButton = commonsModule.findWebElement(driver, placeOrderLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(placeOrderButton);
        int counter = 0;
        while (counter < 100) {
            if (commonsModule.verifyElementExist(driver, placeOrderTextLocator, LocatorTypes.XPATH)) {
                break;
            }
            counter++;
        }
    }

    public void setPersonalData(DataTable personalData) {
        int counter = 0;
        while (counter < 100) {
            if (commonsModule.verifyElementExist(driver, nameInputLocator, LocatorTypes.XPATH)) {
                break;
            }
            counter++;
        }
        WebElement nameInput = commonsModule.findWebElement(driver, nameInputLocator, LocatorTypes.XPATH);
        WebElement countryInput = commonsModule.findWebElement(driver, countryInputLocator, LocatorTypes.XPATH);
        WebElement cityInput = commonsModule.findWebElement(driver, cityInputLocator, LocatorTypes.XPATH);
        WebElement creditCardInput = commonsModule.findWebElement(driver, creditCardInputLocator, LocatorTypes.XPATH);
        WebElement monthInput = commonsModule.findWebElement(driver, monthInputLocator, LocatorTypes.XPATH);
        WebElement yearInput = commonsModule.findWebElement(driver, yearInputLocator, LocatorTypes.XPATH);
        WebElement totalAmount = commonsModule.findWebElement(driver, totalAmountLocator, LocatorTypes.XPATH);
        commonsModule.inputText(nameInput, personalData.cell(1, 0));
        commonsModule.inputText(countryInput, personalData.cell(1, 1));
        commonsModule.inputText(cityInput, personalData.cell(1, 2));
        commonsModule.inputText(creditCardInput, personalData.cell(1, 3));
        commonsModule.inputText(monthInput, personalData.cell(1, 4));
        commonsModule.inputText(yearInput, personalData.cell(1, 5));
        CommonsModule.setSessionVariable("totalAmount", totalAmount.getText().split(" ")[1]);
    }

    public void purchaseOrder() {
        WebElement purchaseOrderButton = commonsModule.findWebElement(driver, purchaseOrderLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(purchaseOrderButton);
    }

    public String getPurchaseAmount() {
        WebElement purchaseText = commonsModule.findWebElement(driver, purchaseLocator, LocatorTypes.XPATH);
        return purchaseText.getText().split("\n")[1].split(" ")[1];
    }

    public void logPurchase() {
        WebElement purchaseText = commonsModule.findWebElement(driver, purchaseLocator, LocatorTypes.XPATH);
        String purchaseAmount = purchaseText.getText().split("\n")[1].split(" ")[1];
        String purchaseId = purchaseText.getText().split("\n")[0].split(" ")[1];
        String logLine = new Date() + " ID: " + purchaseId + ". Amount: " + purchaseAmount;
        commonsModule.appendLineToFile(purchaseLogFilePath, logLine);
    }

    public void userAccepts() {
        WebElement okButton = commonsModule.findWebElement(driver, okButtonLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(okButton);
    }
}
