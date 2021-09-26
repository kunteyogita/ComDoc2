package com.mindtree.uistore;

import org.openqa.selenium.By;

public class SignUpUI {
	public static By giftCardText=By.className("_1bluI");
	public static By giftcardLink=By.xpath("/html/body/div[1]/header/section/div/ul[2]/li[3]/a");
	public static By chatBoxOpen= By.xpath("/html/body/div[2]/div[2]/div[1]");
	public static By profileLink=By.xpath("/html/body/div[1]/header/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a");
	public static By profileEmail=By.xpath("/html/body/div[1]/div[1]/div[2]/div/div/table/tbody/tr[2]/td[2]");
	public static By tracSubBtn=By.xpath("/html/body/div[1]/div/main/section/form[1]/button");
	public static By tracLink=By.xpath("/html/body/div[1]/header/section/div/ul[1]/li[2]/a");
	public static By tracEmail=By.xpath("/html/body/div[1]/div/main/section/form[1]/div[1]/input");
	public static By tracMob  =By.xpath("/html/body/div[1]/div/main/section/form[1]/div[2]/input");
	public static By subEmail=By.xpath("/html/body/div[1]/footer/div[1]/div[1]/form/div[1]/input");
	public static By subBtn	= By.xpath("/html/body/div[1]/footer/div[1]/div[1]/form/div[2]/input");
	public static By storeLink=By.xpath("/html/body/div[1]/header/section/div/ul[2]/li[1]/a");
	public static By helpBtn =By.xpath("/html/body/div[1]/header/section/div/ul[1]/li[1]/a");
	public static By searchBox = By.xpath("//*[@id=\"search\"]");
	public static By searchButton = By.id("nav-search-submit-button");
	public static By SignUp_mail=By.xpath("//*[@id=\'spree_user_email\']");
	public static By SignUp_pass=By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[2]/form/div/div/input[2]");
	public static By SignUp_btn =By.xpath("/html/body/div[6]/div/div[1]/div/div[2]/div[2]/form/input[4]");
	public static By EmailExists=By.xpath("//*[@id=\"ulerrors\"]/ul/li");
	
	

}
