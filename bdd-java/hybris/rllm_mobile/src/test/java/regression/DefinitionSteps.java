package regression;

import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import steps.EndUserSteps;

public class DefinitionSteps {

	private Map<String, String> givenTheUserIsOnPageMap = new HashMap<String, String>();
	private Map<String, String> whenTheUserClicksOnElementMap = new HashMap<String, String>();
	private Map<String, String> thenTheUserShouldSeeElementMap = new HashMap<String, String>();
	private Map<String, String> thenTheUserShouldNotSeeElementMap = new HashMap<String, String>();
    private boolean isInitialized = false;
	
    public void init() {
    	//Maps between strings in scenario definitions and corresponding methods
		givenTheUserIsOnPageMap.put("Homepage".toLowerCase(), "isOnHomepage");
		givenTheUserIsOnPageMap.put("Brand Landing".toLowerCase(), "isOnBrandLanding");
		givenTheUserIsOnPageMap.put("Brand List".toLowerCase(), "isOnBrandList");
		
		whenTheUserClicksOnElementMap.put("account info from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("member info from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("store addresses from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("stored credit cards from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("order history from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("my returns from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("my credit from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("notifications settings from my account menu".toLowerCase(), "");
		whenTheUserClicksOnElementMap.put("MyStyle banner for authenticated user".toLowerCase(), "homepageMyStyleBannerClick");
		whenTheUserClicksOnElementMap.put("logo from header".toLowerCase(), "headerClickLogo");
    	
    	thenTheUserShouldSeeElementMap.put("Welcome banner".toLowerCase(), "homepageWelcomeBannerAppears");
    	thenTheUserShouldSeeElementMap.put("Men category banner link".toLowerCase(), "");
    	thenTheUserShouldSeeElementMap.put("Womens category banner link".toLowerCase(), "");
    	thenTheUserShouldSeeElementMap.put("Kids category banner link".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("5 featured brands".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("Featured collections".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("My Style feed".toLowerCase(), "homepageMyStyleFeedAppears");
		thenTheUserShouldSeeElementMap.put("My Style page".toLowerCase(), "");
		thenTheUserShouldSeeElementMap.put("My Style banner".toLowerCase(), "homepageMyStyleFeedBannerAppears");
		
		thenTheUserShouldNotSeeElementMap.put("".toLowerCase(), "");

	}
    
    @Steps
    EndUserSteps endUser;
    
    //General
    
    @Given("the user is on '$name' page")
    public void givenTheUserIsOnPage(String name) {
    	//Initialize maps
    	if (!isInitialized)
    		init(); 
    	//Verify that the string/strings have a match in MAP
    	assertThat("No key found with " + name + " in givenTheUserIsOnPageMap", givenTheUserIsOnPageMap.keySet().contains(name.toLowerCase()));	
    	//Verify that there is method assigned for the given key
		String methodName = givenTheUserIsOnPageMap.get(name.toLowerCase());
		assertThat("Method is not defined for " + name, !"".equals(methodName));	
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
    
    //Homepage
    
    //Login
    @Given("the user authenticates with '$username' and '$password'")
    public void givenTheUserAuthenticatesWithUsernameAndPassword(String username, String password) {
        endUser.isOnHomepage();
    	endUser.login(username, password);
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
}
