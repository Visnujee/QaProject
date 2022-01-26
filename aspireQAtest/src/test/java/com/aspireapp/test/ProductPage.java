package com.aspireapp.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By inventroyOption = By.xpath("//div[(text() = 'Inventory')]");
	By productMenu = By.xpath("//a[contains(text(),'Products')]");
	By productopton = By.xpath("//span[(text() = 'Products')]");
	
	public boolean navigateProductPage() {
		try {
			driver.findElement(inventroyOption).click();
			driver.findElement(productMenu).click();
			driver.findElement(productopton).click();
			return true;
		}catch(Exception e) {
			System.out.println("Not able to navigate to product page " + e );
			return false;
		}
	}
	
	By createBtn = By.xpath("//button[contains(text(), 'Create')]");
	By productNametxtbox = By.xpath("//input[@name='name']");
	By updateQuantitytxtbox = By.xpath("//span[(text() = 'Update Quantity')]");
	By creatbtncheck = By.xpath("//button[contains(text(), 'Create')]//parent::div");
	By autoCompleteinputtxtbox = By.xpath("//div[@name='location_id']//input[@class='o_input ui-autocomplete-input']");
	By inventryQuantity = By.xpath("//input[@name='inventory_quantity']");
	By saveBtn = By.xpath("//button[contains(text(), 'Save')]");
	
	public boolean createProduct(String productName,String quantity) {
		try {
			driver.findElement(createBtn).click();
			driver.findElement(productNametxtbox).sendKeys("ProjectTest2");
			driver.findElement(updateQuantitytxtbox).click();
			new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(creatbtncheck));	                       
			driver.findElement(createBtn).click();		
			driver.findElement(autoCompleteinputtxtbox).click();		
			driver.findElement(autoCompleteinputtxtbox).sendKeys(Keys.ENTER);
		    WebElement input= driver.findElement(inventryQuantity);
		    input.clear();
		    input.sendKeys(quantity);
			driver.findElement(saveBtn).click();
			return true;
		}
		catch(Exception e)
			{
			System.out.println("Not able to create the product "+ e);
			return false;
			}
		
	}
	
	


}
