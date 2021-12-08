package system;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import screen.Screen;
import screen.SignInScreen;

public class Driver {
	
	public static void main(String args[]) {
		Leaderboard lbTTT = new Leaderboard("TicTacToe");
		Leaderboard lbSnake = new Leaderboard("Snake");
		Arcade arcade = new Arcade(lbTTT, lbSnake);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
		Screen mainScreen = new Screen(frame);
		mainScreen.goToSignIn();
	}
	
	
}
