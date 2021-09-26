package com.mindtree.runner;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.SignUpObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class SignUp {

	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(SignUp.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void signrun() throws InterruptedException {
		extentTest = report.createTest("Sign up test case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(SignUpObj.signUp(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log));
		log.info("Sign up test success.");
		extentTest.pass("Sign up success");
		
		
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}

}
