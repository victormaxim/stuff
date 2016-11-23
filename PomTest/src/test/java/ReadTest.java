
import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class ReadTest {
public static String path = "";

    public static void main(String[] args) throws IOException {
        OutputStream os = null;
        String path = new File(".").getCanonicalPath()+"\\src\\test\\java\\test.properties";

//        System.out.println(path);
        ClassLoader loader = ReadTest.class.getClassLoader();
        ReadTest red = new ReadTest();
//        URL urs = loader.getResource(red.toString());
//        path = urs.toString();
        System.out.println(path);
        Properties prop = new Properties();
        Properties propo = new Properties();
        FileInputStream is = new FileInputStream(path);
        prop.load(is);
        is.close();

        os = new FileOutputStream(path);

        prop.setProperty("name","11");
        prop.store(os,null);
//        System.out.println(prop.getProperty("name"));
        os.close();




    }

}
