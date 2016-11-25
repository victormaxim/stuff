package pages.cart;


import base.web.WebPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsTable extends WebPage{

	private By rowItemSelector = By.cssSelector("div.cart-item-inner");
	private By cartTable = By.cssSelector(".cart-table");

	private By prodIdLink = By.cssSelector("div.item-details a.item-code");
	private By prodNameLink = By.cssSelector("div.item-details a.item-name");
	private By prodAttributesDiv = By.cssSelector("div.item-attr");

	private By prodConfigOptions = By.cssSelector("div.item-details>span>strong");


	private By prodQtyInput = By.cssSelector("input.qty");
	private By updateQtyLink = By.cssSelector("a.updateQuantityProduct");
	private By removeProductLink = By.cssSelector("a.submitRemoveProduct");

	private By prodNormalPriceText = By.cssSelector("div.item-unit-price p.actual-price");
	private By prodOldPriceText = By.cssSelector("div.item-unit-price p.old-price");
	private By prodNewPriceText = By.cssSelector("div.item-unit-price p.new-price");

	private By prodFrequencyCurrentValue = By.cssSelector(".btn.btn-default.dropdown-toggle span:nth-of-type(1)");
	private By prodFrequencyExpandButton = By.cssSelector(".btn.btn-default.dropdown-toggle");
	private String frequencyOptionTemplate = ".dropdown-menu>li:nth-of-type(%s)";

	private By rowTotalNormalPriceText = By.cssSelector("div.item-total p.actual-price");
	private By rowTotalOldPriceText = By.cssSelector("div.item-total p.old-price");
	private By rowTotalNewPriceText = By.cssSelector("div.item-total p.new-price");


	public ProductsTable(WebDriver driver) {
		super(driver);
	}

	public ArrayList<RowItemPojo> getCartRowsInfo() {

		waitSeconds(1);
		waitPresent(rowItemSelector);

		ArrayList<RowItemPojo> items = new ArrayList<RowItemPojo>();

		List<WebElement> rows = driver.findElements(rowItemSelector);

		for (int i = 0; i < rows.size(); i++){
			items.add(extractInfo(rows.get(i)));
		}
		return items;
	}

	private RowItemPojo extractInfo(WebElement row) {

		waitPresent(rowItemSelector);

		RowItemPojo item = new RowItemPojo();

		item.setProdId(row.findElement(prodIdLink).getText().trim());
		item.setProdName(row.findElement(prodNameLink).getText().trim());
		item.setProdAttributes(row.findElement(prodAttributesDiv).getText().trim());

		item.setQty(Integer.valueOf(row.findElement(prodQtyInput).getAttribute("value").trim()));

		try {	item.setItemNormalPrice(row.findElement(prodNormalPriceText).getText().trim());	} catch (Exception e) {}
		try {	item.setItemOldPrice(row.findElement(prodOldPriceText).getText().trim());	} catch (Exception e) {}
		try {	item.setItemNewPrice(row.findElement(prodNewPriceText).getText().trim());	} catch (Exception e) {}

		try {	item.setRowTotalNormalPrice(row.findElement(rowTotalNormalPriceText).getText().trim());	} catch (Exception e) {}
		try {	item.setRowTotalNewPrice(row.findElement(rowTotalNewPriceText).getText().trim());	} catch (Exception e) {}
		try {	item.setRowTotalOldPrice(row.findElement(rowTotalOldPriceText).getText().trim());	} catch (Exception e) {}

		try{
//			item.setProdConfiguredOptions(StringUtils.join(getTexts(prodConfigOptions)));
			System.out.println("entered config options try");
			StringBuffer configOptionsString = new StringBuffer();
			for (WebElement configOption : row.findElements(prodConfigOptions)) {
				configOptionsString.append(configOption.getText().trim());
				configOptionsString.append(", ");
			}
			System.out.println("configOptionsString = " + configOptionsString);
			item.setProdConfiguredOptions(StringUtils.substringBeforeLast(configOptionsString.toString(), ","));
		}catch(Exception e){
			System.out.println("entered config options catch ERR");
		}

		item.setProdShipFrequency(row.findElement(prodFrequencyCurrentValue).getText().trim());

		return item;
	}

	public void setProductQtyTo(Integer qty, Integer rowIndex){
		WebElement row = driver.findElements(rowItemSelector).get(rowIndex-1);

		WebElement qtyInput = row.findElement(prodQtyInput);
		qtyInput.clear();
		qtyInput.sendKeys(qty.toString());

		row.findElement(updateQtyLink).click();
	}

	public void removeProduct(Integer rowIndex){
		WebElement row = driver.findElements(rowItemSelector).get(rowIndex - 1);
		row.findElement(removeProductLink).click();
	}

	public Integer countProductRows(){
		List<WebElement> rows = driver.findElements(rowItemSelector);
		return rows.size();
	}

	public void clickProductName(Integer index){
		driver.findElements(prodNameLink).get(index-1).click();
	}

	/**
	 * @param code
	 * @return true if cart contains an item with the give code as parameter
	 */
	public boolean containsItemWithCode(String code){
		return getText(cartTable).contains(code);
	}

}
