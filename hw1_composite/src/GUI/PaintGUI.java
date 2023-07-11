package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import contoller.PaintGUIController;

public class PaintGUI {
	private JFrame frame;
	private JPanel buttonPanel;
	private JPanel canvasPanel;
	
	JButton circleButton ;
	JButton rectangleButton;
	JButton triangleButton;

	PaintGUIController controller;
	
	public PaintGUI(){
		initialize();
		controller = new PaintGUIController(this);
		controller.AddListener();
	}


	private void initialize() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setTitle("Paint");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,500);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(false);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

		canvasPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		canvasPanel.setBackground(Color.WHITE);
		
		rectangleButton = new JButton("Box");
		circleButton = new JButton("Circle");
		triangleButton = new JButton("Triangle");
			
		// Add the buttons to the panel
		//buttonPanel.add(Box.createVerticalGlue());
		buttonPanel.add(Box.createVerticalStrut(10));
		buttonPanel.add(circleButton);
		buttonPanel.add(Box.createVerticalStrut(10)); // Add some spacing between buttons
		buttonPanel.add(rectangleButton);
		buttonPanel.add(Box.createVerticalStrut(10)); // Add some spacing between buttons
		buttonPanel.add(triangleButton);
		//buttonPanel.add(Box.createVerticalGlue());
		
        /*buttonPanel.add(circleButton);
        buttonPanel.add(rectangleButton);
		buttonPanel.add(triangleButton);
		*/
		
		rectangleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		circleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		triangleButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		frame.add(buttonPanel,BorderLayout.WEST);
		frame.add(canvasPanel,BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	
	public JButton getBoxButton() {
        return rectangleButton;
    }

	public JButton getCircleButton() {
        return circleButton;
    }
	
	
    public JButton getTriangleButton() {
        return triangleButton;
    }
    
    public JPanel getCanvasPanel() {
        return canvasPanel;
    }
    

}
