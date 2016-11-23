import java.util.Scanner;

/**
 * Created by alexandru.dima on 10/7/2016.
 */
public class RevString {

    public static void main(String[] args) {

        //String input = "string test  a is it";

        String input = "This is a test string";
        Scanner scan = new Scanner(System.in);
        System.out.println("strig: ");
        input = scan.nextLine();
//        System.out.println(spart[3]);
        System.out.println(rev(input));
        int ten = 10;
        System.out.println(ten + "plm");
        //System.out.println();

    }

    private static String rev(String input){
        String reverse = "";

        String[] spart = input.split("\\s+");
        char[] ch;
        String revch;
//        revch ="";

        for (String x:spart) {
        revch = "";
//        System.out.println("de intors: " + x + " " + x.charAt(0) + " " + x.length());
        ch = x.toCharArray();

            for(Character cha:ch){
//                System.out.println(cha);
                revch = cha + revch;
            }

            reverse = revch + " " + reverse ;

        }

    return reverse;
    }

}
