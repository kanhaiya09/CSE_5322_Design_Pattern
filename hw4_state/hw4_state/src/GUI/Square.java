package GUI;

import java.awt.Color;
import java.awt.Dimension;

//import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Square extends JPanel {
	
	private final int length = 50;
	
    public Square() {
        setPreferredSize(new Dimension(length, length));
        setBackground(new Color(0,100,0));
    }
}