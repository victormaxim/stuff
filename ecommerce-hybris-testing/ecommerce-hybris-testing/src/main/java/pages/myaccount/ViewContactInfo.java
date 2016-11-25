package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ViewContactInfo extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By contactInfoContainer = By.cssSelector("table.account-profile-data");

// ---------------------------------------------  Constructor and components --------------------------------------


	public ViewContactInfo(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public String getContactInfo(){
		return getText(contactInfoContainer);
	}


}
