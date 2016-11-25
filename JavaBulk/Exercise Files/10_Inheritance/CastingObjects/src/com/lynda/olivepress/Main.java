package com.lynda.olivepress;

import java.util.ArrayList;
import java.util.Iterator;

import com.lynda.olivepress.olives.Kalamata;
import com.lynda.olivepress.olives.Ligurian;
import com.lynda.olivepress.olives.Olive;
import com.lynda.olivepress.press.OlivePress;

public class Main {

static int numar = 11;
	
	
public static int getCifra(){
		
		int cifra = 69;
		return cifra;
	}
	public static void main(String[] args) {
		
	ArrayList<Olive> olives = new ArrayList<Olive>();
	

	
	
		//Array[] ara = new Array[5];
		
		//ara = {1,2,3,4,5};
		
		//ara = Array.
		
		Olive olive;
		
		olive = new Kalamata();
		olives.add(olive);

		olive = new Ligurian();
		olives.add(olive);

		olive = new Kalamata();
		olives.add(olive);
	
		OlivePress press = new OlivePress();
		press.getOil(olives);
		
		System.out.println("You got " + press.getTotalOil() + 
				" units of oil");
		
		
	metoda();
	
	}
	
	
	
	public static void metoda() {

	ArrayList<Integer> foo = new ArrayList<Integer>();
	ArrayList<Integer> goo = new ArrayList<Integer>();
	
	
	
	
//	Integer[] bar = foo.toArray(new Integer[0]);
//	for (int i = 1; i < 10; ++i) {
//		System.out.println(bar[i]);
//	}

	//int bi = 0;
	
	//bi = goo.get(1)*100;
	System.out.println("cifra este: " + Main.getCifra());
	System.out.println(numar);
	
	//System.out.println("elementul 1 este:" + bi);
		for (int i = 0; i < 10; ++i) {
		foo.add(i);
		}
		
		goo = foo;	
		
		System.out.println(goo.size());
		
		goo.remove(1);
		goo.remove(goo.indexOf(5));
		
		System.out.println(goo.size());
		
		Iterator<Integer> itr = goo.iterator();
		while(itr.hasNext()){
		System.out.println(itr.next());
		}
		}
		
}
