package com.aspireapp.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManufacturePage {
	
	private WebDriver driver;
	
	public ManufacturePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By applicationMenu = By.xpath("//a[@title='Applications']");
	By manufacturingOption = By.xpath("//div[(text() = 'Manufacturing')]");
	By creatxtBox = By.xpath("//button[contains(text(), 'Create')]");
	By autoCompleteInputtxt = By.xpath("//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']");
	By addLink = By.xpath("//a[contains(text(), 'Add a line')]");
	By autoCompleteProduct = By.xpath("//tr[@class='o_data_row o_selected_row']//div[@name='product_id']//input[@class='o_input ui-autocomplete-input']");
	By saveBtn = By.xpath("//button[@type='button'][contains(.,'Save')]");
	
	public boolean createMaufactureItem(String productName) throws InterruptedException {
		try {
			driver.findElement(applicationMenu).click();
			driver.findElement(manufacturingOption).click();
			driver.findElement(creatxtBox).click();
			driver.findElement(autoCompleteInputtxt).click();
			driver.findElement(autoCompleteInputtxt).sendKeys(productName);
			Thread.sleep(5000);
			driver.findElement(autoCompleteInputtxt).sendKeys(Keys.ENTER);
		    driver.findElement(addLink).click();
		    driver.findElement(autoCompleteProduct).click();
		    driver.findElement(autoCompleteProduct).sendKeys(productName);
		    Thread.sleep(5000);
			driver.findElement(autoCompleteProduct).sendKeys(Keys.ENTER);
			driver.findElement(saveBtn).click();
			return true;
		}
		catch(Exception e) {
			System.out.println("Not able to create Manufacturingitem "+e);
			return false;
			}
	}
	String productName = "//span[.='%s']";
	By quanityNumber = By.xpath("//span[@class='o_field_float o_field_number o_field_widget o_required_modifier oe_inline text-left']");
	String productcategory ="//tr[@class='o_data_row']/td[.='%s']";
	
	public boolean checkProductDetails(String prName,String prQuantity) {
		boolean flag = false;
		try {
			 String prodName,quantity,prodCategory;
			 prodName = driver.findElement(convertXpath(productName,prName)).getText();
			 quantity = driver.findElement(quanityNumber).getText();
			 prodCategory =driver.findElement(convertXpath(productcategory,prName)).getText();
			 System.out.println(quantity);
			 if(prodName.equalsIgnoreCase(prName) && quantity.equals(prQuantity) && prodCategory.equals(prName)) {
				 flag=true;
			 }
			 return flag;
		}catch(Exception e) {
			System.out.println("Added product not saved properly "+ e);
			return flag;
		}
	}

	public By convertXpath(String xPath, String value) {
		System.out.println(xPath);
		String temp = xPath.toString();
		By ele;
		String path = String.format(temp, value);
		System.out.println(path);
		ele = By.xpath(path);
		System.out.print(ele);
		return ele;
		}
}
