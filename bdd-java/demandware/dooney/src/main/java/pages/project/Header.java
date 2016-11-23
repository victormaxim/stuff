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

public class Header extends PageObject {
	
    @FindBy(css=".user-login")
    private WebElementFacade loginLink;
    
    @FindBy(css=".isMobile-no.hdr-acct.last")
    private WebElementFacade welcomeLink;
    
    @FindBy(css=".isMobile-no.hdr-acct.last>.user-account")
    private WebElementFacade accountLink;
    
    @FindBy(css=".isMobile-no.hdr-acct.last>.welcome-msg")
    private WebElementFacade logoutLink;
    
    public void loginLinkClick() {
    	loginLink.click();
    }
    
    public void accountLinkClick() {
    	accountLink.click();
    }
    
    public void logoutLinkClick() {
    	logoutLink.click();
    }
    
    public String getWelcomeText() {
    	return welcomeLink.getText();
    }
    
    public boolean logoutLinkIsVisible() {
    	return logoutLink.isVisible();
    }
}