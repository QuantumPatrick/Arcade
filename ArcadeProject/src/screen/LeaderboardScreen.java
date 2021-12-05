package screen;

import java.util.ArrayList;
import people.*;

public class LeaderboardScreen extends Screen{
	private ArrayList<User> scorers;
	
	public LeaderboardScreen() {
		scorers = new ArrayList<User>();
	}
	
	public ArrayList<User> getScorers(){
		return scorers;
	}
	
	public void setScorers(ArrayList<User> scorerList) {
		scorers = scorerList;
	}
	
	
}
