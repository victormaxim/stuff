package pages.generic;

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


public class HybrisGlobalMessages extends PageObject {
	
    @FindBy(css="[id=globalMessages]>.alert.negative")
    private WebElementFacade alertNegative;
    
    @FindBy(css="[id=globalMessages]>.alert.positive")
    private WebElementFacade alertPositive;
    
	public String errorMessageGet() {
	    return alertNegative.getText();
	}
	
	public String successMessageGet() {
	    return alertPositive.getText();
	}
	
	public void errorMessageAppears() {
		alertNegative.shouldBeVisible();
	}
	
	public void successMessageAppears() {
		alertPositive.shouldBeVisible();
	}
	
	public void errorMessageDoesntAppear() {
		alertNegative.shouldNotBeVisible();
	}
	
}