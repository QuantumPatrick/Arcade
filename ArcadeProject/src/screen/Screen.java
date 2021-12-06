package screen;

import people.User;

public abstract class Screen {
	User currentUser;
	public Screen() {
		
	}
	
	public void goToHome() {
		new HomeScreen();
	}
	
	public void goToSignIn() {
		new SignInScreen();
	}
	
	public static void goToLibrary() {
		new LibraryScreen();
	}

	public static void goToProfile() {
		// TODO Auto-generated method stub
		
	}

	public static void goToLeaderboard() {
		// TODO Auto-generated method stub
		
	}
}
