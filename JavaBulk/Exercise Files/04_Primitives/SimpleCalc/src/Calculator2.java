import java.io.*;

public class Calculator {

	public static void main(String[] args) {
		
		
		Boolean boo;
		String s1 = getInput("Enter a value: ");
		boo = s1.equals("pus");
		while (!boo){
		String s2 = getInput("Enter a value: ");
		boo = s2.equals("pus");
		}
		//if(s1.equals("pus")){System.out.println("hello pus!!");}
		
		System.out.println("hello mrs. Puss!!");
	}
	
	private static String getInput(String prompt) {
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));

		System.out.print(prompt);
		System.out.flush();
		
		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

}
