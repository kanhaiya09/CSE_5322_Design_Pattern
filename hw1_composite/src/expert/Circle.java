package expert;

import java.awt.Graphics;

public class Circle extends Shape{

	public Circle(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawOval(x, y, 100,100);
	}

	

}
