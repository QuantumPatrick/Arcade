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
	
	private TicTacToe ttt;
	private Snake snake;
	private User u;
	private LeaderboardScreen l; //FIXME: Do we need a leaderboard class separate to the leaderboardscreen class?
	
	public LibraryScreen(User u, LeaderboardScreen l) {
		frame = new JFrame();
		
		lib = new Library();
		
		//add games to library
		ttt = new TicTacToe();
		ttt.setName("TicTacToe");
		snake = new Snake();
		snake.setName("Snake");
		
		this.u = u; //To know what user will play the games
		this.l = l;
		
		lib.addGame(ttt);
		lib.addGame(snake);
		
		JLabel text = new JLabel("Game Library", SwingConstants.CENTER);
		
		tttButton = new JButton("TicTacToe");
		snakeButton = new JButton("Snake");
		
		tttButton.addActionListener(new ButtonListener());
		snakeButton.addActionListener(new ButtonListener());
		
		frame.add(text);
		frame.add(tttButton);
		frame.add(snakeButton);
		
		text.setBounds(200,0,200,50);
		tttButton.setBounds(150,50,100,50);
		snakeButton.setBounds(350,50,100,50);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(tttButton)) { //FIXME: Still needs to implemented
				System.out.println("tttButton pressed");
			}
			else if (source.equals(snakeButton)) {
				lib.playGame(snake, u, l);
			}
		}
	}
	
	public static void main(String args[]) {
		//new LibraryScreen();
	}
}
