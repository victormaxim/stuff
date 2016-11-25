package pages.login;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 7/25/14.
 */
public class Registration extends NewpigGenericPage {


//	public NPHeader header_footer = new NPHeader(driver);
//	public NPFooter footer = new NPFooter(driver);
//	public NPMessageArea messageArea = new NPMessageArea(driver);


	//	information field set
	private  By emailInput = By.id("register.email");
	private  By firstNameInput = By.id("register.firstName");
	private  By lastNameInput = By.id("register.lastName");
	private  By passwordInput = By.id("password");
	private  By passwordConfirmInput = By.id("register.checkPwd");
	private  By rememberMeCheckbox = By.id("_spring_security_remember_me");

	private  By jobTitleInput = By.id("register.jobTitle");
	private  By companyNameInput = By.id("register.companyName");
	private  By parentCompanyInput = By.id("register.parentCompany");

	//	address field set
	private  By address1Input = By.id("register.addressLine1");
	private  By address2Input = By.id("register.addressLine2");
	private  By mailStopInput = By.id("register.mailStop");
	private  By zipCodeInput = By.id("register.zipCode");
	private  By cityInput = By.id("register.city");
	private  By stateSelect = By.id("register.state");
	private  By countrySelect = By.id("register.country");

	//	contact preferences field set
	private  By phoneNumberInput = By.id("register.phoneNumber");
	private  By phoneExtInput = By.id("register.phoneExt");
	private  By cellphoneInput = By.id("register.cellphone");
	private  By faxInput = By.id("register.fax");

	//	submit button
	private  By submitButton = By.cssSelector("#extendedRegisterForm > div.form-actions > button");

	public Registration(WebDriver driver) {
		super(driver);
	}


	public  void fillRegistrationForm(String email,
									  String firstName,
									  String lastName,
									  String password,
									  String confirmPassword,
									  Boolean rememberMe,
									  String jobTitle,
									  String company,
									  String parentCompany,
									  String address1,
									  String address2,
									  String mailStop,
									  String zipCode,
									  String phoneNumber){

		fillInput(emailInput, email);
		fillInput(firstNameInput, firstName);
		fillInput(lastNameInput, lastName);
		fillInput(passwordInput, password);
		fillInput(passwordConfirmInput, confirmPassword);

//		if (rememberMe) check(rememberMeCheckbox);
//		else  uncheckCheckbox(rememberMeCheckbox);

		fillInput(jobTitleInput, jobTitle);
		fillInput(companyNameInput, company);
		fillInput(parentCompanyInput, parentCompany);
		fillInput(address1Input, address1);
		fillInput(address2Input, address2);
		fillInput(mailStopInput, mailStop);
		fillInput(zipCodeInput, zipCode);
//		fillInput(cityInput, city);

//		waitSeconds(2);
//		selectByVisibleText(countrySelect, country);
//		waitSeconds(2);
//		selectByVisibleText(stateSelect, state);

		fillInput(phoneNumberInput, phoneNumber);
//		fillInput(phoneExtInput, phoneExt);
//		fillInput(cellphoneInput, cellPhone);
//		fillInput(faxInput,fax);
	}

	public  void submit(){
		click(submitButton);
	}



}
