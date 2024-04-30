package testRunner;
 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
//		features ={".//featureFiles/"}
		features ={"@target/rerun.txt"}
//		features = {".//featureFiles/cab.feature"}
//		features={".//featureFiles/giftCards.feature"}
//		features ={".//featureFiles/hotels.feature"}
		,glue = {"stepDefinition"},
plugin= {"pretty", "html:reports/myreport.html",
		 "rerun:target/rerun.txt",
		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		},
 
dryRun=false, // checks mapping between scenario steps and step definition methods
monochrome=true, // to avoid junk characters in output
publish=true,
tags="@smoke or @regression"
)
public class TestRunner {
 
}