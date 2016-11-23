package pages.project;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.thucydides.core.pages.WebElementFacade;

import net.thucydides.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("http://www-qa-247rue-ruelala.ruedev.com:9001/ruelala/en/")
public class HomePage extends PageObject {
	@FindBy(css=".homepage >[class*=top-content-slot]>.simple-banner-component [src*=medias]")
	private WebElementFacade welcomeBanner;

	@FindBy(css=".bottom-content-slot>.product-carousel-component>.products-container>.product-list>.single-product>a:first-of-type")
	private WebElementFacade addToMyStyleLink;

	@FindBy(css=".single-product.new-feed-items>a>.new-feed-number")
	private WebElementFacade myStyleBanner;
	
	@FindBy(css=".bottom-content-slot>.product-carousel-component>.content-slot-header")
	private WebElementFacade myStyleFeedHeader;
	
	@FindBy(css=".bottom-content-slot>.product-carousel-component>.products-container")
	private WebElementFacade myStyleFeedProducts;
	
	@FindBy(css=".brand-content-slot>div>.thumbnail>a[href*=\"Brands/Nike\"]")
	private WebElementFacade brandBannerLink;
	
	@FindBy(css=".collection-content-slot>div>.thumbnail>a[href*=\"Collections/Snow\"]")
	private WebElementFacade collectionBannerLink;

	public void welcomeBannerAppears() {
		welcomeBanner.shouldBeVisible();
	}

	public void myStyleFeedBannerClick(){
		myStyleBanner.click();
	}

	public void myStyleFeedBannerAppears() {
		myStyleBanner.shouldBeVisible();
	}
	
	public void myStyleFeedHeaderAppears() {
		myStyleFeedHeader.shouldBeVisible();
	}
	
	public void myStyleFeedProductsAppears() {
		myStyleFeedProducts.shouldBeVisible();
	}
	
	public void brandBannerClick() {
		brandBannerLink.click();
	}
	
	public void brandBannerAppears() {
		brandBannerLink.shouldBeVisible();
	}
	
	public void collectionBannerClick() {
		collectionBannerLink.click();
	}
	
	public void collectionBannerAppears() {
		collectionBannerLink.shouldBeVisible();
	}
}
