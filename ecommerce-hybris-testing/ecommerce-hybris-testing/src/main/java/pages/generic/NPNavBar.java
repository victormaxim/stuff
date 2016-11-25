package pages.generic;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NPNavBar extends WebPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private String topLevelCategoryLinkPattern = "#navbar > ul > li.dropdown.nav-item:nth-of-type(%s) > a";
	private String categoryLinkPattern = "#navbar > ul > li.dropdown.nav-item.open > ul > li.submenu-link > ul > li:nth-child(%s) > a";


// ---------------------------------------------  Constructor and components --------------------------------------


	public NPNavBar(WebDriver driver) {
		super(driver);
	}




// ---------------------------------------------  Functionality ---------------------------------------------------


	public By getTopCategorySelector(String topCategoryName){
		for (int i = 1; i < 8; i++) {
			By selector = By.cssSelector(String.format(topLevelCategoryLinkPattern, i));
			if(getText(selector).equals(topCategoryName)){
				return selector;
			}
		}
		return null;
	}


	public void expandTopCategory(String topCategoryName){
		click(getTopCategorySelector(topCategoryName));
	}


	public void clickCategoryName(String categoryName){
		click(getCategorySelector(categoryName));
	}

	private By getCategorySelector(String categoryName) {
		for (int i = 1; i < 8; i++) {
			By selector = By.cssSelector(String.format(categoryLinkPattern, i));
			if (getText(selector) == null){
				return null;
			}
			if(getText(selector).equals(categoryName)){
				return selector;
			}
		}
		return null;
	}


}
