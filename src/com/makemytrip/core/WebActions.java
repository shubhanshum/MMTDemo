package com.makemytrip.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Log;
import com.makemytrip.utilities.Reports;


public class WebActions {

	
	public static String loadUrl() {
		String testUrl = null;
		try {
			testUrl = System.getProperty("ENVT_URL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testUrl;
	}
	
	public static String loadEmailForSuiteResult() {
		String testUrl = null;
		try {
			testUrl = System.getProperty("UserEmail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testUrl;
	}
	
	public static void navigateToURL() {
		String testURL=WebActions.loadUrl();
		Log.info("Navigating to URL>"+testURL);
		try {
			BrowserFactory.getDriver().navigate().to(testURL);
			Log.info("Pass:Navigated to URL>"+testURL);
		}
		catch(Exception e) {
			Log.info("Fail:Could not navigate to URL>"+testURL);
			e.printStackTrace();
		}
	}
	
	public static void clearTextField(WebElement Element, String name) {
		Log.info("Clearing " + name + " text field");
		explctWaitTillElementVisibility(Element,name);
		try {
			Element.clear();
			Log.info("Pass: Text Field " + name + " has been cleared");
			Reports.setMethodMessage("Pass: Text Field " + name + " has been cleared");
		} catch (Exception e) {
			Log.info("Fail:Could not clear " + name + " text field");
			Reports.setMethodMessage("Fail:Could not clear " + name + " text field");
			e.printStackTrace();
		}
	}
	
	public static void clearTextFieldUsingKeys(WebElement Element, String name) {
		Log.info("Clearing " + name + " text field");
		explctWaitTillElementVisibility(Element,name);
		try {
			Element.click();
			String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE; 
			Element.sendKeys(del);
			Log.info("Pass: Text Field " + name + " has been cleared");
			Reports.setMethodMessage("Pass: Text Field " + name + " has been cleared");
		} catch (Exception e) {
			Log.info("Fail:Could not clear " + name + " text field");
			Reports.setMethodMessage("Fail:Could not clear " + name + " text field");
			e.printStackTrace();
		}
	}
	
	public static void setText(WebElement Element, String Text,String field) {
		Log.info("Setting text");
		explctWaitTillElementVisibility(Element,field);
		try {
			Element.sendKeys(Text);
			Log.info("Pass:" + Text + " is entered in "+field+ " text box");
			Reports.setMethodMessage("Pass:" + Text + " is entered");
		} catch (Exception e) {
			Log.info("Fail:Unable to set text: " + Text);
			Reports.setMethodMessage("Fail:Unable to set text: " + Text);
			e.printStackTrace();
		}
	}
	
	public static void click(WebElement Element, String name) {
		Log.info("Clicking on" + name);
		explctWaitTillElementBecomesClickable(Element,name);
		try {
			Element.click();
			Log.info("Pass: " + name + " :is clicked");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on " + name);
			Assert.fail();
		}
	}

	public static void clickUsingJS(WebElement Element, String name) {
		Log.info("Clicking using JS on: " + name);
		explctWaitTillElementBecomesClickable(Element,name);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) BrowserFactory.getDriver();
			executor.executeScript("arguments[0].click();", Element);
			Log.info("Pass: " + name + " :is clicked");
			Reports.setMethodMessage("Pass: " + name + " :is clicked");
		} catch (Exception e) {
			Log.info("Fail:Could not Click on: " + name);
			Reports.setMethodMessage("Fail:Could not Click on: " + name);
			e.printStackTrace();
		}
	}
	
	public static void explctWaitTillElementVisibility(WebElement Element, String name) {
		Log.info("waiting for " + name + " to display");
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 25);
		wait.until(ExpectedConditions.visibilityOf(Element));
		Log.info("Pass: " + name + " is displayed");
	}
	
	public static void explctWaitTillElementBecomesClickable(WebElement Element, String name) {
		Log.info("waiting for " + name + " to be clickable");
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 25);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		Log.info("Pass: " + name + " is clickable");
	}
	
