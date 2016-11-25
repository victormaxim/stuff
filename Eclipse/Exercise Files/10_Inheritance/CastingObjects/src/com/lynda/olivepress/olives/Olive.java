package com.lynda.olivepress.olives;

public class Olive {
	
	public static final long BLACK = 0x000000;
	public static final long GREEN = 0x00FF00;
	
	public String name = "Kalamata";
	public String flavor = "Grassy";
	public long color = Olive.BLACK;
	private int oil = 1;
	protected boolean crushed=false;
	
	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public Olive() {
		System.out.println("Constructor of " + this.name);
	}
	
	public Olive(int oil) {
		System.out.println("bla" + oil);
		setOil(oil);
	}

	public int crush() {
		System.out.println("crush from " + this.name);
		return oil;
	}

}
