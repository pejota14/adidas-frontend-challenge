package org.adidas.frontend.stepDefinitions;

import io.cucumber.java.en.When;
import org.adidas.frontend.hooks.Hooks;
import org.adidas.frontend.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class ProductPageSteps {
    WebDriver driver = Hooks.getDriver();
    ProductPage productPage = new ProductPage(driver);

    @When("^the user adds the product to cart$")
    public void addProductToCart() {
        productPage.addProductToCart();
        productPage.confirmProductAdded();
    }
}
