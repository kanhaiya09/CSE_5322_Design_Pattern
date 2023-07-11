package expert;

import java.awt.Graphics;

public class Triangle extends Shape {
	
	public Triangle(int x,int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int len = 100;
		int[] xPoints = new int[] { x , x - len/2,x + len/2};
		int[] yPoints = new int[] { y , y + len  ,y + len};
		g.setPaintMode();
		g.drawPolygon(xPoints, yPoints, 3);
	}


	
}
