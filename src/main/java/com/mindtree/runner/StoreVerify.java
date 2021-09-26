package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.StoreVerObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class StoreVerify {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(SignUp.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void StoreVer() throws InterruptedException {
		extentTest = report.createTest("Verifying Store name");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(StoreVerObj.Store(driver, PropertyFileReader.loadFile().getProperty("store"), log));
		log.info("Sign up test success.");
		extentTest.pass("Verified");
		
		
	}

}
