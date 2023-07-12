package observer;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import GUI.Square;


/*  Here Lawn is working as Observer 
 *  MoverState is working as Subject/Observable
 *  Since State can get the Lawn object using controller, I didn't put Lawn object in State
 *  Thats why I didn't include addObserver() method, Observer/Subject interface (As mentioned in assignment)  
 *  As soon as Mover moves(works as notify of subject) , it calls update on the lawn
 *  Also, this is 1(1 mover)-1( 1 lawn) mapping so I didn't include Observer and Subject interface 
 * */


public class Lawn {

	private int n,m;
	private JPanel squarePanel;
	private Square[][] lawn;
	
	public Lawn(int n, int m) {
		this.n = n;
		this.m = m;
		intialize();
	}


	private void intialize() {
		squarePanel = new JPanel();
		squarePanel.setLayout(new GridLayout(n,m));
		squarePanel.setBackground(new Color(0, 100, 0));
		lawn = new Square[n][m];
		for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Square square = new Square();
                lawn[i][j] = square;
                squarePanel.add(square);
            }
        }
	}
	
	public Square[][] getLawn() {
		return lawn;
	}
	
	public JPanel getSquarePanel() {
		return squarePanel;
	}
		

	public void update(int i,int j) {
		lawn[i][j].setBackground(Color.GREEN);
		lawn[i][j].setBorder(BorderFactory.createMatteBorder(0,0,1,1, Color.WHITE));
	}

}

