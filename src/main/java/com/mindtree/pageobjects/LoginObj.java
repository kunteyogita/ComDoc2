package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.LoginUI;

public class LoginObj {
	public static boolean Login(WebDriver driver, String email,String pass,Logger log) throws InterruptedException {
		 WebElement mainMenu = driver.findElement(LoginUI.profileIcon);
		    Actions actions = new Actions(driver);
		    actions.moveToElement(mainMenu);
		    WebElement subMenu = driver.findElement(LoginUI.loginLink);
		    actions.moveToElement(subMenu);
		    actions.click().build().perform();
		    Thread.sleep(10000);
		    ReusableMethods.sendKeys(LoginUI.emailField, email, driver);
		    ReusableMethods.sendKeys(LoginUI.passField, pass, driver);
		    ReusableMethods.click(LoginUI.loginBtn, driver);
		    try {
		    	System.out.println(driver.findElement(By.xpath("//*[@id=\"ulerrors\"]/ul/li")).getText());
		    	return true;
		    	
		    }catch(Exception e) {
//		    	System.out.println("Login Success");
		    	return true;
		    }
	}
}
