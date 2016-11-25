package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class LoginVechi {

	private FirefoxDriver driver;

	public LoginVechi(FirefoxDriver driver){
		this.driver = driver;
	}
	
	public void VerifyLogin(){
		driver.findElement(By.name("firstName")).sendKeys("victor");
		driver.findElement(By.name("lastName")).sendKeys("maxim");
		driver.findElement(By.name("phone")).sendKeys("0123456789");
		driver.findElement(By.name("userName")).sendKeys("seleniumuseri");
		
		new Select(driver.findElement(By.name("country"))).selectByVisibleText("ANGOLA");
		
		driver.findElement(By.name("email")).sendKeys("alexa@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		driver.findElement(By.name("register")).click();
		
	}
}
