package com.example.tests;

import com.thoughtworks.selenium.*;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import java.util.regex.Pattern;

public class Testulet extends SeleneseTestNgHelper {
	@Test public void testUlet() throws Exception {
		selenium.open("/?page_id=4");
		selenium.click("link=Checkout");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Store");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=product_rating", "label=2");
		selenium.click("css=form.wpsc_product_rating > input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=product_rating", "label=3");
		selenium.click("css=form.wpsc_product_rating > input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=s", "vegas");
		selenium.click("id=searchsubmit");
		selenium.waitForPageToLoad("30000");
	}
}
