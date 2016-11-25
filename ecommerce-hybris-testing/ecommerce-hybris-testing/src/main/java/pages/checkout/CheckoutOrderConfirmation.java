package pages.checkout;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ionut.Trusca on 6/25/2015.
 */
public class CheckoutOrderConfirmation extends NewpigGenericPage {


// ---------------------------------------------  Selectors -------------------------------------------------------

    private By content = By.cssSelector(".body-container");


// ---------------------------------------------  Constructor and components --------------------------------------


    public CheckoutOrderConfirmation(WebDriver driver) {
        super(driver);
    }

// ---------------------------------------------  Functionality ---------------------------------------------------

    public boolean pageDisplaysText(String text){
        if (getText(content).contains(text))
            return true;
        else
            return false;
    }

}
