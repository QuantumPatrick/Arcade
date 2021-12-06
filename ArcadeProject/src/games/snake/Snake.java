package games.snake;
import games.Game;

public class Snake extends Game{
	SnakeWindow s;
	public Snake() {
		
	}
	
	public void play() {
		s = new SnakeWindow();
	}
	
	public int getScore() {
		return s.getScore();
	}
	
	public void playAgain() {
		play();
	}
	
	public void reset() {
		
	}
	
}
