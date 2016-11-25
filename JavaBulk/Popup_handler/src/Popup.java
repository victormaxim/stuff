import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import java.awt.event.*;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//static WebDriver driver = new FirefoxDriver();
		
		
	public class Popup {	
			@Test
			public void simpleOrder() throws Exception{
			WebDriver driver = new FirefoxDriver();
			//Actions builder = new Actions(driver);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			driver.get("http://www.telacad.ro/videoconferinte/java1curs" + 1 + ".mp4");
					
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 11; j++) {
				driver.get("http://www.telacad.ro/videoconferinte/java" + i + "curs" + j + ".mp4");
				salveaza();
				}
				
			}
			
			//String selectAll = Keys.chord(Keys.CONTROL, "s");
			//((WebElement) driver).sendKeys(selectAll);
		//	((JavaScriptExecutor)driver).executeScript("window.print();");
			
					
			/*
			Thread.sleep(2000);
			Robot rb = new Robot();
			
			//builder.sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
			
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_S);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			
			//builder.sendKeys(Keys.chord(Keys.ENTER)).perform();
			Thread.sleep(2000);
			
			
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			*/
			

			
			
			
			//driver.wait(2000);
			
			//builder.sendKeys("xxx").perform();
						
		}
			@Test
			public void salveaza() throws Exception {
				
				
				//builder.sendKeys(Keys.chord(Keys.CONTROL, "s")).perform();
				Robot rb = new Robot();
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_S);
				rb.keyRelease(KeyEvent.VK_S);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				
				//builder.sendKeys(Keys.chord(Keys.ENTER)).perform();
				Thread.sleep(1000);
				
				
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				
			}
		
		
}
