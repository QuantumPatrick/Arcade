package system;

import javax.swing.JFrame;

import screen.Screen;
import screen.SignInScreen;

public class Driver {
	
	public static void main(String args[]) {
		Arcade arcade = new Arcade();
		JFrame frame = new JFrame();
		Screen mainScreen = new Screen(frame);
		mainScreen.goToSignIn();
	}
	
	
}
