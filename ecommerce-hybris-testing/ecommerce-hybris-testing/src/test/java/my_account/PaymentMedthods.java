package my_account;

import base.data.NPMESSAGING;
import base.data.TestDataReader;
import base.data.pojos.User;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

@Listeners(MyTNGListener.class)
public class PaymentMedthods {


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


    @Test(groups = {"smoke"}, description = "DESCRIPTION")
    public void TC1870_registerValidUser() {
        SoftAssert softAssert = new SoftAssert();

        User user = testDataReader.getRndUser();

        newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

        //go to My Account Payment
        newpig.homepage.header.clickMyAccountMenuOption("My Account");
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Payment");

        //add new random address
        newpig.myAccount.payment.clickAddNewAddress();

        String comapny = Utils.getRndString();
        String addrLine1 = Utils.getRndString();
        String addrLine2 = Utils.getRndString();
        String zip = "10001";
        newpig.myAccount.addEditAddress.fillForm(comapny, addrLine1, addrLine2, zip, false, false);
        newpig.myAccount.addEditAddress.submit();

        softAssert.assertTrue(newpig.myAccount.payment.isSuccessMessageDisplayed(),"Invoice address addded");

        //set the added address as default payment
        newpig.myAccount.payment.setAddressContainingTextAsDefaultPayment(comapny);
        softAssert.assertTrue(newpig.myAccount.payment.isSuccessMessageDisplayed(),"Success message displayed");
        softAssert.assertTrue(newpig.myAccount.payment.addressContainingTextIsSetAsDefaultPayment(comapny),"Invoice set as default payment");

        //check that the default payment option is Invoicec
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Account Overview");
        softAssert.assertTrue(newpig.myAccount.myAccountDashboard.getDefaultPaymentOptionsText().contains("Invoice"), "Invoice is set as default payment option");

        softAssert.assertAll();
    }
}
