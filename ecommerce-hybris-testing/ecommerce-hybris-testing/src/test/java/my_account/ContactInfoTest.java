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
public class ContactInfoTest {


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


	@Test(groups = {"smoke"}, description = "1829 - Contact Information - Registered User - Edit information")
	public void TC1829_editContactInfo() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("============================FAILING bug ER-3246 question 5342=============================");

		User user = testDataReader.getRndUser();

		newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

		newpig.homepage.header.clickMyAccountMenuOption("My Account");
		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Contact Information");

		String email = Utils.getRndString() + "test@email.com";
		String jobTitle = Utils.getRndString();
		String fname = Utils.getRndString();
		String lname = Utils.getRndString();


		newpig.myAccount.editContactInfo.fillForm(email, fname, lname, jobTitle, null, null, null, null, null, null, null);
		newpig.myAccount.editContactInfo.clickSubmit();


		String contactInfo = newpig.myAccount.viewContactInfo.getContactInfo();

		softAssert.assertTrue(contactInfo.contains(email), "Email after update");
		softAssert.assertTrue(contactInfo.contains(jobTitle), "Job title after update");
		softAssert.assertTrue(contactInfo.contains(fname), "First name after update");
		softAssert.assertTrue(contactInfo.contains(lname), "Last name after update");


		softAssert.assertAll();
	}
}
