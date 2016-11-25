package base.data.pojos;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by optaros on 6/3/15.
 */
public class PricePojo {

	String currency;
	Float price;

	public PricePojo(String currency, Float price) {
		this.currency = currency;
		this.price = price;
	}

	public PricePojo(String fullPrice) {
		fullPrice = fullPrice.replaceAll(",", "");
		Pattern pattern = Pattern.compile("(^\\D+)(.*)");
		Matcher matcher = pattern.matcher(fullPrice);
		if (matcher.find())
		{
			this.currency = matcher.group(1);
			this.price = Float.valueOf(matcher.group(2));
		}
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Price{" +
				"currency='" + currency + '\'' +
				", price=" + price +
				'}';
	}
}
