package pages.barnyard;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Barnyard extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

	private By headerNavigationBar = By.cssSelector(".navbar-default");
	private By faceNavigation = By.cssSelector(".facetNavigation .category-tree");
	private By breadCrumbContainer = By.cssSelector(".breadcrumb-container");
	private By barnyardBadge = By.cssSelector(".barnyard-flag");
	private By productBlocks = By.cssSelector("product-block");


// ---------------------------------------------  Constructor and components --------------------------------------

	public Barnyard(WebDriver driver) {
		super(driver);
	}

// ---------------------------------------------  Functionality ---------------------------------------------------

	public boolean isHeaderNavigationBarDisplayed(){
		return isVisible(headerNavigationBar);
	}

	public boolean isFaceNavigationDisplayed(){
		return isVisible(faceNavigation);
	}

	public boolean isBreadCrumbContainerCorrectlyDisplayed(){
		return getText(breadCrumbContainer).contains("Barnyard Clearance");
	}

	public boolean allProductsHaveBarnyardBadge(){
		List<WebElement> blocks = driver.findElements(productBlocks);
		for (WebElement productBlock : blocks) {
			if (productBlock.findElement(barnyardBadge)==null){
				log.error("Product with no Barnyard badge displayed:\n" +productBlock.getText());
				return false;
			}
		}
		return true;
	}


}