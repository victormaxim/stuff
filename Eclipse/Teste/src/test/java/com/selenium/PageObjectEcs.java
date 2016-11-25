package com.selenium;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Dashboard;
import pageobject.Login;
import pageobject.RegistrationVechi;


public class PageObjectEcs extends SelTestCase {

	@Test
	public void testLogin() {
		//Registration registration = new Registration(driver);
		Login login = new Login(driver);
		driver.get("http://www.asistentul-tau.ro");
		//registration.registerNewUser();
		//login.VerifyLogin();
				
		
		//String bodyText = driver.findElement(By.tagName("body")).getText();
		//Assert.assertTrue(bodyText.contains("Thank"));
		//assert driver.findElement(By.tagName("body").contains(""));
		//assert driver.findElement(By.tagName("body").contains(""));
		//a[contains(text(),'Contul meu')]
		
		//assert driver.findElement(By.xpath("//div[@id='account']/div/p[2]/a").contains("Contul"));
		
		driver.findElement(By.xpath("//div[@id='account']/div/p[2]/a"));
				
		//Assert.assertTrue((driver.findElement(((List<WebElement>) By.xpath("//div[@id='account']/div/p[2]/a")).contains("Thank")));
		if(driver.findElements(By.xpath("//a[contains(text(),'Contul meu')]")).size() != 0){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
	
		Dashboard dash = new Dashboard(driver);
		
		dash.GotoPrestatori();
		
		
	}
	
	
	
	
	
}
