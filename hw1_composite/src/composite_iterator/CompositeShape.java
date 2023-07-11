package composite_iterator;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import expert.Shape;

public class CompositeShape extends Shape{

	private ArrayList<Shape> collection;
	
	
	public CompositeShape() {
		collection = new ArrayList<Shape>();
	}
	
	public void add(Shape p) {
		collection.add(p);
	}
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Iterator<Shape> itr = collection.iterator();
		while(itr.hasNext()) {
			Shape s = itr.next();
			s.draw(g);
		}
	}
	
}
