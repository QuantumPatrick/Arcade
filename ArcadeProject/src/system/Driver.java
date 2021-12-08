package system;

import javax.swing.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

import screen.Screen;

public class Driver {
	
	public static void main(String args[]) {
		Leaderboard lbTTT = new Leaderboard("TicTacToe");
		Leaderboard lbSnake = new Leaderboard("Snake");
		
		Arcade arcade = new Arcade(lbTTT, lbSnake);
		arcade = Arcade.loadArcadeState();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
		Screen mainScreen = new Screen(frame);
		mainScreen.goToSignIn();
		
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Arcade.saveArcadeState(arcade);
				JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
			}
		});
	}
}
