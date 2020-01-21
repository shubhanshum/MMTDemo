package com.makemytrip.utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

private static ThreadLocal<WebDriver> threadedDriver = null;
	
	public static void getBrowser(String browserName) {
		
		threadedDriver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		
		switch(browserName) {
		
		case "chrome":
			caps = DesiredCapabilities.chrome();
			ChromeOptions chromeOption = new ChromeOptions();
			caps.setCapability(ChromeOptions.CAPABILITY, chromeOption);
			caps.setPlatform(Platform.LINUX);
			caps.setCapability("browserName", "chrome");
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
			threadedDriver.set(new ChromeDriver());
			Log.info("Chrome Browser has Launched");
			getDriver().manage().window().maximize();
			
			break;
			
		case "firefox":
			caps = DesiredCapabilities.firefox();
			caps.setPlatform(Platform.WIN10);
			caps.setCapability("build", "build-3");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"false");
			  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
			  "//Drivers//geckodriver.exe");
			  threadedDriver.set(new FirefoxDriver());
			 Log.info("Firefox Browser has Launched");
			getDriver().manage().window().maximize();
			break;
		}
	}
	
	public static WebDriver getDriver() {
		WebDriver driver = null;
		try {
			driver = threadedDriver.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
}
