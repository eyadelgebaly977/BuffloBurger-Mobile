package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = {"org.example.stepDefs"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
