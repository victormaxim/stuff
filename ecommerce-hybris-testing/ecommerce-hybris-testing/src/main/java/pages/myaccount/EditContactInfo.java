package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class EditContactInfo extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By emailInput = By.id("profile.emailAddress");
	private By fNmeInput = By.id("profile.firstName");
	private By lNmeInput = By.id("profile.lastName");
	private By titleInput = By.id("profile.title");
	private By companyInput = By.id("profile.companyName");
	private By parentCompanyInput = By.id("profile.parentCompany");
	private By addressLine1Input = By.id("profile.address1");
	private By addressLine2Input = By.id("profile.address2");

	private By mailStopInput = By.id("profile.mailStop");
	private By zipCodeInput = By.id("profile.zipCode");
	private By phoneNumberInput = By.id("profile.phoneNumber");


	private By saveButton = By.cssSelector(".btn.btn-primary");







// ---------------------------------------------  Constructor and components --------------------------------------


	public EditContactInfo(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------


	public void fillForm(String email,
						 String fname,
						 String lname,
						 String jobTitle,
						 String company,
						 String parentCompany,
						 String addr1,
						 String addr2,
						 String mailStop,
						 String zip,
						 String phoneNumber
						 ){
		fillInput(emailInput, email);
		fillInput(fNmeInput, fname);
		fillInput(lNmeInput, lname);
		fillInput(titleInput, jobTitle);
		fillInput(companyInput, company);
		fillInput(parentCompanyInput, parentCompany);
		fillInput(addressLine1Input, addr1);
		fillInput(addressLine2Input, addr2);
		fillInput(mailStopInput, mailStop);

		fillInput(zipCodeInput, zip);
		click(emailInput);
		waitSeconds(2);

//		fillInput(phoneNumberInput, phoneNumber);
		fillInput(phoneNumberInput, "0016464536655");
	}


	public void clickSubmit(){
		click(saveButton);
	}

}
