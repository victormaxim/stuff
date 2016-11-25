package pages.checkout;

import base.data.NPMESSAGING;
import base.data.pojos.User;
import base.web.NewpigGenericPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutLoginRegister extends NewpigGenericPage {

	Logger log = Logger.getLogger("TESTS");
// ---------------------------------------------  Selectors -------------------------------------------------------

	private By emailInput = By.id("j_username");
	private By passInput = By.id("j_password");
	private By loginAndCheckoutButton = By.cssSelector("div.col-xs-6:nth-of-type(1) button.button-primary.button-red");
	private By errorMessage = By.cssSelector(".alert");

	private By continueCheckout = By.cssSelector("#guestForm .button-primary");
// ---------------------------------------------  Constructor and components --------------------------------------


	public CheckoutLoginRegister(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public boolean isLoginAndCheckoutPage(){
		return isVisible(loginAndCheckoutButton);
	}

	public void loginWithUser(User user){
		fillInput(emailInput, user.getUsername());
		fillInput(passInput, user.getPassword());
		click(loginAndCheckoutButton);
	}
	
	/**
	 * Performs login with given credentials as parameter
	 * @param user
	 * @param password
	 */
	public void loginWithUserAndPassword(String user, String password){
		fillInput(emailInput, user);
		fillInput(passInput, password);
		click(loginAndCheckoutButton);
	}
	
	/**
	 * Performs login with given credentials as parameter
	 * User is retrieved from test data
	 * @param user
	 * @param password
	 */
	public void loginWithUserAndPassword(User user, String password){
		fillInput(emailInput, user.getUsername());
		fillInput(passInput, password);
		click(loginAndCheckoutButton);
	}

	/**
	 * Verifies that the specific error messages are displayed for invalid login
	 * @return true if both error messages are correctly displayed
	 */
	public boolean invalidLoginErrorsDisplayed(){
		if (isVisible(errorMessage) &&
			driver.getPageSource().toLowerCase().contains(NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE.get().toLowerCase()) &&
			driver.getPageSource().toLowerCase().contains(NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE2.get().toLowerCase()))
			return true;
		else{
			log.error("Invalid Login erros not dsiplayed");
			return false;
		}
	}

	public void continueAsGuest(){
		click(continueCheckout);
	}

}
