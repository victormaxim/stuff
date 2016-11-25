package com.lynda.olivepress.press;

import java.util.Collection;

import com.lynda.olivepress.olives.Olive;

public interface Press {
	public void getOil(Collection<Olive> olives);
	public int getTotalOil();
	public void setTotalOil(int totalOil);
}
