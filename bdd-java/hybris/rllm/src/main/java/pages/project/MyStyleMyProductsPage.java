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

@DefaultUrl("http://www-qa-247rue-ruelala.ruedev.com:9001/ruelala/en/mystyle/products")
public class MyStyleMyProductsPage extends PageObject {
	
    @FindBy(xpath="html/body/div[1]/div[2]/div[1]/h2[contains(text(), 'MY PRODUCTS')]")
    private WebElementFacade myProductsPage;
    
    public void myProductPageAppears() {
    	myProductsPage.shouldBeVisible();
    }
}