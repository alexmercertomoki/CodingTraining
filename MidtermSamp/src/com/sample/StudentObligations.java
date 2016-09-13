package com.sample;

public class StudentObligations extends Obligations {
       StudentObligations(String t, String d,String c) {
		super(t, d);
		// TODO Auto-generated constructor stub
		this.MISM_MSITstudent=c;
	}

	String MISM_MSITstudent;
       
}
