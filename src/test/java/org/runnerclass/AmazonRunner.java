package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src\\test\\resources\\Feature File\\Amazon.feature",
		"src\\test\\resources\\Feature File\\abc.feature" }, glue = { "org.program",
				"org.hooksclass" }, dryRun = false, plugin = "json:C:\\Users\\Balakrishnan G"
						+ "\\eclipse-workspace\\Cucumber"
						+ "\\target\\Amazon.json")
public class AmazonRunner {

}
