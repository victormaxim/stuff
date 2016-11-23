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

    @FindBy(id="email")
    private WebElementFacade userInput;

    @FindBy(id="pass")
    private WebElementFacade passwordInput;
    
    @FindBy(id="send2")
    private WebElementFacade submitButton;
    
    @FindBy(id="send2")
    private WebElementFacade myAccountText;

	public void fillUsernameLogin(String username){
		userInput.type(username);
	}
	
	public void fillPasswordLogin(String password){
		passwordInput.type(password);
	}
	
	public void submitLogin(){
		submitButton.click();
	}
	
	public String getMyAccounLoginText() {
		return myAccountText.getText();
	}
}