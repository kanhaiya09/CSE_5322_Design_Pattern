package controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JOptionPane;

import command.AddRowCommand;
import command.Command;
import command.DeleteRowCommand;
import gui.AddRowDialogBox;
import gui.TableGUI;

public class TableGUIController implements ActionListener {
	private TableGUI gui;
	private Stack<Command> undo_stack;
	private Stack<Command> redo_stack;
	
	
	public TableGUIController() {
		gui = new TableGUI();
		gui.getAddButton().addActionListener(this);
		gui.getDeleteButton().addActionListener(this);
		gui.getUndoButton().addActionListener(this);
		gui.getRedoButton().addActionListener(this);
		
		
		undo_stack = new Stack<Command>();
		redo_stack = new Stack<Command>();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Clicked event listener added");
		if(e.getActionCommand()=="Add") {
			addButtonClicked();
		}else if(e.getActionCommand()=="Delete"){
			deleteButtonClicked();
		}else if(e.getActionCommand()=="Undo") {
			undoButtonClicked();
		}else {
			redoButtonClicked();
		}
	}


	private void deleteButtonClicked() {
		Command deleteCmd = new DeleteRowCommand(gui.getTable());
		ExecuteCommand(deleteCmd);
	}


	private void addButtonClicked() {
		// TODO Auto-generated method stub
		AddRowDialogBox window = new AddRowDialogBox();
		Point panelLocation = gui.getTablePanel().getLocationOnScreen();
        Dimension panelSize = gui.getTablePanel().getSize();
        System.out.println(panelLocation.x + " " + panelLocation.y);
        Point dialogLocation = new Point(
                panelLocation.x + (panelSize.width / 2) - (JOptionPane.getRootFrame().getWidth() / 2),
                panelLocation.y + (panelSize.height / 2) - (JOptionPane.getRootFrame().getHeight() / 2)
        );
        JOptionPane.getRootFrame().setLocation(dialogLocation);
		
		int result = JOptionPane.showConfirmDialog(
                window.getMainFrame(),
                window.getMainPanel(),
                "Add Row",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );
		
		
	
		if (result == JOptionPane.OK_OPTION) {
			String id = window.getId();
			String name = window.getName();
			Command addRow = new AddRowCommand(gui.getTable(),id,name);
			ExecuteCommand(addRow);
			//addButtonCommand.execute();
        } else {
            
        }
		
		
		
	}
	
	
	private void ExecuteCommand(Command cmd) {
		cmd.execute();
		redo_stack.clear(); 
		undo_stack.push(cmd);
	}
	
	

	private void redoButtonClicked() {
		// TODO Auto-generated method stub
		if(redo_stack.empty())
			JOptionPane.showMessageDialog(null, "First do undo then redo", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			Command cmd = redo_stack.pop();
			cmd.redo();
			undo_stack.push(cmd);
		}
	}


	private void undoButtonClicked() {
		// TODO Auto-generated method stub
		if(undo_stack.empty())
			JOptionPane.showMessageDialog(null, "Nothing to revert", "Error", JOptionPane.ERROR_MESSAGE);
		else {
			Command cmd = undo_stack.pop();
			cmd.undo();
			redo_stack.push(cmd);
		}
	}

}
