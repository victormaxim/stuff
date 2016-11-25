package pages.generic.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by optaros on 4/17/15.
 */
public class SimplePopup extends BasePopup {

	private By message = By.cssSelector(".modal-body>p");



	public SimplePopup(WebDriver driver) {
		super(driver);
	}


	public String getMessage() {
		return getText(message);
	}


}
