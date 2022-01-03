package org.adidas.frontend.stepDefinitions;

import io.cucumber.java.en.Given;
import org.adidas.frontend.config.DriverManager;
import org.adidas.frontend.pages.CommonsPage;
import org.openqa.selenium.WebDriver;

public class CommonsSteps {
    WebDriver driver = DriverManager.getDriver();
    CommonsPage commonsPage = new CommonsPage(driver);

    @Given("^the user navigates to (.*)$")
    public void navigateToSection(String section) {
        commonsPage.navigateToSection(section);
    }
}
