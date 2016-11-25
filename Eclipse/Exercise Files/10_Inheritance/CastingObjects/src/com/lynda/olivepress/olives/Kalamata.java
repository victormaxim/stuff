package com.lynda.olivepress.olives;

import com.lynda.olivepress.Main;

public class Kalamata extends Olive {

	public Kalamata() {
		super(55);
		this.name = "Kalamata";
		this.flavor = "Grassy";
		this.color = Olive.BLACK;
	}
	
	@Override
	public int crush() {
		//System.out.println("crush from subclass");
		System.out.println(Main.getCifra() + "!!!");
		return super.crush();
	}

}
