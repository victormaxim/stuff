import java.util.ArrayList;
import java.util.HashMap;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("California");
		list.add("Oregon");
		list.add("Washington");
		
		System.out.println(list);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("California", "Sacramento");
		map.put("Oregon", "Salem");
		map.put("Washington", "Olympia");
		System.out.println(map);

	}

}
