package state;

import controller.LawnMowerController;

public abstract class State {
	
	public abstract void onStart(LawnMowerController c);
	public abstract void onStop(LawnMowerController c);
	public void setLastState(State lastState) {
		
	}
	
	
}
