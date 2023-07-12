package gui;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddRowDialogBox {

	private JFrame frame; 
	private JPanel panel;
	private JLabel idLabel,nameLabel;
	private JTextField idField,nameField;
	
	public AddRowDialogBox() {
		
		initialize();
		
	}
	
	private void initialize() {
		frame = new JFrame("My Frame");
	    panel = new JPanel(new GridLayout(0, 2));
	    idLabel = new JLabel("Id:");
	    idField = new JTextField(20);
	    nameLabel = new JLabel("Name:");
	    nameField = new JTextField(20);

	    panel.add(idLabel);
	    panel.add(idField);
	    panel.add(nameLabel);
	    panel.add(nameField);
	    
	}
	 
	
	public JFrame getMainFrame() {
		return frame;
	}
	
	public JPanel getMainPanel() {
		return panel;
	}

    public String getId() {
    	return idField.getText();
    }
    
    public String getName() {
    	return nameField.getText();
    }
}
