package games;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import system.Arcade;
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
		if(g.getClass().getName().equals("games.snake.Snake")) {
			if (rec >= u.getSnakeHighScore()) {
				System.out.println("New personal high!");
				System.out.println("Current personal score is: " + Arcade.getCurrentUser().getSnakeHighScore());
				System.out.println("Current personal score is: " + rec);
				int option = JOptionPane.showConfirmDialog(null, "New personal high of " + rec + "!", "New Personal High", JOptionPane.PLAIN_MESSAGE);
				//if (option == JOptionPane.OK_OPTION) {
				//	u.setSnakeHighScore(rec);
				//}
				System.out.println("New personal high is: " + u.getSnakeHighScore());
				System.out.println("Current User: " + Arcade.getCurrentUser().getSnakeHighScore());
			}
		}
		else if(g.getClass().getName().equals("games.tictactoe.TicTacToe")){
			if (rec >= u.getTicTacToeHighScore()) {
				System.out.println("New personal high!");
				System.out.println("Current personal score is: " + Arcade.getCurrentUser().getTicTacToeHighScore());
				System.out.println("Current personal score is: " + rec);
				int option = JOptionPane.showConfirmDialog(null, "New personal high of " + rec + "!", "New Personal High", JOptionPane.PLAIN_MESSAGE);
				//if (option == JOptionPane.OK_OPTION) {
				//	u.setSnakeHighScore(rec);
				//}
				System.out.println("New personal high is: " + u.getTicTacToeHighScore());
				System.out.println("Current User: " + Arcade.getCurrentUser().getTicTacToeHighScore());
			}
		}
	}

	public void detectHighScore(int rec, Game g, User u, Leaderboard l) {
		if(g.getClass().getName().equals("games.snake.Snake")) {

			if (l.getScorers().isEmpty()) {
				System.out.println("New high score!");
				JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New High Score", JOptionPane.PLAIN_MESSAGE);
				l.getScorers().add(u);
				u.setSnakeHighScore(rec);
			} 

			else {
				int leaderboardSize = l.getScorers().size();
				for (int i = 0; i < leaderboardSize; i++) {
					if ((rec > l.getScorers().get(i).getSnakeHighScore())) {
						JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New High Score", JOptionPane.PLAIN_MESSAGE);
						System.out.println("New high score!");
						System.out.println("Bazinga");
						l.getScorers().add(i, u);
						u.setSnakeHighScore(rec);//test
					}
				}
			}
		}
		else if(g.getClass().getName().equals("games.tictactoe.TicTacToe")){
			if (l.getScorers().isEmpty()) {
				System.out.println("New high score!");
				JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New High Score", JOptionPane.PLAIN_MESSAGE);
				l.getScorers().add(u);
				u.setTicTacToeHighScore(rec);//test

			} 

			else {
				int leaderboardSize = l.getScorers().size();
				for (int i = 0; i <leaderboardSize; i++) {
					if ((rec > l.getScorers().get(i).getTicTacToeHighScore())) {
						JOptionPane.showConfirmDialog(null, "New high score of " + rec + "!", "New High Score", JOptionPane.PLAIN_MESSAGE);
						System.out.println("New high score!");
						System.out.println("Bazinga");
						l.getScorers().add(i, u);
						u.setTicTacToeHighScore(rec);//test
					}
				}
			}
		}
	}
}
