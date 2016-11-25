package jFrames;

/**
 * Created by user on 11/25/2016.
 */
public class SimpleInputUser {
    static String prompt;
    public static void main (String[] args){

        SimpleInput x = new SimpleInput();
        prompt  = x.getString();
        System.out.println(prompt);

    }
}
