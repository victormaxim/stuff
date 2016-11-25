package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {


	public WebDriver driver;
	public String user;
	public String pass;
	//private static WebDriver driver;
	
	
	//initializare parametru driver
	public Login(WebDriver driver){
		this.driver = driver;
	}
	
	//metoda VerifyLogin care returneaza si un obiect de tip Dashboard
	public Dashboard VerifyLogin(String user, String pass){
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//form[@id='login']/div[3]/button")).click();
		//returneaza un obiect Dashboard cu driverul de dupa logare
		return new Dashboard(driver);
	}

	public Dashboard Login(String user, String pass){
		driver.findElement(By.id("email")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//form[@id='login']/div[3]/button")).click();
		//returneaza un obiect Dashboard cu driverul de dupa logare
		return new Dashboard(driver);
	}
	
	
}
