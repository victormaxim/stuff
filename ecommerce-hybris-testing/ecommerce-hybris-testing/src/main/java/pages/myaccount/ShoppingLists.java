package pages.myaccount;

import base.web.NewpigGenericPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Ionut.Trusca on 7/23/2015.
 */
public class ShoppingLists extends NewpigGenericPage {

// ---------------------------------------------  Selectors -------------------------------------------------------
    private By listNames = By.cssSelector(".orderListTable a[id*='view']");

    private By listItem  = By.cssSelector(".item-code");

// ---------------------------------------------  Constructor and components --------------------------------------


    public ShoppingLists(WebDriver driver) {
        super(driver);
    }

// ---------------------------------------------  Functionality ---------------------------------------------------

    public void clickOnListWithName(String listName){
        List<WebElement> lists  = driver.findElements(listNames);
        if (lists==null){
            log.error("No lists found!!!");
        }
        boolean found = false;
        for (WebElement list : lists) {
            if (list.getText().equalsIgnoreCase(listName)){
                list.click();
                break;
            }
        }
        if (!found){
            log.error("List with name " + listName + " was NOT found!!!");
        }
    }

    public boolean isItemWithCodeVisibleInList(String itemCode){
        List<WebElement> items  = driver.findElements(listItem);
        if (items==null){
            log.error("No items found!!!");
        }
        for (WebElement item : items) {
            if (item.getText().equalsIgnoreCase(itemCode)){
                return true;
            }
        }
        return false;
    }

}
