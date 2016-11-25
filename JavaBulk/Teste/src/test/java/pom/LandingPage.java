package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import TestBase.Page;

public class LandingPage extends Page {
	private By emailField = By.id("email");
	private By passwordField = By.id("password");
	private By loginButton = By.cssSelector("div.control-group button");
	
	public String username = "c1@2.2";
	public String password = "123456";
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}
	
	public Dashboard validLogin(){
		driver.get("http://www.asistentul-tau.ro/contacts");
		driver.findElement(emailField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		return new Dashboard(driver);
	}
	
	
	public void dashboardShit(){
		
	}
	
	
	
}