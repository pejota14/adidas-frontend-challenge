package org.adidas.frontend.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static WebDriver driver;

    public DriverManager(String driver) {
        switch (driver) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                DriverManager.driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                DriverManager.driver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                DriverManager.driver = new ChromeDriver();
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void setupDriver(String webUrl) {
        driver.manage().window().maximize();
        driver.get(webUrl);
    }

    public void tearDownDriver() {
        driver.quit();
    }
}
