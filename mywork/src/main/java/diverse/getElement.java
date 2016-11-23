package diverse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Method;

/**
 * Created by alexandru.dima on 10/13/2016.
 */
public class getElement {

        public String methodName(String i) {
            return "Hello World: " + i;
        }

        public static void main(String... args) throws Exception {

            WebDriver driver = new FirefoxDriver();
            Method[] methods = driver.getClass().getMethods();

            for(Method method:methods){
                System.out.println(method.getName());
            }
            //driver.manage().g
            driver.get("http://www.facebook.com/");
            By by = By.name("email");
            Class c = Class.forName(driver.getClass().getName());
            Method getMethod = c.getMethod("findElement", new Class[]{by.getClass()});
            getMethod.setAccessible(true);
            WebElement element = (WebElement) getMethod.invoke(driver, by);

//            getElement t = new getElement();
//            Method m = getElement.class.getMethod("methodName", String.class);
//
//            String returnVal = (String) m.invoke(t,"1-abc");
//            System.out.println(returnVal);


        }
    }

