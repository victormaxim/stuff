package pages.generic;

import base.data.pojos.AddressPojo;
import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AddressForm extends WebPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By emailInput = By.id("address.email");

	private By fnameInput = By.id("address.firstName");
	private By lnameInput = By.id("address.lastName");

	private By companyInput = By.id("address.companyName");
	private By address1Input = By.id("address.line1");
	private By address2Input = By.id("address.line2");
	private By zipInput = By.id("address.postcode");
	private By cityInput = By.id("address.townCity");


	private By stateExpanderSelect = By.cssSelector("#address\\.region+div button");
	private By stateOption = By.cssSelector("#address\\.region+div ul>li");

	private By countryExpanderSelect = By.cssSelector("#address\\.country+div button");
	private By countryOption = By.cssSelector("#address\\.country+div ul>li");


	private By phoneInput = By.id("address.phoneNumber");
	private By faxInput = By.id("address.faxNumber");



// ---------------------------------------------  Constructor and components --------------------------------------


	public AddressForm(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------


	public void fillAddressForm(AddressPojo address){
		fillInput(emailInput, address.getEmail());

		fillInput(fnameInput, address.getFirstName());
		fillInput(lnameInput, address.getLastName());

		fillInput(companyInput, address.getCompany());
		fillInput(address1Input, address.getAddr1());
		fillInput(address2Input, address.getAddr2());

		fillInput(zipInput, address.getZip());
		fillInput(cityInput, address.getCity());

		if(address.getState() != null){
			selectOption(stateExpanderSelect, stateOption, address.getState());
		}

		if(address.getCountry() != null){
			selectOption(countryExpanderSelect, countryOption, address.getCountry());
		}

		fillInput(phoneInput, address.getPhone());
		fillInput(faxInput, address.getFax());

	}

	private void selectOption(By expander, By optionSelector, String desiredOptionText){
		click(expander);
		for (WebElement option : driver.findElements(optionSelector)) {
			if(option.getText().trim().equalsIgnoreCase(desiredOptionText)){
				log.info("Checking otpion: " + option.getText());
				option.click();
			}
		}
	}








}
