package com.makemytrip.core;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;

public class VerifyAndAssert extends Reports{

	public static void isElementDisplayed(WebElement Element,String name) {
		Log.info("Verifying Is Element Displayed:"+name);
		boolean status=Element.isDisplayed();
		if (status==true) {
			Log.info("Pass:"+name+" is displayed");
			Reports.setMethodMessage("Pass:"+name+" is displayed");
		}
		else{
			Log.info("Fail:"+name+" is NOT displayed");
			Reports.setMethodMessage("Fail:"+name+" is NOT displayed");
			Assert.fail();
		}
	}
	
	public static void verifyText(String ActText,String ExpText) {
		Log.info("Verifying Text");
		if (ActText.equals(ExpText)) {
			Log.info("Pass: Act Text:"+ActText+" Exp Text:"+ExpText);
			Reports.setMethodMessage("Pass: Act Text:"+ActText+"Exp Text:"+ExpText);
		}
		else {
			Log.info("Fail: Act Text:"+ActText+" Exp Text:"+ExpText);
			Reports.setMethodMessage("Fail: Act Text:"+ActText+"Exp Text:"+ExpText);
			Assert.fail();
		}
	}
	
	public static void verifyChildStringInParentString(String parentString,String childString) {
		Log.info("Verifying whether child text is present in parent text");
		if (parentString.contains(childString)) {
			Log.info("Pass:child:"+childString+"Parent:"+parentString);
			Reports.setMethodMessage("Pass:child:"+childString+"Parent:"+parentString);
		}
		else {
			Log.info("Fail:child:"+childString+" parent:"+parentString);
			Reports.setMethodMessage("Fail:child:"+childString+" parent:"+parentString);
			Assert.fail();
		}
	}
	
	public static void verifyUrl(String expUrl) {
		Log.info("Verifying URL");
		String actUrl=BrowserFactory.getDriver().getCurrentUrl();
		if (actUrl.equals(expUrl)) {
			Log.info("Pass: Act Url:"+actUrl+" Exp Url:"+expUrl);
			Reports.setMethodMessage("Pass: Act Url:"+actUrl+" Exp Url:"+expUrl);
		}
		else {
			Log.info("Fail: Act Url:"+actUrl+" Exp Url:"+expUrl);
			Reports.setMethodMessage("Fail: Act Url:"+actUrl+" Exp Url:"+expUrl);
			Assert.fail();
		}
	}
}
