package com.makemytrip.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageUtils {

	public static WebElement  find_Element(String locator, String attri) throws Exception{
	     return	BrowserFactory.getDriver().findElement(buildLocator(locator, attri));
	}
	
	public static List<WebElement>  find_Elements(String locator, String attri) throws Exception{
	     return	BrowserFactory.getDriver().findElements(buildLocator(locator, attri));
	}
	
	public static By buildLocator(String locator, String attribute) throws Exception {
		switch (locator.toLowerCase()) {
		case "id":
			return By.id(attribute);
		case "name":
			return By.name(attribute);
		case "class":
		case "classname":
			return By.className(attribute);
		case "css":
		case "cssSelector":
			return By.cssSelector(attribute);
		case "linktext":
		case "link":
			return By.linkText(attribute);
		case "partiallinktext":
		case "partiallink":
			return By.partialLinkText(attribute);
		case "tagname":
		case "tag":
		case "html tag":
		case "htmltag":
			return By.tagName(attribute);
		case "xpath":
			return By.xpath(attribute);
		default:
			throw new Exception("Unknown locator type :" + attribute);
		}
	}
}
