package pages.category_sub;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;


public class Search extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By breadcrumbs = By.cssSelector(".breadcrumb.pull-left");
	private By totalResults = By.cssSelector(".pagination-bar.top.clearfix .total-results");
	private By leftNavMarketingBlock = By.cssSelector(".yCmsComponent.section4.cms_disp-img_slot>a>img");

	private By productImage = By.cssSelector(".product-block-grid-container .product-image>a>img");
	private By productCode = By.cssSelector(".product-block-grid-container .product-code");
	private By productName = By.cssSelector(".product-block-grid-container .product-name>a");
	private By productAttributes = By.cssSelector(".product-block-grid-container .product-attributes");
	private By productPrice = By.cssSelector(".product-block-grid-container .product-price");
	private By productAddToCartBtn = By.cssSelector(".product-block-grid-container .add-to-cart-mini");



	private By sortOption = By.cssSelector("#sort_form1 .dropdown-menu>li");
	private By sortExpandButton = By.cssSelector("#sort_form1 .btn-group.select");

//  --------------- Filters
	private By facetContainerSelector = By.cssSelector("#filter-block-accordion .panel");
	private String facetTitleSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a.panel-title";
	private String facetExpanderSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a>span";
	private String showMoreLnkSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>a.show-more";
	private String filterSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>ul:nth-child(1) li:nth-of-type(1) input[type=checkbox]";
	private String filterLabelSelectorTemplate = "#filter-block-accordion .panel:nth-of-type(%s)>div>ul:nth-child(1) li:nth-of-type(1) span.css-input-label";

	private By appliedFilters = By.cssSelector(".remove_item_left_name");
	private By clearAllAppliedFilters = By.cssSelector(".clear-all.list-group-item");


//	--------------- NoResults specific selectors

	private By spellingSuggestionText = By.cssSelector(".search-spelling-suggestion-prompt");
	private By spellingSuggestionTerm = By.cssSelector(".search-spelling-suggestion-prompt>a");

	private By supportChatButton = By.cssSelector(".btn.btn-secondary.liveChat");
	private By supportPhoneButton = By.cssSelector(".btn.btn-secondary.phone");


	private By alternateSeachBox = By.cssSelector("div.empty-search-suggestion div.siteSearch form div.search-input-container div.controls input#search.form-control.siteSearchInput.ui-autocomplete-input");


	private By customerFavoritesContainer = By.cssSelector(".yCmsContentSlot.customer-favorites.product-block-grid-container.panel.panel-default");



// ---------------------------------------------  Constructor and components --------------------------------------


	public Search(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

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

	public void changeSortOrder(String optionName){
		click(sortExpandButton);
		for (WebElement option : driver.findElements(sortOption)) {
			if(option.getText().trim().equalsIgnoreCase(optionName)){
				option.click();
				break;
			}
		}
	}

	public boolean isLoadedCorrectly(){
		boolean flag = true;

		flag = flag && isVisible(breadcrumbs);
		flag = flag && isVisible(totalResults);
		flag = flag && isVisible(leftNavMarketingBlock);

		Integer productImages = driver.findElements(productImage).size();
		Integer productCodes = driver.findElements(productCode).size();
		Integer productNames = driver.findElements(productName).size();
		Integer productAttrs = driver.findElements(productAttributes).size();
		Integer productPrices = driver.findElements(productPrice).size();
		Integer productAddToCartBtns = driver.findElements(productAddToCartBtn).size();

		flag = flag && (productImages == productCodes) &&(productImages == productNames) &&(productImages == productAttrs) &&
				(productImages == productPrices) && (productImages == productAddToCartBtns);

		return flag;
	}

	public boolean noResultsPageLoadedCorrectly(){
		boolean flag = true;

		flag = flag && isVisible(breadcrumbs);

//		flag = flag && isVisible(leftNavMarketingBlock);
		flag = flag && (messageArea.getWarningMessages().size()>0);

		//flag = flag && isVisible(spellingSuggestionText);
		flag = flag && isVisible(supportChatButton);
		flag = flag && isVisible(supportPhoneButton);
		flag = flag && isVisible(alternateSeachBox);
		flag = flag && isVisible(customerFavoritesContainer);

		Integer productImages = driver.findElements(productImage).size();
		Integer productCodes = driver.findElements(productCode).size();
		Integer productNames = driver.findElements(productName).size();
		Integer productAttrs = driver.findElements(productAttributes).size();
		Integer productPrices = driver.findElements(productPrice).size();
		Integer productAddToCartBtns = driver.findElements(productAddToCartBtn).size();

		flag = flag && (productImages == productCodes) &&(productImages == productNames) &&(productImages == productAttrs) &&
				(productImages == productPrices) && (productImages == productAddToCartBtns) && (productImages >0);
//		flag = flag && getAttributeValue(spellingSuggestionTerm, "href").contains("/search");

		return flag;
	}


}
