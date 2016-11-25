package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;


public class DeliveryOptions extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------

    private By allwaysUseColletShipping = By.id("defaultDeliveryModecollect-carrier");
    private By addNewCarrier = By.cssSelector("#collectShippingCarriers a[href*=new-carrier]");
    private By carrierNames = By.cssSelector("#collectShippingCarriers tr td:nth-child(1)");
    private By carrierAccount = By.cssSelector("#collectShippingCarriers tr td:nth-child(2)");
    private By removeCarrier = By.cssSelector("#removeCarrierLink");
    private By editCarrier = By.cssSelector("#collectShippingCarriers a[href*=edit-carrier]");
    private By successMessage = By.cssSelector(".alert.alert-success");
    private By setAsDefault = By.cssSelector("#collectShippingCarriers a[href*=set-default]");
    private By carriersTableLines = By.cssSelector("#collectShippingCarriers tr");


// ---------------------------------------------  Constructor and components --------------------------------------


    public DeliveryOptions(WebDriver driver) {
        super(driver);
    }

    public NewShippingCarrier newCarrier = new NewShippingCarrier(driver);

// ---------------------------------------------  Functionality ---------------------------------------------------

    /**
     * Clicks of Allways Use Collect Shipping radio
     */
    public void selectShippingCarrier(){
        click(allwaysUseColletShipping);
    }

    /**
     * Searches in the table for a given carrier name as parameter
     * @param carrierName
     * @return true if found
     */
    public boolean isCarrierDisplayed(String carrierName){
        ArrayList<String> carriers = getTexts(carrierNames);
        boolean found = false;
        for (String carrier : carriers) {
            if (carrier.contains(carrierName))
                found = true;
        }
        return  found;
    }

    /**
     * Clicks on Add New link on top of carriers table
     */
    public void clickAddNew(){
        click(addNewCarrier);
    }

    /**
     * Verifies if any carriers displayed
     * @return true if any is displayed
     */
    public boolean carriersExist(){
        return (isVisible(carrierAccount));
    }

    /**
     * @param index
     * @return the text of the carrier name at position indicated by index parameter
     */
    public String getCarrierName(int index){
        return getTexts(carrierNames).get(index);
    }

    /**
     * Clicks on the remove link for the first listed carrier
     */
    public void removeFirstCarrier(){
        click(removeCarrier);
        acceptAlert();
    }

    /**
     * Clicks on the edit link for the first listed carrier
     */
    public void editFirstCarier(){
        click(editCarrier);

    }

    /**
     * Verifies if any success message is displayed
     * @return true if displayed
     */
    public boolean successMessageDisplayed(){
        return isVisible(successMessage);
    }

    /**
     * Verifies if the success message contains a given text as parameter
     * @param sequence
     * @return true if sequence is displayed within the success message
     */
    public boolean successMessageContains(String sequence){
        return getText(successMessage).contains(sequence);
    }


    /**
     * @param text
     * @return the line number within the Carrier table for whom the text contains the given parameter
     */
    public int getTableIndexForFirstCarrierWithText(String text){
        ArrayList<String> tableLines = getTexts(carriersTableLines);
        for (String tableLine : tableLines) {
            if(tableLine.contains(text))
                return tableLines.indexOf(tableLine);
        }
        return 0;
    }

    /**
     * @return the line number of the first non default carrier
     */
    public int getTableIndexForFirstNonDefaultCarrier(){
        return getTableIndexForFirstCarrierWithText("Set as Default");
    }

    /**
     * @return the line number of the default carrier
     */
    public int getTableIndexForDefaultCarrier(){
        return getTableIndexForFirstCarrierWithText("Default Carrier");
    }

    /**
     * @return true if any non default carrier is displayed
     */
    public boolean isNonDefaultCarierDisplayed(){
        return isVisible(setAsDefault);
    }

    /**
     * Sets the first non default carrier as default
     */
    public void setAsDefaultFirst(){
        click(setAsDefault);
    }

    /**
     * @param index
     * @return the text of the Account of carrier at index provided as parameter
     */
    public String getAccountText(int index){
        return getText(carrierAccount);
    }

    /**
     * @return the text of the First Carrier Name
     */
    public String getFirstCarrierName(){
        return getText(carrierNames);
    }

    /**
     * @return the text of the First Carrier Account
     */
    public String getFirstCarrierAccount(){
        return getText(carrierAccount);
    }

}
