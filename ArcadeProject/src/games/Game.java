package games;

import java.util.ArrayList;

import people.Player;
import people.User;

public class Game {

	private String name;
	private ArrayList<Player> topScorers;
	private User currentUser;
	
	public Game() {
		this.name = "";
		topScorers = new ArrayList<Player>();
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void play() {
		System.out.println("Launching game");
	}
	
	public void playAgain() {
		System.out.println("Playing again");
	}
	
	public void reset() {
		System.out.println("Resetting game");
	}
	
	public int getScore() { //Will be overridden
		System.out.println("Returning score");
		return 1;
	}
	
	public void sendScoreToUser() {
		int score = this.getScore();
		
		this.currentUser.saveScore(score);
	}
}
