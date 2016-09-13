		
        /*
		This file: Index Searching Prgram
		Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
		Course/Section: 95-712
		Assignment: First Java Program to search for certain string and print out the line
		Description: Type in a .txt file and a keyword to search for, if the .txt file is found, 
		the program start searching, if not, exit. As the searching begins the program compares each line.
		if it has found a line that contains the keyword we need, the line will be printed out.
		Last Modified: 08/31/2014
		Known Bugs: No bugs at present.
		Compiler: JDK 1.6
		*/

package com.cmuHomework1;

		
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class IndexFinder {

	
	public static void main(String[] args) {
		 //the String is used to hold one line of the txt file
		 String theLine =new String();
		 
		 System.out.println("please enter the name of a txt file to check out ");
		 // Initiate two scanners one is to find proper file the other is for the keyword searching
		 Scanner fromKeyborad = new Scanner(System.in);
		 Scanner whatToSearch = new Scanner(System.in);
		
		 //get a name from the keyboard to find file
	        String fileName = fromKeyborad.nextLine();
	      
	       
	        Scanner file = null;
	        try {
	        	file = new Scanner(new File(fileName));
	        }
	        catch (FileNotFoundException f) {
	        	System.out.println("We can not find your file");
	        	System.exit(0);
	        }
	        
	        System.out.println("please enter what you want to search about ");
	        //to get a keyword from keyboard to know what to search for
	        String aboutSearch = whatToSearch.nextLine();
	        //read the file
	        while(file.hasNextLine() == true) {
	        	//put the line read from the file into the string
	        	theLine= file.nextLine();
	        	//judge whether the line contains the keyword,if it does, print out.
	        	if(theLine.contains(aboutSearch)){
	        		  System.out.println(theLine);
	        	}
	            
	        }
	        System.out.println("We have finished sir");
	}

}
//*citation: how to find out a file is learnt from what been taugh during class  
