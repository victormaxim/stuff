package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;



public class Testare {

	private FirefoxDriver driver;

	public Testare(FirefoxDriver driver){
		this.driver = driver;
	}
	

	
	public void cautaColier(){
		driver.findElement(By.name("search_query_block")).sendKeys("colier");
		driver.findElement(By.name("search_button")).click();
		
			
		}
	
}
