package com.lynda.olivepress.press;

import java.util.Collection;

import com.lynda.olivepress.olives.Olive;

public class OlivePress {
	
	private int totalOil=0;
	
	public int getTotalOil() {
		return totalOil;
	}

	private void setTotalOil(int totalOil) {
		this.totalOil += totalOil;
	}

	public OlivePress() {
	}
	
	public void getOil(Collection<Olive> olives) {
		
		int oil = 0;
		
		for (Olive olive : olives) {
			oil += olive.crush();
		}
		
		setTotalOil(oil);

	}
}
