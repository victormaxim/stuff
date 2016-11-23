
public class VariabileClase {
public static int a=11;
public static void main(String[] args) {
	metA();
	
}
	
	public static void metA(){
		System.out.println(a);
		a=a+5;
		
		metB();
		
	}
	
	
	public static void metB(){
		System.out.println(a);
		
	}
	
}
