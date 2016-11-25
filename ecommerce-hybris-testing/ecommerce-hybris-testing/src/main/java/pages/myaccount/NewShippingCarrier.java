package pages.myaccount;

import base.utils.Utils;
import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;


public class NewShippingCarrier extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

    private By carrierName = By.id("carrierName");
    private By accountNumber = By.id("accountNumber");
    private By setAsDefault = By.id("setAsDefault1");
    private By submit = By.cssSelector("input[type=submit]");

// ---------------------------------------------  Constructor and components --------------------------------------

    public NewShippingCarrier(WebDriver driver) {
        super(driver);
    }

// ---------------------------------------------  Functionality ---------------------------------------------------

    /**
     * Completes the form with random carier name
     * @return Carrier name
     */
    public String addNewRandomCarrier(){
        String carrierSufix = "TestCarrier_"+ Utils.getRndString(4);
        fillInput(carrierName,carrierSufix);
        fillInput(accountNumber, "testAccount");
        click(submit);
        return carrierSufix;
    }

    /**
     * Verifies if all elements on new shipping carrier form are displayed
     * @return true if all displayed
     */
    public boolean elementsDisplayed(){
        if (isVisible(carrierName) &&
            isVisible(accountNumber) &&
            isVisible(setAsDefault) &&
            isVisible(submit))
            return true;
        else
            return false;
    }

    public void editCarrier(String name, String account, boolean setDefault){
        fillInput(carrierName,name);
        fillInput(accountNumber, account);
        if (setDefault)
            check(setAsDefault);
        click(submit);
    }


}
