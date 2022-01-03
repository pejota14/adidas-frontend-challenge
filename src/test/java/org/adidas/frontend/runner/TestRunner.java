package org.adidas.frontend.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {
                "src/test/resources/features"
        },
        tags = "@TEST_001",
        glue = {
                "org.adidas.frontend.stepDefinitions",
                "org.adidas.frontend.hooks"
        }
)
public class TestRunner {
}
