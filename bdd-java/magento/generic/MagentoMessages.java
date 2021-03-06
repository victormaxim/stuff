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


public class MagentoMessages extends PageObject {
	
    @FindBy(css=".messages>.error-msg")
    private WebElementFacade errorMessage;
    
    @FindBy(css=".messages>.error-msg")
    private WebElementFacade successMessage;
    
	public String errorMessage() {
	    return errorMessage.getText();
	}
	
	public String successMessage() {
	    return successMessage.getText();
	}
	
}