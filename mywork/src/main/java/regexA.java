import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandru.dima on 9/29/2016.
 */
public class regexA {
    private static int poz;
    private static String arg1;

    //HashMap definitii = new HashMap<String, String>();

    public static void main(String[] args) throws IOException {
        poz = 0;

        HashMap<String,String> definitii;
String cauta = new String();
        String s = new String();
        definitii = new HashMap<String, String>();
        definitii.put("starts with", "^");
        definitii.put("ends with", "$");
        definitii.put("isn't", "[^");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String");


        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        s = "starts.with abc ";
        //definitii.put("start with", "123");
        //System.out.println(definitii.get(s));
        System.out.println(s);

        for(Map.Entry<String, String> entry : definitii.entrySet()) {
            cauta = entry.getKey();
//            System.out.println(cauta);
//            System.out.println(s.indexOf(cauta));

            
            if(s.indexOf(cauta,poz)>=0){

                //System.out.println(definitii.get(entry.getKey()));
                String sir = entry.getKey();
                //System.out.println(sir.length());
                poz = s.indexOf(cauta,poz);
//                System.out.println(poz);

                arg1 = s.substring(poz + sir.length(), s.indexOf(" ",poz+sir.length() +1));
                System.out.println(entry.getValue() + arg1);
            }
//            System.out.println();

        }
    }
}
