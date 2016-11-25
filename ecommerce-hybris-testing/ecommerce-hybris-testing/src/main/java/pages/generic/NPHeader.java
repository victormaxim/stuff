package pages.generic;

import base.data.pojos.User;
import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by optaros on 7/25/14.
 */
public class NPHeader extends WebPage {


// ---------------------------------------------  Selectors -----------------------------------------------------------

	private By logoImage = By.cssSelector("#header a>img");

	//	registration link
	private  By registerLink = By.cssSelector("ul.top-links>li.topbar-item>a[href='/register']");

	//	Segementation select
	private  By segmentationExpandSelector = By.cssSelector("li.segment-select.dropdown a.dropdown-toggle");
	private  By segmentationOptionSelector = By.cssSelector("li.site-select>a");

	//	login popup in header_footer
	private  By signInExpandLink = By.cssSelector("li.topbar-item:nth-of-type(3)>a");
	private By popupUsernameInput = By.id("j_username");
	private  By popupPassInput = By.id("j_password");
	private  By popupSignInButton = By.cssSelector("form#loginForm div button");

	private By myAccuntMenuItemLink = By.cssSelector("ul.dropdown-menu.my-account li a");


	private By cartLink = By.cssSelector("div#navbar.container ul.nav.navbar-nav.row li.dropdown.miniCart a.minicart-link");


	private By addedToCartHoverMessage = By.cssSelector("div#addToCartLayer");

//---- Recently viewed selectors
	private By recentlyViewedExpander = By.id("recently-viewed");
	private By recentlyViewedProductContainer = By.cssSelector(".popupCartItem.item-product");
	private By recentlyViewedProductName = By.cssSelector(".popupCartItem.item-product .item-name");


//	----------- quickAdd
	private By quickAddExpander = By.cssSelector(".dropdown-toggle.quick-order-toggle");

// ---------------------------------------------  Components and constructor -------------------------------------------------------

	public NPHeader(WebDriver driver) {
		super(driver);
	}

	public SearchControls searchControls = new SearchControls(driver);
	public HeaderMinicart minicart = new HeaderMinicart(driver);
	public NPNavBar navBar = new NPNavBar(driver);
	public HeaderQuickAdd quickAdd = new HeaderQuickAdd(driver);



	// ---------------------------------------------  Functionality -------------------------------------------------------
	public  void goToRegistrationPage(){
		click(registerLink);
	}

	public  void goToCartPage(){
		click(cartLink);
	}

	public boolean addedToCartMessageVisible(){
		try {
			waitVisible(addedToCartHoverMessage);
			return true;
		}catch (Exception e){

		}
		return false;
	}


	public  void changeSegmentTo(String countryFullName){
		click(segmentationExpandSelector);

		for (WebElement option : driver.findElements(segmentationOptionSelector)) {
			if(option.getText().trim().equals(countryFullName.trim())){
				option.click();
				break;
			}
		}
	}


	public  void headerPopupLogin(String username, String password) {
		click(signInExpandLink);
		fillInput(popupUsernameInput, username);
		fillInput(popupPassInput, password);
		click(popupSignInButton);
	}

	public void headerPopupLogin(User user) {
		click(signInExpandLink);
		fillInput(popupUsernameInput, user.getUsername());
		fillInput(popupPassInput, user.getPassword());
		click(popupSignInButton);
	}

	public  String getSignInLinkText(){
		return getText(signInExpandLink);
	}


	public  void clickMyAccountMenuOption(String option) {
		click(signInExpandLink);

		waitVisible(myAccuntMenuItemLink);
		for (WebElement link : driver.findElements(myAccuntMenuItemLink)) {
			if(link.getText().trim().equals(option)){
				link.click();
				return;
			}
		}
	}

	public boolean isAddedToCartMessageVisible(){
		return isVisible(addedToCartHoverMessage);
	}

	public boolean isProductListedInRecentlyViewed(String productName){
		return getTexts(recentlyViewedProductName).contains(productName);
	}

	public void expandRecentlyViewed(){
		click(recentlyViewedExpander);
	}
	public void expandQuickAdd(){
		click(quickAddExpander);
	}


	public void clickLogo(){
		click(logoImage);
	}



}
