import telacad.Magazin;

public class LabelProceduraGetInstance {

public static void main(String[] args) {
	// TODO Auto-generated method stub
	int a =0, b=1;
	--a;
	//a--;
	System.out.println(--a + "\n" + b++);
//	metoda(10);
	System.out.println("Nr. produse: " + Magazin.getInstance().getProduse().size());
	int i=0;
	int j=0;
	eticheta:
	while (i < 10) {
	System.out.println("i="+i);
	i++;
	while (j < 10) {
	j++;
	if (j==5) continue eticheta;
	if (j>=10) break eticheta;
	System.out.println("j="+j);
	}
	i++;
	}
	
	new Thread(){
		public void run(){
			try{
				while(true){Thread.sleep(5000);
	System.out.println("Nr. produse: " + Magazin.getInstance().getProduse().size());
				}
			}catch(Exception e){}
		}
		
	};
	
	System.out.println("after timer");
}



public static void metoda(int b) {
int a;
a = b;
for(int d=1; d < 10; d++) {
}
try {
a = b*2;
System.out.println(a);
} catch(ArithmeticException e) {
System.err.println(e.getMessage());
}





}

}

