
/*
This file: FindWordFrequencies.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: get a filename, examine the file, count the words;
Description:This is the file which opens the file get the text inside, count words and return the number of words and the tree
Last Modified:11/03/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.7
*/
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class FindWordFrequencies {
	//get scanner 
    Scanner s = null;
    //wf to count word frequency
    WordFrequencies wf = new WordFrequencies();
    //default constructor 
    FindWordFrequencies() {}
    //constructor which processes the name
    FindWordFrequencies(String fileName) {
    	try {
    		//open a file which is named the value of filename
    		File f = new File(fileName);
    		// 
    		s = new Scanner(f);
    		//to split words using 
    		s.useDelimiter("[^a-zA-Z]+");
    	}
    	catch ( FileNotFoundException e) {
    		System.out.println("file not found!");
    	}

    }
    // wrong filename then exist.
    boolean buildWordFrequencyMap() {
    	//create a string 
        String nextWord = null;
        //if scanner is null return false , the program stops 
        if(s==null){    // check ... null 
        	return false;
        }
        //else we go on 
        while (s.hasNext()) {   // haven'reached EOF
        	//read the file get the next word
        	nextWord = s.next();
        	//change it to lower case
            nextWord = nextWord.toLowerCase();
            //put the word in the tree
            wf.put(nextWord);
        }
        
        return true;
    }
    //return the number of words
    public int numWords() {return wf.numWords(); }
    //return the whole tree
    public String toString() { return wf.toString(); }
}
