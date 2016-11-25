package base.utils;

import base.data.PROP;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configurator {

	public static WebDriver getDriver(){
		System.setProperty("webdriver.chrome.driver", PROP.CHROME_DRIVER_PATH.get());
		return new ChromeDriver();
	}


}

