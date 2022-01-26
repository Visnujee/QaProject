package com.aspireapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	private WebDriver driver;


	public LoginPage (WebDriver driver) {
		this.driver= driver;
	}
	
	By user_Name = By.xpath("//input[@id='login']");
	By pass_Word = By.xpath("//input[@id='password']");
	By login_Btn = By.xpath("//button[(text() = 'Log in')]");
	
	
	public boolean homePageLogin(String userName, String passWord) {
		try{
		driver.findElement(user_Name).sendKeys(userName);
		driver.findElement(pass_Word).sendKeys(passWord);
		driver.findElement(login_Btn).click();
		return true;
		}catch(Exception e) {
			System.out.println("Login is not successful" + e );
			return false;
		}
		}


}
