package com.cmu.help;

import java.util.*;
import java.io.*;

public class ScanandSearch {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the file name: " + "\n");
		String fName = keyboard.nextLine();
		Scanner file = null;
		
		try{
			file = new Scanner(new File(fName));
		}
		catch(FileNotFoundException f){
			System.out.println("Sorry, file not found!");
			System.exit(0);
		}
		
		System.out.println("Enter the pattern: " + "\n");
		String pattern = keyboard.nextLine();
				
		while(file.hasNextLine()==true) {
			String a=file.nextLine();
		    if (file.findInLine(arg0)){
			 System.out.println(file.nextLine());
		    }
			//System.out.println(file.nextLine()+file.findInLine(pattern));
			System.out.println();
		}
		System.out.println("Finished!");
		
		keyboard.close();

	}

}
