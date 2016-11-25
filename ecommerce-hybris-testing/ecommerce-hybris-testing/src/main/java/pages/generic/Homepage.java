package pages.generic;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.generic.product_grid.ProductGrid;

public class Homepage extends NewpigGenericPage {

	
	private By addfirstFeaturedItemToCartButton = By.cssSelector("#Tabs-FeaturedItems > div > div:nth-child(1) > div:nth-child(1) > div > div > div.block-body > div > div.product-action > form > div > button");

	private By featuredItemsTabOpener = By.cssSelector("a[href=\"#Tabs-FeaturedItems\"]");
	private By barnyardItemsTabOpener = By.cssSelector("a[href=\"#Tabs-BarnyardClearance\"]");
	private By myProductsItemsTabOpener = By.cssSelector("a[href=\"#Tabs-MyProducts\"]");
	private By recentlyViewedItemsTabOpener = By.cssSelector("a[href=\"#Tabs-RecentlyViewed\"]");



	public ProductGrid featuredProductsTab = new ProductGrid(driver, By.id("Tabs-FeaturedItems"));
	public ProductGrid barnyardProductsTab = new ProductGrid(driver, By.id("Tabs-BarnyardClearance"));
	public ProductGrid myProductsTab = new ProductGrid(driver, By.id("Tabs-MyProducts"));
	public ProductGrid recentlyViewedTab = new ProductGrid(driver, By.id("Tabs-RecentlyViewed"));


	public Homepage(WebDriver driver) {
		super(driver);
	}


	public void addFeaturedProductToCart() {
		click(addfirstFeaturedItemToCartButton);
	}

	public void openFeaturedProductsTab(){
		click(featuredItemsTabOpener);
	}
	public void openBarnyardProductsTab(){
		click(barnyardItemsTabOpener);
	}

	public void openRecentlyViewedProductsTab(){
		click(recentlyViewedItemsTabOpener);
	}

	public void openMyProductsProductsTab(){
		click(myProductsItemsTabOpener);
	}

	private boolean isTabVisible(String tabName){
		if(tabName.equalsIgnoreCase("Featured Items")){
			return isVisible(featuredItemsTabOpener);
		}
		if(tabName.equalsIgnoreCase("My Products")){
			return isVisible(myProductsItemsTabOpener);
		}

		if(tabName.equalsIgnoreCase("Barnyard Clearance")){
			return isVisible(barnyardItemsTabOpener);
		}
		if(tabName.equalsIgnoreCase("Recently Viewed")){
			return isVisible(recentlyViewedItemsTabOpener);
		}
		return false;
	}

	public boolean isBarnyardTabVisible(){
		return isTabVisible("Barnyard Clearance");
	}
	public boolean isFeaturedItemsTabVisible(){
		return isTabVisible("Featured Items");
	}
	public boolean isMyProductsTabVisible(){
		return isTabVisible("My Products");
	}
	public boolean isRecentlyViewedTabVisible(){
		return isTabVisible("Recently Viewed");
	}









}
