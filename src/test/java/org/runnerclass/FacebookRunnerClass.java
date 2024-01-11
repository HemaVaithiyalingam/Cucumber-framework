package org.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\src\\test"
		+ "\\resources\\Feature File\\facebook.feature",glue="org.program",monochrome = true,dryRun = false,
		tags = "@forgotpassword",plugin = "html:C:\\Users\\Balakrishnan G"
				+ "\\eclipse-workspace\\Cucumber\\target\\fb.html")

public class FacebookRunnerClass {

}
