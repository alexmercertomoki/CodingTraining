//Problem        : Twin Primes
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       int k=  stdin.nextInt();
       
       for(int i=k;i>0;i--){
    	   if(isPrime(i)){
    		   int j = i-2;
    		   if(isPrime(j)){
//    			   int temp[]={j,i};
    			   System.out.print(j+","+i);
    			
    			   stdin.close();
    			   return;
    		   }
    	   }
       } 
           
       
       
    }
    
    static boolean isPrime(int n) {
        for(int i=2;2*i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

}

