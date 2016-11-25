package pages.generic.product_grid;

import base.data.pojos.PricePojo;

/**
 * Created by optaros on 6/22/15.
 */
public class ProductBlockContent {

	String productID;
	String productName;
	String productAttributes;

	PricePojo normalPrice;
	PricePojo oldPrice;
	PricePojo newPrice;



	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(String productAttributes) {
		this.productAttributes = productAttributes;
	}

	public PricePojo getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(PricePojo normalPrice) {
		this.normalPrice = normalPrice;
	}

	public PricePojo getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(PricePojo oldPrice) {
		this.oldPrice = oldPrice;
	}

	public PricePojo getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(PricePojo newPrice) {
		this.newPrice = newPrice;
	}

	@Override
	public String toString() {
		return "ProductBlockContent{" +
				"productID='" + productID + '\'' +
				", productName='" + productName + '\'' +
				", productAttributes='" + productAttributes + '\'' +
				", normalPrice=" + normalPrice +
				", oldPrice=" + oldPrice +
				", newPrice=" + newPrice +
				'}';
	}
}
