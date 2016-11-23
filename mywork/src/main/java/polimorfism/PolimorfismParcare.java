package polimorfism;
import java.math.BigDecimal;
import java.util.Scanner;

public class PolimorfismParcare {

	public static void main(String[] args) {
		
		vehicule v1[] = new vehicule[4];
		v1[0]=new masina();
		v1[1]=new moto();
		v1[2]=new vehicule();
		v1[3]=new Chopper();
	  
		for (vehicule vrum : v1) {
		vrum.present();
		}
		v1[3].sound();
		System.out.println(vehicule.y);
		
		System.out.println(valori.x);
		
		double valoare= 7.5;
		int inte;
		inte = (int) valoare;
		System.out.println(valoare + " " + inte);
		char ch[]={'a','l','x'};
		String s1 = new String();
		s1 = String.valueOf(ch[2]);
		
		int num = 7;
		double d = num/3;
		
		
		//d = d / 5;
		long ds = (long)(d /5);
		//double ds = d/2.5;
		//String ds = Double.toString(d/3);
		//BigDecimal numar= new BigDecimal(ds);
		//BigDecimal dd= new BigDecimal();
		System.out.println(num);
		System.out.println(ds + " " + d);
		//numar = 2.75;
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String lineb = scan.nextLine();
		System.out.println(line);
		
		
		
		System.out.println(ch[1]);
		System.out.println(s1);
		
	}
	
}
