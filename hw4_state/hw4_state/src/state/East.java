package state;


import controller.LawnMowerController;

public class East extends MowerOn {
	
	public East() {
	
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
		//System.out.println("Moved east");
		c.getLawn().update(c.getI(), c.getJ());
		c.setJ(c.getJ()+1);
		if(c.rightEdgeReached()){
			c.setState(new SouthEast());
		}else
			c.setState(East.this);
	}
}
