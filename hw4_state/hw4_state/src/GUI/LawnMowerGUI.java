package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import observer.Lawn;

public class LawnMowerGUI {

	JFrame window;
	JPanel lawnPanel;
	JPanel buttonPanel;
	JButton startButton, stopButton;
	private Lawn lawn;
	private int n,m;
	

	public LawnMowerGUI(int n,int m) {
		this.n = n;
		this.m = m;
		initialize();
	}

	private void initialize() {
		//Main window
		window = new JFrame();
		window.setTitle("Mower Machine");
		
	
		// create the buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        
        // create the button panel with the buttons
        buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // adds some space between the buttons
        buttonPanel.add(stopButton);
		
        
        // create the second panel with the lawn
        lawn = new Lawn(n, m);
        lawnPanel = new JPanel();
        lawnPanel.setBackground(new Color(0,100,0));
        lawnPanel.add(lawn.getSquarePanel());
        
        
        // add in frame
 		window.add(buttonPanel, BorderLayout.NORTH);
 		window.add(lawnPanel, BorderLayout.CENTER);
 		
 		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		window.setVisible(true);
 		window.pack();
 		window.setLocationRelativeTo(null);
 		
 		window.validate();
        
        
	}
	
	public JButton getStartButton() {
		return startButton;
	}

	public JButton getStopButton() {
		return stopButton;
	}

	public Lawn getLawn() {
		return lawn;
	}

}


