import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class FileReaderC {

    public static void main(String[] args) throws IOException {
        System.out.println(getVals());
    }

    public static String getVals() throws IOException {
        String result = "";
        InputStream inputStream = null;
        FileReaderB filb = new FileReaderB();
        Properties prop = new Properties();


        try {

//String x = filb.getClass().getClassLoader().getResource("test.properties").toString();
            URL xy = filb.getClass().getClassLoader().getResource("config.properties");
String x = xy.toString();
            System.out.println(x);
//            System.out.println();
            inputStream = filb.getClass().getClassLoader().getResourceAsStream("test.properties");




            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + "test.properties" + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String user = prop.getProperty("name");
            result = user;

            //result = "Company List = " + company1 + ", " + company2 + ", " + company3;
            //System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }



}
