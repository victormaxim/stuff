package curat;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageobject.Dashboard;
import pageobject.Login;

public class PageObjectAsistent extends SelTestCase {
	static Dashboard dash;
	
	@Test
	//testam Login prin clasa pageobject.login
	public void testLogin() {
		Login login = new Login(driver);
		driver.get("http://www.asistentul-tau.ro");
		login.VerifyLogin("c1@2.2","123456");
		
		//cauta elementul "Contul meu"
		//driver.findElement(By.xpath("//div[@id='account']/div/p[2]/a"));
		
		if(driver.findElements(By.xpath("//a[contains(text(),'Contul meu')]")).size() != 0){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
	
		dash = new Dashboard(driver);
			
		dash.GotoPrestatori();
		//dash.Cauta();
		
	}
	
	@Test
	public void Cautare(){
		//AICI E PROBLEMA
		//dash = new Dashboard(driver);
		dash.Cauta();
		
	}
	
}
