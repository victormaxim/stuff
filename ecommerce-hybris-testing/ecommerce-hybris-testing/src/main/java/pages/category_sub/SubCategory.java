package pages.category_sub;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SubCategory extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By subcategoryDisplayedName = By.cssSelector(".col-xs-9>header>h1");

//	-------------- others
	private By breadCrumbs = By.cssSelector(".breadcrumb.pull-left");
	private By heroBlock = By.cssSelector("#HERO_BLOCK_MISSING");
	private By categoryTree = By.cssSelector(".category-tree.panel");
	private By noOfProducts = By.cssSelector(".total-results");

//	----------- List/Grid view selectors
	private By gridButtonSelector = By.cssSelector("div#page div.container.body-container div.row section.col-xs-9 div.pagination-bar.top.clearfix div.view-type a:nth-of-type(1)");
	private By listButtonSelector = By.cssSelector("div#page div.container.body-container div.row section.col-xs-9 div.pagination-bar.top.clearfix div.view-type a:nth-of-type(2)");


//	----------------- Sort select selectors
	private By sortSelectExpanderButton = By.cssSelector("#sort_form1 .btn.btn-default.dropdown-toggle");
	private By sortSelectedOption = By.cssSelector("#sort_form1 .btn.btn-default.dropdown-toggle span.selected-option");
	private By sortSelectOption = By.cssSelector("#sort_form1 .dropdown-menu>li");


//	----------- product Block selectors
	private By listProductBlockContainer = By.cssSelector(".product-block.list");
	private By gridProductBlockContainer = By.cssSelector(".product-block.block");


	private By productNameSelector = By.cssSelector("section.col-xs-9 .product-name>a");
	private By addToCartSelector = By.cssSelector("section.col-xs-9 .add-to-cart-mini");


//	  --------------- Filters
	private By facetContainerSelector = By.cssSelector("#filter-block-accordion .panel");
	private String facetTitleSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a.panel-title";
	private String facetExpanderSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a>span";
	private String showMoreLnkSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a.show-more";
	private String filterSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>ul:nth-child(1) li:nth-of-type(1) input[type=checkbox]";
	private String filterLabelSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>ul:nth-child(1) li:nth-of-type(1) span.css-input-label";

	private By appliedFilters = By.cssSelector(".remove_item_left_name");
	private By clearAllAppliedFilters = By.cssSelector(".clear-all.list-group-item");




