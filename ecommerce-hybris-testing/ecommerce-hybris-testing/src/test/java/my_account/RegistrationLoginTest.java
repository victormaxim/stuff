package my_account;

import base.data.NPMESSAGING;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

import static org.testng.Assert.assertEquals;

@Listeners(MyTNGListener.class)
public class RegistrationLoginTest {


	private String new_user;
	private String pass = "Pass123!@#";

	Newpig newpig;

	@BeforeMethod
	public void before(){
		newpig = new Newpig();
	}

	@AfterMethod
	public void after(){
		newpig.quit();
	}



	@Test(groups = {"smoke"}, description = "MyAccount - 1870\tRegistration - valid data")
	public void TC1870_registerValidUser() {
		String username = Utils.getRndString() + "test@email.com";
		newpig.homepage.header.goToRegistrationPage();
		newpig.registration.fillRegistrationForm(
				username,
				"testFname",
				"testLname",
				pass,
				pass,
				false,
				"CEO",
				"ComLand",
				"COM",
				"address line 1",
				"adress line 2",
				"mail stop",
				"45432",
				"416.306.5800");

		newpig.registration.submit();

		assertEquals(newpig.messages.getSuccessMessages().get(0),NPMESSAGING.REGISTRATION_SUCCESS.get());
		new_user = username;
	}


	@Test(groups = {"smoke"}, description = "MyAccount - 1401\tLogin - fields validations")
	public void TC1401_loginFieldValidations() {

		SoftAssert softAssert = new SoftAssert();


		newpig.homepage.header.headerPopupLogin("gjhj@test.com", "1234");

		softAssert.assertEquals(newpig.messages.getErrorMessages().get(0).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE.get().toLowerCase());
		softAssert.assertEquals(newpig.messages.getErrorMessages().get(1).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE2.get().toLowerCase());


		newpig.login.login("6g.com", "sadadasdasdasasdasdasaasas");

		softAssert.assertEquals(newpig.messages.getErrorMessages().get(0).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE.get().toLowerCase());
		softAssert.assertEquals(newpig.messages.getErrorMessages().get(1).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE2.get().toLowerCase());


		newpig.login.login("609659xwebtest@newpig.com", "sadadasdasdasasdasdasaasas");

		softAssert.assertEquals(newpig.messages.getErrorMessages().get(0).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE.get().toLowerCase());
		softAssert.assertEquals(newpig.messages.getErrorMessages().get(1).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE2.get().toLowerCase());

		softAssert.assertAll();

	}


	@Test(groups = {"smoke"}, description = "MyAccount - 1397\tLogin - valid data", dependsOnMethods = { "TC1870_registerValidUser" })
	public void TC1397_validLogin() {

		SoftAssert softAssert = new SoftAssert();


		newpig.homepage.header.headerPopupLogin(new_user, pass);

		softAssert.assertTrue(newpig.homepage.header.getSignInLinkText().contains("Hi"));

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "MyAccount - 1399\tLogin - logout", dependsOnMethods = { "TC1870_registerValidUser" })
	public void TC1399_validLogout() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.headerPopupLogin(new_user, pass);

		softAssert.assertTrue(newpig.homepage.header.getSignInLinkText().contains("Hi"));

		newpig.homepage.header.clickMyAccountMenuOption("Logout");

		softAssert.assertTrue(newpig.homepage.header.getSignInLinkText().contains("Sign In"));

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "MyAccount - 1349\tChange Password - Registered User - Change your password.", dependsOnMethods = { "TC1870_registerValidUser" }, priority = 9999)
	public void TC1349_changePassword() {

		SoftAssert softAssert = new SoftAssert();


		newpig.homepage.header.headerPopupLogin(new_user, pass);
		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickChangePasswordLink();
		newpig.myAccount.changePassword.changePassword(pass, "Welcome2!", "Welcome2!");


		newpig.homepage.header.clickMyAccountMenuOption("Logout");

		newpig.homepage.header.headerPopupLogin(new_user, pass);
		softAssert.assertEquals(newpig.messages.getErrorMessages().get(0).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE.get().toLowerCase());
		softAssert.assertEquals(newpig.messages.getErrorMessages().get(1).toLowerCase(), NPMESSAGING.INVALID_LOGIN_ERR_MESSAGE2.get().toLowerCase());

		newpig.homepage.header.headerPopupLogin(new_user, "Welcome2!");
		softAssert.assertTrue(newpig.homepage.header.getSignInLinkText().contains("Hi"));



		softAssert.assertAll();

	}

}
