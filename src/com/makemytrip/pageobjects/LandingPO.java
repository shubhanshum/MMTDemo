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
	
	public static WebElement rd_roundTrip() throws Exception {
		return PageUtils.find_Element("xpath", "//li[@data-cy='roundTrip']");
	}
	
	public static WebElement btn_studentFare() throws Exception {
		return PageUtils.find_Element("xpath", "//ul[@class='specialFare']/li[not(contains(@class,'activeItem'))]");
	}
	
	public static WebElement btn_search() throws Exception {
		return PageUtils.find_Element("css", "a.widgetSearchBtn");
	}
	
	public static void clickRoundTripRadio() throws Exception {
		WebActions.clickUsingJS(rd_roundTrip(), "Round trip radio button");
	}
	
	public static void clickStudentFareButton() throws Exception {
		WebActions.clickUsingJS(btn_studentFare(), "Student fare button");
	}
	
	public static void clickSearchButton() throws Exception {
		WebActions.clickUsingJS(btn_search(), "Search button");
	}
	
	public static void clickLoginButton() throws Exception {
		WebActions.clickUsingJS(loginLink(), "Login or create account link");
	}
	
	public static void clickHotelLink() throws Exception {
		WebActions.clickUsingJS(lnk_hotel(), "Hotel link");
	}
	
	public static void searchRoundtripStudentFare() throws Exception {
		clickRoundTripRadio();
		clickStudentFareButton();
		clickSearchButton();
	}
	
}
