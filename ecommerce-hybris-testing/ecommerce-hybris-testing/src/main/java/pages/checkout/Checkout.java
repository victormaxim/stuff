package pages.checkout;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Checkout extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By object = By.cssSelector("");

// ---------------------------------------------  Constructor and components --------------------------------------


	public Checkout(WebDriver driver) {
		super(driver);
	}

	public CheckoutLoginRegister loginRegister = new CheckoutLoginRegister(driver);
	public CheckoutPayment payment = new CheckoutPayment(driver);
	public CheckoutShippingAddress shippingAddress = new CheckoutShippingAddress(driver);
	public CheckoutShippingMethod shippingMethod = new CheckoutShippingMethod(driver);
	public CheckoutOrderReview orderReview = new CheckoutOrderReview(driver);
	public CheckoutOrderConfirmation orderConfirmation = new CheckoutOrderConfirmation(driver);

// ---------------------------------------------  Functionality ---------------------------------------------------


}
