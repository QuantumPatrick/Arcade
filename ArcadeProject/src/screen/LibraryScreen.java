package screen;

import javax.swing.*;
import system.*;

public class LibraryScreen extends Screen {
	Library lib = new Library();
	JFrame frame;
	
	LibraryScreen() {
		frame = new JFrame();
		
		JLabel text = new JLabel("Game Library", SwingConstants.CENTER);
		
		JButton tttButton = new JButton("TicTacToe");
		JButton snakeButton = new JButton("Snake");
		
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
	
	public static void main(String args[]) {
		new LibraryScreen();
	}
}
