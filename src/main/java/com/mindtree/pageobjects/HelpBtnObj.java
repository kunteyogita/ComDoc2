package com.mindtree.pageobjects;

import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class HelpBtnObj {
	public static boolean help(WebDriver driver) {
		ReusableMethods.click(SignUpUI.helpBtn,driver);
		
		return true;
		
	}

}
