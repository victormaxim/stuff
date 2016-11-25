package pages.ppc;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class PPC extends NewpigGenericPage{
	


// --------------------------------------------- Selectors -------------------------------------------------------
	
	private By breadcrumbs = By.cssSelector(".breadcrumb");
	private By leftNavigationBar = By.cssSelector(".facetNavigation");
	private By mobileSpillKits = By.cssSelector("a[href*='c/PPC']:nth-of-type(5) div img");
	private By universalHeader = By.cssSelector("#header");
	private By categoryBar = By.cssSelector("#navbar");
	private By universalFooter = By.cssSelector(".footer-container");
	private By productBlocks = By.cssSelector(".product-block");
	private By productImages = By.cssSelector(".product-block img");
	private By productDetails = By.cssSelector(".product-block .product-information");
	private By listView = By.cssSelector("a[title=List]");
	private By productsList = By.cssSelector("#resultsList");

// --------------------------------------------- Constructor and components --------------------------------------
	
	
	public PPC(WebDriver driver) {
		super(driver);
	}
	
// --------------------------------------------- Functionality ---------------------------------------------------
	
	
	public void selectMobileSpillKits(){
		click( mobileSpillKits);
	}

	public boolean areBreadCrumbsVisible(){
		return isVisible(breadcrumbs);
	}

	public boolean isLeftNavigationBarVisible(){
		return isVisible(leftNavigationBar);
	}

	public boolean isUniversalHeaderVisible(){
		return isVisible(universalHeader);
	}

	public boolean isUniversalFooterVisible(){
		return isVisible(universalFooter);
	}

	public boolean isCategoryBarVisible(){
		return isVisible(categoryBar);
	}

	public boolean isProductsGridVisible(){
		return isVisible(productBlocks);
	}

	public boolean allProductsHaveImages(){
		List<WebElement> blocks = driver.findElements(productBlocks);
		List<WebElement> images = driver.findElements(productImages);
		if (blocks.size() != images.size()){
			log.error("Not all products on page have images");
			return false;
		}
		return true;
	}

	public boolean allProductsHaveDetails(){
		List<WebElement> blocks = driver.findElements(productBlocks);
		List<WebElement> details = driver.findElements(productDetails);
		if (blocks.size() != details.size()){
			log.error("Not all products on page have details");
			return false;
		}
		return true;
	}

	public void selectListView(){
		click(listView);
	}

	public boolean isListViewEnabled(){
		return isVisible(productsList);
	}


}