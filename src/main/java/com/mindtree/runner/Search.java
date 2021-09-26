package com.mindtree.runner;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.SearchObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.utility.ExcelReader;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class Search {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(Search.class.getName());
	WebDriver driver;
	

	@BeforeClass
	void testing() {
		 driver =  ReusableComponents.loadDriver();
	}
	
	@Test(dataProvider="getTestData")
	void testSearchTitle(String data) throws IOException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
			extentTest = report.createTest("UrbenLadder Search");
			

			assertTrue(SearchObj.search(driver, data, log));
			log.info("Search test Case Success");
			extentTest.pass("Search test Case Success");
		}
	
	@BeforeTest
	@DataProvider(name="getTestData")
	public Object[][] getTestData() {
		Object[][]data = null;
		try {
			data= ExcelReader.readExcel();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	@AfterSuite
	void clean() {
		report.flush();
		driver.quit();
		
	}
}
