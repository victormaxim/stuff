package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginSimplu {

	private FirefoxDriver driver;

	public LoginSimplu(FirefoxDriver driver){
		this.driver = driver;
	}
	
	public void VerifyLogin(){
		driver.findElement(By.id("email")).sendKeys("c1@2.2");
		driver.findElement(By.id("password")).sendKeys("123456");
		
		//new Select(driver.findElement(By.name("country"))).selectByVisibleText("ANGOLA");
		
		//driver.findElement(By.name("email")).sendKeys("alexa@gmail.com");
		//driver.findElement(By.name("password")).sendKeys("123456");
		//driver.findElement(By.name("confirmPassword")).sendKeys("123456");
		driver.findElement(By.xpath("//form[@id='login']/div[3]/button")).click();
		
	}
}
