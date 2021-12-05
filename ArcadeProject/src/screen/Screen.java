package screen;

public abstract class Screen {
	public Screen() {
		
	}
	
	public void goToHome() {
		System.out.println("Going to home screen");
	}
	
	public void goToSignIn() {
		new SignInScreen();
	}
	
	public void goToLibrary() {
		
	}
}
