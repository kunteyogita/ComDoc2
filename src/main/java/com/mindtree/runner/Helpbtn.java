package com.mindtree.runner;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.HelpBtnObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class Helpbtn {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(Helpbtn.class.getName());
	WebDriver driver;
	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test
	public void HelpBtn() throws IOException{
		extentTest = report.createTest("QA section ");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=HelpBtnObj.help(driver);
		assertTrue(isSearch);
		ReusableMethods.TakeScreenshot(driver, "Help Button");
		 log.info("Help button passed");
		 extentTest.pass("QA Section passed");
	}
	@AfterClass
	void clean() {
		report.flush();
		driver.quit();
	}

}
