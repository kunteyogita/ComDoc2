package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.LogOutObj;
import com.mindtree.pageobjects.LoginObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class LogOut {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(LogIn.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void LogOutRun() throws InterruptedException {
		extentTest = report.createTest("Log out Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		LoginObj.Login(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log);
		Thread.sleep(1000);
		Assert.assertTrue(LogOutObj.Logout(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log));
		log.info("Log out test success.");
		extentTest.pass("Log out success");
		
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}
}
