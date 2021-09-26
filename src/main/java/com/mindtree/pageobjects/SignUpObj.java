package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class SignUpObj {
	public static boolean signUp(WebDriver driver, String email,String pass,Logger log) throws InterruptedException {
		 Thread.sleep(10000);
		 //Email id locator :
		 ReusableMethods.sendKeys(SignUpUI.SignUp_mail, email, driver);
	     //Password locator :
		 ReusableMethods.sendKeys(SignUpUI.SignUp_pass, pass, driver);
		 //SignUp button
		 ReusableMethods.click(SignUpUI.SignUp_btn, driver);
		    try
		    {
		    	System.out.println(driver.findElement(By.xpath("//*[@id=\"ulerrors\"]/ul/li")).getText());
		    	
		    }catch(Exception e) {
		    	System.out.println("You have been signed up!");
		    }
		return true;
		
	}
}
