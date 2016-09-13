package com.cmu.help;


import java.util.*;

public class You{

   public static void main(String[] args) {

      String s = "Hello World! 3+3.0=6";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // find a string "World"
      System.out.println("" + scanner.findInLine("World"));

      // print the rest of the string
      System.out.println("" + scanner.nextLine());

      // close the scanner
      scanner.close();
   }
}