package pages.baseapp;

import base.data.PROP;
import base.utils.Configurator;
import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;
import pages.barnyard.Barnyard;
import pages.cart.Cart;
import pages.category_sub.Category;
import pages.category_sub.Search;
import pages.category_sub.SubCategory;
import pages.checkout.Checkout;
import pages.generic.Homepage;
import pages.generic.NPMessageArea;
import pages.login.ForgotPassword;
import pages.login.Login;
import pages.login.Registration;
import pages.myaccount.*;
import pages.pdp.PDP;
import pages.ppc.PPC;
import dg_homepage.*;
import Dg

/**
 * Created by optaros on 5/7/15.
 */
public class Newpig {

    private  WebDriver driver= Configurator.getDriver();


    public  NPMessageArea messages = new NPMessageArea(driver);

    public  Homepage homepage = new Homepage(driver);
    public  Cart cart = new Cart(driver);
    public  Registration registration = new Registration(driver);
    public  Login login = new Login(driver);

    public MyAccount myAccount = new MyAccount(driver);
    public ForgotPassword forgotPassword = new ForgotPassword(driver);


    public Category category = new Category(driver);
    public SubCategory subCategory = new SubCategory(driver);
    public Barnyard barnyard = new Barnyard(driver);
    public Search search = new Search(driver);
    public PDP pdp = new PDP(driver);
    public PPC ppc = new PPC(driver);

    public DgHomepage DgHomepage = new DgHomepage(driver);




    public Checkout checkout = new Checkout(driver);


    public Newpig() {
        driver.manage().window().maximize();
        homepage.openHomePage();
    }

    public void goToCart(){
        homepage.header.goToCartPage();
    }

    public void quit(){
        driver.quit();
    }

    public void navigatetoURL(String URL){
        driver.get(URL);
    }
}
