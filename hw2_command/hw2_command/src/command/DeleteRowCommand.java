package command;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DeleteRowCommand implements Command{

	private JTable table;
	private int deleteIndex;
	private String name;
	private String id; 
	
	
	public DeleteRowCommand(JTable table) {
		this.table = table;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(table.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(null, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			deleteIndex = table.getSelectedRow();
			id = (String)table.getValueAt(deleteIndex, 0);
			name = (String)table.getValueAt(deleteIndex, 1);
			model.removeRow(deleteIndex);
		}
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[]row = { id, name};
		model.insertRow(deleteIndex, row);
		
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		//execute();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(deleteIndex);
	}

}
