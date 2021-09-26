package com.mindtree.runner;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.TrackOrderObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class TrackOrder {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(SignUp.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void Trackorder(){
		extentTest = report.createTest("Track order");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=TrackOrderObj.Track(driver, PropertyFileReader.loadFile().getProperty("trackid"), PropertyFileReader.loadFile().getProperty("mob"), log);
		assertTrue(isSearch);
		 log.info("Track order success");
		 extentTest.pass("Track order success");
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}

}
