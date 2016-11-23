package compare;

import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Set;

public class compare {



    public static void main(String[] args) throws IOException {
        // Create a hash map
        HashMap psd = new HashMap();
        // Put elements to the map
        psd.put("primul text", "10");
    //HashSet txt = new hashset();

        FileInputStream fstream = new FileInputStream("C:\\Users\\Optaros\\Documents\\Alex\\java\\src\\compare\\abc.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            System.out.println ("a " + strLine);
            System.out.println ("b " + strLine);
        }

//Close the input stream
        br.close();
        // Get a set of the entries
        // Set set = hm.entrySet();
        // Get an iterator
//        Iterator i = set.iterator();
//        // Display elements
//        while(i.hasNext()) {
//            Map.Entry me = (Map.Entry)i.next();
//            System.out.print(me.getKey() + ": ");
//            System.out.println(me.getValue());
//        }
//        System.out.println();
//        // Deposit 1000 into Zara's account
//        double balance = ((Double)hm.get("Zara")).doubleValue();
//        hm.put("Zara", new Double(balance + 1000));
//        System.out.println("Zara's new balance: " +
//                hm.get("Zara"));
    }

}
