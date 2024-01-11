package org.program;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.base.BaseclassCucumber;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FaceBookLogin extends BaseclassCucumber {

	@Given("The user is in the loginpage using {string} browser")
	public void initsetup(String string) {
		browserLaunch(string);
		maximizeWindow();
		loadUrl("https://www.facebook.com/");
	}

	@When("The user enters valid {string} and {string} for login")
	public void enter_valid_details(String username, String password) {

		sendingValue(findingWebElement("name", "email"), username);
		sendingValue(findingWebElement("name", "pass"), password);
	}

	@When("The user clicks the login button")
	public void login() {
		clickButton(findingWebElement("name", "login"));
	}

	@Then("User checks the result")
	public void screenshot() throws IOException {
		screenShot("C:\\Users\\Balakrishnan G\\eclipse-workspace" + "\\Cucumber\\target\\fb.png");
	}

	@Given("user clicks forgot password")
	public void forgotPassword() {
		clickButton(findingWebElement("xpath", "//a[text()='Forgotten password?']"));
	}

	@When("user clicks valid credendials {string}")
	public void enter_details(String details) {
		sendingValue(findingWebElement("name", "email"),details);
	}


	@When("click search")
	public void search() {
		clickButton(findingWebElement("name", "did_submit"));
	}

	@Then("validate the result")
	public void validate() {
		String expected = "It looks like you were misusing this feature by going too fast."
				+ " You’ve been temporarily blocked from using it.";
		boolean displayed = findingWebElement("xpath", "//li[contains(text(),'It looks like you ')]").isDisplayed();
		Assert.assertTrue(displayed);
	}

}
