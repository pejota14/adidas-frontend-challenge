package org.adidas.frontend.stepDefinitions;

import io.cucumber.java.en.Given;
import org.adidas.frontend.hooks.Hooks;
import org.adidas.frontend.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = Hooks.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("^the user switches to (Phones|Laptops|Monitors) category and selects (.*)$")
    public void switchCategory(String category, String product) {
        homePage.switchCategory(category);
        homePage.selectProduct(product);
    }
}
