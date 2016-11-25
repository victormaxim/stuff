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
public class DeliveryOptions {

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


    @Test(groups = {"smoke"}, description = "My Account - 5192 - Shipping Method - Registered User - Add a New Collect Shipping Carrier")
    public void TC5192_addNewCollectShippingCarrier() {
        SoftAssert softAssert = new SoftAssert();

        //Log in. (US / CA / FED user).
        User user = testDataReader.getUserByType("us_1");
        newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

        //Click My Account link in the Universal Header .
        newpig.homepage.header.clickMyAccountMenuOption("My Account");

        //Select Delivery Options  from the My Account Navigation block .
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Delivery Options");

        //User selects 'Always Use My Collect Shipping Carrier'.
        newpig.myAccount.deliveryOptions.selectShippingCarrier();

        //User clicks on 'ADD NEW' link
        newpig.myAccount.deliveryOptions.clickAddNew();

        //Check the available fields.
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.newCarrier.elementsDisplayed());

        //Complete the fields
        String newCarrierName = newpig.myAccount.deliveryOptions.newCarrier.addNewRandomCarrier();

        //Check to see if new entry is displayed
        newpig.myAccount.deliveryOptions.selectShippingCarrier();
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.successMessageDisplayed());
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.isCarrierDisplayed(newCarrierName));

        softAssert.assertAll();
    }

    @Test(groups = {"smoke"}, description = "My Account - 5197 - Shipping Method - Remove a Saved Collect Shipping Carrier")
    public void TC5197_removeSavedShippingCarrier() {
        SoftAssert softAssert = new SoftAssert();

        //Log in. (US / CA / FED user).
        User user = testDataReader.getUserByType("us_1");
        newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

        //Click My Account link in the Universal Header .
        newpig.homepage.header.clickMyAccountMenuOption("My Account");

        //Select Delivery Options  from the My Account Navigation block .
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Delivery Options");

        //User selects 'Always Use My Collect Shipping Carrier'.
        newpig.myAccount.deliveryOptions.selectShippingCarrier();

        //Add a new carrier if none available
        if (!newpig.myAccount.deliveryOptions.carriersExist()) {
            newpig.myAccount.deliveryOptions.clickAddNew();
            newpig.myAccount.deliveryOptions.newCarrier.addNewRandomCarrier();
            newpig.myAccount.deliveryOptions.selectShippingCarrier();
        }
        String firstCarrier = newpig.myAccount.deliveryOptions.getCarrierName(0);

        //User selects 'REMOVE' link for carrier to be removed
        newpig.myAccount.deliveryOptions.removeFirstCarrier();

        //Remove confirmation message displaysSaved. Shipping Carrier is now removed
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.successMessageContains("removed"));
        softAssert.assertFalse(newpig.myAccount.deliveryOptions.isCarrierDisplayed(firstCarrier));

        softAssert.assertAll();
    }

    @Test(groups = {"smoke"}, description = "My Account - 5191 - Shipping Method - Set a Saved Collect Shipping Carrier as the Default Carrier")
    public void TC5191_setAsDefaultCarrier() {
        SoftAssert softAssert = new SoftAssert();

        //Log in. (US / CA / FED user).
        User user = testDataReader.getUserByType("us_1");
        newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

        //Click My Account link in the Universal Header .
        newpig.homepage.header.clickMyAccountMenuOption("My Account");

        //Select Delivery Options  from the My Account Navigation block .
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Delivery Options");

        //User selects 'Always Use My Collect Shipping Carrier'.
        newpig.myAccount.deliveryOptions.selectShippingCarrier();

        //Add a new carrier if no non default carrier is displayed
        if (!newpig.myAccount.deliveryOptions.isNonDefaultCarierDisplayed()) {
            newpig.myAccount.deliveryOptions.clickAddNew();
            newpig.myAccount.deliveryOptions.newCarrier.addNewRandomCarrier();
            newpig.myAccount.deliveryOptions.selectShippingCarrier();
        }
        //Get index of the first non default carrier
        int initialIndex = newpig.myAccount.deliveryOptions.getTableIndexForFirstNonDefaultCarrier();

        //User selects 'Set as Default' link for first non default carrier
        newpig.myAccount.deliveryOptions.setAsDefaultFirst();

        //Successful update message displayed. Carrier is now set as default
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.successMessageContains("updated"));
        int indexOfDefault = newpig.myAccount.deliveryOptions.getTableIndexForDefaultCarrier();
        softAssert.assertEquals(initialIndex,indexOfDefault,"Carrier is set as default");

        //When user goes through the checkout flow, the Delivery Options page will be skipped since a default is set.
        newpig.homepage.header.goToCartPage();
        newpig.cart.quickAdd("MAT230", "1");
        newpig.cart.startCheckout();
        newpig.checkout.shippingAddress.clickContinue();
        softAssert.assertTrue(newpig.checkout.payment.isDisplayed());

        softAssert.assertAll();
    }

    @Test(groups = {"smoke"}, description = "My Account - 5195 - Shipping Method - Edit a Saved Collect Shipping Carrier")
    public void TC5195_editCarrier() {
        SoftAssert softAssert = new SoftAssert();

        //Log in. (US / CA / FED user).
        User user = testDataReader.getUserByType("us_1");
        newpig.homepage.header.headerPopupLogin(user.getUsername(), user.getPassword());

        //Click My Account link in the Universal Header .
        newpig.homepage.header.clickMyAccountMenuOption("My Account");

        //Select Delivery Options  from the My Account Navigation block .
        newpig.myAccount.myAccountDashboard.clickLeftNavOption("Delivery Options");

        //User selects 'Always Use My Collect Shipping Carrier'.
        newpig.myAccount.deliveryOptions.selectShippingCarrier();

        //Add a new carrier if none exist
        if (!newpig.myAccount.deliveryOptions.carriersExist()) {
            newpig.myAccount.deliveryOptions.clickAddNew();
            newpig.myAccount.deliveryOptions.newCarrier.addNewRandomCarrier();
            newpig.myAccount.deliveryOptions.selectShippingCarrier();
        }

        //Edit the first Carrier
        newpig.myAccount.deliveryOptions.editFirstCarier();
        String Edited_Name = "Edited_Name_"+Utils.getRndString(3);
        String Edited_Account = "Edited_Account_"+Utils.getRndString(3);
        newpig.myAccount.deliveryOptions.newCarrier.editCarrier(Edited_Name,Edited_Account,true);

        //Success update message displayed. Carrier is displayed with the updated data
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.successMessageContains("updated"));
        softAssert.assertEquals(newpig.myAccount.deliveryOptions.getTableIndexForDefaultCarrier(),2);
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.getFirstCarrierName().contains(Edited_Name));
        softAssert.assertTrue(newpig.myAccount.deliveryOptions.getFirstCarrierAccount().contains(Edited_Account));

        softAssert.assertAll();
    }



}
