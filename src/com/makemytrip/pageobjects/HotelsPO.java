package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class HotelsPO {

	public static WebElement btn_city() throws Exception {
		return PageUtils.find_Element("xpath", "//label[@for='city']/input[@id='city']");
	}
	
	public static WebElement txt_enterCity() throws Exception {
		return PageUtils.find_Element("css", "input.react-autosuggest__input--open");
	}
	
	public static List<WebElement> str_autoSuggestedCities() throws Exception {
		return PageUtils.find_Elements("xpath", "//li[starts-with(@id,'react-autowhatever-')]");
	}
	
	public static WebElement btn_search() throws Exception {
		return PageUtils.find_Element("id", "hsw_search_button");
	}
	
	
	public static void searchHotelInCity(String city) throws Exception {
		WebActions.waitFor(2);
		WebActions.click(btn_city(), "city button");
		WebActions.waitFor(1);
		WebActions.setText(txt_enterCity(), city, "Enter city");
		WebActions.waitFor(3);
		WebActions.clickUsingJS(str_autoSuggestedCities().get(0), city);
		WebActions.clickUsingJS(btn_search(), "Search button");
	}
	
}
