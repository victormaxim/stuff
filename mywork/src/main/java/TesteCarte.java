
public class TesteCarte {

	public static void main(String[] args) {
    double egal, rezu, bi;
    
   int bla;
    // int unu=10, doi = 3;
    //egal = unu / doi;
    rezu = 10.0 / 3.0;
    System.out.println(rezu);
    bi = ((int)(rezu * 100)) /100.0;
    //bla = (int)(rezu * 100); 
    //rezu = ((int)(rezu * 100)) /100.0;
    egal = 4.5;
    rezu = Math.pow(rezu, egal);
    rezu = (int)rezu;
    System.out.println(rezu);
    bi = Math.pow(bi, egal);
    bi = ((int)(bi * 100)) /100.0;
    System.out.println(bi);
			
	}


}
