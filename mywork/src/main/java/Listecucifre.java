import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class Listecucifre {

	public static LinkedList<Integer> lista = new LinkedList<Integer>();
	
	public static void main(String[] args) {
		
		int[] matrix = {1,2,3};
		
		for(int a : matrix){
			System.out.println(a);
			}
		
	//	List<Integer> lista = Arrays.asList(matrix);
		
		//LinkedList<Integer> lista = new LinkedList<Integer>(Arrays.asList(matrix));
		
		//List<Integer> lista = new ArrayList<Integer>();
	    for (Integer item: matrix) {
	        lista.add(item);
	    }
		
		//lista.add(4);
		
		adauga(1);
		//if(lista.indexOf(5))
		
		//System.out.println("adaug d");
		/*
		for (Integer temp : lista) {
		System.out.println(temp);	
		}
		
		System.out.println("scoatem elementul 1: " + lista.get(1));
		lista.remove(1);
		
		
		Collections.sort(lista);
		
		for (Integer temp : lista) {
			System.out.println(temp);	
			}
		//System.out.println(lista.indexOf(5));
		
		
		
		
		//System.out.println(lista.get(2));
		*/
		
	}
	 
	public static void adauga(int numar) {
		System.out.println("Adaug " + numar + "?");
		//if(lista.indexOf(numar)>-1){System.out.println("e");}
		
		if(lista.indexOf(numar)<0){
			//System.out.println(lista.indexOf(numar));
			//lista.add(null);
			lista.add(numar);
			System.out.println("am adaugat " + numar);
			}
			else{
				System.out.println("era deja " + numar);
			}
		
		Collections.sort(lista);
		
		
		
		System.out.println(lista.toString()
				);
		int suma = 0;
		
		for (Integer temp : lista) {
			suma = suma + temp;
				}
		System.out.println("Suma: " + suma);
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter an integer | -1 to exit");
		int myint = keyboard.nextInt();
		if(myint > 0){adauga(myint);}
		else if(myint <0){sterge(0-myint);}
		else{away();};
		
		
			}

	

	public static void sterge(int numar) {
		System.out.println("Sa sterg " + numar + "?");
		//if(lista.indexOf(numar)>-1){System.out.println("e");}
		
		if(lista.indexOf(numar)>-1){
			//System.out.println(lista.indexOf(numar));
			//lista.add(null);
			lista.remove(lista.indexOf(numar));
			System.out.println("am sters " + numar);
			}
			else{
				System.out.println("nu era " + numar);
			}
		
		Collections.sort(lista);
		
		
		
		System.out.println(lista.toString()
				);
		int suma = 0;
		
		for (Integer temp : lista) {
			suma = suma + temp;
				}
		System.out.println("Suma: " + suma);
		Scanner keyboard = new Scanner(System.in);
		System.out.println("enter an integer | -1 to exit");
		int myint = keyboard.nextInt();
		if(myint > 0){adauga(myint);}
		else if(myint <0){sterge(0-myint);}
		
	}
	private static void away() {
		// TODO Auto-generated method stub
		
	}
	
}
