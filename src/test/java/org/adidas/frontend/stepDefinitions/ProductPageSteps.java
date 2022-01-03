package org.adidas.frontend.stepDefinitions;

import io.cucumber.java.en.When;
import org.adidas.frontend.config.DriverManager;
import org.adidas.frontend.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class ProductPageSteps {
    WebDriver driver = DriverManager.getDriver();
    ProductPage productPage = new ProductPage(driver);

    @When("^the user adds the product to cart$")
    public void addProductToCart() {
        productPage.addProductToCart();
        productPage.confirmProductAdded();
    }
}
