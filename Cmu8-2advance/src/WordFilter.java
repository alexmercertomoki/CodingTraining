import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;




public class WordFilter {
	 //list to get all the words on the file
	static LinkedList<String>  filters=new LinkedList<String>();
    //used to scan through the file
    Scanner sc=null;
    
    
	public WordFilter() {
		try {
			//open stopwordlist
			File sl = new File("stopwordlist.txt");
			// 
			sc = new Scanner(sl);
			//to split words using 
			sc.useDelimiter("[^a-zA-Z]+");
		}
	    //if file is not found, print out message
		catch ( FileNotFoundException e) {
			System.out.println("hey! You should add the stopwordlist file!");
		}
	  
        String nextword=null;
        while (sc.hasNext()) {   
        	
        	//read the file get the next word
        	nextword = sc.next();
        	//change it to lower case
        	nextword = nextword.toLowerCase();
        	//adding the word to the linkedlist
            filters.add(nextword);
           
        }
	}

    // Filter method 
	public static boolean Filters(String a) {
		    //string to get the word from the stopwordlist
		    String  filterword;
		    //iterator for the filter
	        Iterator<String> itrfilters=filters.iterator();
	        //iterates to check if the word is on the list
	        while(itrfilters.hasNext()){
	        	//get the next word on the list
	        	filterword=itrfilters.next();	
	        	//if on the list return false
		        if(a.equals(filterword)){
		        	return false;
		        }
		      
	        }
	        //if no word on the list matches the word given(string a) then return true
	        return true;
	}
  
}
