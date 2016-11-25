package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Payment extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

    private By successAllert = By.cssSelector(".alert-success");
    private By addressRows = By.cssSelector(".account-content table tr");
    private By setDefaultPaymentOnRow = By.cssSelector("a[href*=set-default-payment]");
    private By addNewAddressLink = By.cssSelector("#newInvoice");

// ------------------------------------  Constructor and components --------------------------------------


    public Payment(WebDriver driver) {
        super(driver);
    }

// ---------------------------------------------  Functionality ---------------------------------------------------
    /**
     * @return true if any success message is displayed
     */
    public boolean isSuccessMessageDisplayed(){
        return isVisible(successAllert);
    }

    /**
     * Searches for an address containing the given text as String parameter
     * Sets the first found address as Default Payment
     * @param text
     */
    public void setAddressContainingTextAsDefaultPayment(String text){
        boolean addressWasSet = false;
        List<WebElement> addressBlocks = driver.findElements(addressRows);
        for (int i=0;i<addressBlocks.size();i++){
            if(addressBlocks.get(i).getText().contains(text)){
                addressWasSet = true;
                addressBlocks.get(i).findElement(setDefaultPaymentOnRow).click();
                break;
            }
        }
        if (!addressWasSet){
            log.error("Address with text: " + text + " was NOT found");
        }
    }

    /**
     * Searches for an address containing the given text as String parameter
     * Returns true if address is already set as default
     * @param text
     */
    public boolean addressContainingTextIsSetAsDefaultPayment(String text){
        boolean addressWasSetAsDefault = true;
        List<WebElement> addressBlocks = driver.findElements(addressRows);
        for (int i=0;i<addressBlocks.size();i++){
            if(addressBlocks.get(i).getText().contains(text)){
                if(addressBlocks.get(i).getText().contains("Set as")){
                    addressWasSetAsDefault=false;
                }
                break;
            }
        }
        if (!addressWasSetAsDefault){
            log.error("Address with text: " + text + " was NOT set as default");
        }
        return addressWasSetAsDefault;
    }


    /**
     * Clicks on Add new Invoice address
     */
    public void clickAddNewAddress(){
        click(addNewAddressLink);
    }


}
