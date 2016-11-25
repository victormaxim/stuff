package my_account;

import base.data.TestDataReader;
import base.data.pojos.User;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

@Listeners(MyTNGListener.class)
public class AddressBookTest {

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




	@Test(groups = {"smoke"}, description = "My Account - 1560 - Address Book - Registered User - Edit Address")
	public void TC1560_editAddress() {
		SoftAssert softAssert = new SoftAssert();


		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		newpig.myAccount.addressBook.clickEditAddress(1);

		String addrLine2 = Utils.getRndString();

		newpig.myAccount.addEditAddress.fillForm(null, null, addrLine2, null, false, false);
		newpig.myAccount.addEditAddress.submit();

		softAssert.assertTrue(newpig.myAccount.addressBook.getAddres(1).contains(addrLine2));


		softAssert.assertAll();
	}



	@Test(groups = {"smoke"}, description = "My Account - 1556 - Address Book - Registered User - Add New Address - make default shipping address")
	public void TC1556_newAddressDefaultShipping() {
		SoftAssert softAssert = new SoftAssert();

		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		//add new random address as default shipping address
		newpig.myAccount.addressBook.clickAddNewAddress();

		String comapny = Utils.getRndString();
		String addrLine1 = Utils.getRndString();
		String addrLine2 = Utils.getRndString();
		String zip = "45432";
		newpig.myAccount.addEditAddress.fillForm(comapny, addrLine1, addrLine2, zip, true, false);
		newpig.myAccount.addEditAddress.submit();

		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		softAssert.assertTrue(newpig.myAccount.addressBook.isAddressContainingTextDisplayed(addrLine1), "Address was added");

		//Check that the addedd address is saved as default shipping address
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Account Overview");
		String accountOverviewDefaultShippingAddress = newpig.myAccount.myAccountDashboard.getDefaultShippingAddressText();
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(comapny), "Company displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine1),"addrLine1 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine2),"addrLine2 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(zip),"Zip code displayed on Acc Overview");

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "My Account - 1557 - Address Book - Registered User - Add New Address - make default billing address")
	public void TC1557_newAddressDefaultBilling() {
		SoftAssert softAssert = new SoftAssert();

		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		//add new random address as default billing address
		newpig.myAccount.addressBook.clickAddNewAddress();

		String comapny = Utils.getRndString();
		String addrLine1 = Utils.getRndString();
		String addrLine2 = Utils.getRndString();
		String zip = "45432";
		newpig.myAccount.addEditAddress.fillForm(comapny, addrLine1, addrLine2, zip, false, true);
		newpig.myAccount.addEditAddress.submit();

		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		softAssert.assertTrue(newpig.myAccount.addressBook.isAddressContainingTextDisplayed(addrLine1), "Address was added");

		//Check that the addedd address is saved as default billing address
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Account Overview");
		String accountOverviewDefaultShippingAddress = newpig.myAccount.myAccountDashboard.getDefaultPaymentOptionsText();
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(comapny), "Company displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine1),"addrLine1 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine2),"addrLine2 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(zip),"Zip code displayed on Acc Overview");

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "My Account - 1563 - Address Book - Registered User - Set as Default Billing")
	public void TC1563_setDefaultBilling() {
		SoftAssert softAssert = new SoftAssert();

		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		//add new random address, DO NOT set as any default
		newpig.myAccount.addressBook.clickAddNewAddress();

		String comapny = Utils.getRndString();
		String addrLine1 = Utils.getRndString();
		String addrLine2 = Utils.getRndString();
		String zip = "45432";
		newpig.myAccount.addEditAddress.fillForm(comapny, addrLine1, addrLine2, zip, false, false);
		newpig.myAccount.addEditAddress.submit();

		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		softAssert.assertTrue(newpig.myAccount.addressBook.isAddressContainingTextDisplayed(addrLine1), "Address was added");

		//Set the added address as default billing address
		newpig.myAccount.addressBook.setAddressContainingTextAsDefaultBilling(addrLine1);
		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		newpig.myAccount.addressBook.waitSeconds(2);

		//Check that the addedd address is saved as default billing address
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Account Overview");
		String accountOverviewDefaultShippingAddress = newpig.myAccount.myAccountDashboard.getDefaultPaymentOptionsText();
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(comapny), "Company displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine1),"addrLine1 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine2),"addrLine2 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(zip),"Zip code displayed on Acc Overview");

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "My Account - 1562 - Address Book - Registered User - Set as Default Shipping")
	public void TC1562_setDefaultShipping() {
		SoftAssert softAssert = new SoftAssert();

		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");

		//add new random address, DO NOT set as any default
		newpig.myAccount.addressBook.clickAddNewAddress();

		String comapny = Utils.getRndString();
		String addrLine1 = Utils.getRndString();
		String addrLine2 = Utils.getRndString();
		String zip = "45432";
		newpig.myAccount.addEditAddress.fillForm(comapny, addrLine1, addrLine2, zip, false, false);
		newpig.myAccount.addEditAddress.submit();

		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		softAssert.assertTrue(newpig.myAccount.addressBook.isAddressContainingTextDisplayed(addrLine1), "Address was added");

		//Set the added address as default shipping address
		newpig.myAccount.addressBook.setAddressContainingTextAsDefaultShipping(addrLine1);
		softAssert.assertTrue(newpig.myAccount.addressBook.isSuccessMessageDisplayed(),"Success message displayed");
		newpig.myAccount.addressBook.waitSeconds(2);

		//Check that the addedd address is saved as default shipping address
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Account Overview");
		String accountOverviewDefaultShippingAddress = newpig.myAccount.myAccountDashboard.getDefaultShippingAddressText();
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(comapny), "Company displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine1),"addrLine1 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(addrLine2),"addrLine2 displayed on Acc Overview");
		softAssert.assertTrue(accountOverviewDefaultShippingAddress.contains(zip),"Zip code displayed on Acc Overview");

		softAssert.assertAll();
	}



}
