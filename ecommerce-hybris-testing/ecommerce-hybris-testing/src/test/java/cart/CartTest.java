package cart;

import base.utils.MyTNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;
import pages.cart.RowItemPojo;

import java.util.HashMap;

@Listeners(MyTNGListener.class)
public class CartTest {

	public Newpig newpig;

	@BeforeMethod
	public void before(){
		newpig = new Newpig();
	}

	@AfterMethod
	public void after(){
		newpig.quit();
	}




	@Test(groups = {"smoke"}, description = "Cart - 360\tCart Content and # - Guest - Check cart content")
	public void TC360_cartContentGuest() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.addFeaturedProductToCart();

		softAssert.assertTrue(newpig.homepage.header.addedToCartMessageVisible());

		newpig.homepage.header.goToCartPage();
		newpig.cart.areBaseElementsPresent();

		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Cart - 552 - Calculations - Any User - Edit quantity - check calculations")
	public void TC552_cartEditQtyCalculations() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.addFeaturedProductToCart();
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "5");


		softAssert.assertTrue(newpig.cart.isCalcuationsCorrect());

		newpig.cart.productsTable.setProductQtyTo(5, 1);
		newpig.cart.productsTable.setProductQtyTo(6, 2);

		softAssert.assertTrue(newpig.cart.isCalcuationsCorrect());

		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Cart - 551 - Calculations - Any User - Add to cart - check calculations")
	public void TC551_addToCartCalculations() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.addFeaturedProductToCart();
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "5");

		softAssert.assertTrue(newpig.cart.isCalcuationsCorrect());

		newpig.cart.quickAdd("PIG210", "2");

		softAssert.assertTrue(newpig.cart.isCalcuationsCorrect());

		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Cart - 337\tQuick Add - Full positive flow")
	public void TC337_quickAddPositive() {

		String prodId = "MAT276";
		String prodQty = "2";

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.goToCartPage();

		newpig.cart.quickAdd(prodId, prodQty);

		softAssert.assertEquals(newpig.cart.productsTable.getCartRowsInfo().get(0).getProdId(), prodId);
		softAssert.assertEquals(newpig.cart.productsTable.getCartRowsInfo().get(0).getQty().toString(), prodQty);

		softAssert.assertAll();

	}


	@Test(groups = {"smoke"}, description = "Cart - 674\tEmpty cart - Guest - go to cart - from Header -> View Cart")
	public void TC674_emptyCartViewCart() {

		SoftAssert softAssert = new SoftAssert();
		newpig.homepage.header.goToCartPage();
		newpig.cart.areEmptyCartBaseElementsPresent();
		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Cart - 335\tQuick Add - Check Quick Add option in cart")
	public void TC335_checkQuickAddOptionInCart() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.openHomePage();

		String productID = newpig.homepage.featuredProductsTab.getProductID(1, 1);
		String productName = newpig.homepage.featuredProductsTab.getProductName(1, 1);

		newpig.homepage.featuredProductsTab.clickAddToCart(1,1);

		newpig.homepage.header.goToCartPage();

		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId());
		softAssert.assertEquals(productName, row.getProdName());

		newpig.cart.quickAdd(productID, "1");

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Cart - 394\tCart - Update quantity")
	public void TC394_updateQuantity() {


		SoftAssert softAssert = new SoftAssert();



		String productID = newpig.homepage.featuredProductsTab.getProductID(1, 1);
		String productName = newpig.homepage.featuredProductsTab.getProductName(1, 1);

		newpig.homepage.featuredProductsTab.clickAddToCart(1,1);

		newpig.homepage.header.goToCartPage();


		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId());
		softAssert.assertEquals(productName, row.getProdName());
		softAssert.assertTrue(row.getQty() == 1);

		newpig.cart.productsTable.setProductQtyTo(3, 1);

		row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId());
		softAssert.assertEquals(productName, row.getProdName());
		softAssert.assertTrue(row.getQty() == 3);

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Cart - 393\tRemove from cart - Remove option")
	public void TC393_removeProduct() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.openHomePage();

		String productID = newpig.homepage.featuredProductsTab.getProductID(1, 1);
		String productName = newpig.homepage.featuredProductsTab.getProductName(1, 1);

		newpig.homepage.featuredProductsTab.clickAddToCart(1, 1);

		newpig.homepage.header.goToCartPage();


		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId());
		softAssert.assertEquals(productName, row.getProdName());
		softAssert.assertTrue(row.getQty() == 1);

		newpig.cart.productsTable.removeProduct(1);

		softAssert.assertTrue(newpig.cart.productsTable.countProductRows() == 0);

		softAssert.assertAll();

	}


	@Test(groups = {"smoke"}, description = "Cart - 344\tQuick Add - Discontinued product - No replacement item")
	public void TC344_quickAddDiscontinuedWNoReplacement() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.openHomePage();

		String productID = newpig.homepage.featuredProductsTab.getProductID(1, 1);
		String productName = newpig.homepage.featuredProductsTab.getProductName(1, 1);
		newpig.homepage.featuredProductsTab.clickAddToCart(1,1);

		newpig.homepage.header.goToCartPage();


		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId());
		softAssert.assertEquals(productName, row.getProdName());
		softAssert.assertTrue(row.getQty() == 1);

		newpig.cart.quickAdd("DRM399", "4");

		newpig.cart.simplePopup.clickClose();

		softAssert.assertTrue(newpig.cart.productsTable.countProductRows() == 1);


		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Cart - 347\tQuick Add - SKU'd item - YES")
	public void TC347_quickAddSKUdItem() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("==========================FAILING bug ER-5332=================================");
