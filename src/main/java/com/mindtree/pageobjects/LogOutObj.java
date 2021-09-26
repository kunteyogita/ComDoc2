package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.uistore.LoginUI;

public class LogOutObj {
	public static boolean Logout(WebDriver driver, String email,String pass,Logger log) throws InterruptedException {
		 WebElement mainMenu = driver.findElement(LoginUI.profileIcon);
		    Actions actions = new Actions(driver);
		    actions.moveToElement(mainMenu);
		    WebElement subMenu = driver.findElement(LoginUI.logoutLink);
		    actions.moveToElement(subMenu);
		    actions.click().build().perform();
		    Thread.sleep(10000);
			return true;
		    
	}

}
