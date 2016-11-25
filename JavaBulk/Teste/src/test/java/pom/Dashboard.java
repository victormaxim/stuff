package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestBase.Page;

public class Dashboard extends Page{
	public By prestatoriLink = By.xpath("//a[text()='Prestatori']");
	
	
	public Dashboard(WebDriver driver){
		this.driver = driver;
	}
	
	public Prestatori navigateToPrestatori(){
		driver.findElement(prestatoriLink).click();
		return new Prestatori(driver);
	}
		
}