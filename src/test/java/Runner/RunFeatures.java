package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:/Features/Login.feature",
        glue = {"StepDefinitions"},
        tags = "@existing-user",
        plugin = { "pretty", "html:target/cucumber-reports.html" }
        )


public class RunFeatures {
}
