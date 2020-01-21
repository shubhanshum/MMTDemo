package com.makemytrip.tests;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.makemytrip.core.WebActions;
import com.makemytrip.utilities.BrowserFactory;
import com.makemytrip.utilities.Reports;

public class RunnerTest extends Reports{

	@BeforeClass(alwaysRun=true)
	@Parameters({ "browserName" })
	public void setUp(String browserName) {
		if (extent == null) {
			PropertyConfigurator.configure("log4j.properties");
			Reports.setReport();
			BrowserFactory.getBrowser(browserName);
			WebActions.navigateToURL();
		}
		BrowserFactory.getBrowser(browserName);
		WebActions.navigateToURL();
	}

	@AfterMethod(alwaysRun = true)
	public void verifyingResult(ITestResult result) {
		  Reports.getResult(result); 
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {
		BrowserFactory.getDriver().close();
		Reports.flush();
	}
}
