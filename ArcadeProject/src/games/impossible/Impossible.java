package games.impossible;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import games.Game;

public class Impossible extends Game {

	JFrame frame;
	Integer finalScore;
	Integer position;
	boolean running;
	
	public Impossible() {
		position = 300;
		JFrame frame = new JFrame();
		ScreenCanvas sc = new ScreenCanvas();
		frame.add(sc);
		frame.setVisible(true);
		frame.repaint();
		frame.setSize(600,600);
		frame.setBackground(Color.blue);
		running = true;
	}
	
	public void end() {
		
		
		
		frame.removeAll();
		
	}
	
	public class ScreenCanvas extends Canvas implements KeyListener {
	
		public ScreenCanvas(){
			this.addKeyListener(this);
		}

		//set up a function to draw the shapes
	    @Override
	    public void paint (Graphics graphics){
	    	graphics.setColor(Color.blue.cyan); 
	    	graphics.fillRect(0,0,600,400);
	    	graphics.setColor(Color.green); 
	    	graphics.fillRect(0,400,600,200);
	    	graphics.setColor(Color.red); 
	        graphics.fillRect(100, position, 20, 20);
	    }
	    
	    public void endGame() {
	    	running = false;
	    }
	    
	    public void update() {
	    	repaint();
	    }
	    
	    public void moveUp() {
	    	if (running) {
		    	position -= 10;
		    	}
	    	if (position <= 0) {
	    		endGame();
	    	}
	    	//System.out.println("up");
	    }
	    
	    public void moveDown() {
	    	if (running) {
	    	position += 10;
	    	}
	    	if (position >= 540) {
	    		endGame();
	    	}
	    	//System.out.println("down");
	    }

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				moveUp();
			}
			System.out.println("recognized");
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				moveDown();
			} 
			//System.out.println("recognized");
			update();
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	}
	
}




