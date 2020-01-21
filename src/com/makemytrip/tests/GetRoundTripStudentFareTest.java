package com.makemytrip.tests;

import org.testng.annotations.Test;

import com.makemytrip.pageobjects.FlightListPO;
import com.makemytrip.pageobjects.LandingPO;
import com.makemytrip.utilities.Reports;

public class GetRoundTripStudentFareTest extends RunnerTest{

	@Test(groups= {"Regression","Sanity"})
	public void getRoundTripStudentFareOfFlight() throws Exception {
		Reports.setTestName(this.getClass().getSimpleName());
		LandingPO.searchRoundtripStudentFare();
		FlightListPO.displayFourFlightDetails();
	}
}
