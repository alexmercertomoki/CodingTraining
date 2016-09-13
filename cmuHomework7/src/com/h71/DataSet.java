package com.h71;


/*
This file: DataSet.java
Programmer: Bilei Huang (bhuang@andrew.cmu.edu)
Course/Section: 95-712
Assignment: Generate a random tree and calculate the fitness
Description: a set of DataRow
Last Modified: 10/30/2014
Known Bugs: No bugs at present.
Compiler: JDK 1.6
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {
	
	//independent  variable number we get , how many rows there are and something we use to get data
	public int NumIndepentVar;
	int Row;
	double[] transX;
	DataRow dr;
	//Most importantly arraylist of datarow
	ArrayList<DataRow> da = new ArrayList<DataRow>();
	
    //getter and setters 
	public ArrayList<DataRow> getDa() {
		return da;
	}

	public void setDa(ArrayList<DataRow> da) {
		this.da = da;
	}
    
	//read file get data
	public DataSet(String filename) {
		Scanner file = null;
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException f) {
			System.out.println("We can not find your file");
			System.exit(0);
		}
		
		
            //use string to the the first line
			String l = new String();
            //the first line
			l = file.nextLine();
            //String.split() to split the data into parts
			String[] i = l.split(" ");
			//new dataRow
			dr = new DataRow();
			//get the number of independent variable in the frist line and how many rows there are 
			NumIndepentVar = Integer.parseInt(i[0]);
			Row = Integer.parseInt(i[1]);
			//initial an array with the same size 
			transX = new double[NumIndepentVar];
			//read and get as we know exatly how many lines there are we don't need has next:
			for (int a = 0; a < Row; a++) {
                 //get nextline 
				l = file.nextLine();
				//split 
				i = l.split(" ");
				//setting y
				dr.setY(Double.parseDouble(i[0]));
				// get the rest of the data of the line
				for (int b = 1; b <= NumIndepentVar; b++) {
					transX[b-1] = Double.parseDouble(i[b]);
				}
				
		        //setting the value
				dr.setX(transX);
				//adding this to dataset
				da.add(dr);

			}

	}

}
