package org.adidas.frontend.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.adidas.frontend.config.DriverManager;
import org.adidas.frontend.pages.CartPage;
import org.adidas.frontend.supportFunctions.CommonsModule;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartPageSteps {
    WebDriver driver = DriverManager.getDriver();
    CartPage cartPage = new CartPage(driver);

    @When("^the user removes (.*) from cart$")
    public void deleteProductFromBasket(String product) {
        cartPage.deleteProductFromBasket(product);
    }

    @When("^the user places the order with their personal data$")
    public void placeOrder(DataTable personalData) {
        cartPage.placeOrder();
        cartPage.setPersonalData(personalData);
        cartPage.purchaseOrder();
    }

    @Then("^the basket has ([0-9]*) product$")
    public void verifyProductsQuantity(int productQuantity) {
        int basketProducts = cartPage.countBasketProducts();
        Assert.assertEquals("Expected products: " + productQuantity + "\nCurrent products: " + basketProducts, productQuantity, basketProducts);
    }

    @Then("^the purchase amount equals cart amount$")
    public void verifyPurchaseAmount() {
        cartPage.logPurchase();
        Assert.assertEquals("Purchase amount is not equal to cart amount", CommonsModule.getSessionVariable("totalAmount"), cartPage.getPurchaseAmount());
    }
    @When("^the user accepts$")
    public void userAccepts() {
        cartPage.userAccepts();
    }
}
