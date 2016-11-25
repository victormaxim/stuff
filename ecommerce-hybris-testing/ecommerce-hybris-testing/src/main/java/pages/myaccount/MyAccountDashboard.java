package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAccountDashboard extends NewpigGenericPage {

	//-------------------------------------- Selctors -------------------------------------------------------------
	//private By changePasswordLink = By.cssSelector(".panel-body>ul>li:nth-of-type(4)>a");
	private By changePasswordLink = By.cssSelector("[href='/my-account/update-password']");
	private By leftNavLink = By.cssSelector("div.account-navigation div.panel div.panel-body ul li a");
	private By defaultShippingAddressContainer = By.cssSelector("#defaultShippingAddressContainer");
	private By defaultPaymentOptionsContainer = By.cssSelector("#defaultPaymentOptionsContainer");

	//-------------------------------------------------Constructors--------------------------------------------
	public MyAccountDashboard(WebDriver driver) {
		super(driver);
	}

	//------------------------------------------------ Methods ----------------------------------------------------
	public void clickChangePasswordLink() {
//		driver.findElement(changePasswordLink).getAttribute("href");
		driver.get(driver.findElement(changePasswordLink).getAttribute("href"));
	}

	public void clickLeftNavOption(String option){
		List<WebElement> navLinks = driver.findElements(leftNavLink);
		for (WebElement navLink : navLinks) {
			if(navLink.getText().trim().equals(option)){
				driver.get(navLink.getAttribute("href"));
				break;
			}
		}

	}

	/**
	 * @return text of the default payment options
	 */
	public String getDefaultPaymentOptionsText(){
		return getText(defaultPaymentOptionsContainer);
	}

	/**
	 * @return text of the default shipping addreess
	 */
	public String getDefaultShippingAddressText(){
		return getText(defaultShippingAddressContainer);
	}

}
