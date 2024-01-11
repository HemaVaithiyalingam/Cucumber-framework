package org.pom;

import org.base.BaseclassCucumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactingResultLocator extends BaseclassCucumber {
	public AdactingResultLocator() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='welcome_menu'])[1]")
	private WebElement resulttc1;
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement resulttc2;
	
	@FindBy(xpath="(//td[@class='login_title'])[2]")
	private WebElement resulttc3;
	
	@FindBy(xpath="//td[@class='login_title']")
	private WebElement resulttc4;

	public WebElement getResulttc4() {
		return resulttc4;
	}

	public WebElement getResulttc3() {
		return resulttc3;
	}

	public WebElement getResulttc1() {
		return resulttc1;
	}
	
	public WebElement getResulttc2() {
		return resulttc2;
	}


}
