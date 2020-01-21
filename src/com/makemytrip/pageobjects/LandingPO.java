package com.makemytrip.pageobjects;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class LandingPO {

	public static WebElement loginLink() throws Exception {
		return PageUtils.find_Element("css", "span.userNameIcon");
	}
	
	public static WebElement lnk_hotel() throws Exception {
		return PageUtils.find_Element("xpath", "//li[@data-cy='menu_Hotels']/a[contains(@href,'hotels')]");
	}
	
	public static void clickLoginButton() throws Exception {
		WebActions.clickUsingJS(loginLink(), "Login or create account link");
	}
	
	public static void clickHotelLink() throws Exception {
		WebActions.clickUsingJS(lnk_hotel(), "Hotel link");
	}
	
}
