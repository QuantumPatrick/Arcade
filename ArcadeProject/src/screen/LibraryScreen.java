package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import system.*;
import games.tictactoe.*;
import games.snake.*;
import people.*;

public class LibraryScreen extends Screen {
	private Library lib;
	private JFrame frame;
	private JButton tttButton;
	private JButton snakeButton;
	private JButton backButton;
	
	private TicTacToe ttt;
	private Snake snake;
	private User u;
	private Leaderboard l; //FIXME: Do we need a leaderboard class separate to the leaderboardscreen class?
	
	public LibraryScreen(JFrame frame) {
	//public LibraryScreen(User u, JFrame frame) {
		super(frame);
		this.frame = frame;
		
		lib = new Library();
		
		//add games to library
		ttt = new TicTacToe();
		ttt.setName("TicTacToe");
		snake = new Snake("Snake");
		
		//u = new User();
		this.u = Arcade.getCurrentUser(); //To know what user will play the games
		
		lib.addGame(ttt);
		lib.addGame(snake);
		
		JLabel text = new JLabel("Game Library", SwingConstants.CENTER);
		
		tttButton = new JButton("TicTacToe");
		snakeButton = new JButton("Snake");
		backButton = new JButton("Back");

		
		tttButton.addActionListener(new ButtonListener());
		snakeButton.addActionListener(new ButtonListener());
		backButton.addActionListener(new ButtonListener());
		
		frame.add(text);
		frame.add(tttButton);
		frame.add(snakeButton);
		frame.add(backButton);
		
		text.setBounds(200,0,200,50);
		tttButton.setBounds(150,50,100,50);
		snakeButton.setBounds(350,50,100,50);
		backButton.setBounds(25,25,100,50);
		
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void handleGoToBack() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToHome();
	}

	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(tttButton)) { //FIXME: Still needs to implemented
				//lib.playGame(ttt, u, Arcade.getLeaderboard());
				if (u.getGamesPlayed().isEmpty() || u.checkGame(ttt) == false) { //Checks to see if user has not played games or not played the game before
					u.addGamesPlayed(ttt);
					u.setPersonalHigh(0);
				}
				
				ttt.play(u, ttt, Arcade.getLeaderboard("TicTacToe"));
				
			}
			else if (source.equals(snakeButton)) {
				//lib.playGame(snake, u, Arcade.getLeaderboard());
				
				//if(u.checkGame(snake) == false) {
					if (u.getGamesPlayed().isEmpty()){ //Checks to see if user has not played games or not played the game before
						u.addGamesPlayed(snake);
						u.setPersonalHigh(0);
					}
				//}
				snake = new Snake(u, snake, Arcade.getLeaderboard("Snake"));
				
//				System.out.println(ss.getIsRunning());
				
//				System.out.println("Exit");
//				
//				System.out.println("Exit");
//				snake = ss;
				
				//do snake.play
				//back button sends values to leaderboard
				
			}
			else if (source.equals(backButton)) {
				handleGoToBack();
			}
		}
	}
	
//	public static void main(String args[]) {
//		//new LibraryScreen();
//	}
}
