package ro.alx.blah;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


@Test
public class AppTest {

static WebDriver driver = new FirefoxDriver();
	
	
	public static void simpleOrder(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://www.soastastore.com/?page_id=4");
		
//		driver.findElement(By.id("product_111_submit_button")).click();
//		driver.findElement(By.xpath("//*[@id='cart-widget-links']/a")).click();
//		driver.findElement(By.id("log")).sendKeys("kvl");
		WebElement element = driver.findElement(By.tagName("111"));
		
		Select dropDown  = new Select(element);
		dropDown.selectByVisibleText("2");
	}
	/*
	public static void searchVegasAddToCart(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.soastastore.com/?page_id=4");

		driver.findElement(By.id("s")).sendKeys("Vegas");
		driver.findElement(By.id("searchsubmit")).click();
		
	}
	
	//find for dropdowns
	*/

	
	
}
