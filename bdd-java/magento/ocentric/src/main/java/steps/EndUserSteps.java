package steps;

import pages.project.HomePage;
import pages.project.LoginPage;
import pages.project.Header;
import pages.generic.MagentoMessages;
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
    MagentoMessages magentoMessages;
    
    @Step
    public void isOnHomepage() {
    	homePage.open();
    }
    
    @Step
    public void clickOnLoginLinkFromHeader() {
    	header.loginLinkClick();;
    }
    
    @Step
 	public void login(String username, String password){
     	loginPage.fillUsernameLogin(username);
     	loginPage.fillPasswordLogin(password);
 		loginPage.submitLogin();
 	}
    
    @Step
    public void verifyWelcomeMessageFromHeader (String message) {
    	String welcomeMessage=header.getWelcomeMessage();
    	assertThat("Error message ("+message+") not found", welcomeMessage.equals(message));
    }

	public void errorMessage(String message) {
    	assertThat("Error message ("+message+") not found", magentoMessages.errorMessage().equals(message));
	}

}
