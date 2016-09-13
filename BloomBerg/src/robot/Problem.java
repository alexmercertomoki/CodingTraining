package robot;

//Problem        : Help The Robot
//Language       : Java
//Compiled Using : javac
//Version        : Java 1.7.0_65
//Input for your program will be provided from STDIN
//Print out all output from your program to STDOUT

import java.util.ArrayList;
import java.util.Scanner;
//Your submission should *ONLY* use the following class name
public class Problem
{
    public static void main(String[] args)
    {

       Scanner stdin = new Scanner(System.in);
       int row = stdin.nextInt();
       int col = stdin.nextInt();
       
       int maze[][]= new int[row][col];
       
       
       
       String s =  stdin.nextLine();
       String[]  Line=s.split(" ");
       int[] temp=new int[Line.length];
       for(int a=0;a<Line.length;a++){
    	  temp[a]=Integer.parseInt(Line[a]);
    	  
       }
       
       
       for(int i=row-1;i>=0;i--){
//    	   for(int j=0;j<col;j++){
//    		  
//    	   }
    	   maze[i] = temp;
    	   
       }
       
       ArrayList  a = new ArrayList();
       
       int sum =0;
       
       for(int i=row-1;i>=0;i--){ 
    	   for(int j=0;j<col;j++){
    		  
    		   
    	   }  
       }
      
       
       stdin.close();
       
    }

    
    
    public static ArrayList<ArrayList<Integer>> getPaths(int[][]A, int i, int j, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPaths) {
        int n = A.length;
        if (i>=0 || j>=n) return allPaths;
        if (i==0 && j==n-1) {
            path.add(A[i][j]);
            allPaths.add(new ArrayList<Integer>(path));
            return allPaths;
        }
        path.add(A[i][j]);
        getPaths(A, i, j+1, path, allPaths);
        getPaths(A, i+1, j, path, allPaths);

        path.remove(path.size()-1);
		return allPaths;
    }
    
    
   

}

