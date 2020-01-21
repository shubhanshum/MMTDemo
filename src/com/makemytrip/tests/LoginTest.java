package com.makemytrip.tests;

import org.testng.annotations.Test;

import com.makemytrip.core.VerifyAndAssert;
import com.makemytrip.core.WebActions;
import com.makemytrip.pageobjects.HomePage;
import com.makemytrip.pageobjects.LandingPO;
import com.makemytrip.pageobjects.LoginPO;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;

public class LoginTest extends RunnerTest{
	
	String uname=WebActions.getPropFileData("userDetails","testdata", "username");
	String pwd=WebActions.getPropFileData("userDetails","testdata", "password");

	@Test(groups= {"Sanity"})
	public void loginwithValidData() throws Exception {
		Reports.setTestName(this.getClass().getSimpleName());
		Log.startTestCase(this.getClass().getSimpleName());
		LandingPO.clickLoginButton();
		LoginPO.login(uname, pwd);
		VerifyAndAssert.verifyChildStringInParentString(HomePage.getHeyUsernameText(), "Hey");
	}
}
