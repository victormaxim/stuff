package com.selenium;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.RegistrationVechi;


public class WebDriverTest extends SelTestCase {

	@Test(groups = { "foo" })
	public void testRegistration() {
		RegistrationVechi registration = new RegistrationVechi(driver);
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		registration.registerNewUser();
				
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("Thank"));
		//assert driver.findElement(By.tagName("body").contains(""));
		
	}
	
	@Test(groups = { "goo" })
	public void testRegistrations() {
		RegistrationVechi registration = new RegistrationVechi(driver);
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		registration.registerNewUser();
				
		
		String bodyText = driver.findElement(By.tagName("body")).getText();
		Assert.assertTrue(bodyText.contains("xxx"));
		//assert driver.findElement(By.tagName("body").contains(""));
		
	}
}
