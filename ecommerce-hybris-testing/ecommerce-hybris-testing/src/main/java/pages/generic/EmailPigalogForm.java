package pages.generic;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class EmailPigalogForm extends WebPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By formConatainer = By.id("mailToMeForm");

	private By firsNameInput = By.id("mailtome.firstName");
	private By lastNameInput = By.id("mailtome.lastName");
	private By companyInput = By.id("mailtome.companyName");
	private By address1Input = By.id("mailtome.addressLine1");
	private By zipInput = By.id("mailtome.zipCode");
	private By cityInput = By.id("mailtome.townCity");

	private By phoneInput = By.id("mailtome.phone");

	private By registerCheckbox = By.id("checkboxAddEmail");

	private By registerEmailInput = By.id("mailtome.email");
	private By registerPassInput = By.id("mailtome.password");
	private By registerConfirmPassInput = By.id("mailtome.checkPassword");


	private By submitButton = By.cssSelector("#mailToMeForm .button-primary");

	private By textInputSelector = By.cssSelector("form#mailToMeForm div.form_field-elements>div.form-group input[type=text]");

// ---------------------------------------------  Constructor and components --------------------------------------


	public EmailPigalogForm(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public void fillForm(String firstName, String lastName, String companyName, String address1, String zip, String phone){
		fillInput(firsNameInput, firstName);
		fillInput(lastNameInput, lastName);
		fillInput(companyInput, companyName);
		fillInput(address1Input, address1);
		fillInput(zipInput, zip);
		waitSeconds(1);
		fillInput(phoneInput, phone);
		click(submitButton);
	}

	public ArrayList<String> getPrefilledTextInForm(){
		waitSeconds(1);
		ArrayList<String> toret = new ArrayList<String>();

		toret.add(driver.findElement(companyInput).getAttribute("value").trim());
		toret.add(driver.findElement(address1Input).getAttribute("value").trim());
		toret.add(driver.findElement(zipInput).getAttribute("value").trim());
		toret.add(driver.findElement(cityInput).getAttribute("value").trim());

		System.out.println("toret = " + toret);

		return toret;
	}


	public void fillAndRegisterForm(String firstName, String lastName, String companyName, String address1, String zip, String phone, String email, String pass){
		fillInput(firsNameInput, firstName);
		fillInput(lastNameInput, lastName);
		fillInput(companyInput, companyName);
		fillInput(address1Input, address1);
		fillInput(zipInput, zip);
		waitSeconds(1);
		fillInput(phoneInput, phone);

		executeJavascript("$('#checkboxAddEmail').trigger('click');");
//		handleCheckbox(registerCheckbox, true);
		waitSeconds(1);

		fillInput(registerEmailInput, email);
		fillInput(registerPassInput, pass);
		fillInput(registerConfirmPassInput, pass);

		click(submitButton);
	}


}
