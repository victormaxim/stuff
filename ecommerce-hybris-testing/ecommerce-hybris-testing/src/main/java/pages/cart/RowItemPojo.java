package pages.cart;

import base.data.pojos.PricePojo;

/**
 * Created by optaros on 4/3/15.
 */
public class RowItemPojo {

	private String prodId;
	private String prodName;
	private String prodAttributes;

	private String prodConfiguredOptions;

	private Integer qty;

	private PricePojo itemNormalPrice;
	private PricePojo itemOldPrice;
	private PricePojo itemNewPrice;

	private String prodShipFrequency;

	private PricePojo rowTotalNormalPrice;
	private PricePojo rowTotalOldPrice;
	private PricePojo rowTotalNewPrice;


	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdAttributes() {
		return prodAttributes;
	}

	public void setProdAttributes(String prodAttributes) {
		this.prodAttributes = prodAttributes;
	}

	public String getProdConfiguredOptions() {
		return prodConfiguredOptions;
	}

	public void setProdConfiguredOptions(String prodConfiguredOptions) {
		this.prodConfiguredOptions = prodConfiguredOptions;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public PricePojo getItemNormalPrice() {
		return itemNormalPrice;
	}

	public void setItemNormalPrice(PricePojo itemNormalPrice) {
		this.itemNormalPrice = itemNormalPrice;
	}

	public void setItemNormalPrice(String priceString) {
		this.itemNormalPrice = new PricePojo(priceString);
	}

	public PricePojo getItemOldPrice() {
		return itemOldPrice;
	}

	public void setItemOldPrice(PricePojo itemOldPrice) {
		this.itemOldPrice = itemOldPrice;
	}

	public void setItemOldPrice(String priceString) {
		this.itemOldPrice = new PricePojo(priceString);
	}

	public PricePojo getItemNewPrice() {
		return itemNewPrice;
	}

	public void setItemNewPrice(PricePojo itemNewPrice) {
		this.itemNewPrice = itemNewPrice;
	}

	public void setItemNewPrice(String priceString) {
		this.itemNewPrice = new PricePojo(priceString);
	}

	public String getProdShipFrequency() {
		return prodShipFrequency;
	}

	public void setProdShipFrequency(String prodShipFrequency) {
		this.prodShipFrequency = prodShipFrequency;
	}

	public PricePojo getRowTotalNormalPrice() {
		return rowTotalNormalPrice;
	}

	public void setRowTotalNormalPrice(PricePojo rowTotalNormalPrice) {
		this.rowTotalNormalPrice = rowTotalNormalPrice;
	}

	public void setRowTotalNormalPrice(String priceString) {
		this.rowTotalNormalPrice = new PricePojo(priceString);
	}

	public PricePojo getRowTotalOldPrice() {
		return rowTotalOldPrice;
	}

	public void setRowTotalOldPrice(PricePojo rowTotalOldPrice) {
		this.rowTotalOldPrice = rowTotalOldPrice;
	}

	public void setRowTotalOldPrice(String priceString) {
		this.rowTotalOldPrice = new PricePojo(priceString);
	}

	public PricePojo getRowTotalNewPrice() {
		return rowTotalNewPrice;
	}

	public void setRowTotalNewPrice(PricePojo rowTotalNewPrice) {
		this.rowTotalNewPrice = rowTotalNewPrice;
	}

	public void setRowTotalNewPrice(String priceString) {
		this.rowTotalNewPrice = new PricePojo(priceString);
	}

	@Override
	public String toString() {
		return "RowItemPojo{" +
				"prodId='" + prodId + '\'' +
				", prodName='" + prodName + '\'' +
				", prodAttributes='" + prodAttributes + '\'' +
				", prodConfiguredOptions='" + prodConfiguredOptions + '\'' +
				", qty=" + qty +
				", itemNormalPrice=" + itemNormalPrice +
				", itemOldPrice=" + itemOldPrice +
				", itemNewPrice=" + itemNewPrice +
				", prodShipFrequency='" + prodShipFrequency + '\'' +
				", rowTotalNormalPrice=" + rowTotalNormalPrice +
				", rowTotalOldPrice=" + rowTotalOldPrice +
				", rowTotalNewPrice=" + rowTotalNewPrice +
				'}';
	}
}