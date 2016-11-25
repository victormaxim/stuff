package com.lynda.olivepress;

import java.util.ArrayList;

import com.lynda.olivepress.olives.Kalamata;
import com.lynda.olivepress.olives.Ligurian;
import com.lynda.olivepress.olives.Olive;
import com.lynda.olivepress.press.OlivePress;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Olive> olives = new ArrayList<Olive>();
		
		Olive olive;
		
		olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);

		olive = new Ligurian();
		System.out.println(olive.name);
		olives.add(olive);

		olive = new Kalamata();
		System.out.println(olive.name);
		olives.add(olive);
	
		OlivePress press = new OlivePress();
		press.getOil(olives);
		
		System.out.println("You got " + press.getTotalOil() + 
				" units of oil");
		
		press.getOil(olives);
		
		System.out.println("You got " + press.getTotalOil() + 
				" units of oil");
	}

}
