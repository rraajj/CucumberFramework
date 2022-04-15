package TestRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Users/menakagandhis/eclipse/CucumberFrameWork_EndtoEnd/src/test/resources/Features"},
		glue = {"stepDefinitions","AppHooks"},
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "summary",
		/* "rerun:target/rerun1.txt" */ }/* , tags = "@dialect" */)
public class TestRun //extends AbstractTestNGCucumberTests
{

}
