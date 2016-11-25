package pages.login;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 8/16/14.
 */
public class ForgotPassword extends NewpigGenericPage {

//	public NPHeader header_footer = new NPHeader(driver);
//	public NPFooter footer = new NPFooter(driver);
//	public NPMessageArea messageArea = new NPMessageArea(driver);

	private By emailInput = By.id("forgottenPwd.email");
	private By sendEmailBtn = By.cssSelector("form#forgottenPwdForm button.positive");

	public ForgotPassword(WebDriver driver) {
		super(driver);
	}
}
