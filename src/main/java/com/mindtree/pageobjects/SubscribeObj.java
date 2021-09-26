package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class SubscribeObj {
	public static boolean Subscribe(WebDriver driver,String email) {
		ReusableMethods.sendKeys(SignUpUI.subEmail, email, driver);
		
		
		ReusableMethods.click(SignUpUI.subBtn,driver);
		
		return true;
		
	}
}
