package pages.pdp;

import base.data.pojos.PricePojo;
import base.data.pojos.Product;
import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class PDP extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By productName = By.cssSelector(".product-title");

	By pricingContainer = By.id("variantPricePanel-pdp");



	//	PRODUCT OPTIONS
	By colorSwatchContainer = By.cssSelector(".variant-colorSwatchImage.variantpart");
	By colorButtonSelector = By.cssSelector(".variant-colorSwatchImage.variantpart a.colorVariant");
	By colorButtonImgSelector = By.cssSelector(".variant-colorSwatchImage.variantpart a.colorVariant img");

	By styleWISwatchContainer = By.cssSelector(".variant-miscUniqueFeatureSwatchImage.variantpart");
	By styleWIButtonSelector = By.cssSelector(".variant-miscUniqueFeatureSwatchImage.variantpart a.colorVariant");
	By styleWIButtonImgSelector = By.cssSelector(".variant-miscUniqueFeatureSwatchImage.variantpart a.colorVariant img");

	By lengthSelectorContainer = By.cssSelector("div.variant-length");
	By lengthSelectorExpanderButton = By.cssSelector("div.variant-length .btn.btn-default.dropdown-toggle");
	By lengthSelectorOption = By.cssSelector("div.variant-length .dropdown-menu>li");

	By styleSelectorContainer = By.cssSelector("div.variant-miscUniqueFeature");
	By styleSelectorExpanderButton = By.cssSelector("div.variant-miscUniqueFeature .btn.btn-default.dropdown-toggle");
	By styleSelectorOption = By.cssSelector("div.variant-miscUniqueFeature .dropdown-menu>li");

	By sizeSelectorContainer = By.cssSelector("div.variant-size");
	By sizeSelectorExpanderButton = By.cssSelector("div.variant-size .btn.btn-default.dropdown-toggle");
	By sizeSelectorOption = By.cssSelector("div.variant-size .dropdown-menu>li");

	By stockInfo = By.cssSelector(".stock-message");
	By addToCartButton = By.id("addToCartButton-pdp");
	By addToShoppingList = By.cssSelector("#addToShoppingList");

	By newShoppingListField = By.cssSelector("#wishlistCodeNewList");
	By addToListButton = By.cssSelector("#addToListButton");
	By closeAddedToWishlist = By.cssSelector("#addedToWishlist .close");
	By closeSelectWishlist = By.cssSelector("#selectWishlist .close");

	By priceAmounts = By.cssSelector(".volume-price-amount");

	By subscribeToAutoShip = By.cssSelector(".autoship");
	By autoShipFrequencyContainer = By.cssSelector(".autoShipSelector .btn");
	By autoShipFrequencyExpander = By.cssSelector(".autoShipSelector .btn .caret");
	By autoShipFrequencyOptions = By.cssSelector(".autoShipSelector li");


//	print and email buttons
	By printButton = By.id("toolbar-print-productdetail");
	By emailButton = By.id("toolbar-mail-productdetail");
	
//	others
	By pigLogoIcon = By.cssSelector(".product-title img[src=\"//newpig.scene7.com/is/image/NewPig/NEWPIG_W\"]");
	
	//	bundle block
	private By bundleBlockContainer = By.cssSelector(".bundle-container");
	private By bundlePrice = By.cssSelector(".bundle-price");
	private By bundleItemNames = By.cssSelector(".item-name");
	private By bundleAddToCartBtn = By.id("addBundleToCartButton");


// ---------------------------------------------  Constructor and components --------------------------------------


	public PDP(WebDriver driver) {
		super(driver);
	}

	public PrintPopup printPdp = new PrintPopup(driver);


