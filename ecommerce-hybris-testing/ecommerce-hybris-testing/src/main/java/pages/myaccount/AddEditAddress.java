package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AddEditAddress extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By companyNameInput = By.id("address.companyName");
	private By addressLine1Input = By.id("address.line1");
	private By addressLine2Input = By.id("address.line2");
	private By zipInput = By.id("address.postcode");
	private By cityInput = By.id("address.townCity");

	private By makeDefaultShippingCheck = By.cssSelector("input[name=shippingAddress]");
	private By makeDefaultBillingCheck =  By.cssSelector("input[name=billingAddress]");
	private By makeDefaultShippingLabel = By.cssSelector("label[for=\"address.shippingAddress\"]");
	private By makeDefaultBillingLabel = By.cssSelector("label[for=\"address.billingAddress\"]");

	private By submitForm = By.cssSelector("#addressform_button_panel>input");

// ---------------------------------------------  Constructor and components --------------------------------------


	public AddEditAddress(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public void fillForm(String company, String addressLine1, String addressLine2, String zip, Boolean makeDefaultShipping, Boolean makeDefaultBilling){

		fillInput(companyNameInput, company);
		fillInput(addressLine1Input, addressLine1);
		fillInput(addressLine2Input, addressLine2);
		fillInput(zipInput, zip);

		click(companyNameInput);

		waitSeconds(2);

		if (makeDefaultShipping){
			click(makeDefaultShippingLabel);
		}
		if (makeDefaultBilling){
			click(makeDefaultBillingLabel);
		}
//		handleCheckbox(makeDefaultShippingCheck, makeDefaultShipping);
//		handleCheckbox(makeDefaultBillingCheck, makeDefaultBilling);

	}

	public void submit(){
		click(submitForm);
	}


}
