import java.util.Scanner;
import java.util.regex.MatchResult;


public class Param {
private static Scanner keyboard;

public static void main(String[] args) {
	
	keyboard = new Scanner(System.in);
	
	String x = keyboard.nextLine();
	String y = keyboard.nextLine();
	//System.out.println(myint);
	para(x, y);
	
	String input = "1 fish 2 fish red fish blue fish";
    Scanner s = new Scanner(input);
    s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
    MatchResult result = s.match();
    for (int i=1; i<=result.groupCount(); i++)
        System.out.println(result.group(i));
    s.close(); 
	
	
}

public static void para(String x, String y){
	System.out.println(x + " " + y);
	
}

}

