package regression;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

    @Given("the user is on homepage")
    public void givenTheUserIsOnHomePage() {
        endUser.isOnHomepage();
    }
    
    @Given("the user authenticates with '$username' and '$password'")
    public void givenTheUserAuthenticatesWithUsernameAndPassword(String username, String password) {
    	endUser.goToLoginPageFromHeader();
    	endUser.login(username, password);
    }
    
    @Then("the authenticated user should see account link with text '$message' in header")
    public void thenTheUserShouldSeeAccountLinkWithTextMessage(String message){
    	endUser.verifyWelcomeMessageHeaderAuthenticatedUser(message);
    }
    
    @Then("the user should see logout link in header")
    public void theUserShouldSeeLogoutLinkInHeader() {
    	endUser.logoutLinkFromHeaderIsVisible();
    }
    
    @When ("the user clicks on logout link from header")
    public void theUserClicksOnLogoutLinkFromHeader() {
    	endUser.logout();
    }
    
    @Then ("the user should see the login page with '$message' text")
    public void theUserShouldSeeTheLoginPageWithMyAccountLoginText(String message) {
    	endUser.verifyMyAccountText(message);
    }
    
    @Then("the user should not see account link with text '$message' in header")
    public void thenTheUserShouldNotSeeAccountLinkWithTextMessage(String message){
    	endUser.verifyNotWelcomeMessageHeader(message);
    }
}
