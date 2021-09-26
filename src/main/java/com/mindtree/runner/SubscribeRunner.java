package com.mindtree.runner;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.SubscribeObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class SubscribeRunner {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(SignUp.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void HelpBtn(){
		extentTest = report.createTest("Subscribe");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=SubscribeObj.Subscribe(driver,PropertyFileReader.loadFile().getProperty("email"));
		assertTrue(isSearch);
		 log.info("Subscribe passed");
		 extentTest.pass("Subscribe passed");
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}
}
