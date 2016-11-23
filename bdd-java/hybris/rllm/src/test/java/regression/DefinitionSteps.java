package regression;

import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.WebElementFacade;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebElement;

import steps.EndUserSteps;

public class DefinitionSteps {
	private Map<String, String> givenTheUserIsOnPageMap = new HashMap<String, String>();
	private Map<String, String> whenTheUserClicksOnElementMap = new HashMap<String, String>();
	private Map<String, String> thenTheUserShouldSeeElementMap = new HashMap<String, String>();
	private Map<String, String> whenTheUserHoversOverElementMap = new HashMap<String, String>();
	private Map<String, String> thenTheUserShouldNotSeeElementMap = new HashMap<String, String>();
    private boolean isInitialized = false;
    	
    public void init() {
    	isInitialized = true;
    	//Maps between strings in scenario definitions and corresponding methods
		givenTheUserIsOnPageMap.put("Homepage".toLowerCase(), "isOnHomepage");
		givenTheUserIsOnPageMap.put("Plp".toLowerCase(), "isOnPlp");
		givenTheUserIsOnPageMap.put("Pdp".toLowerCase(), "isOnPdp");
		givenTheUserIsOnPageMap.put("My Account".toLowerCase(), "isOnMyAccount");
		givenTheUserIsOnPageMap.put("Brand Landing".toLowerCase(), "isOnBrandLanding");
		givenTheUserIsOnPageMap.put("Brand List".toLowerCase(), "isOnBrandList");
		givenTheUserIsOnPageMap.put("Collections".toLowerCase(), "isOnCollections");
		givenTheUserIsOnPageMap.put("My Style".toLowerCase(), "isOnMyStyle");
		givenTheUserIsOnPageMap.put("Checkout".toLowerCase(), "isOnCheckout");
		
		whenTheUserClicksOnElementMap.put("account info from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("member info from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("store addresses from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("stored credit cards from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("order history from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("my returns from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("my credit from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("notifications settings from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("MyStyle banner for authenticated user".toLowerCase(), "homepageMyStyleBannerClick");
		whenTheUserClicksOnElementMap.put("Logo from header".toLowerCase(), "headerClickLogo");
		whenTheUserClicksOnElementMap.put("Bag link from header".toLowerCase(), "headerCartButtonClick");
		whenTheUserClicksOnElementMap.put("My Products from My Style menu".toLowerCase(), "headerMyStyleMyProductsClick");
		whenTheUserClicksOnElementMap.put("Logout from My Account menu".toLowerCase(), "headerMyAccountLogoutClick");
		
		whenTheUserHoversOverElementMap.put("My Account menu".toLowerCase(), "headerHoverMyAccountMenu");
		whenTheUserHoversOverElementMap.put("My Style menu".toLowerCase(), "headerHoverMyStyleMenu");
    	
    	thenTheUserShouldSeeElementMap.put("Welcome banner".toLowerCase(), "homepageWelcomeBannerAppears");
    	thenTheUserShouldSeeElementMap.put("Men category banner link".toLowerCase(), "");
    	thenTheUserShouldSeeElementMap.put("Womens category banner link".toLowerCase(), "");
    	thenTheUserShouldSeeElementMap.put("Kids category banner link".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("Brand banner link".toLowerCase(), "homepageBrandBannerAppears");
		thenTheUserShouldSeeElementMap.put("Collection banner link".toLowerCase(), "homepageCollectionBannerAppears");
		thenTheUserShouldSeeElementMap.put("My Style feed".toLowerCase(), "homepageMyStyleFeedAppears");
		thenTheUserShouldSeeElementMap.put("My Style page".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("My Style banner".toLowerCase(), "homepageMyStyleFeedBannerAppears");
		thenTheUserShouldSeeElementMap.put("Top level navigation menu".toLowerCase(), "headerTopLevelNavigationMenuAppears");
		thenTheUserShouldSeeElementMap.put("My Account menu".toLowerCase(), "headerMyAccountMenuAppears");
		thenTheUserShouldSeeElementMap.put("My Style menu".toLowerCase(), "headerMyStyleMenuAppears");
		thenTheUserShouldSeeElementMap.put("Rue365 promo link".toLowerCase(), "headerRue365PromoLinkAppears");
		thenTheUserShouldSeeElementMap.put("Cart icon".toLowerCase(), "headerCartButtonAppears");
		thenTheUserShouldSeeElementMap.put("Search box".toLowerCase(), "headerSearchBoxAppears");
		thenTheUserShouldSeeElementMap.put("Logo from header".toLowerCase(), "headerLogoAppears");
		thenTheUserShouldSeeElementMap.put("Shopping cart".toLowerCase(), "headerCartAppears");
		thenTheUserShouldSeeElementMap.put("My Products page".toLowerCase(), "myStyleMyProductPageAppears");
		thenTheUserShouldSeeElementMap.put("Women top level category".toLowerCase(), "headerWomenTopLevelCategoryAppears");
		thenTheUserShouldSeeElementMap.put("Men top level category".toLowerCase(), "headerMenTopLevelCategoryAppears");
		thenTheUserShouldSeeElementMap.put("Kids top level category".toLowerCase(), "headerKidsTopLevelCategoryAppears");
		thenTheUserShouldSeeElementMap.put("Brands top level category".toLowerCase(), "headerBrandsTopLevelCategoryAppears");
		thenTheUserShouldSeeElementMap.put("Collections top level category".toLowerCase(), "headerCollectionsTopLevelCategoryAppears");
		thenTheUserShouldSeeElementMap.put("Account Info".toLowerCase(), "headerMyAccountAccountInfoAppears");
		thenTheUserShouldSeeElementMap.put("Member Info".toLowerCase(), "headerMyAccountMemberInfoAppears");
		thenTheUserShouldSeeElementMap.put("Stored Addresses".toLowerCase(), "headerMyAccountStoredAddressesAppears");
		thenTheUserShouldSeeElementMap.put("Stored Credit Cards".toLowerCase(), "headerMyAccountStoredCreditCardsAppears");
		thenTheUserShouldSeeElementMap.put("Order History".toLowerCase(), "headerMyAccountOrderHistoryAppears");
		thenTheUserShouldSeeElementMap.put("My Returns".toLowerCase(), "headerMyAccountMyReturnsAppears");
		thenTheUserShouldSeeElementMap.put("My Credit".toLowerCase(), "headerMyAccountMyCreditAppears");
		thenTheUserShouldSeeElementMap.put("Notification Settings".toLowerCase(), "headerMyAccountNotificationSettingsAppears");
		thenTheUserShouldSeeElementMap.put("Logout link".toLowerCase(), "headerMyAccountLogoutAppears");
		thenTheUserShouldSeeElementMap.put("My Style Feed".toLowerCase(), "headerMyStyleMyStyleFeedAppears");
		thenTheUserShouldSeeElementMap.put("My Products".toLowerCase(), "headerMyStyleMyProductsAppears");
		thenTheUserShouldSeeElementMap.put("My Brands".toLowerCase(), "headerMyStyleMyBrandsAppears");
		thenTheUserShouldSeeElementMap.put("My Collections".toLowerCase(), "headerMyStyleMyCollectionsAppears");
		thenTheUserShouldSeeElementMap.put("My Sizes".toLowerCase(), "headerMyStyleMySizesAppears");
		thenTheUserShouldSeeElementMap.put("My Searches".toLowerCase(), "headerMyStyleMySearchesAppears");
		thenTheUserShouldSeeElementMap.put("Login page".toLowerCase(), "loginPageAppears");

		thenTheUserShouldNotSeeElementMap.put("Top level navigation menu".toLowerCase(), "headerTopLevelNavigationDoesntAppear");
		thenTheUserShouldNotSeeElementMap.put("My Account menu".toLowerCase(), "headerMyAccountDoesntAppear");
		thenTheUserShouldNotSeeElementMap.put("My Style menu".toLowerCase(), "headerMyStyleDoesntAppear");

	}
    
    @Steps
    EndUserSteps endUser;
    
    //General
    
    @Given("the user is on '$element' page")
    @When("the user is on '$element' page")
    public void givenTheUserIsOnPage(String element) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + element + " in givenTheUserIsOnPageMap", givenTheUserIsOnPageMap.keySet().contains(element.toLowerCase()));	
    	//Verify that there is method assigned for the given key
		String methodName = givenTheUserIsOnPageMap.get(element.toLowerCase());
		assertThat("Method is not defined for " + element, !"".equals(methodName));	
    	try {
			endUser.getClass().getMethod(methodName).invoke(endUser);
		} catch (IllegalAccessException e)  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Throwable cause = e.getCause();
		    System.err.format("Error encoutered", cause.getMessage());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    @When("the user clicks on '$element'")
    public void whenTheUserClicksOnElement(String element) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + element + " in whenTheUserClicksOnElementMap", whenTheUserClicksOnElementMap.keySet().contains(element.toLowerCase()));
    	//Verify that there is method assigned for the given key
		String methodName = whenTheUserClicksOnElementMap.get(element.toLowerCase());
		assertThat("Method is not defined for " + element, !"".equals(methodName));	
    	try {
			endUser.getClass().getMethod(methodName).invoke(endUser);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    @Then("the user should see '$element'")
    public void thenTheUserShouldSeeElement(String element) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + element + " in thenTheUserShouldSeeElementMap", thenTheUserShouldSeeElementMap.keySet().contains(element.toLowerCase()));	
    	//Verify that there is method assigned for the given key
		String methodName = thenTheUserShouldSeeElementMap.get(element.toLowerCase());
		assertThat("Method is not defined for " + element, !"".equals(methodName));	
    	try {
	    	endUser.getClass().getMethod(methodName).invoke(endUser);
    	} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    @Then("the user shouldn't see '$element'")
    public void thenTheUserShouldNotSeeElement(String element) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + element + " in thenTheUserShouldNotSeeElementMap", thenTheUserShouldNotSeeElementMap.keySet().contains(element.toLowerCase()));	
    	//Verify that there is method assigned for the given key
		String methodName = thenTheUserShouldNotSeeElementMap.get(element.toLowerCase());
		assertThat("Method is not defined for " + element, !"".equals(methodName));	
    	try {
    		endUser.getClass().getMethod(methodName).invoke(endUser);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
    }
    
    @When("the user hovers over '$element'") 
    public void whenTheUserHoversOverElement(String element) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + element + " in whenTheUserHoversOverElementMap", whenTheUserHoversOverElementMap.keySet().contains(element.toLowerCase()));	
    	//Verify that there is method assigned for the given key
		String methodName = whenTheUserHoversOverElementMap.get(element.toLowerCase());
		assertThat("Method is not defined for " + element, !"".equals(methodName));	
    	try {
    		endUser.getClass().getMethod(methodName).invoke(endUser);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    //Homepage
    
    //Login
    @Given("the user authenticates with '$username' and '$password'")
    public void givenTheUserAuthenticatesWithUsernameAndPassword(String username, String password) {
        endUser.isOnHomepage();
    	endUser.login(username, password);
    	endUser.loginErrorMessageCheck();
    }
    
    //Header
    @When("the user searches for '$keyword'")
    public void whenTheUserSearchesForKeyword(String keyword){
    	endUser.searchForKeyword(keyword);
    }
    
    @When("the user clicks on '$breadcrumb' link from breadcrumbs")
    public void whenTheUserClicksOnBreadcrumbLink(String breadcrumb) {
    	endUser.headerClickBreadcrumb(breadcrumb);
    }

    //PDP
    @When("the user adds product to cart from PDP")
    public void whenTheUserAddsProductToCartFromPdp() {
    	endUser.pdpAddToCart();
    }
    

}

