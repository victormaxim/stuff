package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {

	private WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.setDriver(driver);
	}

	public void GotoPrestatori(){
	
		
		System.out.println("asta-s eu, Dashboard, care da click pe prestatori");
		getDriver().findElement(By.xpath("//*[@id='mainmenu']/li[2]/a")).click();
		System.out.println(getDriver());
		
		
	}
	
	public void Cauta(){
		getDriver().findElement(By.xpath("//*[@id='mainmenu']/li[3]/a")).click();
		System.out.println("cauta");
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
}
