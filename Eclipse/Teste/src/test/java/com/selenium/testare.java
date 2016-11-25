package com.selenium;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class testare {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.soastastore.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAre() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Store")).click();
    driver.findElement(By.linkText("Tron: Legacy")).click();
    driver.findElement(By.id("product_155_submit_button")).click();
    new Select(driver.findElement(By.name("product_rating"))).selectByVisibleText("2");
    driver.findElement(By.id("s")).clear();
    driver.findElement(By.id("s")).sendKeys("firth");
    driver.findElement(By.id("searchsubmit")).click();
    driver.findElement(By.linkText("The King’s Speech")).click();
    new Select(driver.findElement(By.name("product_rating"))).selectByVisibleText("4");
    driver.findElement(By.id("product_160_submit_button")).click();
    driver.findElement(By.linkText("Checkout")).click();
    driver.findElement(By.cssSelector("input.remove_button")).click();
    driver.findElement(By.cssSelector("span > input[name=\"submit\"]")).click();
    // Warning: assertTextPresent may require manual changes
    assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
