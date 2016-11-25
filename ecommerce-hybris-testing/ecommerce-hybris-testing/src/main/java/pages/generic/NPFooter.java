package pages.generic;

import base.data.NPMESSAGING;
import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 3/20/15.
 */
public class NPFooter extends WebPage{

	// ---------------------------------------------  Selectors -------------------------------------------------------

	private By pigalogContainer = By.cssSelector(".marketing-block.footer-pigalog.panel-body");
	private By pigalogMailToMe = By.cssSelector(".footer-pigalog a[title*=Mail]");
	private By pigalogViewOnline = By.cssSelector(".footer-pigalog a[title*=View]");
	private By pigalogMailToMeForm = By.cssSelector(".modal-content");

	private By pigalogMailConfimationMess = By.cssSelector("#confirmationMsg span");
	private By pigalogMailOKButton = By.cssSelector(".button-primary.okbtn");




	private By todayOnlyDealContainer = By.cssSelector(".cms-mini-promotion-component");
	private By todImageSelector = By.cssSelector(".cms-mini-promotion-component .product-image>a>img");
	private By todPriceSelector = By.cssSelector(".cms-mini-promotion-component .normal-price");
	private By todProdNameSelector = By.cssSelector(".cms-mini-promotion-component .product-name");
	private By todAddToCartButton = By.cssSelector(".cms-mini-promotion-component .add-to-cart-mini");




	private By emailInput = By.cssSelector(".form-control.EmailAddressCapture-field.email-address-capture-field");
	private By emailSignUpButton = By.cssSelector("#captureEmailSlot .btn.btn-secondary.email-address-capture-button");
	private By emailSignUpErrMessage = By.cssSelector("#EmailAddressCapture-message label");
	private By emailSignUpSuccessMessage = By.cssSelector("#captureEmailSlot .marketing-block-success");





	// ---------------------------------------------  Constructor and components --------------------------------------


	public NPFooter(WebDriver driver) {
		super(driver);
	}


	public EmailPigalogForm pigalogForm = new EmailPigalogForm(driver);

	// ---------------------------------------------  Functionality ---------------------------------------------------


	public void clickMailPigalog(){
		click(pigalogMailToMe);
	}

	public boolean checkViewOnlinePigalog(){
		return getAttributeValue(pigalogViewOnline, "href").endsWith("/viewOnLine");
	}

	public void signupForNewsletter(String email){
		fillInput(emailInput, email);
		click(emailSignUpButton);
	}

	public boolean isSubscriptionErrorTextVisible(){
		return isVisible(emailSignUpErrMessage);
	}

	public boolean isSubscriptionSuccessTextVisible(){
		return isVisible(emailSignUpSuccessMessage);
	}


	public boolean isTODProdImageVisible(){
		return isVisible(todImageSelector);
	}

	public boolean isTODProdPriceVisible(){
		return isVisible(todPriceSelector);
	}

	public String getProductName(){
		return getText(todProdNameSelector);
	}

	public void addTODProductToCart(){
		click(todAddToCartButton);
	}


	public boolean isMailPigalogMessageVisible() {
		String mess = getText(pigalogMailConfimationMess);
		click(pigalogMailOKButton);
		return mess.equals(NPMESSAGING.MAIL_PIGALOG_SUCCESS.get());
	}


	public boolean isMailPigalogFormVisible() {
		return isVisible(pigalogMailToMeForm);
	}


}
