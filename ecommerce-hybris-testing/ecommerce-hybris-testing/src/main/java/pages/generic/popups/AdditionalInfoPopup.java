package pages.generic.popups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 4/21/15.
 */
public class AdditionalInfoPopup extends BasePopup{


	By modalProductNameLink = By.cssSelector("div.modal-item .right>h2>a");
	By modalProductIDLink = By.cssSelector("div.modal-item .productCode>a");

	By modalPickColorControl = By.cssSelector("div.modal-item ul.variant-swatch li:nth-of-type(1) a");
	By modalPickColorLabel = By.cssSelector("div.modal-item ul.variant-swatch li:nth-of-type(1) a img");

	By pickLengthExpander = By.cssSelector("div.variant-length div.variant-option button");
	By modalPickLengthControl = By.cssSelector("div.modal-item div div.styled-select div.btn-group.select.open ul.dropdown-menu li:nth-of-type(2)");

	By pickStyleExpander = By.cssSelector("div.variant-miscUniqueFeature div.styled-select div.btn-group.select button");
	By modalPickStyleControl = By.cssSelector("div.modal-item div div.styled-select div.btn-group.select.open ul.dropdown-menu li:nth-of-type(2)");

	By qtyInput = By.cssSelector("div.modal-item input.qty");

	By priceSpan = By.cssSelector("div.modal-item span.pdpPrice");

	By addToCartButton = By.cssSelector("div.modal-item form.add_to_cart_quick_form button.addToCartButton");
	By removeItemFromPopupLink = By.cssSelector("div.modal-item a.remove-item");

	By requiredAccessoriesAddToCart = By.cssSelector(".requiredAccessories.is-active .add-to-cart-mini");
	By requiredAccessoryLinkID = By.cssSelector(".requiredAccessories.is-active .productCode>a");
	By requiredAccessoryQty = By.cssSelector(".requiredAccessories.is-active .qty");

	public AdditionalInfoPopup(WebDriver driver) {
		super(driver);
	}


	public String pickColor(){
		click(modalPickColorControl);
		String value = getAttributeValue(modalPickColorLabel, "alt");
		return value;
	}

	public String pickLength(){
		click(pickLengthExpander);
		String value = getAttributeValue(modalPickLengthControl, "data-value");
		click(modalPickLengthControl);
		return value;
	}

	public String pickStyle(){
		click(pickStyleExpander);
		String value = getAttributeValue(modalPickStyleControl, "data-value");
		click(modalPickStyleControl);
		return value;
	}

	public void updateQty(Integer qty){
		fillInput(qtyInput, qty.toString());
	}
	public void addToCart(){
		click(addToCartButton);
	}
	public void removeItem(){
		click(removeItemFromPopupLink);
	}

	public String getPrice(){
		return getText(priceSpan);
	}


	/**
	 * @return the text of the first required accessory ID
	 */
	public String getFirstRequiredAccessoryID(){
		return  getText(requiredAccessoryLinkID);
	}
	
	/**
	 * Adds the required number of accessories
	 * For each accessory type the add qty is incremented by 1. Starts with 2.
	 * @return Hashmap <productID , qty>
	 */
	public HashMap<String, String> addRequiredAccessories(){
		HashMap<String, String> accessories = new HashMap<String,String>();
		int counter=2;
		while (isVisible(requiredAccessoriesAddToCart)){
			accessories.put(getFirstRequiredAccessoryID(),Integer.toString(counter));
			fillInput(requiredAccessoryQty, Integer.toString(counter));
			click(requiredAccessoriesAddToCart);
			counter++;
		}
		return accessories;
	}

}
