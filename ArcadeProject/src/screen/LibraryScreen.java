package screen;

import java.util.ArrayList;
import games.*;
import people.*;

import java.util.Scanner;

public class LibraryScreen extends Screen {
	// declaration of library of games
	private ArrayList<Game> library;
	
	// default constructor of screen 
	// FIXME: Not sure who wrote this, but this currently rebuilds the library every time we return to the screen
	// 		  Can we find a better way to do this? Do we want this saved to a serialized file too? -Patrick
	public LibraryScreen() {
		library = new ArrayList<Game>();
	}
	
	public void playGame(Game g, User u, LeaderboardScreen l) {
		boolean playAgain = true;
		Scanner againResponse = new Scanner(System.in);
		String response;
		System.out.println("User "+ u.getName() + " is playing " + g.getName());
		
		//add to gamesPlayed for user
		if (u.getGamesPlayed().isEmpty()) { // checks to see if the user has played before FIXME: appears to check if they've never played anything
											// rather than checking if their high score for this game is null.
			u.addGamesPlayed(g);
			u.setPersonalHigh(0);
		}
		
		if (playAgain == true) { //If player chooses to play again
			g.play();
			
			//detect personal high
			detectPersonalHigh(g.getScore(), g, u);
			
			//If top 10 scores
			detectHighScore(g.getScore(), g, u, l);
			g.playAgain();
			System.out.println("Play again? y/n");
			response = againResponse.nextLine();
			
			if (response.toUpperCase().equals("Y")) {
				playAgain = true;
			} 
			
			else {
				playAgain = false;
			}
		} 
		
		else {
			g.reset();
		}
	}
	
	public void detectPersonalHigh(int rec, Game g, User u) {
		if (rec >= u.getHighScores().get(u.getGamesPlayed().indexOf(g))) {
			System.out.println("New personal high!");
			u.getHighScores().set(u.getGamesPlayed().indexOf(g), g.getScore());
		}
	}
	
	public void detectHighScore(int rec, Game g, User u, LeaderboardScreen l) {
		if (l.getScorers().isEmpty()) {
			System.out.println("New high score!");
			l.getScorers().add(u);
		} 
		
		else {
			for (int i = 0; i < l.getScorers().size(); i++) {
				if ((rec >= l.getScorers().get(i).getHighScores().get(l.getScorers().get(i).getGamesPlayed().indexOf(g)))) {
					System.out.println("New high score!");
					l.getScorers().add(i, u);
				}
			}
		}
	}
	
	public ArrayList<Game> getLibrary() { 
		return library;
	}
	
	public void addGame(Game game) {
		library.add(game);
		System.out.println(game.getName() + " has been added to library");
	}
	
}
