package com.aspireapp.test;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPage extends BasePage {
	public Properties prop ;
	
	public TestPage() throws IOException {
		prop = UtlityPage.userInput();
	}
	
  @Test(priority=1)
  public void login() throws IOException {
	  LoginPage lpage = new LoginPage(driver);
	  Assert.assertTrue(lpage.homePageLogin(prop.getProperty("UserName"),prop.getProperty("PassWord")));
  }
  
  @Test(priority=2)
  public void createNewProduct() {
	  ProductPage pp = new ProductPage(driver);
	  Assert.assertTrue(pp.navigateProductPage());
	  Assert.assertTrue(pp.createProduct(prop.getProperty("ProductName"),prop.getProperty("Quantity")));
  }
  
  @Test(priority=3)
  public void createManufactureProduct() throws InterruptedException {
	  ManufacturePage mp = new ManufacturePage(driver);
	  Assert.assertTrue(mp.createMaufactureItem(prop.getProperty("ProductName")));
  }
  
  @Test(priority=4)
  public void verifyProductDetails() {
	  ManufacturePage mp = new ManufacturePage(driver);
	  Assert.assertTrue(mp.checkProductDetails(prop.getProperty("ProductName"),prop.getProperty("Quantity")));
  }
  
}
