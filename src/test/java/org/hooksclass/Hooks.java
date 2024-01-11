package org.hooksclass;

import org.base.BaseclassCucumber;
import org.junit.BeforeClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseclassCucumber {
	@BeforeClass
	public static void before() {
		browserLaunch("chrome");
		maximizeWindow();
		
	}
	@After
	public void after() {
		System.out.println("hooks after@@@@@");
	}

}
