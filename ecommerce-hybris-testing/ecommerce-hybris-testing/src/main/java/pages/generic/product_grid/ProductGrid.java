package pages.generic.product_grid;

import base.data.pojos.PricePojo;
import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by optaros on 4/15/15.
 */
public class ProductGrid extends WebPage {

	By container = null;

	String prodIDSelectTemplate = "div.product-block-row:nth-of-type(%s) div.product-block-column:nth-of-type(%s) a.product-code";
	String prodNameSelectTemplate = "div.product-block-row:nth-of-type(%s) div.product-block-column:nth-of-type(%s) .product-name a";
	String prodAttributesSelectTemplate = "div.product-block-row:nth-of-type(%s) div.product-block-column:nth-of-type(%s) span.product-attributes-wrapper";
	String prodPriceSelectTemplate = "div.product-block-row:nth-of-type(%s) div.product-block-column:nth-of-type(%s) div.product-action p";
	String prodAddToCartSelectTemplate = "div.product-block-row:nth-of-type(%s) div.product-block-column:nth-of-type(%s) div.product-action button";


	By productContainer = By.cssSelector(".product-block.block");

	By prodIDSelect= By.cssSelector(".product-code");
	By prodNameSelect = By.cssSelector(".product-name>a");
	By prodAttributesSelect = By.cssSelector(".product-attributes");

	By prodNormalPriceSelect = By.cssSelector(".normal-price");
	By prodOldPriceSelect = By.cssSelector(".crossed-out-price");
	By prodNewPriceSelect = By.cssSelector(".sale-price");

	By prodAddToCartSelect = By.cssSelector("div.product-block-row div.product-block-column div.product-action button");



	public ProductGrid(WebDriver driver, By container) {
		super(driver);
		this.container = container;
	}

	private By getBy(Integer row, Integer col, String selectorTemplate){
		return By.cssSelector(String.format(selectorTemplate, row, col));
	}

	private WebElement getElement(Integer row, Integer col, String selectorTemplate){
		waitVisible(container);
		By selector = getBy(row, col, selectorTemplate);
		return driver.findElement(container).findElement(selector);
	}



	public String getProductID(Integer row, Integer col){
		return getElement(row,col,prodIDSelectTemplate).getText().trim();
	}

	public String getProductName(Integer row, Integer col){
		return getElement(row,col,prodNameSelectTemplate).getText().trim();
	}
	public String getProductAttrib(Integer row, Integer col){
		return getElement(row,col,prodAttributesSelectTemplate).getText().trim();
	}
	public String getProductPrice(Integer row, Integer col){
		return getElement(row,col,prodPriceSelectTemplate).getText().trim();
	}


	public void clickProductID(Integer row, Integer col){
		getElement(row,col,prodIDSelectTemplate).click();
	}

	public void clickProductName(Integer row, Integer col){
		getElement(row,col,prodNameSelectTemplate).click();
	}

	public void clickAddToCart(Integer row, Integer col){
		getElement(row,col,prodAddToCartSelectTemplate).click();
	}

	public ArrayList<String> getProductNames(){
		return getTexts(prodNameSelect);
	}

	public ArrayList<ProductBlockContent> getProducts(){
		ArrayList<ProductBlockContent> products = new ArrayList<>();

		waitSeconds(1);

		List<WebElement> containers = driver.findElement(container).findElements(productContainer);


		System.out.println("containers = " + containers);

		for (WebElement prodContainer : containers) {

			ProductBlockContent productBlockContent = new ProductBlockContent();

			productBlockContent.setProductName(prodContainer.findElement(prodNameSelect).getText().trim());
			productBlockContent.setProductID(prodContainer.findElement(prodIDSelect).getText().trim());
			productBlockContent.setProductAttributes(prodContainer.findElement(prodAttributesSelect).getText().trim());


			try { productBlockContent.setNormalPrice(new PricePojo(prodContainer.findElement(prodNormalPriceSelect).getText().trim())); } catch (Exception e) {}
			try { productBlockContent.setNewPrice(new PricePojo(prodContainer.findElement(prodNewPriceSelect).getText().trim())); } catch (Exception e) {}
			try { productBlockContent.setOldPrice(new PricePojo(prodContainer.findElement(prodOldPriceSelect).getText().trim())); } catch (Exception e) {}

			products.add(productBlockContent);
		}
		return products;
	}











}
