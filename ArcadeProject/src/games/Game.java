package games;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import system.Leaderboard;

import people.Player;
import people.User;

public class Game {

	private String name;
	private ArrayList<Player> topScorers;
	private User currentUser;
	private boolean isRunning;
	
	public Game() {
		this.name = "";
		isRunning = true;
		topScorers = new ArrayList<Player>();
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void play(User u, Game g, Leaderboard l) { //Gets overrided
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
	
	public boolean getIsRunning() {
		return isRunning;
	}
	
	public void setIsRunning(boolean b) {
		isRunning = b;
	}
	
	public void detectPersonalHigh(int rec, Game g, User u) {
		if (rec >= u.getHighScores().get(u.getGamesPlayed().indexOf(g))) {
			System.out.println("New personal high!");
			JOptionPane.showConfirmDialog(null, "New personal high of " + rec + "!", "New Personal High", JOptionPane.PLAIN_MESSAGE);
			u.getHighScores().set(u.getGamesPlayed().indexOf(g), g.getScore());
		}
	}
	
	public void detectHighScore(int rec, Game g, User u, Leaderboard l) {
		if (l.getScorers().isEmpty()) {
			System.out.println("New high score!");
			JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New High Score", JOptionPane.PLAIN_MESSAGE);
			l.getScorers().add(u);
		} 
		
		else {
			for (int i = 0; i < l.getScorers().size(); i++) {
				if ((rec >= l.getScorers().get(i).getHighScores().get(l.getScorers().get(i).getGamesPlayed().indexOf(g)))) {
					JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New Personal Score", JOptionPane.PLAIN_MESSAGE);
					System.out.println("New high score!");
					l.getScorers().add(i, u);
				}
			}
		}
	}
}
