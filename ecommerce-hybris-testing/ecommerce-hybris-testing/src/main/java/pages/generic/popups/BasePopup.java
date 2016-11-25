package pages.generic.popups;

import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 4/22/15.
 */
public class BasePopup extends WebPage{

	private By title = By.className("modal-title");
	private By closeButton = By.cssSelector("div.modal-header>.close");

	public BasePopup(WebDriver driver) {
		super(driver);
	}

	public String getTitle() {
		return getText(title);
	}

	public void clickClose() {
		click(closeButton);
	}

}
