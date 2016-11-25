package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 3/26/15.
 */
public class ChangePassword extends NewpigGenericPage {

	private By currentPasswordInput = By.id("profile.currentPassword");
	private By newPasswordInput = By.id("profile.newPassword");
	private By newPasswordConfirmInput = By.id("profile.checkNewPassword");

	private By submitButton = By.cssSelector("#updatePasswordForm > div.form-actions.align-with-fields > button");



	public ChangePassword(WebDriver driver) {
		super(driver);
	}


	public void changePassword(String oldPass, String newPass, String newPassConfirm){
		fillInput(currentPasswordInput, oldPass);
		fillInput(newPasswordInput, newPass);
		fillInput(newPasswordConfirmInput, newPassConfirm);
		click(submitButton);
	}



}
