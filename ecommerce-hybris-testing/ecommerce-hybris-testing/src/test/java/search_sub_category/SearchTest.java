package search_sub_category;

import base.utils.MyTNGListener;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

import java.util.ArrayList;

@Listeners(MyTNGListener.class)
public class SearchTest {


	Newpig newpig;

	@BeforeMethod
	public void before() {
		newpig = new Newpig();
	}

	@AfterMethod
	public void after() {
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "Search - 1815\tVerify Search Results Facets")
	public void TC1815_searchResultsFacets() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.searchControls.searchFor("test");

		ArrayList<String> facetNames = new ArrayList<>();
		facetNames.add("Shop by Size");
		facetNames.add("Shop by Color");
		facetNames.add("Shop by Type");
		facetNames.add("Shop by Absorbency");

		for (String facetName : facetNames) {

			softAssert.assertTrue(newpig.search.isFacetPresent(facetName));
			newpig.search.expandCollapsedFacet(facetName);

			String selectedFilter = StringUtils.substringBeforeLast(newpig.search.selectFirstValueForFacet(facetName), " ");

			ArrayList<String> appliedFilters = newpig.search.getAppliedFilters();

			softAssert.assertTrue(appliedFilters.contains(selectedFilter));

			newpig.search.removeAppliedFilters();
			newpig.search.waitSeconds(1);
		}

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Search - 18XX\tVerify Search Results Page")
	public void TC18XX_searchResultsPage() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.searchControls.searchFor("test");
		newpig.search.changeSortOrder("Best Seller");
		softAssert.assertTrue(newpig.search.isLoadedCorrectly());

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Search - 1816\tVerify Search NO Results Facets")
	public void TC1816_searchNoResultsPage() {
		SoftAssert softAssert = new SoftAssert();
		newpig.homepage.header.searchControls.searchFor("lkfd;");
		softAssert.assertTrue(newpig.search.noResultsPageLoadedCorrectly());
		softAssert.assertAll();
	}

}
