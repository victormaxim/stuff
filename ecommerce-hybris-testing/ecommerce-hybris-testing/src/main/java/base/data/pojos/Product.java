package base.data.pojos;

/**
 * Created by optaros on 5/31/15.
 */
public class Product {

	private String itemNumber;
	private String productName;

	private Boolean colorSelect = false;
	private Boolean styleWithImageSelect = false;
	private Boolean styleSelect = false;
	private Boolean sizeSelect = false;
	private Boolean lengthSelect = false;

	private Boolean discontinuedNoReplace = false;
	private Boolean discontinuedWReplace = false;
	private Boolean callForQuote = false;
	private Boolean sampleProduct = false;
	private Boolean requiredAccesories = false;
	private Boolean autoshipable = false;

	public Boolean isAutoshipable() {
		return autoshipable;
	}

	public void setAutoshipable(Boolean autoshipable) {
		this.autoshipable = autoshipable;
	}

	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Boolean isColorSelect() {
		return colorSelect;
	}

	public void setColorSelect(Boolean colorSelect) {
		this.colorSelect = colorSelect;
	}

	public Boolean isStyleWithImageSelect() {
		return styleWithImageSelect;
	}

	public void setStyleWithImageSelect(Boolean styleWithImageSelect) {
		this.styleWithImageSelect = styleWithImageSelect;
	}

	public Boolean isStyleSelect() {
		return styleSelect;
	}

	public void setStyleSelect(Boolean styleSelect) {
		this.styleSelect = styleSelect;
	}

	public Boolean isSizeSelect() {
		return sizeSelect;
	}

	public void setSizeSelect(Boolean sizeSelect) {
		this.sizeSelect = sizeSelect;
	}

	public Boolean isLengthSelect() {
		return lengthSelect;
	}

	public void setLengthSelect(Boolean lengthSelect) {
		this.lengthSelect = lengthSelect;
	}

	public Boolean isDiscontinuedNoReplace() {
		return discontinuedNoReplace;
	}

	public void setDiscontinuedNoReplace(Boolean discontinuedNoReplace) {
		this.discontinuedNoReplace = discontinuedNoReplace;
	}

	public Boolean isDiscontinuedWReplace() {
		return discontinuedWReplace;
	}

	public void setDiscontinuedWReplace(Boolean discontinuedWReplace) {
		this.discontinuedWReplace = discontinuedWReplace;
	}

	public Boolean isCallForQuote() {
		return callForQuote;
	}

	public void setCallForQuote(Boolean callForQuote) {
		this.callForQuote = callForQuote;
	}

	public Boolean isSampleProduct() {
		return sampleProduct;
	}

	public void setSampleProduct(Boolean sampleProduct) {
		this.sampleProduct = sampleProduct;
	}

	public Boolean isRequiredAccesories() {
		return requiredAccesories;
	}

	public void setRequiredAccesories(Boolean requiredAccesories) {
		this.requiredAccesories = requiredAccesories;
	}

	@Override
	public String toString() {
		return "Product{" +
				"itemNumber='" + itemNumber + '\'' +
				", productName='" + productName + '\'' +
				", colorSelect=" + colorSelect +
				", styleWithImageSelect=" + styleWithImageSelect +
				", styleSelect=" + styleSelect +
				", sizeSelect=" + sizeSelect +
				", lengthSelect=" + lengthSelect +
				", discontinuedNoReplace=" + discontinuedNoReplace +
				", discontinuedWReplace=" + discontinuedWReplace +
				", callForQuote=" + callForQuote +
				", sampleProduct=" + sampleProduct +
				", requiredAccesories=" + requiredAccesories +
				", autoshipable=" + autoshipable +
				'}';
	}
}
