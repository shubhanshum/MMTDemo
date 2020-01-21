package com.makemytrip.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.makemytrip.context.TestContext;
import com.makemytrip.core.WebActions;
import com.makemytrip.enums.Context;
import com.makemytrip.utilities.PageUtils;

public class MyProfilePO {
	
    static TestContext testContext;
	
	public MyProfilePO(TestContext context) {
		this.testContext=context;
	}

	public static WebElement str_sidebarProfileName() throws Exception {
		return PageUtils.find_Element("css", "div.profilSdeBar__contntWrap>p.blackText");
	}
	
	public static List<WebElement> btn_editAndAddTraveller() throws Exception {
		return PageUtils.find_Elements("css", "button.btn__dtailAdEdt>span.myPrfilSprit");
	}
	
	public static WebElement txt_firstName() throws Exception {
		return PageUtils.find_Element("id", "profileFirstName");
	}
	
	public static WebElement txt_lastName() throws Exception {
		return PageUtils.find_Element("id", "profileLastName");
	}
	
	public static WebElement btn_save() throws Exception {
		return PageUtils.find_Element("css", "div.profilEdtFomCrd__footer>button");
	}
	
	public static WebElement str_userName() throws Exception {
		return PageUtils.find_Element("css", "span.chUserInfoName");
	}
	
	
	public static String changeUserName(String fname,String lname) throws Exception {
		WebActions.waitForBrowsertoload();
		WebActions.waitFor(2);
		WebActions.clickUsingJS(btn_editAndAddTraveller().get(0), "Edit button");
		WebActions.waitFor(1);
		WebActions.clearTextFieldUsingKeys(txt_firstName(), "First Name");
		WebActions.setText(txt_firstName(), fname, "First Name");
		WebActions.waitFor(1);
		WebActions.clearTextFieldUsingKeys(txt_lastName(), "Last Name");
		WebActions.waitFor(1);
		WebActions.setText(txt_lastName(), lname, "Last Name");
		WebActions.clickUsingJS(btn_save(), "Save button");
		WebActions.refreshPage();
		WebActions.waitForBrowsertoload();
		String profileName=WebActions.getElementText(str_userName());
		return profileName;
	}
	
}
