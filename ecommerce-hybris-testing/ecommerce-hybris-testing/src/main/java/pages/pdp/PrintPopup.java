package pages.pdp;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PrintPopup extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By productTitle = By.cssSelector(".product-title>h1");

	private By pricingContainer = By.cssSelector(".pds-print");

// ---------------------------------------------  Constructor and components --------------------------------------


	public PrintPopup(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------


	public String getPricingBlockContent(){
		return getText(pricingContainer);
	}


}
