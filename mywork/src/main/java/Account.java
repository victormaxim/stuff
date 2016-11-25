import static java.lang.System.out;

public class Account {
	String name;
	String address;
	String cemiazis;
	double balance;

	public void display() {
	out.print(name);
	//out.print(" (");
	//out.print(address);
	out.print(" has $");
	out.println(balance);
	}

	public int print(String cemiazis){
		out.println(cemiazis);
		return cemiazis.indexOf("a");
		
		
	}
	
	public double getInterest(double percentageRate) {
	return balance * percentageRate / 100.00;
	}
	
	
}
