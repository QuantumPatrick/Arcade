package system;

import java.util.ArrayList;

import people.User;

public class Leaderboard {

	ArrayList<User> scores;
	
	public Leaderboard() {
		ArrayList<User> scores = new ArrayList<User>();
	}
	
	public ArrayList<User> getScorers() {
		return this.scores;
	}
	
	public void addScorers(User u) {
		this.scores.add(u);
	}
	
}
