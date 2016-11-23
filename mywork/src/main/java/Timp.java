import java.util.Date;


public class Timp {

	public static void main(String[] args) {
		 try {
		        while (true) {
		            System.out.println(new Date());
		            Thread.sleep(5 * 1000);
		        }
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
	}
	
}
