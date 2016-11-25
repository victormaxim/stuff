package com.selenium;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SelTestCase {

	static WebDriver driver;
	
	@BeforeClass
	public void launchBrowser(){
	driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void closeBrowser(){
		//driver.close();
		//driver.quit();
		
		
	}
}
