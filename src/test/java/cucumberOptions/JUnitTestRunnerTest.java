package cucumberOptions;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepDefinitions",
//tags = "@Checkout",
//		+ " or @Search", 
plugin = {"html:target/cucumber.html", "json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
//"xml:target/cucumber.xml"})
//, dryRun=true )
public class JUnitTestRunnerTest
{

}
