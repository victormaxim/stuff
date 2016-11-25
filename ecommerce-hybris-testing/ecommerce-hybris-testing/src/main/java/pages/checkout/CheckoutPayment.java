package pages.checkout;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPayment extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By enterNewCreditCardRadio = By.cssSelector("div.payment-chooser div.radio:nth-of-type(1) span.css-input");
	private By sendInvoiceRadio = By.cssSelector("div.payment-chooser div.radio:nth-of-type(2) span.css-input");

	private By activePage = By.cssSelector(".active[href*=payment]");
	private By savedInvoiceList = By.cssSelector("#saved-invoices-list");

	private By cardTypeSelector = By.id("cardType");
	private By nameOnCardInput = By.id("nameOnCard");
	private By cardNumberInput = By.id("cardNumber");
	private By expiryMonthSelect = By.id("ExpiryMonth");
	private By expiryYearSelect = By.id("ExpiryYear");

	private By company = By.id("invoiceCompany");
	private By addressFirst = By.id("invoiceLine1");
	private By postcode = By.id("invoicePostcode");
	private By city = By.id("invoiceCity");
	private By state = By.id("invoiceState");

	private By saveCardChk = By.id("SaveDetails");
	private By makeDefaultChk = By.id("makeDefaultPaymentNewCC");

	private By continueButton = By.cssSelector(".button-red");

// ---------------------------------------------  Constructor and components --------------------------------------


	public CheckoutPayment(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public void enterNewCreditCard(String cardType, String nameOnCard, String cardNumber, String expiryMonth, String expiryYear, Boolean saveCC, Boolean makeDefaultCC){

		click(enterNewCreditCardRadio);
		waitSeconds(1);

		selectByVisibleText(cardTypeSelector, cardType);
		fillInput(nameOnCardInput, nameOnCard);
		fillInput(cardNumberInput, cardNumber);
		selectByVisibleText(expiryMonthSelect, expiryMonth);
		selectByVisibleText(expiryYearSelect, expiryYear);

		handleCheckbox(saveCardChk, saveCC);
		handleCheckbox(makeDefaultChk, makeDefaultCC);

		click(continueButton);

	}


	/**
	 * Selects Invoice
	 * Completes new invoice form with valid info
	 * Clicks continue
	 */
	public void enterNewValidInvoiceAndContinue(){
		fillInput(company,"Test Company");
		fillInput(addressFirst,"Test Address");
		fillInput(postcode,"90210");
		fillInput(city,"Beverly Hills");
		waitSeconds(1);
		click(continueButton);
	}

	/**
	 * Verifies if the user has a saved invoice payment
	 * @return true if list is populated
	 */
	public boolean userHasSavedInvoice(){
		if(isVisible(savedInvoiceList))
			return true;
		else
			return false;
	}

	/**
	 * Clicks on continue button
	 */
	public void clickContinue(){
		click(continueButton);
	}

	/**
	 * Selcts Send Invoice as payment method
	 */
	public void selectSendInvoice(){
		click(sendInvoiceRadio);
		waitSeconds(2);
	}

	/**
	 * @return true if Payment is the active page
	 */
	public boolean isDisplayed() {
		return isVisible(activePage);
	}


}
