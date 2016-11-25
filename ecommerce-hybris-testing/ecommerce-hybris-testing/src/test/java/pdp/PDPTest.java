package pdp;

import base.data.TestDataReader;
import base.data.pojos.PricePojo;
import base.data.pojos.Product;
import base.data.pojos.User;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;
import pages.cart.RowItemPojo;

import java.util.ArrayList;

@Listeners(MyTNGListener.class)
public class PDPTest {


	Newpig newpig;
	TestDataReader testDataReader = new TestDataReader();


	@BeforeMethod
	public void before() {
		newpig = new Newpig();
	}

	@AfterMethod
	public void after() {
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "PDP - 2765 - Add to Cart - Any User - Quantity - Subscribe to Autoship")
	public void TC2765_subscribeToAutoship() {

		throw new SkipException("Not Implemented yet");
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertAll();
	}



	@Test(groups= {"smoke"}, description = "PDP - 2032 - Product Options - Any User - Color variant")
	public void TC2032_chooseColorVariant() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductWithVariant("color");
		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> selectedOptions = newpig.pdp.selectProductOptions(product);

		newpig.pdp.addToCart();
		newpig.pdp.header.goToCartPage();

		String cartOptions = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdConfiguredOptions();

		for (String selectedOption : selectedOptions) {
			softAssert.assertTrue(cartOptions.contains(selectedOption));
		}
		softAssert.assertAll();
	}


	@Test(groups= {"smoke"}, description = "PDP - 2033 - Product Options - Any User - Size variant")
	public void TC2033_chooseSizeVariant() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductWithVariant("size");
		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> selectedOptions = newpig.pdp.selectProductOptions(product);

		newpig.pdp.addToCart();
		newpig.pdp.header.goToCartPage();

		String cartOptions = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdConfiguredOptions();

		for (String selectedOption : selectedOptions) {
			softAssert.assertTrue(cartOptions.contains(selectedOption));
		}
		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 2034 - Product Options - Any User - Length variant")
	public void TC2034_chooseLengthVariant() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductWithVariant("length");
		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> selectedOptions = newpig.pdp.selectProductOptions(product);

		newpig.pdp.addToCart();
		newpig.pdp.header.goToCartPage();

		String cartOptions = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdConfiguredOptions();

		for (String selectedOption : selectedOptions) {
			softAssert.assertTrue(cartOptions.contains(selectedOption));
		}
		softAssert.assertAll();
	}


	@Test(groups= {"smoke"}, description = "PDP - 2036 - Product Options - Any User - MUF")
	public void TC2036_chooseMUFVariant() {
		SoftAssert softAssert = new SoftAssert();

		Product product = new Product();
		product.setItemNumber("WPL654");
		product.setColorSelect(true);
		product.setSizeSelect(true);


		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> selectedOptions = newpig.pdp.selectProductOptions(product);

		newpig.pdp.waitSeconds(1);

		newpig.pdp.addToCart();
		newpig.pdp.header.goToCartPage();

		String cartOptions = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdConfiguredOptions();

		for (String selectedOption : selectedOptions) {
			softAssert.assertTrue(cartOptions.contains(selectedOption));
		}


		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 2035 - Product Options - Any User - Custom Length")
	public void TC2035_chooseLengthVariant() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductWithVariant("length");
		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> selectedOptions = newpig.pdp.selectProductOptions(product);

		newpig.pdp.addToCart();
		newpig.pdp.header.goToCartPage();

		String cartOptions = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdConfiguredOptions();

		for (String selectedOption : selectedOptions) {
			softAssert.assertTrue(cartOptions.contains(selectedOption));
		}


		softAssert.assertAll();
	}



	@Test(groups= {"smoke"}, description = "PDP - 2664 - Print product - Any user - Check Pricing - non SKU'd - Tiered price break")
	public void TC2664_pricesInPrintPopup() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductById("404");

		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		String pricingBlockContent = newpig.pdp.getPricingBlockContent();

		newpig.pdp.clickPrintPDP();
		newpig.pdp.switchToWindowWithTitle(product.getProductName() + " - " + product.getItemNumber() + " - " + product.getProductName() + " - " + product.getItemNumber() + " - New Pig-pds");

		String popupPricingBlockContent = newpig.pdp.printPdp.getPricingBlockContent();

		softAssert.assertTrue(pricingBlockContent.equalsIgnoreCase(popupPricingBlockContent));


		softAssert.assertAll();
	}


	@Test(groups= {"smoke"}, description = "PDP - 2665 - Print product - Any user - Check Pricing - non SKU'd - Single price")
	public void TC2665_pricesInPrintPopup() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductById("GEN572");

		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		String pricingBlockContent = newpig.pdp.getPricingBlockContent();

		newpig.pdp.clickPrintPDP();
		newpig.pdp.switchToWindowWithTitle(product.getProductName()+" - "+product.getItemNumber()+" - "+product.getProductName()+" - "+product.getItemNumber()+" - New Pig-pds");

		String popupPricingBlockContent = newpig.pdp.printPdp.getPricingBlockContent();

		softAssert.assertTrue(pricingBlockContent.equalsIgnoreCase(popupPricingBlockContent));


		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 2666 - Print product - Any user - Check Pricing - SKU'd")
	public void TC2666_pricesInPrintPopup() {
		SoftAssert softAssert = new SoftAssert();

		Product product = testDataReader.getProductWithVariant("color");

		newpig.homepage.header.searchControls.searchFor(product.getItemNumber());

		ArrayList<String> productPrices = newpig.pdp.getPrices();

		newpig.pdp.clickPrintPDP();
		newpig.pdp.switchToWindowWithTitle(product.getProductName()+" - "+product.getItemNumber()+" - "+product.getProductName()+" - "+product.getItemNumber()+" - New Pig-pds");

		String popupPricingBlockContent = newpig.pdp.printPdp.getPricingBlockContent();

		for (String productPrice : productPrices) {
			softAssert.assertTrue(popupPricingBlockContent.contains(productPrice),"Price displayed"+productPrice);
		}

		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 4021 - Details - Any User - Stock info - Barnyard (notSpecified)")
	public void TC4021_barnYardStockInfoNotVisible() {
		SoftAssert softAssert = new SoftAssert();
		//search for Barnyard to reach Barnyard category
		newpig.homepage.header.searchControls.searchFor("Barnyard");
		newpig.subCategory.selectProductById("GLV341");
		softAssert.assertFalse(newpig.pdp.isStockInfoVisible());

		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 4119\tBought together - Guest - Add bundle to cart")
	public void TC4119_addBundleToCart() {
		SoftAssert softAssert = new SoftAssert();

		//			4119	Bought together - Guest - Add bundle to cart

		newpig.homepage.header.searchControls.searchFor("404");
		ArrayList<String> productNames = newpig.pdp.getBundleProducts();
		PricePojo bundlesPrice = newpig.pdp.getBundlePrice();

		newpig.pdp.addBundleToCart();
		newpig.pdp.header.goToCartPage();

		ArrayList<RowItemPojo> itemsInCart = newpig.cart.productsTable.getCartRowsInfo();

		System.out.println("itemsInCart = " + itemsInCart);
		System.out.println("bundlesPrice = " + bundlesPrice);
		System.out.println("productNames = " + productNames);

		for (String productName : productNames) {
			boolean found = false;
			for (RowItemPojo rowItemPojo : itemsInCart) {
				if (rowItemPojo.getProdName().equalsIgnoreCase(productName)){
					found = true;
				}
			}
			softAssert.assertTrue(found, "Product not found in cart - "+productName);
		}

		softAssert.assertTrue(newpig.cart.getTotalPrice().getPrice().equals(bundlesPrice.getPrice()), "Price of bundle is not correct in cart");

		softAssert.assertAll();
	}


	@Test(groups= {"smoke"}, description = "PDP - 4024 - Details - Any User - Call for quote - Bundle block")
	public void TC4024_bundleBlockonCallForQuoteProduct() {
		SoftAssert softAssert = new SoftAssert();

		//			4024 - Details - Any User - Call for quote - Bundle block

		newpig.homepage.header.searchControls.searchFor("PAK296");
		softAssert.assertFalse(newpig.pdp.isBundleBlockPresent());


		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 4011 - Details - Any User - Check Product Name")
	public void TC4011_checkNamePigBranded()  {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Absorbents");
		newpig.homepage.header.navBar.clickCategoryName("Socks, Booms, Pillows & Pans");

		//softAssert.assertTrue(newpig.category.isSubcategoryBlockComplete());
		//softAssert.assertTrue(newpig.category.groupingCategoryVisible());

		newpig.category.goToSubcategory("PIG Blue Spill Response Sock");
		newpig.subCategory.selectProductById("2048");

		String productName = newpig.pdp.getProductName().trim();
		softAssert.assertTrue(productName.startsWith("PIG"));
		softAssert.assertTrue(newpig.pdp.isPigLogoVisibleBeforeProductName());


		softAssert.assertAll();

	}

	@Test(groups= {"smoke"}, description = "PDP - 2765 - Add to Cart - Any User - Quantity - Subscribe to Autoship")
	public void TC2765_subscribeToAutoShip()  {
		SoftAssert softAssert = new SoftAssert();

		String prodId = "BLU102";
		String frequency = "now & every 6 months";

		//Search for an autoshippable product id
		newpig.homepage.header.searchControls.searchFor(prodId);

		//Select delivery frequency from PDP
		newpig.pdp.selectSubscribeAutoship();
		newpig.pdp.chooseFrequency(frequency);
		newpig.pdp.addToCart();

		//Go to cart page
		newpig.pdp.header.goToCartPage();

		//Verify the product has been added with the selected frequency
		softAssert.assertTrue(newpig.cart.getFirstItemAutoshipFrequency().contains(frequency),"Product added with the right frequency");

		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 858 - Shopping List - Any User - Add to Shopping List")
	public void TC858_addToShoppingList()  {
		SoftAssert softAssert = new SoftAssert();

		//Login with random user
		User user = testDataReader.getRndUser();
		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		//Navigate to a product PDP
		String prodId = "MAT240";
		newpig.homepage.header.searchControls.searchFor(prodId);

		String shoppingListName = "List_" + Utils.getRndString(3);
		newpig.pdp.addProductToShoppingListWithName(shoppingListName);

		//Verify that the product was added in the created list
		newpig.pdp.header.clickMyAccountMenuOption("My Shopping Lists");
		newpig.myAccount.shoppingList.clickOnListWithName(shoppingListName);
		softAssert.assertTrue(newpig.myAccount.shoppingList.isItemWithCodeVisibleInList(prodId),"Item added in shopping list");

		softAssert.assertAll();
	}

	@Test(groups= {"smoke"}, description = "PDP - 857 - Shopping List - Any User - Add to Shopping List - Call for quote product.")
	public void TC857_callForQuoteNoAddToShoppingList()  {
		SoftAssert softAssert = new SoftAssert();

		//Login with random user
		User user = testDataReader.getRndUser();
		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		//Navigate to a call for quote product PDP
		newpig.homepage.header.searchControls.searchFor(testDataReader.getCallForQuoteProduct().getItemNumber());
		//Add to shopping list not available
		softAssert.assertFalse(newpig.pdp.isAddToShoppingListLinkDisplayed(),"Item cannot be added to shopping list");

		softAssert.assertAll();
	}








}
