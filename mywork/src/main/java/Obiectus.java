
public class Obiectus extends Obiect {


	public void modi(){
		valu += 15;	
		
	}	
	
	
	public double calcul(double percentageRate) {
		modi();
		return balance * percentageRate * valu * 2;
		
		}

}
