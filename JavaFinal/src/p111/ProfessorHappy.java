package p111;
/*
This file: Professor Happy
Final Exam
Compiler: JDK 1.6
*/
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ProfessorHappy extends JApplet{
     //Add a button name Dear professor
	 JButton b1 = new JButton("Dear Professor");
     //initiation
     public void init() {
      //adding a container to hold everything
      Container cp = getContentPane();
      //use flowlayout
      cp.setLayout(new FlowLayout());
      //adding button to the container
      cp.add(b1);
      //actionlistener
      BYE a = new BYE();
      //adding the listener to the button
      b1.addActionListener(a);
     
     }
     //I add an inner class implements the listener
     private class BYE implements ActionListener {
    	 //when button is clicked
         public void actionPerformed(ActionEvent e) {
        	 //show a confirm box shows happy holiday!!
        	 // since it's a confirm box you can go back and forth to enjoy haha!!
        	 JOptionPane.showConfirmDialog(null, "Happy Holidays!!!!!!!!!!!!!!!");
         }
     }

 

}

