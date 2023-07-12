package state;
import controller.LawnMowerController;

public class SouthWest extends MowerOn {

	public SouthWest() {
		//super(lawn);
	}

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
			// reached bottom turn off the mover
			c.setState(new MowerOff());
		}else {
			c.setState(new East());
		}

	}
}
