package com.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropDown {

//static WebDriver driver = new FirefoxDriver();
	
	
	@Test
	public static void simpleOrder(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://www.soastastore.com/?page_id=4");
		
		
		
		//driver.findElement(By.id("product_111_submit_button")).click();
		//driver.findElement(By.xpath("//*[@id='cart-widget-links']/a")).click();
		//driver.findElement(By.xpath("//*[@id='default_products_page_container']/div/div[1]/div[2]/div[2]/div[2]/form/select"));
		Select drop = new Select(driver.findElement(By.xpath("//*[@id='default_products_page_container']/div/div[1]/div[2]/div[2]/div[2]/form/select")));
		drop.selectByIndex(2);
		
		//driver.findElement(By.id("log")).sendKeys("kvl");
		//driver = new FirefoxDriver();
	
		
		
		
	}
	
	public static void searchVegasAddToCart(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.soastastore.com/?page_id=4");

		driver.findElement(By.id("s")).sendKeys("Vegas");
		driver.findElement(By.id("searchsubmit")).click();
		driver.findElement(By.tagName("name=product_rating"));
		

		
		
	}
	
	//find for dropdowns
	

	
	
}
