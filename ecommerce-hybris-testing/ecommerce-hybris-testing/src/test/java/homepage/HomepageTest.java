package homepage;

import base.data.TestDataReader;
import base.utils.MyTNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;
import pages.generic.product_grid.ProductBlockContent;

import java.util.ArrayList;

@Listeners(MyTNGListener.class)
public class HomepageTest {


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


	private boolean checkBarnyardProducts() {
		ArrayList<ProductBlockContent> displayedProducts = newpig.homepage.barnyardProductsTab.getProducts();
		boolean toreturn = true;

		for (ProductBlockContent displayedProduct : displayedProducts) {

			toreturn = toreturn && (displayedProduct.getNewPrice() != null);
			toreturn = toreturn && (displayedProduct.getOldPrice() != null);
			toreturn = toreturn && (displayedProduct.getNormalPrice() == null);
		}
		return toreturn;
	}

	@Test(groups = {"smoke"}, description = "Homepage - 716 \tVerify Barnyard Product Tab for US segment user")
	public void TC716_verfyUSBarnyardTab() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("==========================FAILING bug ER-3045=================================");
		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("us_2"));
		newpig.homepage.openBarnyardProductsTab();
		softAssert.assertTrue(checkBarnyardProducts());
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Homepage - 717 \t Verify Barnyard Product Tab for FED segment user")
	public void TC717_verfyFEDBarnyardTab() {
		SoftAssert softAssert = new SoftAssert();
		System.out.println("==========================FAILING bug ER-3045=================================");
		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("fed_2"));
		newpig.homepage.openBarnyardProductsTab();
		softAssert.assertTrue(checkBarnyardProducts());
		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Homepage - 718 \tVerify Barnyard Product Tab for CA segment user")
	public void TC718_verfyCABarnyardTab() {
		SoftAssert softAssert = new SoftAssert();
//		718 	Verify Barnyard Product Tab for CA segment user


		softAssert.assertTrue(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertFalse(newpig.homepage.isMyProductsTabVisible());

		newpig.homepage.header.changeSegmentTo("Canada");

		softAssert.assertFalse(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertFalse(newpig.homepage.isMyProductsTabVisible());

		newpig.homepage.header.changeSegmentTo("US Corporate");

		softAssert.assertTrue(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertFalse(newpig.homepage.isMyProductsTabVisible());


		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("ca_2"));

		softAssert.assertFalse(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertTrue(newpig.homepage.isMyProductsTabVisible());


		softAssert.assertFalse(newpig.homepage.isBarnyardTabVisible());

		softAssert.assertAll();
	}

	private metoda()

	@Test(groups = {"smoke"}, description = "Homepage - 731 \t Verify Recently Viewed tab (middle) signed in user on website")
	public void TC731_verfyRecentlyViewedTab() {

		SoftAssert softAssert = new SoftAssert();
		System.out.println("==========================FAILING bug ER-5341=================================");
//			731 \t Verify Recently Viewed tab (middle) signed in user on website

		softAssert.assertTrue(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertFalse(newpig.homepage.isMyProductsTabVisible());
		softAssert.assertFalse(newpig.homepage.isRecentlyViewedTabVisible());

		newpig.homepage.header.expandQuickAdd();
		newpig.homepage.header.quickAdd.fillFirstProduct("404", 2);
		newpig.homepage.header.quickAdd.addToCart();

		newpig.pdp.header.goToCartPage();
		newpig.cart.productsTable.clickProductName(1);

		newpig.pdp.header.clickLogo();

		softAssert.assertTrue(newpig.homepage.isBarnyardTabVisible());
		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertFalse(newpig.homepage.isMyProductsTabVisible());
		softAssert.assertTrue(newpig.homepage.isRecentlyViewedTabVisible());

		newpig.homepage.openRecentlyViewedProductsTab();
		softAssert.assertTrue(newpig.homepage.recentlyViewedTab.getProducts().get(0).getProductID().equalsIgnoreCase("404"));

		newpig.homepage.header.headerPopupLogin(testDataReader.getRndUser());


		softAssert.assertTrue(newpig.homepage.isFeaturedItemsTabVisible());
		softAssert.assertTrue(newpig.homepage.isMyProductsTabVisible());
		softAssert.assertTrue(newpig.homepage.isRecentlyViewedTabVisible());

				newpig.homepage.openRecentlyViewedProductsTab();
		softAssert.assertTrue(newpig.homepage.recentlyViewedTab.getProducts().get(0).getProductID().equalsIgnoreCase("404"));


		softAssert.assertAll();
	}


}
