package screen;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import people.User;

public class Screen extends JFrame{ //Still need to be abstract?
	
	protected User currentUser;
	public JFrame frame;
	
	public Screen(JFrame frame) {
		this.frame = frame;

	}
	//FIXME: Need to create the screen objects ONCE
	//FIXME: Need to find a way where everytime goToHome(), goToSignIn(), goToLibrary(), etc. is called doesn't create a new object.
	public void goToHome() { 
		new HomeScreen(frame);
	}
	
	public void goToSignIn() {
		new SignInScreen(frame);
	}
	
	public void goToLibrary() { //FIXME: Still needs to add leaderboardscreen
		new LibraryScreen(currentUser,frame);  
	}

	public void goToProfile() {
		new ProfileScreen(frame);
	}

	public void goToLeaderboard() {
		// TODO Auto-generated method stub
		
	}
	
	public void setUser(User u) {
		this.currentUser = u;
	}
}
