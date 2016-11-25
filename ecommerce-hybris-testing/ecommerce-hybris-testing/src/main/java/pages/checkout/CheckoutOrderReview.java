package pages.checkout;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ionut.Trusca on 6/25/2015.
 */
public class CheckoutOrderReview extends NewpigGenericPage{

// ---------------------------------------------  Selectors -------------------------------------------------------

    private By contentPanel = By.cssSelector("#checkoutContentPanel");
    private By termsCheckbox = By.cssSelector(".terms input");
    private By placeOrderButton = By.cssSelector(".place-order");
    private By completeOrder = By.cssSelector(".complete-order-top-btn");
    private By editShippingMethod = By.cssSelector(".summaryDeliveryMode .editButton");
    private By shippingMethodContainer = By.cssSelector(".summaryDeliveryMode");
    private By cartTable = By.cssSelector(".cart-table");


// ---------------------------------------------  Constructor and components --------------------------------------


    public CheckoutOrderReview(WebDriver driver) {
        super(driver);
    }

// ---------------------------------------------  Functionality ---------------------------------------------------

    /**
     * Verifies that a text is displayed on the Order Review Page
     * @param text
     * @return
     */
    public boolean contentDisplaysText(String text){
        if (getText(contentPanel).contains(text))
            return true;
        else
            return false;
    }

    /**
     * Accept Terms and Conditions and clicks on Complete Order button
     */
    public void acceptTermsAndPlaceOrder(){
        click(termsCheckbox);
        click(completeOrder);
    }

    /**
     * Verifies if the Complete Order button is displayed on page
     * @return true if displayed
     */
    public boolean isCompleteOrderButtonDisplayed(){
        return isVisible(completeOrder);
    }

    /**
     * Verifies if the Edit link is displayed on the Shipping Method area
     * @return true if displayed
     */
    public boolean isEditShippingMethodLinkDisplayed(){
        return isVisible(editShippingMethod);
    }

    /**
     * clicks on the Edit link situated within ght Shipping Method area
     */
    public void clickEditShippingMethod(){
        click(editShippingMethod);
    }

    /**
     * @return text of the Shipping Method area
     */
    public String getShippingMethodSummary(){
        return getText(shippingMethodContainer);
    }

    /**
     * Accept Terms and Conditions and clicks on bottom Place Order button
     */
    public void acceptTermsAndBottomCompleteOrder(){
        click(termsCheckbox);
        click(placeOrderButton);
    }

    /**
     * Verifies if the bottom Complete Order button is displayed on page
     * @return true if displayed
     */
    public boolean isBottomCompleteOrderButtonDisplayed(){
        return isVisible(placeOrderButton);
    }

    /**
     * @param code
     * @return true if order contains a product with code given as parameter
     */
    public boolean orderContainsItemWithCode(String code){
        return getText(cartTable).contains(code);
    }

}
