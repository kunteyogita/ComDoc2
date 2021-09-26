package com.mindtree.uistore;

import org.openqa.selenium.By;

public class LoginUI {
	public static By logoutLink =By.xpath("/html/body/div[1]/header/div[1]/div/section[3]/ul/li[2]/span/ul/li[4]/a");
	public static By profileIcon=By.cssSelector("#header > div.header__topBar > div > section.header__topBar_sectionRight > ul > li.header__topBarIconList_profile-icon > span > svg > path");
	public static By loginLink	=By.xpath("//*[@id=\'header\']/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a");
	public static By emailField =By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/input");
	public static By passField	=By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input");
	public static By loginBtn	=By.xpath("//*[@id=\"ul_site_login\"]");
	
}
