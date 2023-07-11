package expert;

import java.awt.Graphics;

public class Box extends Shape {
	
	public Box(int x,int y) {
		this.x =  x;
		this.y =  y;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, 100,100);
	}
	
	 
}
