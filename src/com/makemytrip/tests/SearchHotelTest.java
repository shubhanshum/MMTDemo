package com.makemytrip.tests;

import org.testng.annotations.Test;

import com.makemytrip.core.VerifyAndAssert;
import com.makemytrip.core.WebActions;
import com.makemytrip.pageobjects.HotelListPO;
import com.makemytrip.pageobjects.HotelsPO;
import com.makemytrip.pageobjects.LandingPO;
import com.makemytrip.testdata.PageURLs;
import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;

public class SearchHotelTest extends RunnerTest{

	String uname=WebActions.getPropFileData("userDetails","testdata", "username");
	String pwd=WebActions.getPropFileData("userDetails","testdata", "password");
	String city=WebActions.getPropFileData("userDetails","testdata", "city");
	
	@Test(groups= {"Regression","Sanity"})
	public void searchHotelTest() throws Exception {
		Reports.setTestName(this.getClass().getSimpleName());
		Log.startTestCase(this.getClass().getSimpleName());
		LandingPO.clickHotelLink();
		VerifyAndAssert.verifyUrl(PageURLs.hotelPage);
		HotelsPO.searchHotelInCity(city);
		VerifyAndAssert.verifyChildStringInParentString(BrowserFactory.getDriver().getCurrentUrl(), PageURLs.hotelListingPage);
		HotelListPO.getHotelNamesAndRatings();
	}
}
