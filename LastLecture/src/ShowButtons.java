import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;



public class ShowButtons extends JApplet {
    JButton
      b1 = new JButton("Button1"),
      b2 = new JButton("Button2");
    JTextField txt = new JTextField(10);
    
    class BL implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton)e.getSource()).getText();
            txt.setText(name);
        }
    }
    BL aListener = new BL();
    public void init() {
        b1.addActionListener(aListener);
        b2.addActionListener(aListener);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(b1);
        cp.add(b2);
        cp.add(txt);
    }
}
