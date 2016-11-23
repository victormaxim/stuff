package telacad;
import java.io.*;

public class Produs implements Serializable{

	private String nume;
	private double pret;
	
	public Produs(){}
	
	public Produs (String nume, double pret){
		this.nume = nume;
		this.pret = pret;
			}
	
	public void SetNume(String nume){this.nume=nume;}
	public void SetPret(double pret){this.pret=pret;}
	
	public String getNume(){return this.nume;}
	public double getPret(){return this.pret;}
	
	public String toString(){
		return nume + " " + pret;
		
	}
	
	
}
