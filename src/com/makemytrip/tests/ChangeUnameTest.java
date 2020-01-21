package com.makemytrip.tests;

import org.testng.annotations.Test;

import com.makemytrip.context.TestContext;
import com.makemytrip.core.VerifyAndAssert;
import com.makemytrip.core.WebActions;
import com.makemytrip.pageobjects.HomePage;
import com.makemytrip.pageobjects.LandingPO;
import com.makemytrip.pageobjects.LoginPO;
import com.makemytrip.pageobjects.MyProfilePO;
import com.makemytrip.testdata.PageURLs;
import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;

public class ChangeUnameTest extends RunnerTest{

	String uname=WebActions.getPropFileData("userDetails", "username");
	String newUname=WebActions.getPropFileData("userDetails", "newUsername");
	String pwd=WebActions.getPropFileData("userDetails", "password");
	String lastName=WebActions.getPropFileData("userDetails", "lastName");
	
	
	@Test(groups= {"Regression","Sanity"})
	public void changeUserNameTest() throws Exception {
		String expUserName="";
		Reports.setTestName(this.getClass().getSimpleName());
		Log.startTestCase(this.getClass().getSimpleName());
		LandingPO.clickLoginButton();
		LoginPO.login(uname, pwd);
		VerifyAndAssert.verifyChildStringInParentString(HomePage.getHeyUsernameText(), "Hey");
		expUserName=HomePage.getHeyUsernameText();
		HomePage.clickHeyUserNameLink();
		HomePage.clickMyProfileLink();
		VerifyAndAssert.verifyUrl(PageURLs.myProfilePage);
		String profileName=MyProfilePO.changeUserName(newUname, lastName);
		VerifyAndAssert.verifyText(profileName.substring(4), newUname);
		
	}
}
