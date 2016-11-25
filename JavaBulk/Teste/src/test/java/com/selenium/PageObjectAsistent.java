package com.selenium;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pageobject.Dashboard;
import pageobject.Login;

public class PageObjectAsistent{
	static Dashboard dash;
	public WebDriver driver;
	public Login login;
	
		
	@Test
	//testam Login prin clasa pageobject.login
	public void testLogin() {
		login = new Login(driver);
		driver.get("http://www.asistentul-tau.ro");
		dash = login.VerifyLogin("c1@2.2","123456");
		
		//cauta elementul "Contul meu"
		//driver.findElement(By.xpath("//div[@id='account']/div/p[2]/a"));
		
		if(driver.findElements(By.xpath("//a[contains(text(),'Contul meu')]")).size() != 0){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
	
		//dash = new Dashboard(driver);
			
		dash.GotoPrestatori();
		//dash.Cauta();
		
	}
	
	@Test(dependsOnMethods="testLogin")
	public void Cautare(){
		//AICI E PROBLEMA
		//dash = new Dashboard(driver);
		//dash.setDriver(driver);
		dash.Cauta();
		
	}
	
}
