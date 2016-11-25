package header_footer;

import base.utils.MyTNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;
import pages.cart.RowItemPojo;

import java.util.ArrayList;

@Listeners(MyTNGListener.class)
public class HeaderTest {


	Newpig newpig;

	@BeforeMethod
	public void before(){
		newpig = new Newpig();
	}

	@AfterMethod
	public void after(){
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "244\tVerify full keyword in header search")
	public void TC244_searchInHeader() {

		SoftAssert softAssert = new SoftAssert();
		newpig.homepage.header.searchControls.typeInSearch("MAT");

		for (String prodCode : newpig.homepage.header.searchControls.getSuggestedProductCodes()) {
			softAssert.assertTrue(prodCode.contains("MAT"));
		}
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "247\tVerify full keyword in header search")
	public void TC247_searchInHeader() {
		SoftAssert softAssert = new SoftAssert();
		newpig.homepage.header.searchControls.typeInSearch("TEST");
		for (String prodCode : newpig.homepage.header.searchControls.getSuggestedCorrections()) {
			softAssert.assertTrue(prodCode.contains("test"));
		}
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "227\tVerify minicart in header")
	public void TC227_minicartInHeader() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(newpig.homepage.header.minicart.isLoaded());
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "224 \t Verify multiple products are added to recently viewed products in header")
	public void TC224_multipleProductsReentlyViewed() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");
		newpig.category.goToRandomSubcategory();


		String firstProduct = newpig.subCategory.getProductNameAndClickIt(1);
		newpig.pdp.goBack();
		String secondProduct = newpig.subCategory.getProductNameAndClickIt(2);

		newpig.pdp.header.expandRecentlyViewed();
		newpig.pdp.waitSeconds(1);
		softAssert.assertTrue(newpig.pdp.header.isProductListedInRecentlyViewed(firstProduct));
		softAssert.assertTrue(newpig.pdp.header.isProductListedInRecentlyViewed(secondProduct));


		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "226\tVerify quick order pad adds products to cart")
	public void TC226_addToCartViaHeaderQuickAdd() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.expandQuickAdd();
		newpig.homepage.header.quickAdd.fillFirstProduct("PIG210", 2);
		newpig.homepage.header.quickAdd.fillSecondProduct("404", 2);
		newpig.homepage.header.quickAdd.addToCart();


		newpig.homepage.header.goToCartPage();

		ArrayList<RowItemPojo> cartRows = newpig.cart.productsTable.getCartRowsInfo();

		boolean firstProdFound = false;
		boolean secondProdFound = false;

		for (RowItemPojo cartRow : cartRows) {
			if(cartRow.getProdId().equals("PIG210")){
				firstProdFound = true;
			}else if(cartRow.getProdId().equals("404")){
				secondProdFound = true;
			}
			softAssert.assertTrue(cartRow.getQty() == 2);
		}

		softAssert.assertTrue(firstProdFound);
		softAssert.assertTrue(secondProdFound);


		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "316\tVerify SKU product in Quick Order Pad")
	public void TC316_addToCartSkudItemViaHeaderQuickOrder() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.expandQuickAdd();
		newpig.homepage.header.quickAdd.fillFirstProduct("FLM667", 2);
		newpig.homepage.header.quickAdd.addToCart();

		newpig.homepage.header.quickAdd.additionalInfoPopup.pickColor();

		String color = newpig.homepage.header.quickAdd.additionalInfoPopup.pickColor();
		String length = newpig.homepage.header.quickAdd.additionalInfoPopup.pickLength();
		String style = newpig.homepage.header.quickAdd.additionalInfoPopup.pickStyle();

		newpig.homepage.header.quickAdd.additionalInfoPopup.updateQty(3);
		newpig.homepage.header.quickAdd.additionalInfoPopup.addToCart();
		newpig.homepage.header.quickAdd.additionalInfoPopup.clickClose();

		newpig.homepage.header.goToCartPage();

		RowItemPojo row = newpig.cart.productsTable.getCartRowsInfo().get(0);

		softAssert.assertTrue(row.getProdId().contains("FLM667"));
		softAssert.assertTrue(row.getQty() == 3);
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(color));
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(length));
		softAssert.assertTrue(row.getProdConfiguredOptions().contains(style));

		softAssert.assertAll();
	}




}
