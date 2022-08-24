package com.example.demo.Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/cucumber.feature",
		glue= {"com.example.demo.StepDefinitions"},
		plugin = { "pretty","json:build/reports/cucumber-reports.json",
			    "html:build/reports/cucumber-reports.html" 
	          },
		monochrome = true
		)
public class CucumberRunner {

}
