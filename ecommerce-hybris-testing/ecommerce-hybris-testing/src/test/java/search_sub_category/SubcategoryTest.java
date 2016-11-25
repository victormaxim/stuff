package search_sub_category;

import base.utils.MyTNGListener;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;
import pages.cart.RowItemPojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(MyTNGListener.class)
public class SubcategoryTest {


	public Newpig newpig;

	@BeforeMethod
	public void before() {
		newpig = new Newpig();
	}

	@AfterMethod
	public void after() {
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "Subcategory - 1007 - Verify Sub-category Page List/Grid View")
	public void TC1007_subcategoryView() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");

		newpig.category.goToRandomSubcategory();

		softAssert.assertFalse(newpig.subCategory.isListViewActive());

		newpig.subCategory.clickViewList();
		softAssert.assertTrue(newpig.subCategory.isListViewActive());

		newpig.subCategory.clickViewGrid();
		softAssert.assertFalse(newpig.subCategory.isListViewActive());

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Subcategory - 288 - Click product block")
	public void TC288_clickProductBlock() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");

		newpig.category.goToRandomSubcategory();

		String clickedProductName = newpig.subCategory.getRndProductNameAndClickIt();

		softAssert.assertEquals(clickedProductName, newpig.pdp.getProductName());


		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Subcategory - 282 \t Subcategory page display")
	public void TC282_subcategoryDisplay() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");

		newpig.category.goToSubcategory("PIG Spill Containment Berms");

		softAssert.assertTrue(newpig.subCategory.isDisplayedCorrectly());


		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Subcategory - 285\tSubcategory page - filters")
	public void TC285_checkFilters() {

		//			285	Subcategory page - filters
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");

		newpig.category.goToSubcategory("PIG Spill Containment Berms");

		ArrayList<String> facetNames = new ArrayList<>();
		facetNames.add("Shop by Weight");
		facetNames.add("Shop by Thickness");
		facetNames.add("Shop by Sold As");
		facetNames.add("Shop by Dimensions");

		for (String facetName : facetNames) {
			softAssert.assertTrue(newpig.subCategory.isFacetPresent(facetName));
			newpig.subCategory.expandCollapsedFacet(facetName);

			String selectedFilter = StringUtils.substringBeforeLast(newpig.subCategory.selectFirstValueForFacet(facetName), " ");

			ArrayList<String> appliedFilters = newpig.subCategory.getAppliedFilters();

			softAssert.assertTrue(appliedFilters.contains(selectedFilter));

			newpig.subCategory.removeAppliedFilters();
			newpig.subCategory.waitSeconds(1);
		}


		softAssert.assertAll();

	}

	@Test(groups = {"smoke"}, description = "Subcategory - 289 - Add to cart")
	public void TC289_addToCart() {

		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Absorbents");
		newpig.homepage.header.navBar.clickCategoryName("PIG Absorbent Mats");

		newpig.category.goToSubcategory("PIG Mat");

		String addedProductName = newpig.subCategory.getProductNameAndAddItToCart(2);

		softAssert.assertTrue(newpig.homepage.header.isAddedToCartMessageVisible());


		newpig.subCategory.header.goToCartPage();

		List<RowItemPojo> productsInCart = newpig.cart.productsTable.getCartRowsInfo();

		boolean isOK = false;

		for (RowItemPojo rowItemPojo : productsInCart) {
			if(rowItemPojo.getProdName().equals(addedProductName))
				isOK = true;
		}
		softAssert.assertTrue(isOK);

		softAssert.assertAll();
	}



	@Test(groups = {"smoke"}, description = "Subcategory - 1097 \\t Verify Sub-category Page Sort and Filter")
	public void TC1097_sort() {

		//			1097 \t Verify Sub-category Page Sort and Filter
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Spill Containment");
		newpig.homepage.header.navBar.clickCategoryName("Portable & Collapsible Spill Containment");

		newpig.category.goToRandomSubcategory();


		newpig.subCategory.selectSortOrder("Name (ascending)");
		softAssert.assertTrue(isProductListSorted(newpig.subCategory.getListedProductNames(), false));

		newpig.subCategory.waitSeconds(2);

		newpig.subCategory.selectSortOrder("Name (descending)");
		softAssert.assertTrue(isProductListSorted(newpig.subCategory.getListedProductNames(), true));


		softAssert.assertFalse(newpig.subCategory.isListViewActive());

		newpig.subCategory.clickViewList();
		softAssert.assertTrue(newpig.subCategory.isListViewActive());


		newpig.subCategory.selectSortOrder("Name (ascending)");
		ArrayList<String> productNames = newpig.subCategory.getListedProductNames();
		softAssert.assertTrue(isProductListSorted(newpig.subCategory.getListedProductNames(), false));


		newpig.subCategory.waitSeconds(2);

		newpig.subCategory.selectSortOrder("Name (descending)");
		softAssert.assertTrue(isProductListSorted(newpig.subCategory.getListedProductNames(), true));


		softAssert.assertAll();
	}

	private boolean isProductListSorted(ArrayList<String> productNames, Boolean descending){
		List<String> temp = new ArrayList<String>(productNames);
		Collections.sort(temp);

		if(descending){ Collections.reverse(temp); }


		for (int i = 0; i < productNames.size(); i++) {
			if(!productNames.get(i).equals(temp.get(i))){
				return false;
			}
		}
		return true;
	}



}
