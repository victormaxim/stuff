package checkout;

import base.data.TestDataReader;
import base.data.pojos.AddressPojo;
import base.data.pojos.User;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

@Listeners(MyTNGListener.class)
public class CheckoutTest {


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


	@Test(groups = {"smoke"}, description = "498 - Guest user - Checkout from cart")
	public void TC498_guestTryCheckout() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.addFeaturedProductToCart();
		newpig.homepage.header.goToCartPage();
		newpig.cart.startCheckout();
		softAssert.assertTrue(newpig.checkout.loginRegister.isLoginAndCheckoutPage());

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "1115 - Checkout - Saved Address - Logged In - Select address")
	public void TC1115_checkSomeSavedAddressAppears() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("ca_price_type_91"));
		newpig.homepage.addFeaturedProductToCart();

		newpig.homepage.header.goToCartPage();
		newpig.cart.startCheckout();

		softAssert.assertTrue(newpig.checkout.shippingAddress.isShippingAddressLoaded());
		softAssert.assertTrue(newpig.checkout.shippingAddress.isShippingAddressStepActive());

		softAssert.assertTrue(newpig.checkout.shippingAddress.getListedAddresses().size()>=1);
		newpig.checkout.shippingAddress.selectSavedAddressAndContinue(1);

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Checkout - 1806\tEdit Address - Logged In - Use as my billing address")
	public void TC1806_editSavedAddress() {
		SoftAssert softAssert = new SoftAssert();

		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("ca_price_type_91"));
		newpig.homepage.addFeaturedProductToCart();

		newpig.homepage.header.goToCartPage();
		newpig.cart.startCheckout();

		System.out.println(newpig.checkout.shippingAddress.isShippingAddressLoaded());
		System.out.println(newpig.checkout.shippingAddress.isShippingAddressStepActive());

		AddressPojo addressPojo = new AddressPojo();
		addressPojo.setAddr2("addr2test");

		newpig.checkout.shippingAddress.clickEditAddress(1);

		newpig.checkout.shippingAddress.addressForm.fillAddressForm(addressPojo);

		newpig.checkout.shippingAddress.clickContinue();

		newpig.checkout.waitSeconds(1);

		newpig.checkout.openHomePage();
		newpig.homepage.header.clickMyAccountMenuOption("My Account");

		newpig.myAccount.myAccountDashboard.clickLeftNavOption("Address Book");
		System.out.println(newpig.myAccount.addressBook.getAddres(1).contains("addr2test"));
		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "3206 - Payment - Logged in - Enter New Credit Card - set as default payment method.")
	public void TC3206_addNewCreditCard() {
//		SoftAssert softAssert = new SoftAssert();
//		newpig.homepage.addFeaturedProductToCart();
//		newpig.homepage.header_footer.goToCartPage();
//		newpig.cart.startCheckout();
//		System.out.println(newpig.checkout.loginRegister.isLoginAndCheckoutPage());
//
//		newpig.checkout.loginRegister.loginWithUser(testDataReader.getRndUser());
//
//		newpig.checkout.shippingAddress.selectFirstSavedAddressAndContinue();
//		newpig.checkout.shippingMethod.clickFirstShippingMeyhodAndContinue();
//		newpig.checkout.payment.enterNewCreditCard("Visa", "namenamsa", "41111111111111111", "01", "2017", true, true);
//		softAssert.assertAll();

		throw new SkipException("Feature not implemented yet");

	}
	
	@Test(groups = {"smoke"}, description = "4530 - Checkout - Not logged in User - Login and Checkout - fields validations")
	public void TC4530_loginAndCheckoutFieldsValidation() {
		SoftAssert softAssert = new SoftAssert();
		
		//add one product to cart
		newpig.homepage.addFeaturedProductToCart();
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "1");
		
		//go to checkout page
		newpig.cart.startCheckout();
		
		//Login with invalid format email and valid password
		newpig.checkout.loginRegister.loginWithUserAndPassword("invalidUser", "ValidPassword1");
		softAssert.assertTrue(newpig.checkout.loginRegister.invalidLoginErrorsDisplayed());
		
		//Login with valid email and incorrect password
		newpig.checkout.loginRegister.loginWithUserAndPassword(testDataReader.getRndUser(), "invalidPass");
		softAssert.assertTrue(newpig.checkout.loginRegister.invalidLoginErrorsDisplayed());
		
		//Leave both login and password as blank
		newpig.checkout.loginRegister.loginWithUserAndPassword("", "");
		softAssert.assertTrue(newpig.checkout.loginRegister.invalidLoginErrorsDisplayed());

		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "4559 - Checkout - Instructions - Logged in - Add delivery instructions")
	public void TC4559_specialDeliveryInstructions() {
		SoftAssert softAssert = new SoftAssert();

		//login
		TestDataReader reader = new TestDataReader();
		newpig.homepage.header.headerPopupLogin(reader.getUserByType("us_savedCreditCard_2"));

		//Add to cart at least one product.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "1");

		//go to checkout page
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();
		newpig.checkout.waitSeconds(2);
		newpig.checkout.shippingAddress.clickContinue();
		//check Special Shipping Instructions displayed
		softAssert.assertTrue(newpig.checkout.shippingMethod.isSpecialShippingInstrunctionsDisplayed());

		//insert text on Special Shipping Instructions field and continue with checkout
		String specialInstructions = "This is a test for special shipping instructions!";
		newpig.checkout.shippingMethod.fillSpecialShippingInstructions(specialInstructions);
		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();

		//add or select invoice and continue
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}

		//check the special shipping instructions are displayed on the order review page
		softAssert.assertTrue(newpig.checkout.orderReview.contentDisplaysText("Special Instructions: "+specialInstructions));

		//pleace order
		newpig.checkout.orderReview.acceptTermsAndPlaceOrder();

		//check the special shipping instructions are displayed on the order confirmation page
		softAssert.assertTrue(newpig.checkout.orderConfirmation.pageDisplaysText("Special Instructions: "+specialInstructions));
		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "Checkout - 4416\tDelivery Options - Logged in - Collect Shipping - Add New")
	public void TC4416_chekcoutDefineCollectCarier() {
		SoftAssert softAssert = new SoftAssert();

		//			4416	Delivery Options - Logged in - Collect Shipping - Add New

		String carierName = Utils.getRndString();
		String accNo = Utils.getRndString();

		newpig.homepage.header.headerPopupLogin(testDataReader.getRndUser());
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "2");
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();

		newpig.checkout.shippingMethod.addNewCollectCarier(carierName, accNo);

		newpig.checkout.shippingMethod.clickCollectShipping();

		softAssert.assertTrue(newpig.checkout.shippingMethod.isCollectCarrierPresent(carierName, accNo));


		softAssert.assertAll();
	}

	@Test(groups = {"smoke"}, description = "4402 - Checkout - Delivery Options - Logged in - Check delivery options - Free shipping code")
	public void TC4402_freeShippingCodeDeliveryOptions() {
		SoftAssert softAssert = new SoftAssert();

		//login
		TestDataReader reader = new TestDataReader();
		newpig.homepage.header.headerPopupLogin(reader.getUserByType("us_savedCreditCard_2"));

		//Add to cart at least one product.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd("MAT230", "1");

		//Apply a Free shipping promo code
		newpig.cart.removeDeal();
		newpig.cart.applyValidCouponCode("99028");
		softAssert.assertTrue(newpig.cart.isFreeItemDisplayed());

		//go to checkout page
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();


		//check no Delivery options are displayed. FREE shipping is displayed instead
		softAssert.assertTrue(newpig.checkout.shippingMethod.freeShippingDisplayed());
		System.out.println(newpig.checkout.shippingMethod.freeShippingDisplayed());
		softAssert.assertFalse(newpig.checkout.shippingMethod.deliveryMethodsDisplayed());
		System.out.println(newpig.checkout.shippingMethod.deliveryMethodsDisplayed());

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Checkout - 2285\tShipments - Logged in - Check split shipment")
	public void TC2285_chekcoutSplitShippment() {
		SoftAssert softAssert = new SoftAssert();

		//	2285	Shipments - Logged in - Check split shipment
//		Log in. (US / CA / FED user).
		newpig.homepage.header.headerPopupLogin(testDataReader.getUserByType("splitShippment"));

//		Go to Cart
		newpig.homepage.header.goToCartPage();

//		Add products to cart that will trigger split shippment
		newpig.cart.quickAdd("DRM584", "2");
		newpig.cart.quickAdd("PIG233", "2");
		newpig.cart.quickAdd("ELS221", "2");

//		Proceed to Checkout through Delivery Options.
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();

//		Check if the shipment is splitted.
//		Check if number of products in each shipment is displayed.
//		Check if Product name and Information section is displayed for each shipment.
		softAssert.assertTrue(newpig.checkout.shippingMethod.checkSplitShippment(),
				"Checking each shippment has the desired elements present");


		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Checkout - 3352\tPayment - Guest - Send Invoice as my Payment Method")
	public void TC3352_checkoutGuestSendInvoice() {
		SoftAssert softAssert = new SoftAssert();

//		Go to Cart
		newpig.homepage.header.goToCartPage();

//		Add any product to cart
		newpig.cart.quickAdd("PIG233", "2");

//		Proceed to Checkout through Delivery Options.
		newpig.cart.startCheckout();
		newpig.checkout.loginRegister.continueAsGuest();

		//Proceed to Checkout through Payment methods.
		//fill in with random email and valid address
		String email = "mail"+ Utils.getRndString(4)+"@mailinator.com";
		AddressPojo addressPojo = new AddressPojo();
		addressPojo.setEmail(email);
		addressPojo.setFirstName("First-Name");
		addressPojo.setLastName("Last-Name");
		addressPojo.setCompany("testCompany");
		addressPojo.setAddr1("test address 1");
		addressPojo.setZip("90210");
		addressPojo.setPhone("0987654321");
		newpig.checkout.shippingAddress.addressForm.fillAddressForm(addressPojo);
		newpig.checkout.shippingAddress.waitSeconds(2);
		newpig.checkout.shippingAddress.clickContinue();

		//select shipping method and continue
		newpig.checkout.waitSeconds(5);
		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();

		//select a valid invoice address
		newpig.checkout.payment.selectSendInvoice();
		newpig.checkout.payment.enterNewValidInvoiceAndContinue();

		//check that the payment type on order review is Invoice payment
		softAssert.assertTrue(newpig.checkout.orderReview.contentDisplaysText("Invoice Payment"),"Invoice Payment displayed");

		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "Checkout - 4528\tCheckout - Not logged in User - Login and Checkout - normal flow.")
	public void TC4528_loginAndCheckoutNormalFlow() {
		SoftAssert softAssert = new SoftAssert();
		String product = "PIG233";
		String qty = "2";

		//Go to Cart
		newpig.homepage.header.goToCartPage();

		//Add any product to cart
		newpig.cart.quickAdd(product, qty);

		//Proceed to Checkout through Delivery Options.
		newpig.cart.startCheckout();

		User user = testDataReader.getUserByType("us_1");
		newpig.checkout.loginRegister.loginWithUser(user);

		//Proceed with full checkout
		//If user has products in cart check to see if cart contains the added product
		if (newpig.cart.isPageDisplayed()){
			softAssert.assertTrue(newpig.cart.getAlertWarningMessage().contains("Welcome back"));
			softAssert.assertTrue(newpig.cart.productsTable.containsItemWithCode(product),"Added Item is displayed in cart");
			newpig.cart.startCheckout();
		}

		//Check that user is redirected to Checkout Shipping Address step
		softAssert.assertTrue(newpig.checkout.shippingAddress.isShippingAddressStepActive(),"Shipping Address step active");
		newpig.checkout.shippingAddress.clickContinue();
		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}

		//Check that the added item is visible in order review page
		softAssert.assertTrue(newpig.checkout.orderReview.orderContainsItemWithCode(product),"Added Item is displayed in order review");
		newpig.checkout.orderReview.acceptTermsAndPlaceOrder();

		//check the confirmation page displays the added item
		softAssert.assertTrue(newpig.checkout.orderConfirmation.pageDisplaysText("Product Code: "+product));
		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "4335 - Checkout - Review Order - Any user - Complete Order option")
	public void TC4335_orderReviewCompleteOrderOption() {
		SoftAssert softAssert = new SoftAssert();

		String product = "MAT230";
		String qty = "1";
		//login
		TestDataReader reader = new TestDataReader();
		newpig.homepage.header.headerPopupLogin(reader.getUserByType("us_savedCreditCard_2"));

		//Got to cart and add to cart at least one product.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd(product , qty);

		//proceed with checkout through last step
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();

		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();

		//add or select invoice and continue
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}

		//check that Complete Order options is available and finish order
		softAssert.assertTrue(newpig.checkout.orderReview.isCompleteOrderButtonDisplayed(),"Complete Order button displayed");
		newpig.checkout.orderReview.acceptTermsAndPlaceOrder();

		//check the confirmation page is displayed
		softAssert.assertTrue(newpig.checkout.orderConfirmation.pageDisplaysText("Product Code: "+product));
		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "4447 - Checkout - Review Order - Any user - Edit shipping method")
	public void TC4447_orderReviewEditShippingMethod() {
		SoftAssert softAssert = new SoftAssert();

		String product = "MAT230";
		String qty = "1";
		//login
		TestDataReader reader = new TestDataReader();
		newpig.homepage.header.headerPopupLogin(reader.getUserByType("us_savedCreditCard_2"));

		//Got to cart and add to cart at least one product.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd(product , qty);

		//proceed with checkout through last step
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();

		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();

		//add or select invoice and continue
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}

		//check that the edit shipping method link is available and click on it
		softAssert.assertTrue(newpig.checkout.orderReview.isEditShippingMethodLinkDisplayed(),"Edit Shipping Method link displayed");
		newpig.checkout.orderReview.clickEditShippingMethod();

		//verify that the shipping method page is displayed
		softAssert.assertTrue(newpig.checkout.shippingMethod.deliveryMethodsDisplayed(),"Shipping method page displayed");

		//select another shipping method (second method) and proceed
		String editedDeliveryMethod = newpig.checkout.shippingMethod.getDeliveryMethodTextByIndex(1);
		newpig.checkout.shippingMethod.clcikSecondShiinppingMeyhodAndContinue();
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}
		newpig.checkout.payment.clickContinue();

		//check that the edited shipping method is displayed and place order
		softAssert.assertTrue(newpig.checkout.orderReview.getShippingMethodSummary().contains(editedDeliveryMethod));
		newpig.checkout.orderReview.acceptTermsAndPlaceOrder();

		//check the confirmation page is displayed
		softAssert.assertTrue(newpig.checkout.orderConfirmation.pageDisplaysText("Product Code: "+product));
		softAssert.assertAll();
	}


	@Test(groups = {"smoke"}, description = "4462 - Checkout - Review Order - Any user - checl 2nd Complete Order option")
	public void TC4462_orderReviewSecondCompleteOrderOption() {
		SoftAssert softAssert = new SoftAssert();

		String product = "MAT230";
		String qty = "1";
		//login
		TestDataReader reader = new TestDataReader();
		newpig.homepage.header.headerPopupLogin(reader.getUserByType("us_savedCreditCard_2"));

		//Got to cart and add to cart at least one product.
		newpig.homepage.header.goToCartPage();
		newpig.cart.quickAdd(product , qty);

		//proceed with checkout through last step
		newpig.cart.startCheckout();
		newpig.checkout.shippingAddress.clickContinue();

		newpig.checkout.shippingMethod.clcikFirstShiinppingMeyhodAndContinue();

		//add or select invoice and continue
		newpig.checkout.payment.selectSendInvoice();
		if (newpig.checkout.payment.userHasSavedInvoice()) {
			newpig.checkout.payment.clickContinue();
		}
		else {
			newpig.checkout.payment.enterNewValidInvoiceAndContinue();
		}

		//check that the Bottom Complete Order options is available and finish order
		softAssert.assertTrue(newpig.checkout.orderReview.isBottomCompleteOrderButtonDisplayed(),"Complete Order button displayed");
		newpig.checkout.orderReview.acceptTermsAndBottomCompleteOrder();

		//check the confirmation page is displayed
		softAssert.assertTrue(newpig.checkout.orderConfirmation.pageDisplaysText("Product Code: "+product));
		softAssert.assertAll();
	}




}
