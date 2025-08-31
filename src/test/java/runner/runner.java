package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "features", 
glue = { "stepDefinitions","hooks"},
//dryRun = !true,
//tags = "@giftcard",
plugin = { "pretty", "html:reports/cucumber.html","json:reports/cucumber.json" }, 
monochrome = true
)

public class runner extends AbstractTestNGCucumberTests {

}
