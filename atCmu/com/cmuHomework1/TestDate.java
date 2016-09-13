package com.cmuHomework1;

import java.util.*;

public class TestDate {
    public static void main(String[] args) {
    	Date d1=new Date();
    	Date d2=new Date();
    	long t;
        t=d2.getTime()-d1.getTime();
    	
        System.out.println("Hello, it is ");
        System.out.println(t);
    }
}
