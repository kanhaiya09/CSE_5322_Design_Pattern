package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableGUI {
	JFrame window;
	JPanel tablePanel;
	JPanel buttonsPanel;
	JButton addButton, deleteButton, undoButton, redoButton;
	JTable table;
	
	public TableGUI() {
		initialize();
	}
	
	public void initialize() {
		
		//Main window
		window = new JFrame();
		window.setTitle("Table");
		window.setSize(720,720);
		window.setLocationRelativeTo(null);
		
		
		// Table panel
		tablePanel = new JPanel(new BorderLayout());
		tablePanel.setBackground(Color.WHITE);
		tablePanel.setPreferredSize(new Dimension(0,620));
		
		
		// create an empty table with three columns
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Id", "Name"}, 0);
        table = new JTable(model);
        table.setBackground(new Color(255,255,255));
    
        // center the table within the panel
        tablePanel.add(table.getTableHeader(), BorderLayout.PAGE_START);
        tablePanel.add(table, BorderLayout.CENTER);
        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
        
        
		
		//Buttons Panel
		buttonsPanel = new JPanel();
		//create buttons and add it in panel
		addButton = new JButton("Add");
		deleteButton = new JButton("Delete");
		undoButton = new JButton("Undo");
		redoButton = new JButton("Redo");

		//buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		buttonsPanel.add(addButton);
		buttonsPanel.add(deleteButton);
		buttonsPanel.add(undoButton);
		buttonsPanel.add(redoButton);
		
		

		// add in frame
		window.add(tablePanel,BorderLayout.NORTH);
		window.add(buttonsPanel,BorderLayout.SOUTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.validate();
		
	}

	
	public JButton getAddButton() {
		return addButton;
	}
	
	public JButton getDeleteButton() {
		return deleteButton;
	}
	
	public JButton getUndoButton() {
		return undoButton;
	}
	
	public JButton getRedoButton() {
		return redoButton;
	}
	
	public JPanel getTablePanel(){
		return tablePanel;
	}
	
	public JTable getTable() {
		return table;
	}
}
