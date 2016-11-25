package com.lynda.olivepress.olives;

public class Kalamata extends Olive {

	public Kalamata() {
		super(2);
		this.name = "Kalamata";
		this.flavor = "Grassy";
		this.color = Olive.BLACK;
	}
	
	/**
	 * This method is unique to <b>Kalamata</b> olives
	 */
	public String getOrigin() {
		
		return "Greece";
	}

}
