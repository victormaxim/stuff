package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestBase.Page;
public class Prestatori extends Page{
	public By prestatoriVazutiLink = By.xpath("//a[contains(text(),'Prestatori v')]");
	
	public Prestatori(WebDriver driver){
		this.driver = driver;
	}
	public void veziPrestatori(){
		driver.findElement(prestatoriVazutiLink).click();
		//return this;
	}
	
}