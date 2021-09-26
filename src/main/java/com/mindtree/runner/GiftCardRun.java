package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.GiftCardObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class GiftCardRun {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(LogIn.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void GiftCard() throws InterruptedException {
		extentTest = report.createTest("GiftCard Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(GiftCardObj.GiftVerify(driver, log));
		log.info("GiftCard testcase success.");
		extentTest.pass("GiftCard testcase success");
		
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}

}