//			3	Add a product to cart. 		Product added to cart successfully.
		String productID = newpig.homepage.featuredProductsTab.getProductID(1, 1);
		String productName = newpig.homepage.featuredProductsTab.getProductName(1, 1);
		newpig.homepage.featuredProductsTab.clickAddToCart(1,1);

//			4	 Go to cart.	 	Your cart page should be displayed.
		newpig.homepage.header.goToCartPage();


		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertEquals(productID, row.getProdId(), "ProductID is correct in cart _ 1");
		softAssert.assertEquals(productName, row.getProdName(), "Product name is correct in cart _ 1");
		softAssert.assertTrue(row.getQty() == 1, "Product qty is correct in cart _ 1");

//			5	"Insert in the Quick Add form a item number for a SKU'd item product. Select a valid quantity.ADD."	SGN537, PAK595, FLM667 	Additional Information Needed Product Block modal is displayed.
		newpig.cart.quickAdd("FLM667", "4");




		softAssert.assertEquals(newpig.cart.additionalInfoPopup.getTitle(), "Additional Information Required.");

		String color = newpig.cart.additionalInfoPopup.pickColor();
		String length = newpig.cart.additionalInfoPopup.pickLength();
		newpig.cart.additionalInfoPopup.waitSeconds(2);
		String style = newpig.cart.additionalInfoPopup.pickStyle();

		newpig.cart.additionalInfoPopup.updateQty(3);
		newpig.cart.additionalInfoPopup.addToCart();
		newpig.cart.additionalInfoPopup.clickClose();

		row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertTrue(row.getProdId().contains("FLM667"), "ProductID is correct in cart _ 2");
		softAssert.assertTrue(row.getQty()==3, "Product qty is correct in cart _ 2");
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(color), "Product color is correct in cart _ 2");
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(length), "Product length is correct in cart _ 2");
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(style), "Product style is correct in cart _ 2");

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Cart - 594\tToday Deal - Guest - Check if promotion product is replaced by anther once added to cart")
	public void TC594_cartTODAddProduct() {

		SoftAssert softAssert = new SoftAssert();


		newpig.homepage.header.goToCartPage();

		String productName = newpig.cart.addTODProductToCart(1);

		newpig.cart.waitSeconds(1);
		boolean productNameFoundInCart = false;
		for (RowItemPojo rowItemPojo : newpig.cart.productsTable.getCartRowsInfo()) {
			if(rowItemPojo.getProdName().equals(productName)){ productNameFoundInCart = true;}
		}
		softAssert.assertTrue(productNameFoundInCart);
		softAssert.assertFalse(newpig.cart.getTODProductNames().contains(productName));


		productName = newpig.cart.addTODProductToCart(100);

		newpig.cart.waitSeconds(1);
		productNameFoundInCart = false;
		for (RowItemPojo rowItemPojo : newpig.cart.productsTable.getCartRowsInfo()) {
			if(rowItemPojo.getProdName().equals(productName)){ productNameFoundInCart = true;}
		}
		softAssert.assertTrue(productNameFoundInCart);
		softAssert.assertFalse(newpig.cart.getTODProductNames().contains(productName));

		productName = newpig.cart.addTODProductToCart(2);

		newpig.cart.waitSeconds(1);
		productNameFoundInCart = false;
		for (RowItemPojo rowItemPojo : newpig.cart.productsTable.getCartRowsInfo()) {
			if(rowItemPojo.getProdName().equals(productName)){ productNameFoundInCart = true;}
		}
		softAssert.assertTrue(productNameFoundInCart);
		softAssert.assertFalse(newpig.cart.getTODProductNames().contains(productName));


		softAssert.assertAll();

	}
	
	@Test(groups = {"smoke"}, description = "Cart - 360\tDiscounted pricing - US - Free item - Squeal deal price")
	public void TC581_freeItemSquealDealPrice() {
		
		String prodId = "MAT276";
		String prodQty = "1";
		SoftAssert softAssert = new SoftAssert();
		
		// Add a product which comes at promotion with a free item.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd(prodId, prodQty);
		newpig.cart.applyValidCouponCode("99006");
		
		// Verify message and free item
		softAssert.assertTrue(newpig.cart.isCouponSuccessfullyApplied());
		softAssert.assertTrue(newpig.cart.isFreeItemDisplayed());
		
		softAssert.assertAll();
	}
	
	@Test(groups = {"smoke"}, description = "Cart - 888\tAccessories needed - Add to cart Accessory product")
	public void TC888_addToCartRequiredAccessory() {
		
		String prodId = "TLS464";
		String prodQty = "1";
		SoftAssert softAssert = new SoftAssert();
		
		// Add a product which has required accessories
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd(prodId, prodQty);
		newpig.cart.header.quickAdd.additionalInfoPopup.waitSeconds(3);
		newpig.cart.header.quickAdd.additionalInfoPopup.pickColor();
		newpig.cart.header.quickAdd.additionalInfoPopup.addToCart();
		newpig.cart.header.quickAdd.additionalInfoPopup.clickClose();
		
		// Verify the Required accessories link
		softAssert.assertTrue(newpig.cart.isRequiredAccessoriesLinkDisplayed());
		
		//Add required accessories
		newpig.cart.clickRequiredAccessories();
		HashMap<String, String> accesories = newpig.cart.header.quickAdd.additionalInfoPopup.addRequiredAccessories();
		
		//Verify that the added products are correctly displayed in cart
		softAssert.assertTrue(newpig.cart.productsAreDisplayedInCart(accesories));
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Cart - 4839\tAutoShip Item - Add autoshippable product to cart")
	public void TC4839_addAutoshippableProductToCart() {

		String prodId = "MAT185";
		String frequency = "now & every 3 months";
		SoftAssert softAssert = new SoftAssert();

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

	@Test(groups = {"smoke"}, description = "Cart - 4842\tAutoShip Item - Edit AutoShip product")
	public void TC4839_editAutoshippableProductInCart() {

		String prodId = "MAT185";
		String frequency = "now & every 3 months";
		String discountPattern = "You saved";
		int discountPercent = 5;
		SoftAssert softAssert = new SoftAssert();

		//Search for an autoshippable product id
		newpig.homepage.header.searchControls.searchFor(prodId);

		//Add to cart
		newpig.pdp.addToCart();
		newpig.pdp.waitSeconds(2);
		//Go to cart page
		newpig.pdp.header.goToCartPage();

		//Change the frequency so that the product is now an autoship product
		newpig.cart.chooseFirstItemFrequency(frequency);
		newpig.cart.waitSeconds(3);

		//Verify the product has been added with the selected frequency
		softAssert.assertTrue(newpig.cart.getFirstItemAutoshipFrequency().contains(frequency),"Product added with the right frequency");

		//Verify that a discount is applied and a free gift item is added to cart
		softAssert.assertTrue(newpig.cart.isDiscountMessageDisplayed(discountPattern),"Discount message displayed");
		softAssert.assertTrue(newpig.cart.isPercentageDiscountApplied(discountPercent),"Discount correctly applied");
		softAssert.assertTrue(newpig.cart.isFreeGiftItemDisplayed(),"Free gift item displayed");

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Cart - 1195\tAdd to Cart - Any User - Quantity - Check AutoShip option - Non-autoshippable product")
	public void TC1195_checkAutoshipOtopionNonAutoshipProduct() {

		String prodId = "GEN309";
		String frequency = "now & every 3 months";
		SoftAssert softAssert = new SoftAssert();

		//Search for an autoshippable product id
		newpig.homepage.header.searchControls.searchFor(prodId);

		//Add to cart
		newpig.pdp.addToCart();
		newpig.pdp.waitSeconds(2);
		//Go to cart page
		newpig.pdp.header.goToCartPage();

		//Verify that the added item has disabled auto ship options
		newpig.cart.waitSeconds(3);
		softAssert.assertTrue(newpig.cart.isFirstItemNoAutoshipProduct(), "First Item has disabled auto ship options");

		//Verify that selecting any frequency has no efect
		newpig.cart.chooseFirstItemFrequency(frequency);
		softAssert.assertTrue(newpig.cart.getFirstItemAutoshipFrequency().contains("Ship One Time"));

		softAssert.assertAll();
	}
	
}
