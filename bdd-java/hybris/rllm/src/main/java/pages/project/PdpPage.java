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

@DefaultUrl("http://www-qa-247rue-ruelala.ruedev.com:9001/ruelala/en/Obsolete/Streetwear-men/T-Shirts-men/Pennant-SS/p/300417310")
public class PdpPage extends PageObject {

    @FindBy(css="#addToCartButton")
    private WebElementFacade addToCartButton;
    
    
    public void addToCartButtonClick() {
    	addToCartButton.click();
    }
}