package pom;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.Dashboard;
import pom.LandingPage;
import pom.Prestatori;

public class FlowTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
		driver.get("http://www.asistentul-tau.ro/");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void listPrestatori(){
		LandingPage landing = new LandingPage(driver);
		Dashboard dashboard = landing.validLogin();
		Prestatori prestatori = dashboard.navigateToPrestatori();
		prestatori.veziPrestatori();
	}
	
	
	
}