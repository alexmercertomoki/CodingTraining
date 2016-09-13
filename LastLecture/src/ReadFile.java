import java.awt.Container;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;

import javax.swing.JApplet;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReadFile extends JApplet {
    JTextArea t = new JTextArea(15, 40);
    BufferedReader in;
    public void init() {
        String line;
        try {
            in = new BufferedReader(new FileReader("ShowButtons.java"));
            while((line = in.readLine()) != null) {
            	t.append(line);
                t.append("\n");
            }
        }
        catch(Exception e){System.err.println("Error reading file");}
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JScrollPane(t));
    }
//    public static void main(String[] args) {
//        Console.run(new ReadFile(), 500, 300);
//    }

}


