package org.pom;

import org.base.BaseclassCucumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPom extends BaseclassCucumber {
	public AmazonPom() {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="twotabsearchtextbox")
private WebElement searchbox;

@FindBy(id="nav-search-submit-button")
private WebElement search;


}
