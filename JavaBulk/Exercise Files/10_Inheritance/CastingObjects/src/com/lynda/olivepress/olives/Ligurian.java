package com.lynda.olivepress.olives;

public class Ligurian extends Olive {

	public Ligurian() {
		super(10);
		this.name = "Ligurian";
		this.flavor = "Yummy";
		this.color = Olive.GREEN;
	}

	@Override
	public int crush() {
		//System.out.println("strivit L! 10 litri!");
		//System.out.println(super.crush());
		
		return super.crush();
	}
}
