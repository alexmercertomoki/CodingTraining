/*
This file: WordFrequencies.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: get a filename, examine the file, count the words;
Description:This is the file which examine the word adds it into the tree or count it up in the tree
Last Modified:11/03/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.7
 */

import java.util.HashMap;

/**
 * 
 * This class holds a Map, each pair of which holds as key a String and as value
 * a WordCount.
 * 
 * @author Stephen Roehrig
 */

public class WordFrequencies {
    
	// change the tree map to hashmap and then add <>.
	public HashMap<String, WordCount> hm = new HashMap<String, WordCount>();

	/**
	 * Inserts a new word into the map, or if the word already exists,
	 * increments its word count.
	 * 
	 * @param c
	 *            the word to be added.
	 */
	WordFilter wf=new WordFilter();
	// examine the words
	public void put(String c) {
		
		// if the word is an interesting word we continue
		boolean contiNue;
		// get contiNue is true or not
		contiNue = wf.Filters(c);
		if (contiNue) {
			// if in the map
			if (hm.containsKey(c))
				// wordcount plus 1
				((WordCount) hm.get(c)).i++;
			else
				// if new, put it in the map
				hm.put(c, new WordCount());
		}
	}

	// return the map
	public String toString() {
		return hm.toString();
	}

	/**
	 * Returns the number of different words in the map.
	 * 
	 * @return
	 */
	// return how many words counted
	public int numWords() {
		return hm.size();
	}

}
