package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import GUI.*;
import adapter.StartButtonListener;
import adapter.StopButtonListener;
import observer.Lawn;
import state.*;

public class LawnMowerController {

	private LawnMowerGUI GUI;
	private State state;
	private int n,m;
	private int i,j;
	private int remaining;
	private Timer timer;
	
	
	public LawnMowerController(int n, int m) {
		super();
		GUI = new LawnMowerGUI(6,10);
		this.n = n;
		this.m = m;
		this.remaining = n*m;
		this.i = 0;
		this.j = 0;
		state = new MowerOff();
		addButtonListeners();
	}

	private void addButtonListeners() {
		GUI.getStartButton().addActionListener(new StartButtonListener(this));
		GUI.getStopButton().addActionListener(new StopButtonListener(this));
	}


	public void setState(State s) {
		this.state = s;
	}

	public void onStart(ActionEvent e) {    
       	startTimer();
	}

	public void onStop(ActionEvent e) {		
		System.out.println("Mower turned off");
		stopTimer();
	}
	
	private void startTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Timer tick " + counter);
            	if(remaining>0)
            	{
            		state.onStart(LawnMowerController.this);
            		remaining--;
            	}else {
            		System.out.println("Completed mowing");
            		timer.stop();
            	}
            }
        });
        timer.start();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.stop();
            State lastState = state;
    		state.onStop(this);
    		state.setLastState(lastState);
            timer = null;
        }
    }

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
	
	
	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public boolean leftEdgeReached() {
		return j==0;
	}

	public boolean rightEdgeReached() {
		return j==m-1;
	}

	public boolean bottomEdgeReached() {
		return i==n;
	}
    
	public Lawn getLawn() {
		return GUI.getLawn();
	}
}
