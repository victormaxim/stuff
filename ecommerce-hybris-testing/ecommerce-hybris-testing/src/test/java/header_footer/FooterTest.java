package header_footer;

import base.data.NPMESSAGING;
import base.data.TestDataReader;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

import java.util.ArrayList;

@Listeners(MyTNGListener.class)
public class FooterTest {


	Newpig newpig;
	TestDataReader testDataReader = new TestDataReader();

	@BeforeMethod
	public void before() {
		newpig = new Newpig();
	}

	@AfterMethod
	public void after() {
		newpig.quit();
	}


	@Test(groups = {"smoke"}, description = "Footer - 264\tVerify email list subscription section in footer")
	public void TC264_emailSubscriptionInFooter() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.footer.signupForNewsletter("sdknfjkldsjl");
		softAssert.assertTrue(newpig.homepage.footer.isSubscriptionErrorTextVisible(),"Invalid email");

		newpig.homepage.footer.signupForNewsletter("bubu@email.com");
		softAssert.assertTrue(newpig.homepage.footer.isSubscriptionSuccessTextVisible(), "Valid email");

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Footer - 263\tVerify Today Only Deal section in footer")
	public void TC263_todayOnlyDealInFooter() {
		SoftAssert softAssert = new SoftAssert();

		String todProductName = newpig.homepage.footer.getProductName();
		softAssert.assertTrue(newpig.homepage.footer.isTODProdImageVisible());
		softAssert.assertTrue(newpig.homepage.footer.isTODProdPriceVisible());

		newpig.homepage.footer.addTODProductToCart();

		newpig.homepage.header.goToCartPage();

		String cartProdName = newpig.cart.productsTable.getCartRowsInfo().get(0).getProdName();
		softAssert.assertTrue(cartProdName.equalsIgnoreCase(todProductName));

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Footer - 487\tPigalog - Logged in - Mail it to me - positive flow")
	public void TC487_mailPigalogPositive() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.headerPopupLogin(testDataReader.getRndUser());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		String address = newpig.myAccount.addressBook.getAddres(1);

		newpig.myAccount.addressBook.footer.clickMailPigalog();

		ArrayList<String> formPrefills = newpig.myAccount.addressBook.footer.pigalogForm.getPrefilledTextInForm();

		for (String formPrefill : formPrefills) {
			softAssert.assertTrue(address.contains(formPrefill));
		}

		newpig.myAccount.addressBook.footer.pigalogForm.fillForm(null, null, null, null, null, null);
		softAssert.assertTrue(newpig.myAccount.addressBook.footer.isMailPigalogMessageVisible());

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Footer - 262\tVerify Pigalog section in footer")
	public void TC262_verifyPigalogFooterSection() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(newpig.homepage.footer.checkViewOnlinePigalog());

		newpig.homepage.footer.clickMailPigalog();
		softAssert.assertTrue(newpig.homepage.footer.isMailPigalogFormVisible());

		softAssert.assertAll();
	}



	@Test(groups = {"smoke"}, description = "Footer - 490\tPigalog - Guest - Mail it to me - register - positive flow")
	public void TC490_mailPigalogAndRegister() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("==========================FAILING bug ER-5041=================================");
		newpig.homepage.footer.clickMailPigalog();
		newpig.homepage.footer.pigalogForm.fillAndRegisterForm("fName", "lName", "companyName", "addr1Test", "45432", "+1 614-221-6801", Utils.getRndString() + "@email.com", "Pass123!@#");

		newpig.homepage.footer.isMailPigalogMessageVisible();

		//newpig.homepage.refresh();

		softAssert.assertTrue(newpig.homepage.header.getSignInLinkText().equals("Hi, fName"));
		softAssert.assertTrue(newpig.messages.getSuccessMessages().get(0).equals(NPMESSAGING.REGISTRATION_SUCCESS.get()));

		softAssert.assertAll();
	}




}
