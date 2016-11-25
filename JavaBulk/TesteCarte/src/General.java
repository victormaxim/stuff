import static java.lang.System.out;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class General {
private static Scanner keyboard;

public static void main(String[] args) throws Exception {
	//String key="";;
		
		final String format = "%5.1f degrees %s\n";
		Temperature temp = new Temperature();
		
		keyboard = new Scanner(System.in);
		double val = keyboard.nextDouble();
		temp.setNumber(val);
		System.out.println("CELSIUS, FAHRENHEIT, KELVIN, RANKINE,NEWTON, DELISLE, RÉAUMUR, RØMER, LEIDEN");
			
		keyboard = new Scanner(System.in);
		String key = keyboard.nextLine();
		switch (key) {
		case "c":
			temp.setScale(TempScale.CELSIUS);
			break;

		default:
			break;
		}
		 
		//System.out.println('\b');
		/**
		for (int i = 0; i < 1000; i++) {
			
		System.out.println(i);
		
		if(i %100 == 0){
		robbie.keyPress(KeyEvent.VK_WINDOWS);
	    robbie.keyPress(KeyEvent.VK_D);
	    
	    }
		
			try {
			wipeConsole();
			System.out.println(i + "x");
			break;
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		}
		**/
		
		
		//System.out.println(tempi);
		
		
		//System.out.println(myint);

		out.printf(format, temp.getNumber(),temp.getScale());
}

public static void wipeConsole() throws AWTException {
    Robot robbie = new Robot();
    //shows the Console View
    robbie.keyPress(KeyEvent.VK_ALT);
    robbie.keyPress(KeyEvent.VK_SHIFT);
    robbie.keyPress(KeyEvent.VK_Q);
    robbie.keyRelease(KeyEvent.VK_ALT);
    robbie.keyPress(KeyEvent.VK_SHIFT);
    robbie.keyPress(KeyEvent.VK_Q);
    robbie.keyPress(KeyEvent.VK_C);
    robbie.keyRelease(KeyEvent.VK_C);

    //clears the console
    robbie.keyPress(KeyEvent.VK_SHIFT);
    robbie.keyPress(KeyEvent.VK_F10);
    robbie.keyRelease(KeyEvent.VK_SHIFT);
    robbie.keyRelease(KeyEvent.VK_F10);
    robbie.keyPress(KeyEvent.VK_R);
    robbie.keyRelease(KeyEvent.VK_R);
}
	
}
