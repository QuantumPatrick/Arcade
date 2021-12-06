package screen;

import javax.swing.JFrame;

import people.User;

public abstract class Screen extends JFrame{ //Still need to be abstract?
	User currentUser;
	public Screen() {
		
	}
	//FIXME: Need to create the screen objects ONCE
	//FIXME: Need to find a way where everytime goToHome(), goToSignIn(), goToLibrary(), etc. is called doesn't create a new object.
	public void goToHome() { 
		new HomeScreen();
	}
	
	public void goToSignIn() {
		new SignInScreen();
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
