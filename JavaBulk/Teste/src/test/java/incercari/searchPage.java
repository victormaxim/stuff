package incercari;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//@DefaultUrl("http://www.trademe.co.nz")
public class searchPage {

    @FindBy(id = "searchString")
    WebElement searchField;

    @FindBy(css = "button[value='Search']")
    WebElement searchButton;

    @FindBy(id = "main-box-categories")
    WebElement categoriesList;

    public searchPage(WebDriver driver) {
        super();
    }

    public void searchFor(String searchTerms) {
        searchField.sendKeys(searchTerms);
        searchButton.click();
    }

    public void selectsCategory(String category) {
        categoriesList.findElement(
            By.linkText(category)).click();
    }
}