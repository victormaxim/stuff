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


public class LoginPage extends PageObject {

    @FindBy(css="#j_username")
    private WebElementFacade userInput;

    @FindBy(css="#j_password")
    private WebElementFacade passwordInput;
    
    @FindBy(css=".form")
    private WebElementFacade submitButton;

	public void fillUsernameLogin(String username){
		userInput.type(username);
	}
	
	public void fillPasswordLogin(String password){
		passwordInput.type(password);
	}
	
	public void submitLogin(){
		submitButton.click();
	}
}