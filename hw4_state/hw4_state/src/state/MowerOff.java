package state;
import controller.LawnMowerController;

public class MowerOff extends State {
	
	State lastState;

	public MowerOff() {
		lastState = new East();
	}


	@Override
	public void onStart(LawnMowerController c) {
		lastState.onStart(c);
		
	}


	@Override
	public void onStop(LawnMowerController c) {
		System.out.println("Mower is off");
	}


	public State getLastState() {
		return lastState;
	}


	public void setLastState(State lastState) {
		this.lastState = lastState;
	}

	
}
