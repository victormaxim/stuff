package pages.checkout;

import base.utils.Utils;
import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.generic.AddressForm;

import java.util.ArrayList;


public class CheckoutShippingAddress extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private String savedAddressRadioTemplate = "form#selectedAddressForm div.addressEntry.col-xs-3:nth-of-type(%s) input[type=radio]";


	private By savedAddressContainer = By.cssSelector(".addressEntry.col-xs-3.addressEntry>ul");
//	can be selected only by find from container
	private By editSelecedSavedAddressLnk = By.cssSelector(".actions>a:nth-of-type(1)");
	private By makeDefaultSavedAddressLnk = By.cssSelector(".actions>a:nth-of-type(2)");





	private By continueButton = By.cssSelector(".headline .button-primary.button-red");

	private By pageTitle = By.cssSelector(".headline>h3");
	private By activeStep = By.cssSelector(".active");


// ---------------------------------------------  Constructor and components --------------------------------------


	public CheckoutShippingAddress(WebDriver driver) {
		super(driver);
	}

	public AddressForm addressForm = new AddressForm(driver);

// ---------------------------------------------  Functionality ---------------------------------------------------

	public void selectSavedAddressAndContinue(Integer index){
		String selector = String.format(savedAddressRadioTemplate, index);
		String jsToCheckSavedAddress = "$('"+selector+"').trigger('click');";
		executeJavascript(jsToCheckSavedAddress);

		click(continueButton);
	}

	public ArrayList<String> getListedAddresses(){
		return getTexts(savedAddressContainer);
	}


	public boolean isShippingAddressLoaded(){
		return getText(pageTitle).equalsIgnoreCase("Shipping Address");
	}

	public boolean isShippingAddressStepActive(){
		return getText(activeStep).equalsIgnoreCase("Shipping Address");
	}

	public void clickEditAddress(Integer index){
		index--;
		driver.findElements(savedAddressContainer).get(index).findElement(editSelecedSavedAddressLnk).click();

	}

	public void clickContinue(){
		click(continueButton);
	}

	public String fillShippingAddressFormWithValidData(){
		String email = "mail"+ Utils.getRndString(4)+"@mailinator.com";

		return email;
	}


}
