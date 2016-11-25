package base.utils;

import java.util.Random;

/**
 * Created by optaros on 3/25/15.
 */
public class Utils {

	public static String getRndString(){
		StringBuilder builder = new StringBuilder();
		Random rnd = new Random();

		for (int i = 0; i < 10; i++) {
			char c = (char) (rnd.nextInt(122-97)+97);
			builder.append(c);
		}

		return builder.toString();
	}

	public static String getRndString(int length){
		StringBuilder builder = new StringBuilder();
		Random rnd = new Random();

		for (int i = 0; i < length; i++) {
			char c = (char) (rnd.nextInt(122-97)+97);
			builder.append(c);
		}

		return builder.toString();
	}


}
