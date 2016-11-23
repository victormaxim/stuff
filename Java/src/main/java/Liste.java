import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class Liste {

	public static void main(String[] args) {
		
		String[] matrix = {"e","b","a"};
		
		for(String a : matrix){
			System.out.println(a);
			}
		
	//	List<Integer> lista = Arrays.asList(matrix);
		
		LinkedList<String> lista = new LinkedList<String>(Arrays.asList(matrix));
		
		lista.add("d");
		System.out.println("adaug d");
		
		for (String temp : lista) {
		System.out.println(temp);	
		}
		
		lista.remove(1);
		System.out.println("scoatem elementul 1 ('b')");
		
		Collections.sort(lista);
		
		for (String temp : lista) {
			System.out.println(temp);	
			}
		
		
		
		
		//System.out.println(lista.get(2));
		
		
	}
	
}
