package adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.LawnMowerController;

public class StartButtonListener implements ActionListener {

	private LawnMowerController controller;
	
	
	
	public StartButtonListener(LawnMowerController controller) {
		super();
		this.controller = controller;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		controller.onStart(e);
	}

}
