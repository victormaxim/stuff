

public class breic {

	
	
	public static void main(String[] args) {
		
		int px=0;
		int py=0;
		int caseta=0;
		int sigur[][] = new int[10][10];
		
 sigur [9][4]=5;
 sigur [6][2]=15;
 sigur [2][6]=9;
 sigur [3][9]=1;
 sigur [7][7]=1;
		
		
		
		
			
		for(int i =1; i < 10;++i) {
		
		eticheta:
		for(int j=1; j < 10;++j) {
		
		if (sigur[i][j] != 0) {
		System.out.println("found[" + i + "][" + j + "]=" + sigur[i][j]);
		if((i%3)!=0){
			
		px = (int)(i/3)+1;
		
		}else{
			px=(int)(i/3);
			
		}
		System.out.println(px);
		py = (int)((j+1)/3);
		
		System.out.println(px + " " + py);
		
		continue eticheta;
		}
		
		
		
		
		//if (j==7) {System.out.println("break");break eticheta;}
		
		}
		
		}
		
	}

	

}
