package pages.dg_homepage;

import base.web.NewpigGenericPage;
import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

package dg_homepage;

import base.web.NewpigGenericPage;
import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class DgHomepage extends NewpigGenericPage {

// --------------------------------------------- Selectors -------------------------------------------------------

    private By object = By.cssSelector("");
    private By headerMyAccount = By.cssSelector("#header-account a");
    private By loginFormEmail = By.cssSelector("#email");
    private By loginFormPassword = By.cssSelector("#pass");
    private By submitLogin = By.cssSelector("#send2");




// ------------------------------------ Constructor and components --------------------------------------


    public DgHomepage(WebDriver driver) {
        super(driver);
    }

// --------------------------------------------- Functionality ---------------------------------------------------



    public void clickMyAccount() {
        click(headerMyAccount);
    }

    public void loginWithUserNPass(String email, String password){
        fillInput(loginFormEmail, email);
        fillInput(loginFormPassword, password);
        click(submitLogin);
    }
}