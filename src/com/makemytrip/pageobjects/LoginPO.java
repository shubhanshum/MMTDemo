package com.makemytrip.pageobjects;

import org.openqa.selenium.WebElement;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.PageUtils;

public class LoginPO {

	public static WebElement txt_username() throws Exception {
		return PageUtils.find_Element("id", "username");
	}
	
	public static WebElement btn_continue() throws Exception {
		return PageUtils.find_Element("xpath", "//button[@data-cy='continueBtn']");
	}
	
	public static WebElement txt_pwd() throws Exception {
		return PageUtils.find_Element("id", "password");
	}
	
	public static WebElement btn_login() throws Exception {
		return PageUtils.find_Element("xpath", "//button[@data-cy='login']");
	}
	
	public static void login(String uname,String pwd) throws Exception {
		WebActions.setText(txt_username(), uname,"username");
		WebActions.click(btn_continue(), "continue button");
		WebActions.click(btn_continue(), "continue button");
		WebActions.explctWaitTillElementInvisibility(btn_continue(), "Continue button");
		WebActions.setText(txt_pwd(), pwd,"password");
		WebActions.clickUsingJS(btn_login(), "Login button");
		WebActions.explctWaitTillElementInvisibility(txt_pwd(),"password text box");
	}
}
