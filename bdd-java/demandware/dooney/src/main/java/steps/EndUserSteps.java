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
    
    @Step
    public void isOnHomepage() {
    	homePage.open();
    }
    
    @Step
    public void goToLoginPageFromHeader() {
    	header.loginLinkClick();;
    }
    
    @Step
 	public void login(String username, String password){
     	loginPage.fillUsernameLogin(username);
     	loginPage.fillPasswordLogin(password);
 		loginPage.submitLogin();
 	}
    
    @Step
    public void verifyWelcomeMessageHeaderAuthenticatedUser (String message) {
    	String welcomeMessage=header.getWelcomeText();
    	assertThat("Error message ("+message+")not found", welcomeMessage.equals(message));
    }
    
    @Step
    public void logoutLinkFromHeaderIsVisible() {
    	assertThat("Couldn't find Logout link from header", header.logoutLinkIsVisible());
    }
    
    @Step
    public void logout() {
    	header.logoutLinkClick();
    }
    
    @Step
    public void verifyMyAccountText (String message) {
    	String myAccountText=loginPage.getMyAccounLoginText();
    	assertThat("Cannot find ("+message+") on page", myAccountText.equals(message));
    }

	public void verifyNotWelcomeMessageHeader(String message) {
		String welcomeMessage=header.getWelcomeText();
    	assertThat("Error message ("+message+")not found", !welcomeMessage.equals(message));
	}

}
