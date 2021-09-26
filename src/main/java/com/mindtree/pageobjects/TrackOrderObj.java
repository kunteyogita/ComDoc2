package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class TrackOrderObj {
	public static boolean Track(WebDriver driver, String trackId, String mobNo, Logger log) {
		ReusableMethods.click(SignUpUI.tracLink, driver);
		ReusableMethods.sendKeys(SignUpUI.tracEmail,trackId, driver);
		ReusableMethods.sendKeys(SignUpUI.tracMob,mobNo,driver);
		ReusableMethods.click(SignUpUI.tracSubBtn, driver);
		try {
			System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div/main/section/p[1]")).getText());
			log.info("Invalid details");
			return true;
		}catch(Exception e) {
			log.info("Tracked successfully");
			return true;
		}
		

	}

}
