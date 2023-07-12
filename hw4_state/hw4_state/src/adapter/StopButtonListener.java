package adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.LawnMowerController;

public class StopButtonListener implements ActionListener {
	private LawnMowerController controller;
	
	public StopButtonListener(LawnMowerController controller) {
		super();
		this.controller = controller;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		controller.onStop(e);
	}
}
