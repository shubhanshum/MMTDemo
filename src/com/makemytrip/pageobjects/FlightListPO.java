package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class FlightListPO {
	
	public static List<WebElement> str_flightNames() throws Exception {
		return PageUtils.find_Elements("css", "span.airlineInfo-sctn>span");
	}

	public static List<WebElement> str_flightFares() throws Exception {
		return PageUtils.find_Elements("css", "span.actual-price");
	}
	
	public static void displayFourFlightDetails() throws Exception {
		WebActions.waitForBrowsertoload();
		WebActions.waitFor(6);
		for (int i=0;i<4;i++) {
			String flightName=WebActions.getElementText(str_flightNames().get(i));
			String fare=WebActions.getElementText(str_flightFares().get(i));
			System.out.println(">>Flight name is "+flightName+" and fare is "+fare);
		}
	}
}
