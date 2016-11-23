package steps;

import org.openqa.selenium.WebElement;

import pages.generic.HybrisGlobalMessages;
import pages.project.*;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static ch.lambdaj.Lambda.join;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps extends ScenarioSteps {

	HybrisGlobalMessages hybrisGlobalMessages;
    LoginPage loginPage;
    HomePage homePage;
    Header header;
    PlpPage plpPage;
    PdpPage pdpPage;
    BrandLandingPage brandLandingPage;
    BrandListPage brandListPage;
    CollectionsPage collectionsPage;
    MyAccountPage myAccountPage;
    MyStylePage myStylePage;
    MyStyleMyProductsPage myStyleMyProductsPage;
    CheckoutPage checkoutPage;
    
    //General
    public void loginErrorMessageCheck() {
    	hybrisGlobalMessages.errorMessageDoesntAppear();
    }
    
    
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
    
    @Step
	public void headerTopLevelNavigationMenuAppears() {
    	header.topLevelNavigationMenuAppears();
    	header.topLevelNavigationMenMenuAppears();
    	header.topLevelNavigationWomenMenuAppears();
    	header.topLevelNavigationKidsMenuAppears();
    	header.topLevelNavigationBrandsMenuAppears();
    	header.topLevelNavigationCollectionsMenuAppears();
	}
    
    @Step
	public void headerMyAccountMenuAppears() {
    	header.myAccountMenuAccountInfoAppears();
    	header.myAccountMenuIconAppears();
    	header.myAccountMenuAppears();
    	header.myAccountMenuAccountInfoAppears();
    	header.myAccountMenuMemberInfoAppears();
    	header.myAccountMenuStoredAddressesAppears();
    	header.myAccountMenuStoredCreditCardsAppears();
    	header.myAccountMenuOrderHistoryAppears();
    	header.myAccountMenuMyReturnsAppears();
    	header.myAccountMenuMyCreditAppears();
    	header.myAccountMenuNotificationSettingsAppears();
    	header.myAccountMenuLogoutAppears();
	}
    
    @Step
	public void headerMyStyleMenuAppears() {
    	header.myStyleMenuIconAppears();
    	header.myStyleMenuAppears();
    	header.myStyleMenuMyStyleFeedAppears();
    	header.myStyleMenuMyProductsAppears();
    	header.myStyleMenuMyBrandsAppears();
    	header.myStyleMenuMyCollectionsAppears();
    	header.myStyleMenuMySizesAppears();
    	header.myStyleMenuMySearchesAppears();
	}
    
    @Step
    public void headerCartButtonAppears() {
    	header.cartButtonAppears();
    }
    
    @Step
    public void headerCartButtonClick() {
    	header.cartButtonClick();
    }
    
    @Step
    public void headerCartAppears() {
    	header.cartAppears();
    }
    
    @Step
    public void headerSearchBoxAppears() {
    	header.searchBoxAppears();
    }
    
    @Step
    public void headerRue365PromoLinkAppears() {
    	header.rue365PromoLinkAppears();
    }
    
    @Step
    public void headerLogoAppears() {
    	header.logoAppears();
    }
    
    @Step
    public void headerHoverMyAccountMenu() {
    	header.myAccountHover();
    }
    
    @Step
    public void headerHoverMyStyleMenu() {
    	header.myStyleHover();
    }
    
    @Step
    public void headerWomenTopLevelCategoryAppears() {
    	header.topLevelNavigationWomenMenuAppears();
    }
    
    @Step
    public void headerMenTopLevelCategoryAppears() {
    	header.topLevelNavigationMenMenuAppears();
    }
    
    @Step
    public void headerKidsTopLevelCategoryAppears() {
    	header.topLevelNavigationKidsMenuAppears();
    }
    
    @Step
    public void headerBrandsTopLevelCategoryAppears() {
    	header.topLevelNavigationBrandsMenuAppears();
    }
    
    @Step
    public void headerCollectionsTopLevelCategoryAppears() {
    	header.topLevelNavigationCollectionsMenuAppears();
    }
	public void verifyHomepageWelcomeBannerIsVisible () {
    	assertThat("Homepage welcome banner is not visible", homePage.welcomeBannerIsVisible());
	}
	
	public void verifyHomepageMyStyleGuestUserBannerIsVisible () {
    	assertThat("Homepage My Style banner for guest user is not visible", homePage.myStyleBannerGuestUserIsVisible());
	}
	
	public void clickMyStyleBannerAuthenticatedUser(){
		homePage.myStyleBannerAuthenticatedUserClick();
	}
	
	public void verifyHomepageMyStyleAuthenticatedUserBannerIsVisible () {
    	assertThat("Homepage My Style banner for authenticated user is not visible", homePage.myStyleBannerAuthenticatedUserIsVisible());
	}
    
    
    //Header
    @Step
    public void headerMyAccountAccountInfoAppears() {
    	header.myAccountMenuAccountInfoAppears();
    }
    
	public void searchForKeyword (String keyword) {
		header.searchTypeAndEnterKeyword(keyword);
	}
	
	public void clickLogoFromHeader() {
		header.logoClick();
	}
	
	public void clickBreadcrumb(String breadcrumb) {
		header.breadcrumbLinkClick(breadcrumb);
	}


    //Login page
    @Step
    public void headerMyAccountMemberInfoAppears() {
    	header.myAccountMenuMemberInfoAppears();
    }

    @Step
    public void headerMyAccountStoredAddressesAppears() {
    	header.myAccountMenuStoredAddressesAppears();
    }
    
    @Step
    public void headerMyAccountStoredCreditCardsAppears() {
    	header.myAccountMenuStoredCreditCardsAppears();
    }
    
    @Step
    public void headerMyAccountOrderHistoryAppears() {
    	header.myAccountMenuOrderHistoryAppears();
    }
    
    @Step
    public void headerMyAccountMyReturnsAppears() {
    	header.myAccountMenuMyReturnsAppears();
    }

    @Step
    public void headerMyAccountMyCreditAppears() {
    	header.myAccountMenuMyCreditAppears();
    }
    
    @Step
    public void headerMyAccountNotificationSettingsAppears() {
    	header.myAccountMenuNotificationSettingsAppears();
    }
    
    @Step
    public void headerMyAccountLogoutAppears() {
    	header.myAccountMenuLogoutAppears();
    }
    
    @Step
    public void headerMyStyleMyStyleFeedAppears() {
    	header.myStyleMenuMyStyleFeedAppears();
    }
    
    @Step
    public void headerMyStyleMyProductsAppears() {
    	header.myStyleMenuMyProductsAppears();
    }
    
    @Step
    public void headerMyStyleMyBrandsAppears() {
    	header.myStyleMenuMyBrandsAppears();
    }
    
    @Step
    public void headerMyStyleMyCollectionsAppears() {
    	header.myStyleMenuMyCollectionsAppears();
    }
    
    @Step
    public void headerMyStyleMySizesAppears() {
    	header.myStyleMenuMySizesAppears();
    }
    
    @Step
    public void headerMyStyleMySearchesAppears() {
    	header.myStyleMenuMySearchesAppears();
    }
    
    @Step
    public void headerMyAccountLogoutClick() {
    	header.myAccountHover();
    	header.myAccountMenuLogoutClick();
    }
    
    @Step
    public void headerTopLevelNavigationDoesntAppear() {
    	header.topLevelNavigationMenuDoesntAppear();
    }
    
    @Step
    public void headerMyAccountDoesntAppear() {
    	header.myAccountMenuDoesntAppear();
    }
    
    @Step
    public void headerMyStyleDoesntAppear() {
    	header.myStyleMenuDoesntAppear();
    }
    
    //Login page
    @Step
 	public void login(String username, String password){
     	loginPage.fillUsernameLogin(username);
     	loginPage.fillPasswordLogin(password);
 		loginPage.submitLogin();
 	}
    
    @Step
    public void loginPageAppears() {
    	loginPage.loginHeadlineAppears();
    	loginPage.userInputAppears();
    	loginPage.passwordInputAppears();
    	loginPage.submitButtonAppears();
    }
    
    //PLP
    @Step
    public void isOnPlp() {
    	plpPage.open();  	
    }
    
    //PDP
    @Step
    public void isOnPdp() {
    	pdpPage.open();  	
    }
    
    public void pdpAddToCart() {
    	pdpPage.addToCartButtonClick();
    }
    
    //Brand Landing
    @Step
    public void isOnBrandLanding() {
    	brandLandingPage.open();  	
    }
    
    //Brand List
    @Step
    public void isOnBrandList() {
    	brandListPage.open();  	
    }
    
    //Collections
    @Step
    public void isOnCollections() {
    	collectionsPage.open();  	
    }
    
    //My Account
    @Step
    public void isOnMyAccount() {
    	myAccountPage.open();  	
    }
    
    //My Style
    @Step
    public void isOnMyStyle() {
    	myStylePage.open();  	
    }
    
    public void myStyleMyProductPageAppears() {
    	myStyleMyProductsPage.myProductPageAppears();
    }
    
    //Checkout
    public void isOnCheckout() {
    	checkoutPage.open();  	
    }
}
