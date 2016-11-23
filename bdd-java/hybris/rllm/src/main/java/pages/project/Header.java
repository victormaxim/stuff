package pages.project;

import ch.lambdaj.function.convert.Converter;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import net.thucydides.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ch.lambdaj.Lambda.convert;

public class Header extends PageObject {

	//Web Elements
	
    //Breadcrumbs
	private Map<String, WebElementFacade> breadcrumbsMap = new HashMap<String, WebElementFacade>();
    private boolean isInitialized = false;
    
    @FindBy(xpath=".//*[@id='breadcrumb']/ul/li/*[contains(text(),'Home')]")
    private WebElementFacade HomeBreadcrumbLink;
    
    //Search
    @FindBy(css="#search")
    private WebElementFacade searchBox;
    
    //Logo
    @FindBy(css=".header>.wrapper>.bottom-header [class*=bottom-left-header-content-slot]>.simple-banner-component>[href]")
    private WebElementFacade logoLink;
    
    //Top level navigation menu
    @FindBy(css=".navigation-content-slot")
    private WebElementFacade topLevelNavigationMenu;
    
    @FindBy(css=".navigation-content-slot>.navigation-bar-collection-component>.navigation-bar-component>.navigation-dropdown-button[title=Women]")
    private WebElementFacade topLevelNavigationWomenMenu;
    
    @FindBy(css=".navigation-content-slot>.navigation-bar-collection-component>.navigation-bar-component>.navigation-dropdown-button[title=Men]")
    private WebElementFacade topLevelNavigationMenMenu;
    
    @FindBy(css=".navigation-content-slot>.navigation-bar-collection-component>.navigation-bar-component>.navigation-dropdown-button[title=Brands]")
    private WebElementFacade topLevelNavigationBrandsMenu;
    
    //need to update href with actual url to Plp
    @FindBy(css=".navigation-content-slot>.navigation-bar-collection-component>.navigation-bar-component>a[title=Kids][href]")
    private WebElementFacade topLevelNavigationKidsMenu;
    
    //need to update href with actual url to Plp
    @FindBy(css=".navigation-content-slot>.navigation-bar-collection-component>.navigation-bar-component>a[title=Collections][href]")
    private WebElementFacade topLevelNavigationCollectionsMenu;
    
    //My Account
    //need to update href with actual url to page
    @FindBy(css=".icon-account")
    private WebElementFacade myAccountMenuIcon;
    
