package com.week3;

import java.awt.Graphics;
import java.applet.Applet;

public class FactorialTest extends Applet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void paint(Graphics g) {
        int yPosition = 25;
        for (long i = 0; i < 10; i++) {
            g.drawString("" + i + "! = " + factorial(i),
                         25, yPosition);
            yPosition += 15;
        }
    }
    public long factorial( long number) {
        if (number <= 1)    // base case
            return 1;
        else
            return number * factorial(number - 1);
    }
}