package expert;

import java.awt.Graphics;


public abstract class Shape{

	
	public void add(Shape s) {
		
	}
	
	//operation
	public abstract void draw(Graphics g);

	// location
	protected int x;
	protected int y;
	
}
