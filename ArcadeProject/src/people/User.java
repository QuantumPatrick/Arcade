package people;

import java.io.Serializable;
import java.util.ArrayList;

import games.Game;

public class User implements Serializable {
	// attributes
	protected String name;
	protected boolean isGuest; // FIXME: add to UML
	protected ArrayList<Integer> highScores; // FIXME: data system for number + game bundled together?
	protected ArrayList<Game> gamesPlayed;
	protected int snakeHighScore;
	protected int ticTacToeHighScore;
	
	// constructors
	public User() {
		this.name = "undefined";
		this.gamesPlayed = new ArrayList<Game>();
		this.highScores = new ArrayList<Integer>();
	}
	
	public User(String name) { //FIXME: does this need to be declared as public?
		this.name = name;
	}
	
	public int getSnakeHighScore() {
		return this.snakeHighScore;
	}
	public void setSnakeHighScore(int s) {
		this.snakeHighScore = s;
	}
	
	public int getTicTacToeHighScore() {
		return this.ticTacToeHighScore;
	}
	public void setTicTacToeHighScore(int t) {
		this.ticTacToeHighScore = t;
	}
	
	// methods
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsGuest() { // FIXME: add to UML
		return this.isGuest;
	}
	public void setIsGuest(boolean isGuest) { // FIXME: add to UML
		this.isGuest = isGuest;
	}
	
	public void setPersonalHigh(int high) {
		highScores.add(high);
	}
	
	public int getPersonalHigh(Game g) {
		return getHighScores().get(getGamesPlayed().indexOf(g));
	}
	
	public void addGamesPlayed(Game g) {
		gamesPlayed.add(g);
	}
	
	public ArrayList<Game> getGamesPlayed() {
		return gamesPlayed;
	}
	
	public ArrayList<Integer> getHighScores(){
		return highScores;
	}
	
	public void saveScore(int score) {
		this.setPersonalHigh(score);
	}
	//	(g.getClass().getName().equals("games.tictactoe.TicTacToe")){
	
	public Game getGame(String s) {
		Game g = new Game();
		for(int i = 0; i < gamesPlayed.size();i++) {
			if(s.equals(gamesPlayed.get(i).getName())) {
				g = gamesPlayed.get(i);
			}
		}
		return g;
		
	}
	
	public boolean checkGame(Game g) {
		boolean result = false;
		for(int i = 0; i < gamesPlayed.size();i++) {
			if(g.equals(gamesPlayed.get(i))) {
				result = true;
			}
		}
		return result;
	}
}
