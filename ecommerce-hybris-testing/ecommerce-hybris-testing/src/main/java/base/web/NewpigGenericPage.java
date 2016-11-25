package base.web;

import org.openqa.selenium.WebDriver;
import pages.generic.NPFooter;
import pages.generic.NPHeader;
import pages.generic.NPMessageArea;


public class NewpigGenericPage extends WebPage {

// ---------------------------------------------  Selectors -------------------------------------------------------



// ---------------------------------------------  Constructor and components --------------------------------------


	public NewpigGenericPage(WebDriver driver) {
		super(driver);
	}

	public NPHeader header = new NPHeader(driver);
	public NPFooter footer = new NPFooter(driver);
	public NPMessageArea messageArea = new NPMessageArea(driver);

// ---------------------------------------------  Functionality ---------------------------------------------------


}
