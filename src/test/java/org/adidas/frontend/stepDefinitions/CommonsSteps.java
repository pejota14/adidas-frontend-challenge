package org.adidas.frontend.stepDefinitions;

import io.cucumber.java.en.Given;
import org.adidas.frontend.hooks.Hooks;
import org.adidas.frontend.pages.CommonsPage;
import org.openqa.selenium.WebDriver;

public class CommonsSteps {
    WebDriver driver = Hooks.getDriver();
    CommonsPage commonsPage = new CommonsPage(driver);

    @Given("^the user navigates to (.*)$")
    public void navigateToSection(String section) {
        commonsPage.navigateToSection(section);
    }
}
