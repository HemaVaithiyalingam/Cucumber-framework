package org.program;

import org.base.BaseclassCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Amazon extends BaseclassCucumber {
	

@Given("user search for iphone")
public void user_search_for_iphone() {
   loadUrl("https://www.amazon.in"); 
   
}

@When("select filter")
public void select_filter() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("add it to cart")
public void add_it_to_cart() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

}
