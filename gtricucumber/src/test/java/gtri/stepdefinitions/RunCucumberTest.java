package gtri.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//Schedule Jenkin job to run in (Dev, Test, QA, Production)

@RunWith(Cucumber.class)
@CucumberOptions(features = "gtrifeatures/validatehyperlinksongtri.feature",
				 plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
									"json:target/cucumber-reports/cucumber.json"},
				 glue="gtri.stepdefinitions",tags= "@sanity")
public class RunCucumberTest {

}