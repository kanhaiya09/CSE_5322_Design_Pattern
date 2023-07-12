package state;

import controller.LawnMowerController;

public class SouthEast extends MowerOn {

	@Override
	public void onStart(LawnMowerController c) {
		move(c);
		
	}

	@Override
	public void onStop(LawnMowerController c) {
		c.setState(new MowerOff());
		
	}

	private void move(LawnMowerController c) {
		//System.out.println("going down by 1");
		
		//update lawn
		c.getLawn().update(c.getI(), c.getJ());
		
		// move 1 down
		c.setI(c.getI()+1);
		
		if(c.bottomEdgeReached()) {
			c.setState(new MowerOff());
		}else
			//change state to west
			c.setState(new West());
			
	}

}