// ---------------------------------------------  Constructor and components --------------------------------------


	public SubCategory(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public String getDisplayedName(){
		return getText(subcategoryDisplayedName);
	}

	public void clickViewGrid(){
		click(gridButtonSelector);
	}
	public void clickViewList(){
		click(listButtonSelector);
	}

	public boolean isListViewActive(){
		List<WebElement> listProducts = new ArrayList<WebElement>();
		List<WebElement> gridProducts = new ArrayList<WebElement>();

		try { listProducts = driver.findElements(listProductBlockContainer); } catch (Exception e) {}
		try { gridProducts = driver.findElements(gridProductBlockContainer);  } catch (Exception e) {}

		if((listProducts.size()>0) && (gridProducts.size() == 0)){
			return true;
		}else if((listProducts.size()==0) && (gridProducts.size() > 0)){
			return false;
		}
		else{
			return false;
		}
	}

	public String getProductNameAndClickIt(Integer index){

		List<WebElement> productNames = driver.findElements(productNameSelector);
		String prodName = productNames.get(index).getText().trim();

		productNames.get(index).click();
		return prodName;

	}

	public String getRndProductNameAndClickIt(){

		List<WebElement> productNames = driver.findElements(productNameSelector);

		Random rnd = new Random();
		Integer index = rnd.nextInt(productNames.size()-2)+1;

		String prodName = productNames.get(index).getText().trim();
		productNames.get(index).click();

		return prodName;

	}

	public String getRndProductNameAndAddItToCart(){

		List<WebElement> addToCartButtons = driver.findElements(addToCartSelector);

		Integer index = Integer.valueOf(1 + Math.round(Math.random() * (addToCartButtons.size() - 2)) + "");

		String prodName = driver.findElements(productNameSelector).get(index).getText().trim();

		addToCartButtons.get(index).click();

		return prodName;

	}


	public String getProductNameAndAddItToCart(Integer index){

		List<WebElement> addToCartButtons = driver.findElements(addToCartSelector);

		String prodName = driver.findElements(productNameSelector).get(index).getText().trim();

		addToCartButtons.get(index).click();

		return prodName;

	}

	public void selectSortOrder(String selectOption){
		click(sortSelectExpanderButton);

		for (WebElement sortOption : driver.findElements(sortSelectOption)) {
			if(sortOption.getText().trim().equalsIgnoreCase(selectOption)){
				sortOption.click();
				break;
			}
		}

	}

	public String getSelectedSortOrder(){
		return getText(sortSelectedOption);
	}

	public ArrayList<String> getListedProductNames(){
		return getTexts(productNameSelector);
	}

// ------ Filterssssss

	private Integer getFacetListSize(){
		return driver.findElements(facetContainerSelector).size();
	}

	private Integer getFacetIndex(String facetName){
		Integer size = getFacetListSize();
		Integer facetIndex = 0;

		for (int i = 1; i <= getFacetListSize(); i++) {
			String selectorText = String.format(facetTitleSelectorTemplate, i);
			By selector = By.cssSelector(selectorText);
			String title = getText(selector);
			if(title.equalsIgnoreCase(facetName)){
				return i;
			}
		}
		return null;
	}

	public boolean isFacetCollapsed(String facetName){
		Integer index = getFacetIndex(facetName);
		By selector = By.cssSelector(String.format(facetTitleSelectorTemplate, index));
		String className = driver.findElement(selector).getAttribute("class");
		return className.contains("collapsed");
	}

	public void expandCollapsedFacet(String facetName){
		if(isFacetCollapsed(facetName)){
			Integer index = getFacetIndex(facetName);
			By selector = By.cssSelector(String.format(facetExpanderSelectorTemplate, index));
			click(selector);
		}
	}

	public boolean isFacetPresent(String facetName){
		return getFacetIndex(facetName) != null;
	}

	public String selectFirstValueForFacet(String facetName){
		Integer index = getFacetIndex(facetName);
		expandCollapsedFacet(facetName);


		By labelSelector = By.cssSelector(String.format(filterLabelSelectorTemplate, index));
		String label = getText(labelSelector);

		String checkboxSelector = String.format(filterSelectorTemplate, index);
		String jsToExecute = "$('"+checkboxSelector+"').trigger('click');";
		executeJavascript(jsToExecute);

		return label;

	}

	public ArrayList<String> getAppliedFilters(){
		return getTexts(appliedFilters);
	}

	public void removeAppliedFilters(){
		click(clearAllAppliedFilters);
	}

	public boolean isDisplayedCorrectly(){
		boolean isDisplayed = true;

		isDisplayed = isDisplayed && isVisible(breadCrumbs);
		isDisplayed = isDisplayed && isVisible(subcategoryDisplayedName);
		isDisplayed = isDisplayed && isVisible(noOfProducts);
		isDisplayed = isDisplayed && isVisible(facetContainerSelector);
		isDisplayed = isDisplayed && isVisible(categoryTree);
		isDisplayed = isDisplayed && isVisible(gridButtonSelector);
		isDisplayed = isDisplayed && isVisible(listButtonSelector);
		isDisplayed = isDisplayed && isVisible(gridProductBlockContainer);

//		isDisplayed = isDisplayed && isVisible(heroBlock);

		return isDisplayed;
	}

	public void selectProductById(String id){
		By selector = By.cssSelector(".product-code" + "[title=\'" + id + "\'" + "]");
		click(selector);

	}

}