	public static void explctWaitTillElementInvisibility(WebElement Element, String name) {
		Log.info("waiting for " + name + " to become invisible");
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 15);
		wait.until(ExpectedConditions.invisibilityOf(Element));
		Log.info("Pass:"+name+" is invisible");
	}
	
	public static boolean checkBrowserReadyState() {
		JavascriptExecutor js = (JavascriptExecutor) BrowserFactory.getDriver();
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return true;
		} else {
			return false;
		}
	}

	public synchronized static void waitForBrowsertoload() {
         Log.info("Waiting for borwser to load");
		try {
			boolean isReady = checkBrowserReadyState();
			System.out.println("Browser state:"+isReady);
			if (isReady==false) {
				for (int i = 0; i < 90; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {

					}
					isReady = checkBrowserReadyState();
					if (isReady==true) {
						break;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getElementText(WebElement Element) {
		Log.info("Getting Element Text");
		String text = "";
		try {
			text = Element.getText().trim();
			Log.info("Pass:Text is:" + text);
			Reports.setMethodMessage("Pass:Element Text is:" + text);
		} catch (Exception e) {
			Log.info("Could not get text");
			Reports.setMethodMessage("Could not get Element text");
			e.printStackTrace();
		}
		return text;
	}

	public static String getAttributeText(WebElement Element, String attributeName) {
		Log.info("Getting attribute:" + attributeName + " text");
		String attributeValue = "";
		try {
			attributeValue = Element.getAttribute(attributeName).toString().trim();
			Log.info("Pass:Attribute " + attributeName + " text is:" + attributeValue);
			Reports.setMethodMessage("Pass:Attribute " + attributeName + " text is:" + attributeValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return attributeValue;
	}
	
	public static String getPropFileData(String propFileName, String key) {
		FileInputStream file;
		Properties prop;
		String data = "";
		try {
			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\com\\makemytrip\\testdata\\" + propFileName + ".properties");
			prop = new Properties();
			prop.load(file);
			data = prop.getProperty(key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void waitFor(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickUsingActions(WebElement Element, String name) {
		Log.info("Clicking using Actions on:" + name);
		Reports.setMethodMessage("Clicking using Actions on:" + name);
		try {
			WebElement element = Element;
			Actions action = new Actions(BrowserFactory.getDriver());
			((JavascriptExecutor) BrowserFactory.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
			WebActions.waitFor(1);
			action.moveToElement(element).click().perform();
			Log.info("Pass:" + name + " is clicked");
			Reports.setMethodMessage("Pass:" + name + " is clicked");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Fail:Could not Click on:" + name);
			Reports.setMethodMessage("Fail:Could not Click on:" + name);
			Assert.fail();
		}
	}
	
	public static void waitForAjaxToLoad() {
		Log.info("Waiting for ajax to load");
		Reports.setMethodMessage("Waiting for ajax to load");
		WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 90);
		JavascriptExecutor jse = (JavascriptExecutor) BrowserFactory.getDriver();

		String angularReadyScript = "return angular.element(document).injector().get('$http').pendingRequests.length === 0";

		// Wait for ANGULAR to load
		ExpectedCondition<Boolean> angularLoad = driver -> Boolean
				.valueOf(((JavascriptExecutor) driver).executeScript(angularReadyScript).toString());


		

		// Get Angular is Ready
		boolean angularReady = Boolean.valueOf(jse.executeScript(angularReadyScript).toString());
					
		// Wait ANGULAR until it is Ready!
		if (!angularReady) {
			Log.info("ANGULAR is NOT Ready!");
			Reports.setMethodMessage("ANGULAR is NOT Ready!");
			wait.until(angularLoad);
		} else {
			Log.info("ANGULAR is Ready!");
			Reports.setMethodMessage("ANGULAR is Ready!");
		}
	}
	
	public static void switchToWindow(int windowIndex) {
		Log.info("Handling multiple tabs");
		if (windowIndex!=0) {
			WebActions.explctWaitTillTwoWindows();
		}
		ArrayList windows = new ArrayList(BrowserFactory.getDriver().getWindowHandles());
		Log.info("Tabs size:" + windows.size());
		BrowserFactory.getDriver().switchTo().window((String) windows.get(windowIndex));
		Log.info("Pass:Switched to window-" + windowIndex);
	}
	
	public static void explctWaitTillTwoWindows() {
		Log.info("waiting for 2 windows");
		
		try {
			WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 25);
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		}catch(Exception e) {
			Log.info("");
			e.printStackTrace();
		}
		
		Log.info("Pass:2 windows are displayed");
		
	}
	
	public static void closeBrowser() {
		BrowserFactory.getDriver().close();
	}
	
	public static void refreshPage() {
		Log.info("Refreshing page");
		try {
			BrowserFactory.getDriver().navigate().refresh();
			Log.info("Pass:Refreshed page");
		} catch (Exception e) {
			Log.info("Fail:Refresh page");
			e.printStackTrace();
		}
	}
	
}
