package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class AddressBook extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By addNewAddressLink = By.cssSelector("div.headline a.button.positive");
	private By addressContainerDiv = By.cssSelector("div.headline>div.addressItem");
	private By successAllert = By.cssSelector(".alert-success");

	private String addressTextSelectorTemplate = "div.headline>div.addressItem:nth-of-type(%s)>ul";

	private String setDefaultShippingTemplate = "div.headline>div.addressItem:nth-of-type(%s) div.buttons a.button:nth-of-type(1)";
	private String setDefaultBillingTemplate = "div.headline>div.addressItem:nth-of-type(%s) div.buttons a.button:nth-of-type(2)";
	private String editTemplate = "div.headline>div.addressItem:nth-of-type(%s) div.buttons [href*=edit-address]";
	private String removeTemplate = "div.headline>div.addressItem:nth-of-type(%s) div.buttons .removeAddressButton";

// ---------------------------------------------  Constructor and components --------------------------------------


	public AddressBook(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------


	public void clickAddNewAddress(){
		click(addNewAddressLink);
	}

	public void clickEditAddress(Integer index){
		click(By.cssSelector(String.format(editTemplate, index)));
	}

	public String getAddres(Integer index) {
		return getText(By.cssSelector(String.format(addressTextSelectorTemplate, index)));
	}

	/**
	 * @return a list of all addresses as Strings
	 */
	public ArrayList<String> getAllAddresses(){
		ArrayList<String> addresses = null;
		List<WebElement> addressBlocks = driver.findElements(addressContainerDiv);
		for (WebElement addressBlock : addressBlocks) {
			addresses.add(addressBlock.getText());
		}
		return addresses;
	}

	/**
	 * Searches for an address containing the given text as String parameter
	 * Sets the first found address as Default Shipping address
	 * @param text
	 */
	public void setAddressContainingTextAsDefaultShipping(String text){
		boolean addressWasSet = false;
		List<WebElement> addressBlocks = driver.findElements(addressContainerDiv);
		for (int i=0;i<addressBlocks.size();i++){
			if(addressBlocks.get(i).getText().contains(text)){
				addressWasSet = true;
				click(By.cssSelector(String.format(setDefaultShippingTemplate, 2 * i + 1)));
				break;
			}
		}
		if (!addressWasSet){
			log.error("Address with text: " + text + " was NOT found");
		}
	}

	/**
	 * Searches for an address containing the given text as String parameter
	 * Sets the first found address as Default Billing address
	 * @param text
	 */
	public void setAddressContainingTextAsDefaultBilling(String text){
		boolean addressWasSet = false;
		List<WebElement> addressBlocks = driver.findElements(addressContainerDiv);
		for (int i=0;i<addressBlocks.size();i++){
			if(addressBlocks.get(i).getText().contains(text)){
				addressWasSet = true;
				click(By.cssSelector(String.format(setDefaultBillingTemplate,2*i+1)));
				break;
			}
		}
		if (!addressWasSet){
			log.error("Address with text: " + text + " was NOT found");
		}
	}

	/**
	 * @return true if any success message is displayed
	 */
	public boolean isSuccessMessageDisplayed(){
		return isVisible(successAllert);
	}

	public boolean isAddressContainingTextDisplayed(String text){
		boolean found = false;
		List<WebElement> addressBlocks = driver.findElements(addressContainerDiv);
		for (int i=0;i<addressBlocks.size();i++){
			if(addressBlocks.get(i).getText().contains(text)){
				found = true;
				break;
			}
		}
		if (!found){
			log.error("Address with text: " + text + " was NOT found");
		}
		return found;
	}





}
