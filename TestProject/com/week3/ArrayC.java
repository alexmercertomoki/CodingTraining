package com.week3;

public class ArrayC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a4[][][] = {{{1,1},{1,1},{1,1}},{{1,1},{1,1},{1,1}}};
		for (int i = 0; i < a4.length; i++){
		    for (int j = 0; j < a4[i].length; j++)
		        for (int k = 0; k < a4[i][j].length; k++)
		            a4[i][j][k] = i*j*k;  // silly values
		
		}
	}

}
