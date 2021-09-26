package com.mindtree.runner;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.mindtree.pageobjects.GiftCardObj;
import com.mindtree.pageobjects.HelpBtnObj;
import com.mindtree.pageobjects.LogOutObj;
import com.mindtree.pageobjects.LoginObj;
import com.mindtree.pageobjects.ProfileEmailVerifyObj;
import com.mindtree.pageobjects.SearchObj;
import com.mindtree.pageobjects.SignUpObj;
import com.mindtree.pageobjects.StoreVerObj;
import com.mindtree.pageobjects.SubscribeObj;
import com.mindtree.pageobjects.TrackOrderObj;
import com.mindtree.reusablecomponents.ReusableComponents;
import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.utility.ExcelReader;
import com.mindtree.utility.ExtentReport;
import com.mindtree.utility.Log;
import com.mindtree.utility.PropertyFileReader;

public class Runner {
	private ExtentReports report= ExtentReport.generateReport();
	private ExtentTest extentTest;
	private Logger log = Log.logger(Runner.class.getName());
	WebDriver driver;
	@BeforeMethod
	void testing() throws IOException {
		 driver =  ReusableComponents.loadDriver();
	}
	@Test(priority=0)
	public void signrun() throws InterruptedException, IOException {
		extentTest = report.createTest("Sign up test case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(SignUpObj.signUp(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log));
		log.info("Sign up test success.");
		ReusableMethods.TakeScreenshot(driver, "Sign in");
		extentTest.pass("Sign up success");
		
		
	}
	@Test(priority=1)
	public void LoginRun() throws InterruptedException, IOException {
		extentTest = report.createTest("Login Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(LoginObj.Login(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log));
		log.info("Login test success.");
		ReusableMethods.TakeScreenshot(driver, "Log in");
		extentTest.pass("Log in success");
		
	}

	@Test(priority=2,dataProvider="getTestData")
	void testSearchTitle(String data) throws IOException {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
			extentTest = report.createTest("UrbenLadder Search");
			assertTrue(SearchObj.search(driver, data, log));
			log.info("Search test Case Success");
			ReusableMethods.TakeScreenshot(driver, "Searching");
			extentTest.pass("Search test Case Success");
		}

	@Test(priority=3)
	public void ProfileVer() throws InterruptedException, IOException {
		extentTest = report.createTest("Profile Verify Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		LoginObj.Login(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log);
		Thread.sleep(1000);
		Assert.assertTrue(ProfileEmailVerifyObj.ProfileMailVer(driver, PropertyFileReader.loadFile().getProperty("email"),log));
		log.info("Email verification test success.");
		ReusableMethods.TakeScreenshot(driver, "Profile Verification");
		extentTest.pass("Email verification success");
		
	}

	@Test(priority=4)
	public void HelpBtn() throws IOException{
		extentTest = report.createTest("QA section ");
		try {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=HelpBtnObj.help(driver);
		assertTrue(isSearch);
		ReusableMethods.TakeScreenshot(driver, "Help Button");
		 log.info("Help button passed");
		 extentTest.pass("QA Section passed");
		}catch(Exception e) {
			extentTest.fail("QA section failed");
		}
	}
	@Test(priority=5)
	public void StoreVer() throws InterruptedException, IOException {
		extentTest = report.createTest("Verifying Store name");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(StoreVerObj.Store(driver, PropertyFileReader.loadFile().getProperty("store"), log));
		log.info("Sign up test success.");
		ReusableMethods.TakeScreenshot(driver, "Store verified");
		extentTest.pass("Verified");
	}
	@Test(priority=6)
	public void Trackorder() throws IOException{
		extentTest = report.createTest("Track order");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=TrackOrderObj.Track(driver, PropertyFileReader.loadFile().getProperty("trackid"), PropertyFileReader.loadFile().getProperty("mob"), log);
		assertTrue(isSearch);
		ReusableMethods.TakeScreenshot(driver, "Order Tracking");
		 log.info("Track order success");
		 extentTest.pass("Track order success");
	}

	@Test(priority=7)
	public void Subscribe() throws IOException{
		extentTest = report.createTest("Subscribe");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		boolean isSearch=SubscribeObj.Subscribe(driver,PropertyFileReader.loadFile().getProperty("email"));
		assertTrue(isSearch);
		ReusableMethods.TakeScreenshot(driver, "Subscribing");
		 log.info("Subscribe passed");
		 extentTest.pass("Subscribe passed");
	}
	@Test(priority=8)
	public void GiftCard() throws InterruptedException, IOException {
		extentTest = report.createTest("GiftCard Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		Assert.assertTrue(GiftCardObj.GiftVerify(driver, log));
		ReusableMethods.TakeScreenshot(driver, "Gift Card");
		log.info("GiftCard testcase success.");
		extentTest.pass("GiftCard testcase success");
		
	}
	@Test(priority=9)
	public void LogOutRun() throws InterruptedException, IOException {
		extentTest = report.createTest("Log out Test Case");
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		LoginObj.Login(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log);
		Thread.sleep(1000);
		Assert.assertTrue(LogOutObj.Logout(driver, PropertyFileReader.loadFile().getProperty("email"),PropertyFileReader.loadFile().getProperty("pass"), log));
		log.info("Log out test success.");
		ReusableMethods.TakeScreenshot(driver, "Log out");
		extentTest.pass("Log out success");
		
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
	
	@AfterMethod
	void clean() {
		
		report.flush();
		driver.close();
	}
	
}