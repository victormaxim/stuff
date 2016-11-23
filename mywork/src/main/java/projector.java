import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class projector {
    static WebDriver driver;
    static Wait<WebDriver> wait;


    public static void main(String[] args) throws InterruptedException {

        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);

        driver.get("http://www.google.com/");

        try {
            driver.wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        System.out.println("Test " + (result? "passed." : "failed."));



//        String baseUrl = "http://newtours.demoaut.com";
//        String expectedTitle = "Welcome: Mercury Tours";
//        String actualTitle = "";

        // launch Firefox and direct it to the Base URL

        // get the actual value of the title
     //   actualTitle = driver.getTitle();


    }

}
