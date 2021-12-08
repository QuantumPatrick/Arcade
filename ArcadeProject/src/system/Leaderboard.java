package system;

import java.util.ArrayList;
import games.Game;

import people.User;

public class Leaderboard {

	ArrayList<User> scores;
	String game;
	
	public Leaderboard(String s) {
		scores = new ArrayList<User>();
		game = s;
	}
	
	public ArrayList<User> getScorers() {
		return this.scores;
	}
	
	public void addScorers(User u) {
		this.scores.add(u);
	}
	
}
