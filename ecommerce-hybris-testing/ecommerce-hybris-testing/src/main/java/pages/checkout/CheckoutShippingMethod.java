package pages.checkout;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CheckoutShippingMethod extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

//	---------  to use in case of split shippment only
	private By shipmentContainer  = By.cssSelector(".shipment.clearfix");
	private By shipmentNoOfItems = By.cssSelector(".items-in-shipment");

	private By productCode = By.cssSelector(".product-code");
	private By productName = By.cssSelector(".product-name");
	private By productQty = By.cssSelector(".product-qty");
// 	----- end

	private By shippingMethod = By.cssSelector(".delivery-mode .radio .css-input");
	private By continueButton = By.cssSelector(".button-primary.button-red");
	private By specialShippingInstructionsLabel = By.xpath("////label[contains(., /'Special Shipping Instructions/')]");
	private By specialShippingInstructionsTexArea = By.cssSelector("textarea.special-instructions");

	private By genericShippingMethod = By.cssSelector("div.col-xs-12 div.radio .css-input");
	private By genericShippingMethodLabel = By.cssSelector("label.form-radio .css-input-label");


	private By addNewCarrierLink = By.cssSelector("form#selectDeliveryMethodForm.col-xs-12 a.col-xs-6");

	private By carrierNameInput = By.id("carrierName");
	private By carrierAccountNoInput = By.id("carrierAccount");
	private By saveCarrierBtn = By.cssSelector(".button-primary.button-blue.add-carrier-button");

	private By savedCariersSelectOption = By.cssSelector(".form-control>option");
	private By savedCariersSelect = By.cssSelector("select.form-control");

	private By content = By.id("checkoutContentPanel");
	private By deliveryMethodForm = By.id("selectDeliveryMethodForm");

// ---------------------------------------------  Constructor and components --------------------------------------


	public CheckoutShippingMethod(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	/**
	 * Selects first shipping method and clicks continue
	 */
	public void clcikFirstShiinppingMeyhodAndContinue(){
		click(shippingMethod);
		click(continueButton);
	}

	/**
	 * Selects first shipping method and clicks continue
	 */
	public void clcikSecondShiinppingMeyhodAndContinue(){
		List<WebElement> deliveryMethods = driver.findElements(shippingMethod);
		deliveryMethods.get(1).click();
		click(continueButton);
	}

	/**
	 * Verify if the Special Shipping Instructions field is displayed
	 * @return true if displayed
	 */
	public boolean isSpecialShippingInstrunctionsDisplayed(){
		if (isVisible(specialShippingInstructionsLabel) && isVisible(specialShippingInstructionsTexArea))
			return true;
		else
			return false;
	}

	/**
	 * @param index
	 * @return trimmed text of the delivery method indicated as index parameter
	 */
	public String getDeliveryMethodTextByIndex(int index){
		List<WebElement> deliveryMethods = driver.findElements(shippingMethod);
		return deliveryMethods.get(index).getText().trim();
	}

	/**
	 * Fills the Special Shipping Instructions field with given text as parameter
	 * @param text
	 */
	public void fillSpecialShippingInstructions(String text){
		fillInput(specialShippingInstructionsTexArea, text);
	}

	public void clickCollectShipping(){
		waitSeconds(1);

		List<WebElement> methodsLabels = driver.findElements(genericShippingMethodLabel);
		List<WebElement> methodsRadioBtns = driver.findElements(genericShippingMethod);


		for (int i = 0; i <methodsLabels.size(); i++) {
			if(methodsLabels.get(i).getText().trim().contains("Collect Shipping from")){
				methodsRadioBtns.get(i).click();
				break;
			}
		}
	}

	public void addNewCollectCarier(String carierName, String carierAccountNo){
		clickCollectShipping();
		click(addNewCarrierLink);

		fillInput(carrierNameInput, carierName);
		fillInput(carrierAccountNoInput, carierAccountNo);
		click(saveCarrierBtn);

	}

	public ArrayList<String> getSavedCarriers(){
		return getTexts(savedCariersSelectOption);
	}


	public boolean isCollectCarrierPresent(String carierName, String accNo){
		ArrayList<String> savedCariers = getSavedCarriers();

		boolean isCarierPresent = false;
		for (String savedCarier : savedCariers) {
			if(savedCarier.contains(carierName) && savedCarier.contains(accNo)){
				isCarierPresent = true;
				break;
			}
		}
		return isCarierPresent;
	}

/* checks that multiple containers for shipping methods appear
* checks that each container contains the number of items
* checks that each container contains product names
* checks that each container contains product codes
* checks that each container contains product qty
* */
	public boolean checkSplitShippment() {

		boolean isSplitShippmentOK = true;

		Integer noOfSplitShiments = driver.findElements(shipmentContainer).size();

		isSplitShippmentOK = isSplitShippmentOK && (noOfSplitShiments>1);
		isSplitShippmentOK = isSplitShippmentOK && (driver.findElements(shipmentNoOfItems).size() == noOfSplitShiments);


		for (WebElement container : driver.findElements(shipmentContainer)) {
			isSplitShippmentOK = isSplitShippmentOK && (container.findElements(productCode) != null);
			isSplitShippmentOK = isSplitShippmentOK && (container.findElements(productName) != null);
			isSplitShippmentOK = isSplitShippmentOK && (container.findElements(productQty) != null);
		}

		return isSplitShippmentOK;
	}
	/**
	 * Verifies is FREE Shipping delivery option is displayed
	 * @return true if displayed
	 */
	public boolean freeShippingDisplayed(){
		return getText(content).contains("FREE Shipping");
	}

	/**
	 * Verifies if delivery methods are displayed
	 * @return true if displayed
	 */
	public boolean deliveryMethodsDisplayed(){
		return isVisible(shippingMethod);
	}






}
