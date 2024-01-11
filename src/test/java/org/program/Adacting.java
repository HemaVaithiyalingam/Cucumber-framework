package org.program;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.base.BaseclassCucumber;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pom.AdactingResultLocator;
import org.pom.Adactinglocator;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Adacting extends BaseclassCucumber {
	String path = "C:\\Users\\Balakrishnan G\\Documents\\Book1.xlsx";
	static Adactinglocator locator;
	String snap = null;

	@Given("User is on adacting login page using {string} browser")
	public void user_is_on_adacting_login_page_using_browser(String string) {
		browserLaunch("chrome");
		maximizeWindow();
		loadUrl("https://adactinhotelapp.com/");
		locator = new Adactinglocator();
	}

	@When("User enters the valid credentials")
	public void user_enters_the_valid_credentials() throws IOException {
		sendingValue(locator.getUsername(), excelread(path, "Sheet3", 0, 0));
		sendingValue(locator.getPassword(), excelread(path, "Sheet3", 0, 1));
	}

	@When("User enters the valid credentials using 1D Datatable")
	public void user_enters_the_valid_credentials_using_1d_datatable(io.cucumber.datatable.DataTable dataTable) {
		List<String> asList = dataTable.asList();
		String username = asList.get(0);
		sendingValue(locator.getUsername(), username);
		sendingValue(locator.getPassword(), asList.get(1));
	}

	@When("User enters the valid credentials using 2D Datatable without heading")
	public void user_enters_the_valid_credentials_using_2d_datatable_without_heading(
			io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> allList = dataTable.asLists();
		List<String> list = allList.get(0);
		String username = list.get(0);
		sendingValue(locator.getUsername(), username);
		sendingValue(locator.getPassword(), allList.get(0).get(1));
	}

	@When("User enters the valid credentials using 2D Datatable with heading")
	public void user_enters_the_valid_credentials_using_2d_datatable_with_heading1(
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> allMaps = dataTable.asMaps();
		Map<String, String> map = allMaps.get(0);
		String username = map.get("Username");
		sendingValue(locator.getUsername(), username);
		sendingValue(locator.getPassword(), allMaps.get(0).get("password"));
	}

	@When("User clicks login button")
	public void user_clicks_login_button() {
		clickButton(locator.getLoginbtn());
	}

	@Then("User checks the result and takes screenshot")
	public void user_checks_the_result_and_takes_screenshot() throws IOException {
		String expected = "Welcome to Adactin Group of Hotels";
		AdactingResultLocator resultlocator = new AdactingResultLocator();
		String actual = gettingElementText(resultlocator.getResulttc1());
		Assert.assertEquals(expected, actual);
		snap = "tc1";
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target" + snap + ".png");
		screenShot(filePath);

	}

	@When("Entering valid details")
	public void entering_valid_details() throws IOException {
		dropdownSelect(locator.getLocation(), "value", "Melbourne");
		dropdownSelect(locator.getHotels(), "visibleText", "Hotel Sunshine");
		dropdownSelect(locator.getRoomType(), 3);
		dropdownSelect(locator.getRoomNos(), "value", "2");

		WebElement checkin = locator.getCheckin();
		checkin.clear();
		sendingValue(checkin, excelread(path, "Sheet3", 0, 2));

		WebElement checkout = locator.getCheckout();
		checkout.clear();
		sendingValue(checkout, excelread(path, "Sheet3", 0, 3));
		dropdownSelect(locator.getAdult(), "value", "2");
		dropdownSelect(locator.getChild(), 1);
	}

	@When("Entering valid details using 2D Datatable")
	public void entering_valid_details_using_2d_datatable(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> asMap = dataTable.asMap();
		String checkindate = asMap.get("checkin");
		String checkoutdate = asMap.get("checkout");

		dropdownSelect(locator.getLocation(), "value", "Melbourne");
		dropdownSelect(locator.getHotels(), "visibleText", "Hotel Sunshine");
		dropdownSelect(locator.getRoomType(), 3);
		dropdownSelect(locator.getRoomNos(), "value", "2");

		WebElement checkin = locator.getCheckin();
		checkin.clear();
		sendingValue(checkin, checkindate);

		WebElement checkout = locator.getCheckout();
		checkout.clear();
		sendingValue(checkout, checkoutdate);
		dropdownSelect(locator.getAdult(), "value", "2");
		dropdownSelect(locator.getChild(), 1);
	}

	@When("click search button")
	public void click_search_button() {
		clickButton(locator.getSearchBtn());
	}

	@Then("User checks the result and takes screenshot1")
	public void User_checks_the_result_and_takes_screenshot1() throws IOException {
		AdactingResultLocator resultlocator = new AdactingResultLocator();
		boolean displayed = resultlocator.getResulttc2().isDisplayed();
		Assert.assertTrue(displayed);
		snap = "tc2";
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target" + snap + ".png");
		screenShot(filePath);
	}

	@When("User selects the hotel")
	public void user_selects_the_hotel() {
		clickButton(locator.getRadiobtn());
		clickButton(locator.getContinueBtn());
	}

	@Then("User checks the result and takes screenshot2")
	public void User_checks_the_result_and_takes_screenshot2() throws IOException {
		String expected1 = "Book A Hotel";
		AdactingResultLocator resultlocator = new AdactingResultLocator();
		String actual1 = gettingElementText(resultlocator.getResulttc3());
		Assert.assertEquals(expected1, actual1);
		snap = "tc3";
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target" + snap + ".png");
		screenShot(filePath);

	}

	@When("User enters the valid payment details")
	public void User_enters_the_valid_payment_details() throws IOException {
		sendingValue(locator.getFirstname(), excelread(path, "Sheet3", 0, 4));
		sendingValue(locator.getLastname(), excelread(path, "Sheet3", 0, 5));
		sendingValue(locator.getAddress(), excelread(path, "Sheet3", 0, 6));
		sendingValue(locator.getCard(), excelread(path, "Sheet3", 0, 7));

		dropdownSelect(locator.getCardtype(), "value", "VISA");
		dropdownSelect(locator.getExpiryMonth(), "value", "10");
		dropdownSelect(locator.getExpiryYear(), "value", "2028");
		sendingValue(locator.getCvv(), excelread(path, "Sheet3", 0, 8));

	}

	@When("User clicks booknow button")
	public void user_clicks_booknow_button() {
		clickButton(locator.getBooknowBtn());
	}

	@Then("User selects the itinery")
	public void user_selects_the_itinery() throws InterruptedException {
		Thread.sleep(5000);
		clickButton(locator.getItinerary());
	}

	@Then("User checks the result and takes screenshot3")
	public void user_checks_the_result_and_takes_screenshot3() throws IOException {
		String expected2 = "Booked Itinerary  ";
		AdactingResultLocator resultlocator = new AdactingResultLocator();
		String actual2 = gettingElementText(resultlocator.getResulttc4());
		Assert.assertNotEquals(expected2, actual2);
		snap = "tc4";
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target" + snap + ".png");
		screenShot(filePath);
	}

	@When("entering the booking id")
	public void entering_the_booking_id() throws IOException {
		sendingValue(locator.getSearchbox(), excelread(path, "Sheet3", 0, 9));
		clickButton(locator.getGobtn());
	}

	@When("Getting the price")
	public void getting_the_price() {

		String attributeValue1 = getAttributeValue(locator.getPricepernight(), "value");
		System.out.println("price per night=" + attributeValue1);
		String attributeValue2 = getAttributeValue(locator.getPrice(), "value");
		System.out.println("Total price=" + attributeValue2);
	}

	@Then("Taking screenshot")
	public void taking_screenshot() throws IOException {
		snap = "tc5";
		String filePath = ("C:\\Users\\Balakrishnan G\\eclipse-workspace\\Cucumber\\target" + snap + ".png");
		screenShot(filePath);

	}

}
