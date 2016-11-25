package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.WebDriver;
import pages.checkout.CheckoutPayment;

/**
 * Created by Ionut.Trusca on 7/2/2015.
 */
public class MyAccount extends NewpigGenericPage {

    // ---------------------------------------------  Selectors -------------------------------------------------------

    // ---------------------------------------------  Constructor ----------------------------------------------------
    public MyAccount(WebDriver driver) {
        super(driver);
    }

    // ---------------------------------------------  Pages ----------------------------------------------------
    public AddressBook addressBook = new AddressBook(driver);
    public AddEditAddress addEditAddress = new AddEditAddress(driver);
    public ChangePassword changePassword = new ChangePassword(driver);
    public DeliveryOptions deliveryOptions = new DeliveryOptions(driver);
    public EditContactInfo editContactInfo = new EditContactInfo(driver);
    public MyAccountDashboard myAccountDashboard = new MyAccountDashboard(driver);
    public ViewContactInfo viewContactInfo = new ViewContactInfo(driver);
    public ShoppingLists shoppingList = new ShoppingLists(driver);
    public Payment payment = new Payment(driver);
}
