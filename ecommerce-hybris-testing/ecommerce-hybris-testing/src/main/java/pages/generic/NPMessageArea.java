package pages.generic;

import base.data.NPMESSAGING;
import base.web.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by optaros on 3/20/15.
 */
public class NPMessageArea extends WebPage{

	private By container = By.id("globalMessages");
	private By successMessagesSelector = By.cssSelector("div.alert-success");
	private By warningMessagesSelector = By.cssSelector("div.alert-warning");
	private By errorMessagesSelector = By.cssSelector("#globalMessages > div.alert-danger");
	private By neutralMessagesSelector = By.cssSelector("div.alert.neutral");

	public NPMessageArea(WebDriver driver) {
		super(driver);
	}


	public ArrayList<String> getSuccessMessages(){

		waitPresent(successMessagesSelector);

		ArrayList<String> messages = new ArrayList<String>();

		List<WebElement> messagesElements = driver.findElements(successMessagesSelector);

		for (WebElement messagesElement : messagesElements) {
			messages.add(messagesElement.getText().trim());
		}
		return messages;
	}

	public ArrayList<String> getErrorMessages(){
		ArrayList<String> messages = new ArrayList<String>();

		List<WebElement> messagesElements = driver.findElements(errorMessagesSelector);

		for (WebElement messagesElement : messagesElements) {
			messages.add(messagesElement.getText().trim());
		}
		return messages;
	}


	public ArrayList<String> getNeutralMessages(){
		ArrayList<String> messages = new ArrayList<String>();

		List<WebElement> messagesElements = driver.findElements(neutralMessagesSelector);

		for (WebElement messagesElement : messagesElements) {
			messages.add(messagesElement.getText().trim());
		}
		return messages;
	}

	public ArrayList<String> getWarningMessages(){
		ArrayList<String> messages = new ArrayList<String>();

		List<WebElement> messagesElements = driver.findElements(warningMessagesSelector);

		for (WebElement messagesElement : messagesElements) {
			messages.add(messagesElement.getText().trim());
		}
		return messages;
	}

	private boolean checkMessageDisplayed(NPMESSAGING message, String type){
		ArrayList<String> messagesToCheck = new ArrayList<>();
		if(type.equalsIgnoreCase("success")){
			messagesToCheck.addAll(getSuccessMessages());
		}
		else if(type.equalsIgnoreCase("error")){
			messagesToCheck.addAll(getErrorMessages());
		}else if(type.equalsIgnoreCase("neutral")){
			messagesToCheck.addAll(getNeutralMessages());
		}else if(type.equalsIgnoreCase("warning")){
			messagesToCheck.addAll(getWarningMessages());
		}

		for (String s : messagesToCheck) {
			if(s.equalsIgnoreCase(message.get())){
				return true;
			}
		}

		return false;

	}

	public boolean isSuccessMessgageDisplayed(NPMESSAGING message){
		return checkMessageDisplayed(message, "success");
	}

	public boolean isErrorMessgageDisplayed(NPMESSAGING message){
		return checkMessageDisplayed(message, "error");
	}

	public boolean isNeutralMessgageDisplayed(NPMESSAGING message){
		return checkMessageDisplayed(message, "neutral");
	}
	public boolean isWarningMessgageDisplayed(NPMESSAGING message){
		return checkMessageDisplayed(message, "warning");
	}




}