// ---------------------------------------------  Functionality ---------------------------------------------------

	public void addToCart(){
		waitSeconds(1);
		click(addToCartButton);
	}


	public String getProductName(){
		return getText(productName);
	}

	public ArrayList<String> selectProductOptions(Product product){

		ArrayList<String> chosenOptions = new ArrayList<String>();

		if(product.isColorSelect()){
			chosenOptions.add(chooseColor());
		}
		if(product.isSizeSelect()){
			chosenOptions.add(chooseSize());
		}
		if(product.isStyleSelect()){
			chosenOptions.add(chooseStyle());
		}
		if(product.isStyleWithImageSelect()){
			chosenOptions.add(chooseStyleImage());
		}
		if(product.isLengthSelect()){
			chosenOptions.add(chooseLength());
		}

		return chosenOptions;
	}

	private String chooseColor(){
		String colorName = null;
		if (!isVisible(colorSwatchContainer)){
			log.error("Color picker should be visible but isn't");
		}
		else{
			colorName = driver.findElements(colorButtonImgSelector).get(0).getAttribute("alt").trim();
			driver.findElements(colorButtonSelector).get(0).click();
		}
		return colorName;
	}

	private String chooseStyleImage(){
		String styleName = null;
		if (!isVisible(styleWISwatchContainer)){
			log.error("Style w/image picker should be visible but isn't");
		}
		else{
			styleName = driver.findElements(styleWIButtonImgSelector).get(0).getAttribute("alt").trim();
			driver.findElements(styleWIButtonSelector).get(0).click();
		}
		return styleName;
	}

	private String chooseSize(){
		String sizeName = null;
		if (!isVisible(sizeSelectorContainer)){
			log.error("Size picker should be visible but isn't");
		}
		else{
			click(sizeSelectorExpanderButton);
			sizeName = driver.findElements(sizeSelectorOption).get(1).getText().trim();
			driver.findElements(sizeSelectorOption).get(1).click();
		}
		return sizeName;
	}

	private String chooseLength(){
		String lengthOption = null;
		if (!isVisible(lengthSelectorContainer)){
			log.error("Length picker should be visible but isn't");
		}
		else{
			click(lengthSelectorExpanderButton);
			lengthOption = driver.findElements(lengthSelectorOption).get(1).getText().trim();
			driver.findElements(lengthSelectorOption).get(1).click();
		}
		return lengthOption;
	}

	private String chooseStyle(){
		String styleOption = null;
		if (!isVisible(styleSelectorContainer)){
			log.error("Style picker should be visible but isn't");
		}
		else{
			click(styleSelectorExpanderButton);
			styleOption = driver.findElements(styleSelectorOption).get(1).getText().trim();
			driver.findElements(styleSelectorOption).get(1).click();
		}
		return styleOption;
	}

	public void clickPrintPDP(){
		click(printButton);
	}

	public void clickEmailPDP(){
		click(emailButton);
	}

	public String getPricingBlockContent(){
		return getText(pricingContainer);
	}

	public void chooseFirstColor(){
		click(colorButtonSelector);
	}

	public boolean isPigLogoVisibleBeforeProductName(){
		boolean visibility=isVisible(pigLogoIcon);
		if (!visibility) {
			log.error("PigLogo icon should be visible next to the product but isn't");
		}
		return visibility;
		}

	/*clicks add to cart button from the bundle block*/
	public void addBundleToCart(){
		click(bundleAddToCartBtn);
	}

	/*@return the product names of the bundled items*/
	public ArrayList<String> getBundleProducts(){
		return getTexts(bundleItemNames);
	}

	/*@return the price displayed for bundled items*/
	public PricePojo getBundlePrice(){
		return new PricePojo(getText(bundlePrice));
	}

	/*@return true if bundle bock container is present*/
	public boolean isBundleBlockPresent(){
		return isPresent(bundleBlockContainer);
	}

	public boolean isStockInfoVisible(){
		return isVisible(stockInfo);
	}

	/**
	 * @return all prices as String in Array
	 */
	public ArrayList<String> getPrices (){
		return getTexts(priceAmounts);
	}


	/**
	 * Selects the frequency given as text parameter
	 * @param text
	 */
	public void chooseFrequency(String text){
		List<WebElement> options = null;
		if (!isVisible(autoShipFrequencyContainer)){
			log.error("Frequency picker should be visible but isn't");
		}
		else{
			click(autoShipFrequencyExpander);
			options = driver.findElements(autoShipFrequencyOptions);
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

	/**
	 * Select Subscribe to Autoship radio
	 */
	public void selectSubscribeAutoship(){
		click(subscribeToAutoShip);
	}

	public void addProductToShoppingListWithName(String shoppingListName){
		click(addToShoppingList);
		fillInput(newShoppingListField, shoppingListName);
		click(addToListButton);
		click(closeAddedToWishlist);
		if (isVisible(closeSelectWishlist)){
			click(closeSelectWishlist);
		}
	}

	public boolean isAddToShoppingListLinkDisplayed(){
		return isVisible(addToShoppingList);
	}

}


