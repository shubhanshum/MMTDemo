package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class HotelListPO {

	public static List<WebElement> chk_userRating() throws Exception {
		return PageUtils.find_Elements("xpath", "//div[@id='hlistpg_fr_user_rating']/ul[@class='filterList']/li");
	}
	
	public static List<WebElement> str_hotelNames() throws Exception {
		return PageUtils.find_Elements("xpath", "//p[@id='hlistpg_hotel_name']/span[contains(@id,'htl_id_seo_')]");
	}
	
	public static List<WebElement> icon_starRatings() throws Exception {
		return PageUtils.find_Elements("css", "span.rating_fill");
	}
	
	public static WebElement label_blackScreen() throws Exception {
		return PageUtils.find_Element("css", "div.mmBackdrop");
	}
	
	public static List<WebElement> str_roomPrice() throws Exception {
		return PageUtils.find_Elements("xpath", "//p[@id='hlistpg_hotel_shown_price']");
	}
	
	public static void getHotelNamesAndRatings() throws Exception {
		WebActions.waitForBrowsertoload();
		try {
				WebActions.clickUsingJS(label_blackScreen(), "Black screen");
				WebActions.waitFor(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		for (int i=0;i<5;i++) {
			String hotelNameText=WebActions.getElementText(str_hotelNames().get(i));
			String rate=WebActions.getElementText(str_roomPrice().get(i));
			System.out.println(">>>Hotel name is "+hotelNameText+" And rate is "+rate);
		}
	}
}
