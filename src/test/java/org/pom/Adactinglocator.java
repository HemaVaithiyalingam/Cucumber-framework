package org.pom;

import org.base.BaseclassCucumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Adactinglocator extends BaseclassCucumber {
	public Adactinglocator() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginbtn;
	
	@FindBy(name="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(name="room_type")
	private WebElement roomType;
	
	@FindBy(name="room_nos")
	private WebElement roomNos;
	
	@FindBy(name="datepick_in")
	private WebElement checkin;
	
	@FindBy(name="datepick_out")
	private WebElement checkout;
	
	@FindBy(name="adult_room")
	private WebElement adult;
	
	@FindBy(name="child_room")
	private WebElement child;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchBtn;
	
	@FindBy(name="radiobutton_0")
	private WebElement radiobtn;
	
	@FindBy(name="continue")
	private WebElement continueBtn;
	
	@FindBy(name="first_name")
	private WebElement firstname;
	
	@FindBy(name="last_name")
	private WebElement lastname;
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="cc_num")
	private WebElement card;
	
	@FindBy(name="cc_type")
	private WebElement cardtype;
	
	@FindBy(name="cc_exp_month")
	private WebElement expiryMonth;
	
	@FindBy(name="cc_exp_year")
	private WebElement expiryYear;
	
	@FindBy(name="cc_cvv")
	private WebElement cvv;

	@FindBy(name="book_now")
	private WebElement booknowBtn;
	
	@FindBy(name="my_itinerary")
	private WebElement itinerary;

	@FindBy(name="order_id_text")
	private WebElement searchbox;

	@FindBy(name="search_hotel_id")
	private WebElement gobtn;
	
	@FindBy(name="total_price_1145002")
	private WebElement price;
	
	@FindBy(name="price_night_1145002")
	private WebElement pricepernight;

	public WebElement getPricepernight() {
		return pricepernight;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getCheckin() {
		return checkin;
	}

	public WebElement getCheckout() {
		return checkout;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getRadiobtn() {
		return radiobtn;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCard() {
		return card;
	}

	public WebElement getCardtype() {
		return cardtype;
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getExpiryYear() {
		return expiryYear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBooknowBtn() {
		return booknowBtn;
	}

	public WebElement getItinerary() {
		return itinerary;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getGobtn() {
		return gobtn;
	}

	
	


}
