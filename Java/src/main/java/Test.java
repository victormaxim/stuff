import java.io.File;
import java.io.IOException;

/**
 * Created by alexandru.dima on 10/10/2016.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        System.out.println(new File("../").getCanonicalPath());
    }
}
