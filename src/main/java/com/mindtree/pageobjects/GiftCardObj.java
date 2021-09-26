package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class GiftCardObj {
	public static boolean GiftVerify(WebDriver driver,Logger log) {
		ReusableMethods.click(SignUpUI.giftcardLink, driver);
		try {
		System.out.println(driver.findElement(SignUpUI.giftCardText).getText());
		return true;
		}
		catch(Exception e) {
			System.out.println("No page found");
			return false;
		}
	}
}
