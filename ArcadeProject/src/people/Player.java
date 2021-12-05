package people;

import java.util.ArrayList;
import games.Game;
import system.Date;

public class Player extends User {
	// attributes
	public Date cakeDay;
	
	public Player(String name, Date cakeDay) {
		this.highScores = new ArrayList<Integer>();
		gamesPlayed = new ArrayList<Game>();
		this.setName(name);
		this.cakeDay = cakeDay;
		setIsGuest(false);
	}
	
	public Player(String name) {
		this.highScores = new ArrayList<Integer>();
		gamesPlayed = new ArrayList<Game>();
		this.setName(name);
		this.cakeDay = new Date();
		setIsGuest(false);
	}
	
	// FIXME: should there be a way to load high scores into a player's data on construction?
	
	// methods
	public Date getCakeDay() {
		return this.cakeDay;
	}
	public ArrayList<Integer> getHighScores() {
		return this.highScores;
	}
	public void addHighScore(Integer score) { // FIXME: needs an edit in the UML diagram
		this.highScores.add(score);
	}
	public int getPersonalHigh(Game g) {
		return getHighScores().get(getGamesPlayed().indexOf(g));
	}
}
