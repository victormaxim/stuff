package com.lynda.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Main {

	public static void main(String[] args) {
		try {
			File f1 = new File("loremipsum.txt");
			File f2 = new File("target.txt");
			
			FileUtils.copyFile(f1, f2);
			
			System.out.println("File copied!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
