package com.mindtree.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mindtree.utility.PropertyFileReader;

public class ReusableMethods {

	public static void loadURL(WebDriver driver) {
		driver.get(PropertyFileReader.loadFile().getProperty("url"));
		timelapse(driver);
		System.out.println(PropertyFileReader.loadFile().getProperty("url"));
	}
	public static void TakeScreenshot(WebDriver driver,String title) throws IOException {
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(src,new File(".\\screenshot\\"+title+".png"));
		 
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(PropertyFileReader.loadFile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
	
	public static boolean getElement(By selector, WebDriver driver) {
		try {
			driver.findElement(selector);
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s doesnt exist", selector));
		}
		return false;
	}
	
	public static boolean sendKeys(By selector, String keys, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(keys);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	public static boolean sendKeyEnter(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).sendKeys(Keys.ENTER);;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Keys could not be sent to Element %s ", selector));
		}
		return false;
	}
	
	public static boolean click(By selector, WebDriver driver) {
		try {
			driver.findElement(selector).click();;
			return true;
		}
		catch(Exception e) {
			System.out.println(String.format("Element %s could not be clicked ", selector));
		}
		return false;
	}
}
