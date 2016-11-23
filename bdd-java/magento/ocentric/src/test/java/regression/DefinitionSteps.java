package regression;

import net.thucydides.core.annotations.Steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import steps.EndUserSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUser;

  //login.story

    @Given("the user is on homepage")
    public void theUserIsOnHomePage() {
        endUser.isOnHomepage();
    }   
    
    @When("the user clicks on login link from header")
    public void theUserClicksOnLoginLinkFromHeader() {
    	endUser.clickOnLoginLinkFromHeader();
    }
    
    @When("the user enters '$username' and '$password' in the login form")
    public void theUserEntersUsernameAndPasswordInTheLoginForm(String username, String password) {
    	endUser.login(username, password);
    }
    
    @Then("the user should see '$message' error message")
    public void theUserShouldSeeErrorMessage(String message) {
    	endUser.errorMessage(message);
    }
    
    @Then("the user should see '$message' message in header")
    public void theUserShouldSeeSuccessMessage(String message) {
    	endUser.verifyWelcomeMessageFromHeader(message);
    }
}
