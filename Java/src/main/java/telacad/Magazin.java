package telacad;
import java.util.ArrayList;

public class Magazin implements java.io.Serializable{

	//
	private static Magazin singleton = null;
	private ArrayList<Produs> produse = new ArrayList<Produs>();
	
	private Magazin(){}
	
	//creeaza o singura instanta de Magazin
	public static Magazin getInstance(){
		if(singleton==null) singleton = new Magazin();
		return singleton;
	}
	

	
	public void adaugaProdus(Produs p){
		produse.add(p);
		}
	
	public ArrayList<Produs> getProduse(){return produse;}
	
	public void removeProdus(Produs p){
		produse.remove(p);
	}

	public static void setInstance(Magazin m) {
		singleton = m;
		
	}
	
	
}
