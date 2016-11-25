package pages.generic;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.generic.popups.AdditionalInfoPopup;
import pages.generic.popups.SimplePopup;


public class HeaderQuickAdd extends WebPage{

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By product1Input = By.id("productNumber[1]");
	private By qty1Input = By.id("quantity[1]");

	private By product2Input = By.id("productNumber[2]");
	private By qty2Input = By.id("quantity[2]");

	private By addToCart = By.cssSelector("#quick-order-layer button.add-to-cart-mini");


// ---------------------------------------------  Constructor and components --------------------------------------


	public HeaderQuickAdd(WebDriver driver) {
		super(driver);
	}

	public SimplePopup simplePopup = new SimplePopup(driver);
	public AdditionalInfoPopup additionalInfoPopup = new AdditionalInfoPopup(driver);

// ---------------------------------------------  Functionality ---------------------------------------------------

	public void fillFirstProduct(String productId, Integer qty){
		fillInput(product1Input, productId);
		fillInput(qty1Input, qty.toString());
	}
	public void fillSecondProduct(String productId, Integer qty){
		fillInput(product2Input, productId);
		fillInput(qty2Input, qty.toString());
	}
	public void addToCart(){
		click(addToCart);
	}


}
