package ro.alx.tester;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testul {

static WebDriver driver = new FirefoxDriver();
	
	
	@Test
	public void simpleOrder(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.soastastore.com/?page_id=4");
		
		driver.findElement(By.id("product_111_submit_button")).click();
		driver.findElement(By.xpath("//*[@id='cart-widget-links']/a")).click();
		driver.findElement(By.id("log")).sendKeys("kvl");
		
		
	//	driver.findElement(By.tagName("element html tag name"));
		
	}
	
	

	
	
}
