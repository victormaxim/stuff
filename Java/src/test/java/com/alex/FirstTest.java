package com.alex;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

/**
 * Created by user on 10/6/2016.
 */
public class FirstTest {

    @Test
    public void driverK(){
        System.setProperty("webdriver.chrome.driver", "A:\\kits\\IT/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.compendiumdev.co.uk/selenium/");
        assertTrue(driver.getTitle().startsWith("Selenium"));
        driver.quit();


    }



}
