package search_sub_category;

import base.data.PROP;
import base.utils.MyTNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

@Listeners(MyTNGListener.class)
public class CategoryTest {


	Newpig newpig;

	@BeforeMethod
	public void before() {
		newpig = new Newpig();
	}

	@AfterMethod
	public void after() {
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "Category - 279 - Catgegory page subcategory sections")
	public void TC279_subcategoryTiles() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Absorbents");
		newpig.homepage.header.navBar.clickCategoryName("PIG Absorbent Mats");

		softAssert.assertTrue(newpig.category.isSubcategoryBlockComplete());
		softAssert.assertTrue(newpig.category.groupingCategoryVisible());

		newpig.category.goToSubcategory("PIG Mat");

		softAssert.assertTrue(newpig.subCategory.getDisplayedName().equalsIgnoreCase("PIG Mat"));

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Category - 272 - Category page display")
	public void TC272_categoryDdisplay() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.navBar.expandTopCategory("Absorbents");
		newpig.homepage.header.navBar.clickCategoryName("PIG Absorbent Mats");

		softAssert.assertTrue(newpig.category.isSubcategoryBlockComplete(),"Block Complete");
		softAssert.assertTrue(newpig.category.groupingCategoryVisible(),"Grouping Category");
		softAssert.assertTrue(newpig.category.isBreadcrumbsVisible(),"Breadcrumb");
		softAssert.assertTrue(newpig.category.isHeroVisible(),"Hero Visible");
		softAssert.assertTrue(newpig.category.isCategoryTreeVisible(),"Category Tree");
		softAssert.assertTrue(newpig.category.leftNavVsPageGroupingCategories(),"Left Nav Categories");

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Barnyard - 1612 - Verify Barnyard Clearance page")
	public void TC1612_verifyBarnyardClearancePage() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.searchControls.searchFor("barnyard");

		softAssert.assertTrue(newpig.barnyard.isBreadCrumbContainerCorrectlyDisplayed(),"Breadcrumb correctly displayed");
		softAssert.assertTrue(newpig.barnyard.isFaceNavigationDisplayed(),"Facet Navigation");
		softAssert.assertTrue(newpig.barnyard.isHeaderNavigationBarDisplayed(),"Header Navigation bar");
		softAssert.assertTrue(newpig.barnyard.allProductsHaveBarnyardBadge(),"All products have bagdes");

		//!!!!!!!!!!!!!!---- Additional verifications may be inserted -----!!!!!!!!!!!!!

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "PPC - 1887 - PPC - Display")
	public void TC1887_ppcDisplay() {
		SoftAssert softAssert = new SoftAssert();

		newpig.navigatetoURL(PROP.BASE_URL.get()+"/spill-kits/c/PPCTopCategory");
		newpig.ppc.selectMobileSpillKits();

		softAssert.assertTrue(newpig.ppc.areBreadCrumbsVisible(),"Breadcrumb visible");
		softAssert.assertTrue(newpig.ppc.isCategoryBarVisible(),"Category Bar visible");
		softAssert.assertTrue(newpig.ppc.isLeftNavigationBarVisible(),"Left Nav Bar visible");
		softAssert.assertTrue(newpig.ppc.isUniversalFooterVisible(),"Universal Footer visible");
		softAssert.assertTrue(newpig.ppc.isUniversalHeaderVisible(),"Universal Header visible");
		softAssert.assertTrue(newpig.ppc.allProductsHaveDetails(),"All products have details");
		softAssert.assertTrue(newpig.ppc.allProductsHaveImages(),"All products have images");

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "PPC - 1882 - PPC - Verify Product Grid/List View")
	public void TC1882_ppcGridAndListView() {
		SoftAssert softAssert = new SoftAssert();

		newpig.navigatetoURL(PROP.BASE_URL.get()+"/spill-kits/c/PPCTopCategory");
		newpig.ppc.selectMobileSpillKits();
		softAssert.assertTrue(newpig.ppc.allProductsHaveImages(),"Grid view enabled");

		newpig.ppc.selectListView();
		softAssert.assertTrue(newpig.ppc.isListViewEnabled(),"List View Enabled");
		softAssert.assertTrue(newpig.ppc.allProductsHaveImages(),"All products have images");

		softAssert.assertAll();
	}

}
