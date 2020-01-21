package com.makemytrip.pageobjects;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class HomePage {

	public static WebElement str_heyUsername() throws Exception {
		return PageUtils.find_Element("css", "div.userNameText>p");
	}
	
	public static String getHeyUsernameText() throws Exception {
		return WebActions.getElementText(str_heyUsername());
	}
	
	public static WebElement lnk_myProfile() throws Exception {
		return PageUtils.find_Element("xpath", "//a[contains(@href,'my-profile')]");
	}
	
	public static void clickHeyUserNameLink() throws Exception {
		WebActions.click(str_heyUsername(), "Hey Username Link");
	}
	
	public static void clickMyProfileLink() throws Exception {
		WebActions.click(lnk_myProfile(), "My Profile Link");
	}
}