    //need to update href with actual url to page
    @FindBy(css=".my-account-dropdown>.top-header-menu>a[data-toggle=dropdown][href]")
    private WebElementFacade myAccountMenu;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Account Info')]")
    private WebElementFacade myAccountMenuAccountInfo;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Member Info')]")
    private WebElementFacade myAccountMenuMemberInfo;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Stored Addresses')]")
    private WebElementFacade myAccountMenuStoredAddresses;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Stored Credit Cards')]")
    private WebElementFacade myAccountMenuStoredCreditCards;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Order History')]")
    private WebElementFacade myAccountMenuOrderHistory;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'My Returns')]")
    private WebElementFacade myAccountMenuMyReturns;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'My Credit')]")
    private WebElementFacade myAccountMenuMyCredit;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '#')][contains(text(), 'Notification Settings')]")
    private WebElementFacade myAccountMenuNotificationSettings;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-account-dropdown']//*[contains(@href, '/ruelala/en/logout')][contains(text(), 'Sign Out')]")
    private WebElementFacade myAccountMenuLogout;
    
    //My Style
    @FindBy(css=".icon-spot")
    private WebElementFacade myStyleMenuIcon;
    
    //need to update href with actual url to page
    @FindBy(css=".my-style-dropdown>.top-header-menu>a[data-toggle=dropdown][href]")
    private WebElementFacade myStyleMenu;
    
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '/ruelala/en/mystyle/feed')][contains(text(), 'My Style Feed')]")
    private WebElementFacade myStyleMenuMyStyleFeed;
    
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '/ruelala/en/mystyle/products')][contains(text(), 'My Products')]")
    private WebElementFacade myStyleMenuMyProducts;
    
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '/ruelala/en/mystyle/brands')][contains(text(), 'My Brands')]")
    private WebElementFacade myStyleMenuMyBrands;
    
    //need to update href with actual url to page
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '#')][contains(text(), 'My Collections')]")
    private WebElementFacade myStyleMenuMyCollections;
    
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '/ruelala/en/mystyle/sizes')][contains(text(), 'My Sizes')]")
    private WebElementFacade myStyleMenuMySizes;
    
    @FindBy(xpath="//*[@id='my-style-dropdown']//*[contains(@href, '/ruelala/en/mystyle/searches')][contains(text(), 'My Searches')]")
    private WebElementFacade myStyleMenuMySearches;
    
    //Cart
    @FindBy(css="#cart-button")
    private WebElementFacade cartButton;
    
    @FindBy(css="#slide-out-cart")
    private WebElementFacade cart;
    
    //Ship free with rue 365
    @FindBy(css=".rue-365-link")
    private WebElementFacade rue365PromoLink;
    

	//Functions
    
    //General
	public void hoverMouse(WebElement element) {
		Actions action = new Actions(getDriver());	
		action.moveToElement(element).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action = null;
	}
        
    //Breadcrumbs
    public void init() {
    	
		breadcrumbsMap.put("Home", HomeBreadcrumbLink);
	}
    
    public void breadcrumbLinkClick(String breadcrumb) {
    	if (!isInitialized)
    		init(); 	
    	breadcrumbsMap.get(breadcrumb).click();
    }
    
    //Search
    public void searchBoxAppears() {
    	searchBox.shouldBeVisible();
    }
    
    public void searchTypeAndEnterKeyword(String keyword) {
    	searchBox.typeAndEnter(keyword);
    }
    
    //Logo
    public void logoClick() {
    	logoLink.click();
    }
    
    public void logoAppears() {
    	logoLink.shouldBeVisible();;
    }
    
    //Cart
    public void cartButtonAppears() {
    	cartButton.shouldBeVisible();
    }
    
    public void cartButtonClick() {
    	cartButton.click();;
    }
    
    public void cartAppears() {
    	cart.shouldBeVisible();
    }
    
    //RUE365 promo
    public void rue365PromoLinkAppears() {
    	rue365PromoLink.shouldBeVisible();
    }
    
    //Top level navigation
	public void topLevelNavigationMenuAppears() {
		topLevelNavigationMenu.shouldBeVisible();
	}
	
	public void topLevelNavigationMenuDoesntAppear() {
		topLevelNavigationMenu.shouldNotBeVisible();
	}

	public void topLevelNavigationMenMenuAppears() {
		topLevelNavigationMenMenu.shouldBeVisible();
	}
	
	public void topLevelNavigationWomenMenuAppears() {
		topLevelNavigationWomenMenu.shouldBeVisible();
	}
	
	public void topLevelNavigationKidsMenuAppears() {
		topLevelNavigationKidsMenu.shouldBeVisible();
	}
	
	public void topLevelNavigationBrandsMenuAppears() {
		topLevelNavigationBrandsMenu.shouldBeVisible();
	}
	
	public void topLevelNavigationCollectionsMenuAppears() {
		topLevelNavigationCollectionsMenu.shouldBeVisible();
	}
	
	//My Account
	public void myAccountHover() {
		hoverMouse(myAccountMenu);
	}
	
	public void myAccountMenuIconAppears() {
		myAccountMenuIcon.shouldBeVisible();
	}
	
	public void myAccountMenuAppears() {
		myAccountMenu.shouldBeVisible();
	}
	
	public void myAccountMenuDoesntAppear() {
		myAccountMenu.shouldNotBeVisible();
	}
	
	public void myAccountMenuAccountInfoAppears() {
		myAccountHover();
		myAccountMenuAccountInfo.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuMemberInfoAppears() {
		myAccountHover();
		myAccountMenuMemberInfo.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuStoredAddressesAppears() {
		myAccountHover();
		myAccountMenuStoredAddresses.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuStoredCreditCardsAppears() {
		myAccountHover();
		myAccountMenuStoredCreditCards.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuOrderHistoryAppears() {
		myAccountHover();
		myAccountMenuOrderHistory.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuMyReturnsAppears() {
		myAccountHover();
		myAccountMenuMyReturns.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuMyCreditAppears() {
		myAccountHover();
		myAccountMenuMyCredit.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuNotificationSettingsAppears() {
		myAccountHover();
		myAccountMenuNotificationSettings.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myAccountMenuLogoutAppears() {
		myAccountHover();
		myAccountMenuLogout.shouldBeVisible();
		hoverMouse(logoLink);
	}	
	
	public void myAccountMenuLogoutClick() {
		myAccountMenuLogout.click();
	}	
	
	//My Style
	public void myStyleHover() {
		hoverMouse(myStyleMenu);
	}
	
	public void myStyleMenuIconAppears() {
		myStyleMenuIcon.shouldBeVisible();
	}
	
	public void myStyleMenuAppears() {
		myStyleMenu.shouldBeVisible();
	}
	
	public void myStyleMenuDoesntAppear() {
		myStyleMenu.shouldNotBeVisible();
	}
	
	public void myStyleMenuMyStyleFeedAppears() {
		myStyleHover();
		myStyleMenuMyStyleFeed.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myStyleMenuMyProductsAppears() {
		myStyleHover();
		myStyleMenuMyProducts.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myStyleMenuMyProductsClick() {
		myStyleMenuMyProducts.click();
	}
	
	public void myStyleMenuMyBrandsAppears() {
		myStyleHover();
		myStyleMenuMyBrands.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myStyleMenuMyCollectionsAppears() {
		myStyleHover();
		myStyleMenuMyCollections.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myStyleMenuMySizesAppears() {
		myStyleHover();
		myStyleMenuMySizes.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
	public void myStyleMenuMySearchesAppears() {
		myStyleHover();
		myStyleMenuMySearches.shouldBeVisible();
		hoverMouse(logoLink);
	}
	
}
