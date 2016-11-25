package com.selenium;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Testare;


public class WebDriverTest extends SelTestCase {

	@Test(groups = { "foo" })
	public void testRegistration() {
		Testare registration = new Testare(driver);
		driver.get("http://www.jewelry-box.ro/");
		registration.cautaColier();
			
		
	
		
	}
	
	
}
