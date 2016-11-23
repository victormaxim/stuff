package diverse;
import java.lang.reflect.*;

/**
 * Created by alexandru.dima on 10/13/2016.
 */
public class variableMethod {

        public String alex(String i) {
            return "Hello World: " + i;
        }

        public static void main(String... args) throws Exception {
            variableMethod t = new variableMethod();
String metoda = "alex";
            Method m = variableMethod.class.getMethod(metoda, String.class);

            String returnVal = (String) m.invoke(t,"1-abc");
            System.out.println(returnVal);


        }
    }

