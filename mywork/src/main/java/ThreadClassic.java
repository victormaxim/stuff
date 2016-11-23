public class ThreadClassic{
	
	public static void main(String[] args) {
		Timer ceas = new Timer(1000,"pipi");
		ceas.start();
	}
	
}
		  
	class Timer extends Thread {
	         int dilei;
	         String text;
	         
	         Timer(int dilei, String text) {
	             this.dilei = dilei;
	             this.text = text;
	             
	         }

	         public void run() {
	        	 try {
					Thread.sleep(dilei);
					System.out.println(text);
				}
	        	 catch (InterruptedException e) {}
	         }
	     }
	 

	
