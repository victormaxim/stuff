package pages.generic;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 5/22/15.
 */
public class HeaderMinicart extends WebPage {

	// ---------------------------------------------  Selectors -------------------------------------------------------

	private By containerLocator = By.cssSelector("#navbar > ul > li.dropdown.miniCart");

	private By viewCartCheckoutButton = By.cssSelector(".miniCartPopup .button-primary.button-red");

	private By todayDealProductNameContainerSelector = By.cssSelector(".miniCart .cms-mini-promotion-component");


	// ---------------------------------------------  Constructor and components --------------------------------------

	public HeaderMinicart(WebDriver driver) {
		super(driver);
	}

	// ---------------------------------------------  Functionality ---------------------------------------------------

	public boolean isLoaded(){
		boolean isLoaded = true;

		if(!isPresent(containerLocator)){
			isLoaded = false;
		}

		hover(containerLocator);

		if(!isPresent(viewCartCheckoutButton)){
			isLoaded = false;
		}

		if(!isPresent(todayDealProductNameContainerSelector)){
			isLoaded = false;
		}

		return isLoaded;
	}

	public boolean isExpanded(){
		return isVisible(viewCartCheckoutButton);
	}


}
