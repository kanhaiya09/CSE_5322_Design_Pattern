package contoller;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.PaintGUI;
import composite_iterator.CompositeShape;
import expert.Box;
import expert.Circle;
import expert.Shape;
import expert.Triangle;

public class PaintGUIController implements ActionListener,MouseListener {
	private PaintGUI paintGUI;	
	private CompositeShape shapes;
	int shapeType;
	public PaintGUIController(PaintGUI gui) {
		paintGUI = gui;
		shapes = new CompositeShape();
    }
	
	
	
	public void AddListener() {
		paintGUI.getBoxButton().addActionListener(this);
		paintGUI.getCircleButton().addActionListener(this);
		paintGUI.getTriangleButton().addActionListener(this);
		paintGUI.getCanvasPanel().addMouseListener(this);		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="Box") {
			System.out.println("Box clicked");
			shapeType = 0;  // for box
		}else if( e.getActionCommand()=="Circle") {
			System.out.println("Cicle clicked");
			shapeType = 1;  // for circle
		}else {
			System.out.println("Triangle clicked");
			shapeType = 2;  // for circle
		}
					
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
        int x = e.getX();
        int y = e.getY();
        System.out.println(x + "," +  y);
        Graphics g = paintGUI.getCanvasPanel().getGraphics();
        	
        Shape newShape;
        if (shapeType == 0) {
            newShape = new Box(x,y);
        } else if (shapeType == 1) {
            newShape = new Circle(x,y);
        } else {
            newShape = new Triangle(x,y);
        }
        shapes.add(newShape);
        g.clipRect(0, 0, paintGUI.getCanvasPanel().getWidth(), paintGUI.getCanvasPanel().getHeight());
        shapes.draw(g);
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
