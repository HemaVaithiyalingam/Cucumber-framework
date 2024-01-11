package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber"
		+ "\\src\\test\\resources\\Feature File\\Adacting.feature",glue = "org.program",dryRun = false,
		plugin = {"json:C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target\\jsonreport.json",
				"html:C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target\\htmlreport.html"})
public class AdactinTestRunner {

}
