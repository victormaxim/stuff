package com.selenium;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SelTestCase {

	FirefoxDriver driver;
	
	@BeforeMethod
	public void launchBrowser(){
	driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
		driver.quit();
		
		
	}
}
