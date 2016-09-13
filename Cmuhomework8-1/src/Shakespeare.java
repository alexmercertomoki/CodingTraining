/*
This file: Shakespeare.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: get a filename, examine the file, count the words;
Description:This is the file which contains the main method to count words.
Last Modified:11/03/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.7
*/

import java.util.Scanner;

public class Shakespeare {
	// the scanner to get the filename
    private static Scanner keyboard;
   
	public static void main(String[] args) {
		//variables to calculate the time used
    	long start, duration;
    	// get what's input by the keyboard
    	keyboard = new Scanner(System.in);
        System.out.println("Enter the name of a file to count the words ");
        //get the next line input  as the filename
        String KeyboardfName = keyboard.nextLine();
        //Using the filename got from keyboard to get construct a new Findwordfrequencies  
        FindWordFrequencies findFrequencies = new FindWordFrequencies(KeyboardfName);
        //get the starting time
        start = System.currentTimeMillis();
        //this  return value means whether the file is properly opened if not we don't excute 
        boolean r =  findFrequencies.buildWordFrequencyMap();
        // file opened
        if(r){
        //get time used : ending time minus starting time
        duration = System.currentTimeMillis() - start;
        //printout the time used, words frequencies, number of all words
        System.out.println("Duration = " + duration);
        System.out.println(findFrequencies.toString());
        System.out.println("Number of words is " + findFrequencies.numWords());
        }
        //file not opened,print instruction
        else{
        	System.out.println("We cannot open the file ! ");
        }
        
	}
}

		