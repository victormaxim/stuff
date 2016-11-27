
public class Masina {

	public String roti = "4";

	public String nume;
	public String motor;
	
	public Masina(String nume, String motor){
		this.nume = nume;
		this.motor = motor;
	}
	
	public static void main(String args[]){
		
		Masina dacia = new Masina("Dacia", "1.4");
		Masina chia = new Masina("chia", "1.6");
		
		System.out.println(dacia.motor);
		System.out.println(dacia.roti);
		dacia.motor = "2000";
		System.out.println(dacia.motor);
		
		chia.roti = "7";
		
		System.out.println(chia.motor);
		System.out.println(chia.roti);
		
	}
	
}
