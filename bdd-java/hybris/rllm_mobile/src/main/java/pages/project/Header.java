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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ch.lambdaj.Lambda.convert;

public class Header extends PageObject {
	
	private Map<String, WebElementFacade> breadcrumbsMap = new HashMap<String, WebElementFacade>();
    private boolean isInitialized = false;
    
    @FindBy(css="#search")
    private WebElementFacade searchBox;
    
    @FindBy(css=".header>.wrapper>.bottom-header [class*=bottom-left-header-content-slot]>.simple-banner-component>[href]")
    private WebElementFacade logoLink;
    
    @FindBy(xpath=".//*[@id='breadcrumb']/ul/li/*[contains(text(),'Home')]")
    private WebElementFacade HomeBreadcrumbLink;
    
    public void init() {
		breadcrumbsMap.put("Home", HomeBreadcrumbLink);
	}

    public void breadcrumbLinkClick(String breadcrumb) {
    	if (!isInitialized)
    		init(); 	
    	breadcrumbsMap.get(breadcrumb).click();
    }
    
    public void searchTypeAndEnterKeyword(String keyword) {
    	searchBox.typeAndEnter(keyword);
    }
    public void logoClick() {
    	logoLink.click();
    }

        
}