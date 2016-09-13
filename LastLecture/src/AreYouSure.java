import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class AreYouSure extends JApplet {
    JButton b = new JButton("Quit");
    String beginMessage = new String("Are you");
    String midMessage = new String();
    String endMessage = new String(" sure you want to quit?");
    String message;
    // add ActionListener here (next slide)
    BL al = new BL();
    public void init() {
        b.addActionListener(al);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(b);
    }


   class BL implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        message = beginMessage + endMessage;
        int i = JOptionPane.YES_OPTION;
        while (i != JOptionPane.NO_OPTION) {
            i = JOptionPane.showConfirmDialog(null,
                  message, "Choose one", 
                  JOptionPane.YES_NO_OPTION);
            midMessage += " really";
            message = beginMessage + midMessage + endMessage;
        }
        midMessage = "";
    }
  }
}