package incercari;

import org.testng.annotations.Test;

public class TestMare {
	 searchPage searchPage;
	 resultsPage resultsPage;
	            
	    @Test
	    public void TestMare() {
	  //      searchPage.open();
	        searchPage.searchFor("cats");
	    //    resultsPage.shouldDisplayTitlesWith("cats");
	    }
}
