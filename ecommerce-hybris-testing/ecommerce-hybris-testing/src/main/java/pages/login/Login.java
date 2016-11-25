package pages.login;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 8/16/14.
 */
public class Login extends NewpigGenericPage {


//	public NPHeader header_footer = new NPHeader(driver);
//	public NPFooter footer = new NPFooter(driver);
//	public NPMessageArea messageArea = new NPMessageArea(driver);


	private By userInput = By.cssSelector("div#page div.container.body-container input#j_username.text.mandatory");
	private By passInput = By.cssSelector("div#page div.container.body-container input#j_password");

	private By rememberMeCheckbox = By.id("loginOption1");

	private By forgotPassLink = By.cssSelector("div#page div.container.body-container a.password-forgotten");

	private By submitButton = By.cssSelector("#loginForm > div.form-actions.clearfix > button.btn-primary");

	public Login(WebDriver driver) {
		super(driver);
	}


	public void login(String username, String password){
		fillInput(userInput, username);
		fillInput(passInput, password);
		click(submitButton);
	}




}
