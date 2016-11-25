package dg_login;

import base.data.NPMESSAGING;
import base.utils.MyTNGListener;
import base.utils.Utils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;
import pages.baseapp.Newpig;

@Listeners(MyTNGListener.class)
public class NDGLogin {


    Newpig newpig;

    @BeforeMethod
    public void before() {
        newpig = new Newpig();
    }

    @AfterMethod
    public void after() {
        newpig.quit();
    }


    @Test(groups = {"smoke"}, description = "DESCRIPTION")
    public void TC1870_registerValidUser() {
        SoftAssert softAssert = new SoftAssert();
    newpig.DgHomepage.clickMyAccount();
//       newpig.DgHomepage.

        softAssert.assertAll();
    }
}