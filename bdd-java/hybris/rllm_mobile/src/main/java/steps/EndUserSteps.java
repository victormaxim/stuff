package steps;

import pages.project.HomePage;
import pages.project.LoginPage;
import pages.project.Header;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

 	LoginPage loginPage;
    HomePage homePage;
    Header header;
	    
	    
	//Homepage
    @Step
    public void isOnHomepage() {
    	homePage.open();  	
    }
    
    @Step
	public void homepageWelcomeBannerAppears() {
		homePage.welcomeBannerAppears();
	}
	
    @Step
	public void homepageMyStyleBannerClick(){
		homePage.myStyleFeedBannerClick();
	}
	
    @Step
	public void homepageMyStyleFeedBannerAppears() {
		homePage.myStyleFeedBannerAppears();	
	}
	
    @Step
	public void homepageMyStyleFeedAppears() {
		homePage.myStyleFeedHeaderAppears();
		homePage.myStyleFeedProductsAppears();
		homePage.myStyleFeedBannerAppears();	
	}
	
    @Step
	public void homepageBrandBannerClick() {
		homePage.brandBannerClick();
	}
	
    @Step
	public void homepageBrandBannerAppears() {
		homePage.brandBannerAppears();
	}
	
	@Step
	public void homepageCollectionBannerClick() {
		homePage.collectionBannerClick();
	}
	
	@Step
	public void homepageCollectionBannerAppears() {
		homePage.collectionBannerAppears();
	}
    
    //Header
    @Step
	public void searchForKeyword(String keyword) {
		header.searchTypeAndEnterKeyword(keyword);
	}
	
    @Step
	public void headerClickLogo() {
		header.logoClick();
	}
	
    @Step
	public void headerClickBreadcrumb(String breadcrumb) {
		header.breadcrumbLinkClick(breadcrumb);
	}


    //Login page
    @Step
 	public void login(String username, String password){
     	loginPage.fillUsernameLogin(username);
     	loginPage.fillPasswordLogin(password);
 		loginPage.submitLogin();
 	}

}
