package com.makemytrip.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Reports;

public class RunnerTest extends Reports{

	@BeforeClass()
	@Parameters({ "browserName" })
	public void setUp(String browserName) {
			PropertyConfigurator.configure("log4j.properties");
			Reports.setReport();
			BrowserFactory.getBrowser(browserName);
			WebActions.navigateToURL();
	}

	@AfterMethod(alwaysRun = true)
	public void verifyingResult(ITestResult result) {
		  Reports.getResult(result); 
	}

	@AfterClass()
	public void tearDown() {
		//BrowserFactory.getDriver().close();
		Reports.flush();
	}
}
