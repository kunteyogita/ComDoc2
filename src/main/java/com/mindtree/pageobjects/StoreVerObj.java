package com.mindtree.pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusablecomponents.ReusableMethods;
import com.mindtree.uistore.SignUpUI;

public class StoreVerObj {
	public static boolean Store(WebDriver driver, String storename,Logger log) {
		ReusableMethods.click(SignUpUI.storeLink, driver);
		int flag=0;
	int size=	driver.findElements(By.className("_3JJeW")).size();
		for(int i=0;i<size;i++) {
			if(driver.findElements(By.className("_3JJeW")).get(i).getText().equals(storename)) {
				log.info("Store Found");
				System.out.println("Store Found");
				break;
			}
			else {
				flag=1;
			}
		}
		if(flag==1) {
			System.out.println("Store not found");
			log.info("Store not found");
		}
		
		return true;
	}

}
