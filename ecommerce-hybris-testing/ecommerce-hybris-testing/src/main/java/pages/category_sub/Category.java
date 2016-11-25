package pages.category_sub;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Category extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

//	private By subcategorySelector = By.cssSelector(".col-xs-9.last>a");
	private By subcategoryImgSelector = By.cssSelector(".col-xs-9.last>a img");
	private By subcategoryNameSubline = By.cssSelector(".col-xs-9.last>a p");

	private By groupingCategorySelector = By.cssSelector(".col-xs-9.last>h3");

	private By subcategorySelector = By.cssSelector(".col-xs-9.last>a");

	private By leftNavTreeContainer = By.id("category-tree-accordion");
	private By leftNavGroupingCategories = By.cssSelector("#headingOne>a");

	private By breadcrumbsContainer = By.className("breadcrumb-container");
	private By heroBlock = By.cssSelector(".col-xs-9.last img");


// ---------------------------------------------  Constructor and components --------------------------------------


	public Category(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------


	public void goToRandomSubcategory(){
		List<WebElement> subCategoryLinks = driver.findElements(subcategorySelector);

		Integer index = Integer.valueOf(1+ Math.round(Math.random() * (subCategoryLinks.size()-2))+"");
		driver.get(  subCategoryLinks.get(index).getAttribute("href")    );
	}

	public void goToSubcategory(String subcategoryName){
		List<WebElement> subCategoryLinks = driver.findElements(subcategorySelector);
		for (WebElement subCategoryLink : subCategoryLinks) {

			if(getSubcategoryName(subCategoryLink).equals(subcategoryName)){
//				clickSubcategoryLink(subCategoryLink);
				clickSubcategoryNameLink(subCategoryLink);
				return;
			}
		}
		throw new ElementNotVisibleException(subcategoryName);
	}

	private String getSubcategoryName(WebElement subcategoryLink){
		String fullName = subcategoryLink.getText().trim();
		if(fullName.contains("\n")){
			return fullName.substring(0, fullName.indexOf("\n"));
		}
		return fullName;
	}

	private String getSubcategorySubline(WebElement subcategoryLink){
		String fullName = subcategoryLink.getText().trim();
		if(fullName.contains("\n")){
			return fullName.substring(fullName.indexOf("\n")+1);
		}
		return null;
	}

	private void clickSubcategoryLink(WebElement subcategoryLink){
		driver.get(subcategoryLink.getAttribute("href"));
	}

	private void clickSubcategoryNameLink(WebElement subcategoryLink){
		subcategoryLink.findElement(By.tagName("img")).click();
	}


	public boolean groupingCategoryVisible(){
		return isVisible(groupingCategorySelector);
	}

	public boolean isSubcategoryBlockComplete(){
		List<WebElement> subCategoryLinks = driver.findElements(subcategorySelector);

		boolean allGood = true;

		for (WebElement subCategoryLink : subCategoryLinks) {
			if(!subCategoryLink.findElement(By.tagName("img")).isDisplayed()){allGood = false;}
			if(!subCategoryLink.findElement(By.tagName("p")).isDisplayed()){allGood = false;}
		}
		return allGood;
	}

	public boolean isCategoryTreeVisible(){
		return isVisible(leftNavTreeContainer);
	}

	public boolean isBreadcrumbsVisible(){
		return isVisible(breadcrumbsContainer);
	}

	public boolean isHeroVisible(){
		return isVisible(heroBlock);
	}

	public boolean leftNavVsPageGroupingCategories(){
		List<String> leftNavGrC = new ArrayList<String>();
		List<String> pageGrC = new ArrayList<String>();

		for (WebElement leftNGC : driver.findElements(leftNavGroupingCategories)) {
			leftNavGrC.add(leftNGC.getText().trim().toLowerCase());
		}

		for (WebElement pageGC : driver.findElements(groupingCategorySelector)) {
			pageGrC.add(pageGC.getText().trim().replace(" -", "").toLowerCase());
		}

		System.out.println("pageGrC = " + pageGrC);
		System.out.println("leftNavGrC = " + leftNavGrC);

		boolean leftToPage = leftNavGrC.containsAll(pageGrC);
		boolean pageToLeft = pageGrC.containsAll(leftNavGrC);

		return leftToPage && pageToLeft;

	}



}
