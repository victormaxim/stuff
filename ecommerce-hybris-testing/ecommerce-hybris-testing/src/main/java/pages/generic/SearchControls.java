package pages.generic;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

/**
 * Created by optaros on 5/21/15.
 */
public class SearchControls extends WebPage{


    private By searchInput = By.id("search");

    private By suggestionContainer = By.cssSelector(".suggestion-container");
    private By suggestedProductContainer = By.cssSelector("#header_footer > div > div.searchbar > div > ul > li:nth-child(3) > a > div");

    private By suggestedProdName = By.cssSelector("div.item-desc span:nth-of-type(2)");
    private By suggestedProdCode = By.cssSelector("div.item-desc span:nth-of-type(1)");

    private By searchButton = By.cssSelector("button.siteSearchSubmit");




    public SearchControls(WebDriver driver) {
        super(driver);
    }

    public void typeInSearch(String term){
        fillInput(searchInput, term);
    }

    public void searchFor(String term){
        fillInput(searchInput, term);
        click(searchButton);
    }

    public ArrayList<String> getSuggestedCorrections(){
        return getTexts(suggestionContainer);
    }

    public ArrayList<String> getSuggestedProductNames(){
        return getTexts(suggestedProdName);
    }
    public ArrayList<String> getSuggestedProductCodes(){
        return getTexts(suggestedProdCode);
    }

}
