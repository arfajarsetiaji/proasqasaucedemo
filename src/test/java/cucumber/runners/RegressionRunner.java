package cucumber.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports/regression-report.html"},
        tags = "@Regression"
)
public class RegressionRunner {
}
