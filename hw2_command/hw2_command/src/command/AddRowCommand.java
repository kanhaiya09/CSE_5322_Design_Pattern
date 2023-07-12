package command;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class AddRowCommand implements Command {

	private JTable table;
	private String id;
	private String name;
	
	public AddRowCommand(JTable table){
		this.table = table;
	}
	
	public AddRowCommand(JTable table,String id, String name){
		this.table = table;
		this.name = name;
		this.id = id;
	}
	
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[]row = { id, name};
		model.addRow(row);
		
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method 
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int lastRowIndex = model.getRowCount() - 1;
		model.removeRow(lastRowIndex);
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[]row = { id, name};
		model.addRow(row);
		
	}

}
