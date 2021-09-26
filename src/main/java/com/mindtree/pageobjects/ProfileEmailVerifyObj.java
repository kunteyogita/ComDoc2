package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.uistore.LoginUI;
import com.mindtree.uistore.SignUpUI;

public class ProfileEmailVerifyObj {
	public static boolean ProfileMailVer(WebDriver driver, String email,Logger log) {
		 WebElement mainMenu = driver.findElement(LoginUI.profileIcon);
		    Actions actions = new Actions(driver);
		    actions.moveToElement(mainMenu);
		    WebElement subMenu = driver.findElement(SignUpUI.profileLink);
		    actions.moveToElement(subMenu);
		    actions.click().build().perform();
		    String emailActual=driver.findElement(SignUpUI.profileEmail).getText();
		    System.out.println(emailActual);
		    if(emailActual.contains(email)) return true;
		    else return false;
	}

}
