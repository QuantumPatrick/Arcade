package games.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.*;

import games.snake.SnakeWindow.SnakePanel.MyKeyAdapter;

public class SnakeWindow extends JFrame{
	private int screenWidth = 600; //Panel width
	private int screenHeight = 600; //Panel height
	private int boxSize = 25; //Size of box (individual unit of grid)
	private int boxTotal= (screenWidth * screenHeight)/boxSize; //Number of boxes
	private int x[] = new int[boxTotal]; //x coordinates
	private int y[] = new int[boxTotal]; //y coordinates
	private int delay = 75;
	
	private int bodyLength = 6;
	private int score;
	private int xDot; //What snake collects position
	private int yDot;
	private char direction = 'r';
	
	SnakePanel sp;
	
	public SnakeWindow(){
		sp = new SnakePanel();
		this.add(sp); //Needs to be first
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Snake");
		this.pack(); //Alternative to setSize()
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	public int getScore() {
		return score;
	}
	
	public class SnakePanel extends JPanel implements ActionListener{
		boolean running = false;
		Timer timer;
		Random random;
		
		public SnakePanel() {
			random = new Random();
			this.setPreferredSize(new Dimension(screenWidth, screenHeight)); //Dont use set size since preferred size can be used when there is a parent layout (snakeWindow)
			this.setBackground(Color.BLACK);
			this.setFocusable(true);
			this.addKeyListener(new MyKeyAdapter());
			start();
		}
		
		public void start() {
			running = true;
			randomDot();
			timer = new Timer(delay, this);
			timer.start();
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			draw(g);
		}
		
		public void draw(Graphics g) {
			
			if(running) {
				for (int i = 0; i < screenHeight/boxSize; i++) { //Draw grid
					g.drawLine(i*boxSize, 0, i*boxSize, screenHeight);
					g.drawLine(0, i*boxSize, screenWidth, i*boxSize);
					//g.setColor(Color.WHITE);
				}
				g.setColor(Color.RED);
				g.fillOval(xDot, yDot, boxSize, boxSize);
				
				for(int i = 0; i < bodyLength; i++) {//draw snake
					if (i == 0) {
						g.setColor(Color.GREEN);
						g.fillRect(x[i], y[i], boxSize, boxSize);
					} else {
						g.setColor(Color.BLUE);
						g.fillRect(x[i], y[i], boxSize, boxSize);
					}
					g.setColor(Color.WHITE);
					g.setFont(new Font("Comic Sans", Font.BOLD, 20));
					FontMetrics metrics = getFontMetrics(g.getFont());
					g.drawString("Score: " + score, screenWidth - metrics.stringWidth("Score: " + score)- 50, g.getFont().getSize());
				}
			} else {
				gameOver();
			}
		}
		
		public void move() {
			for(int i = bodyLength; i > 0; i--) { //x[0] and y[0] refers to the head. This is where the rest of the body follows along
				x[i] = x[i-1]; 
				y[i] = y[i-1];
			}
			
			if (direction == 'u') {
				y[0] = y[0] - boxSize;
			} else if (direction == 'd') {
				y[0] = y[0] + boxSize;
			} else if (direction == 'l') {
				x[0] = x[0] - boxSize;
			} else if (direction == 'r') {
				x[0] = x[0] + boxSize;
			} 
		}
		
		public void checkCollect() {
			if ((x[0] == xDot) && (y[0] == yDot)) {
				bodyLength = bodyLength + 1;
				score = score + 1;
				randomDot();
			}
		}
		

		public void randomDot() {
			xDot = random.nextInt((int)screenWidth/boxSize)* boxSize;
			yDot = random.nextInt((int)screenHeight/boxSize)* boxSize;
		}
		
		public void checkCollision() {
			for (int i = bodyLength; i> 0; i--) {
				if ((x[0] == x[i]) && (y[0] == y[i])) { //x[0] and [y] refers to the position of the head
					running = false;
				}
			}
			
			if(x[0] < 0) {
				running = false;
			}
			
			if(x[0] > screenWidth-boxSize) {
				running = false;
			}
			
			if(y[0] < 0) {
				running = false;
			}
			
			if(y[0] > screenHeight-boxSize) {
				running = false;
			}
			
			if(running == false) {
				timer.stop();
			}
			
		}
		
		
		
		public class MyKeyAdapter extends KeyAdapter{
			public void keyPressed(KeyEvent k) {
				if (k.getKeyCode() == KeyEvent.VK_LEFT) {
					if(direction != 'r') { //prevents going into body
						direction = 'l';
					}
				} else if (k.getKeyCode() == KeyEvent.VK_UP) {
					if(direction != 'd') {
						direction = 'u';
					}
				} else if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
					if(direction != 'l') {
						direction = 'r';
					}
				} else if (k.getKeyCode() == KeyEvent.VK_DOWN) {
					if(direction != 'u') {
						direction = 'd';
					}
				} 
			}
		}
		
		public void actionPerformed(ActionEvent e) { //Called when ever any operation on snake panel
			if(running) {
				move();
				checkCollect();
				checkCollision();
			}
			repaint();
		}
		
		public void gameOver() {
			JLabel gameOverLabel = new JLabel("Game Over");
			Object[] p = {gameOverLabel};
			
			int option = JOptionPane.showConfirmDialog(null, p, "Game over", JOptionPane.PLAIN_MESSAGE);
			if (option == JOptionPane.OK_OPTION) {
				super.removeAll();
			}
			
		}
	}
}
