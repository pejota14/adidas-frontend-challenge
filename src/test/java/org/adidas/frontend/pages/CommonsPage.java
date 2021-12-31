package org.adidas.frontend.pages;

import org.adidas.frontend.config.Configuration;
import org.adidas.frontend.supportFunctions.CommonsModule;
import org.adidas.frontend.supportFunctions.LocatorTypes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonsPage {
    private static final String sectionLocator = Configuration.SECTION_LOCATOR;
    WebDriver driver;
    CommonsModule commonsModule = new CommonsModule();

    public CommonsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSection(String section) {
        String sectionLocator = CommonsPage.sectionLocator.replace("%s", section);
        WebElement categoryElement = commonsModule.findWebElement(driver, sectionLocator, LocatorTypes.XPATH);
        commonsModule.clickElement(categoryElement);
    }
}
