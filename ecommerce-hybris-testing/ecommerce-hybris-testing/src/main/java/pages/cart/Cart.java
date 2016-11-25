package pages.cart;

import base.data.pojos.PricePojo;
import base.web.NewpigGenericPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.generic.popups.AdditionalInfoPopup;
import pages.generic.popups.SimplePopup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart extends NewpigGenericPage{


	Logger log = Logger.getLogger("TESTS");
	// ---------------------------------------------  Selectors -------------------------------------------------------


	private By printLink = By.id("toolbar-print-cart");
	private By emailLink = By.id("toolbar-mail-cart");

	private By breadcrumbs = By.cssSelector("ul.breadcrumb.pull-left");
	private By checkoutHelp = By.cssSelector("div.contact-info");
	private By continueShoppingLink = By.cssSelector("div.cart-top-cta a.pull-left.continue-shopping");
	private By checkoutButton = By.cssSelector("div.panel-body button.checkoutButton.button-primary.button-red");

	private By cartContainer = By.cssSelector(".cart");
	private By cartItemRow = By.cssSelector("div.cart-item");
	private By cartItemAutoShipFrequency = By.cssSelector(".cart-item-inner .btn.dropdown-toggle");
	private By cartItemAutoShipFrequencyArrow = By.cssSelector(".cart-item-inner .btn.dropdown-toggle .caret");
	private By cartItemAutoshipFrequencyOptions = By.cssSelector(".cart-item-inner .dropdown-menu li");
	private By firstCartItemAutoshipFrequencyOptions = By.cssSelector(".cart-item-container:nth-of-type(2) .cart-item-inner .dropdown-menu li");
	private By firstCartItemAutoshipDisabledFrequencyOptions = By.cssSelector(".cart-item-container:nth-of-type(2) .cart-item-inner .dropdown-menu li[data-disabled='disabled']");

	private By subtotalSelector = By.cssSelector("#orderTotals tbody:nth-of-type(1) td.cart-total-col");
	private By totalSelector = By.cssSelector("#orderTotals tfoot td.cart-total-col");

	private By cartAlertWarning = By.cssSelector(".cart .alert-warning");

	private By estimateShippingLink = By.cssSelector("#orderTotals tbody:nth-of-type(2) td.cart-total-col a");
	private By estimateShippingZipInput = By.id("estimateFreightZipCode");
	private By estimateShippingCalculateButton = By.cssSelector(".estimateFreight.button-primary");
	private By estimateShippingOptionName = By.cssSelector("#estimatedFreight td.cart-label-col");
	private By estimateShippingOptionCost = By.cssSelector("#estimatedFreight td.cart-total-col");
	private By estimateShippingChoooseOption = By.cssSelector("#estimatedFreight td.cart-total-col a");

	private By requiredAccessoriesLink = By.cssSelector("a.required-accessories");

// -------- Coupon
	private By squealDealContainer = By.cssSelector("div.panel div.panel-body div.cart-squeal-deal-container");
	private By couponCodeInput = By.cssSelector("#couponCode");
	private By applyCodeButton = By.cssSelector("#sdSubmit");
	private By couponSuccessfullyAppliedMessage =  By.cssSelector(".alert-success");
	private By removeDealLink = By.cssSelector("#sdRemove");

//--------- Promo items
	private By promoItem = By.cssSelector(".promo-item");
	private By promoItemUnitPrice = By.cssSelector(".promo-item .item-unit-price");
	private By promoItemTotalPrice = By.cssSelector(".promo-item .item-unit-price");
	private By freeGiftItemLink = By.cssSelector(".promo-item a[href*=FREEGIFT]");


// -------- Quick order
	private By quickOrderProdIdInput = By.cssSelector("div.cart-quick-order form.add-to-cart-form input.quick-order-id");
	private By quickOrderQtyInput = By.cssSelector("div.cart-quick-order form.add-to-cart-form input.quick-order-qty");
	private By addToCartButton = By.cssSelector("div.cart-quick-order button.add-to-cart-mini");

// -------- Today only deal

	private By todayOnlyDealContainer = By.id("promotion-block-cart");
	private By firstTODProductName = By.cssSelector("#promotion-block-cart div.product-block:nth-of-type(1) .product-name");
	private By secondTODProductName = By.cssSelector("#promotion-block-cart div.product-block:nth-of-type(2) .product-name");
	private By genericTODProductName = By.cssSelector("#promotion-block-cart div.product-block .product-name");

	private By addFirstTODProductToCart = By.cssSelector("#promotion-block-cart div.product-block:nth-of-type(1) .add-to-cart-mini");
	private By addSecondTODProductToCart = By.cssSelector("#promotion-block-cart div.product-block:nth-of-type(2) .add-to-cart-mini");



	// ---------------------------------------------  Constructor and components --------------------------------------

	public ProductsTable productsTable = new ProductsTable(driver);

	public SimplePopup simplePopup = new SimplePopup(driver);
	public AdditionalInfoPopup additionalInfoPopup = new AdditionalInfoPopup(driver);

	public Cart(WebDriver driver) {
		super(driver);
	}



	// ---------------------------------------------  Functionality ---------------------------------------------------

	public void areBaseElementsPresent(){
		waitVisible(printLink);
		waitVisible(emailLink);
		waitVisible(breadcrumbs);
		waitVisible(checkoutHelp);
		waitVisible(checkoutButton);
		waitVisible(continueShoppingLink);
		waitVisible(cartItemRow);
		waitVisible(squealDealContainer);
	}

	public void areEmptyCartBaseElementsPresent(){
		waitVisible(breadcrumbs);
		waitVisible(checkoutHelp);
		waitVisible(continueShoppingLink);
	}

	public void quickAdd(String productID, String qty){
		fillInput(quickOrderProdIdInput, productID);
		fillInput(quickOrderQtyInput, qty);
		click(addToCartButton);
		waitSeconds(2);
	}

	public PricePojo getSubtotalPrice(){
		return new PricePojo(getText(subtotalSelector));
	}

	public PricePojo getTotalPrice(){
		return new PricePojo(getText(totalSelector));
	}

	public boolean isCalcuationsCorrect(){

		boolean calcualtionsCorrect = true;

		ArrayList<RowItemPojo> cartRowsInfo = productsTable.getCartRowsInfo();

		Float cartSubtotal = getSubtotalPrice().getPrice();
		Float cartTotal = getTotalPrice().getPrice();

		Float calculatedSubtotalPrice = new Float(0);

		for (RowItemPojo cartRow : cartRowsInfo) {
			Integer quantity = cartRow.getQty();
			Float itemPrice = cartRow.getItemNormalPrice().getPrice();
			Float itemSubtotal = cartRow.getRowTotalNormalPrice().getPrice();

			calculatedSubtotalPrice+=itemSubtotal;

			if(quantity*itemPrice != itemSubtotal){
				calcualtionsCorrect = false;
			}
		}

		if(!cartSubtotal.equals(calculatedSubtotalPrice)){ calcualtionsCorrect = false;}

		return calcualtionsCorrect;
	}

	public void startCheckout(){
		waitSeconds(1);
		click(checkoutButton);
	}

	public String addTODProductToCart(Integer index){

		String productName = "";

		if(index==1){
			productName = getText(firstTODProductName);
			click(addFirstTODProductToCart);
		}else{
			productName = getText(secondTODProductName);
			click(addSecondTODProductToCart);
		}
		return productName;
	}


	public ArrayList<String> getTODProductNames(){
		return getTexts(genericTODProductName);
	}
	
	/**
	 * Applies a the coupon code given as string parameter
	 * @param code
	 */
	public void applyValidCouponCode(String code){
		fillInput(couponCodeInput, code);
		click(applyCodeButton);
	}
	
	/**
	 * Verifies that the confirmation message is displayed after saving a coupon code on cart
	 * @return true if displayed
	 */
	public boolean isCouponSuccessfullyApplied(){
		return isVisible(couponSuccessfullyAppliedMessage);
	}

	/**
	 * Verifies that a free item is displayed in cart
	 * Item has unit and total price as FREE
	 * @return true if all conditions met
	 */
	public boolean isFreeItemDisplayed(){
		boolean allDisplayed = true;
		isVisible(promoItem);
		if (!getText(promoItemUnitPrice).contains("FREE"))
			allDisplayed = false;
		if (!getText(promoItemTotalPrice).contains("FREE"))
			allDisplayed = false;
		return allDisplayed;
	}
	
	/**
	 * Verifies that the Required Accessories link is displayed
	 * @return true if displayed
	 */
	public boolean isRequiredAccessoriesLinkDisplayed(){
		return isVisible(requiredAccessoriesLink);
	}
	
	/**
	 * 
	 * @return whole text of a cart item. Includes prices.
	 */
	public String getItemText(){
		return getText(cartItemRow);
	}
	
	/**
	 * Clicks on required accessories
	 */
	public void clickRequiredAccessories(){
		click(requiredAccessoriesLink);
	}
	
	/**
	 * Verifies that the cart displays the products provided as parameters.
	 * Products parameter is a HasMap with key and value (e.g  productId, productPrice)
	 * @param products
	 * @return true if all products as key are displayed in cart with property as value
	 */
	public boolean productsAreDisplayedInCart(HashMap<String, String> products){
		boolean correctlyAdded = true;
		for (Map.Entry<String,String> product : products.entrySet()) {
			boolean found = false;
			List<WebElement> items = cartItemRow.findElements(driver);
			for (WebElement item : items) {
				if (item.getText().contains(product.getKey()) && 
					item.getText().contains(product.getValue())){
					found = true;
					break;
				}
			}
			if (found==false){
				correctlyAdded = false;
				log.error("Item "+product.getKey()+" with value "+product.getValue()+" was not found in cart!");
			}
		}
		return correctlyAdded;
	}

	/**
	 * Clicks on remove deal link if at least one deal is saved
	 */
	public void removeDeal(){
		if (isPresent(removeDealLink))
			click(removeDealLink);
	}

	/**
	 * @return auto ship actual selection text from the first element in cart
	 */
	public String getFirstItemAutoshipFrequency(){
		return getText(cartItemAutoShipFrequency);
	}

	/**
	 * Selects the frequency given as text parameter
	 * @param text
	 */
	public void chooseFirstItemFrequency(String text){
		List<WebElement> options = null;
		if (!isVisible(cartItemAutoShipFrequency)){
			log.error("Frequency picker should be visible but isn't");
		}
		else{
			click(cartItemAutoShipFrequencyArrow);
			options = driver.findElements(cartItemAutoshipFrequencyOptions);
			boolean optionFound = false;
			for (WebElement option : options) {
				if (option.getText().equalsIgnoreCase(text)){
					option.click();
					optionFound = true;
					break;
				}
			}
			if (!optionFound){
				log.error("-----Option: " + text +" to click not found!!!!!");
			}
		}
	}

	public boolean isFirstItemNoAutoshipProduct(){
		List<WebElement> options = null;
		List<WebElement> disabledOptions = null;
		if (!isVisible(cartItemAutoShipFrequency)){
			log.error("Frequency picker should be visible but isn't");
			return false;
		}
		else{
			click(cartItemAutoShipFrequencyArrow);
			options = driver.findElements(firstCartItemAutoshipFrequencyOptions);
			disabledOptions = driver.findElements(firstCartItemAutoshipDisabledFrequencyOptions);
			return (options.size() - disabledOptions.size() == 1);
		}
	}

	/**
	 * Check to see if a promo item in cart contains a discount message pattern
	 * @param discountPattern
	 * @return true if text is found
	 */
	public boolean isDiscountMessageDisplayed(String discountPattern){
		List<WebElement> options = null;
		options = driver.findElements(promoItem);
		boolean found = false;
		for (WebElement option : options) {
			if (option.getText().contains(discountPattern))
				found = true;
		}
		return found;
	}

	/**
	 * Verifies if the percentage discount is correctly applied to cart
	 * @param discountPercent
	 * @return true if calculations are correct
	 */
	public boolean isPercentageDiscountApplied(float discountPercent){
		PricePojo subtotal = getSubtotalPrice();
		PricePojo total = getTotalPrice();

		return (total.getPrice() == (subtotal.getPrice() * (1 - discountPercent/100)));
	}

	/**
	 * @return true if any free gift item is displayed
	 */
	public boolean isFreeGiftItemDisplayed(){
		return isVisible(freeGiftItemLink);
	}

	/**
	 * @return text of the warning alert on cart
	 */
	public String getAlertWarningMessage(){
		return getText(cartAlertWarning);
	}

	/**
	 * @return true if Cart page is displayed
	 */
	public boolean isPageDisplayed(){
		return isVisible(cartContainer);
	}
	
}
