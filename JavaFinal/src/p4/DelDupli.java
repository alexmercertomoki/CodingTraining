package p4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DelDupli {
	  public static void main(String[] args) {
	  char  c;
	  String line = "";
	//  Scanner keyboard = new Scanner(System.in);
    //  System.out.println("Enter the name of a file to eliminate e: ");
     // String fName = keyboard.nextLine();
      Scanner file = null;
      try {
      	file = new Scanner(new File("Happy.txt"));// ?????
      	file.useDelimiter("e");
      }
      catch (FileNotFoundException f) {
      	System.out.println("Sorry, couldn't find that file.");
      	System.exit(0);
      }
      
      
      while(file.hasNext() == true) {
          
         System.out.print(file.next());
          
      }
	 }
      
}
