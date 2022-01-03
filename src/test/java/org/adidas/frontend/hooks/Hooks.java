package org.adidas.frontend.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.adidas.frontend.config.Configuration;
import org.adidas.frontend.config.DriverManager;

public class Hooks {
    private static final String webUrl = Configuration.WEB_URL;
    DriverManager driverManager;

    @Before
    public void setup() {
        driverManager = new DriverManager("chrome");
        driverManager.setupDriver(webUrl);
    }

    @After
    public void tearDown() {
        driverManager.tearDownDriver();
    }


}
