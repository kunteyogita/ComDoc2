package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class SearchObj {
	public static boolean search(WebDriver driver, String searchKey, Logger log) {
		if(ReusableMethods.getElement(SignUpUI.searchBox, driver)) {
			log.info("Clicked on searchbox");
			ReusableMethods.sendKeys(SignUpUI.searchBox, searchKey,driver);
			if(ReusableMethods.sendKeyEnter(SignUpUI.searchBox, driver)) {
					return true;
				
			}
		}
		return false;
	}

}
