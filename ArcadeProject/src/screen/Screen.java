package screen;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import people.User;

public class Screen extends JFrame{ //Still need to be abstract?
	
	User currentUser;
	JFrame frame;
	
	public Screen(JFrame frame) {
		this.frame = frame;
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	//FIXME: Need to create the screen objects ONCE
	//FIXME: Need to find a way where everytime goToHome(), goToSignIn(), goToLibrary(), etc. is called doesn't create a new object.
	public void goToHome() { 
		new HomeScreen(frame);
	}
	
	public void goToSignIn() {
		new SignInScreen(frame);
	}
	
	public static void goToLibrary() { //FIXME: Still needs to add leaderboardscreen
		//new LibraryScreen(currentUser);  
	}

	public static void goToProfile() {
		// TODO Auto-generated method stub
		
	}

	public static void goToLeaderboard() {
		// TODO Auto-generated method stub
		
	}
}
