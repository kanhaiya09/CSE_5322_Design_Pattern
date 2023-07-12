package state;

import controller.LawnMowerController;

public class West extends MowerOn {

	public West() {
		//super(lawn);
		//System.out.println("West called");
	}
	
	@Override
	public void onStart(LawnMowerController c) {
		move(c);
		
	}

	@Override
	public void onStop(LawnMowerController c) {
		// TODO Auto-generated method stub
		c.setState(new MowerOff());
	}
	

	private void move(LawnMowerController c) {
		//System.out.println("Moved west");
		c.getLawn().update(c.getI(), c.getJ());
		c.setJ(c.getJ()-1);
		if(c.leftEdgeReached()){
			c.setState(new SouthWest());
		}else {
			c.setState(this);
		}
	}

}
