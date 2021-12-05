package peopleTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import games.Game;
import people.Player;
import system.Date;

class PlayerTest {

	@Test
	void testGetPersonalHigh() {
		Game g1 = new Game();
		Game g2 = new Game();
		
		Date today = new Date();
		
		Player u1 = new Player("Jason", today);
		
		ArrayList<Game> testGameList = new ArrayList<Game>();
		
		u1.addGamesPlayed(g1);
		u1.addGamesPlayed(g2);
		
		testGameList.add(g1);
		testGameList.add(g2);
		
		assertEquals(u1.getPersonalHigh(g1), 0);
		assertEquals(u1.getPersonalHigh(g2), 0);

	}

	@Test
	void testGetHighScores() {
		Date today = new Date();
		
		Player p1 = new Player("Haseeb", today);
		ArrayList<Integer> testScores = new ArrayList<Integer>();
		
		for (int i = 0; i < 5; i++) {
			testScores.add(i*100);
		}
		
		for (int i = 0; i < 5; i++) {
			p1.addHighScore(i*100);
		}
		
		assertEquals(p1.getHighScores(), testScores);
	}

	@Test
	void testPlayerStringInt() {
		Player p1 = new Player("Jason");
		
		assertEquals(p1.getName(), "Jason");
		//assertEquals(p1.getCakeDay(), new Date());
		System.out.println(p1.getCakeDay().displayCakeDay());
	}
}
