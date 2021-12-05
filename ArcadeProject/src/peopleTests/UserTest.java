package peopleTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import games.Game;
import people.User;

class UserTest {

	@Test
	void testGetName() {
		User u1 = new User("Jason");
		
		assertEquals(u1.getName(), "Jason");
	}

	@Test
	void testGetIsGuest() {
		User u1 = new User("Haseeb");
		User u2 = new User("Patrick");
		
		u1.setIsGuest(false);
		u2.setIsGuest(true);
		
		assertEquals(u1.getIsGuest(), false);
		assertEquals(u2.getIsGuest(), true);
	}

	@Test
	void testGetPersonalHigh() {
		Game g1 = new Game();
		Game g2 = new Game();
		
		User u1 = new User("Jason");
		
		ArrayList<Game> testGameList = new ArrayList<Game>();
		
		u1.addGamesPlayed(g1);
		u1.addGamesPlayed(g2);
		
		testGameList.add(g1);
		testGameList.add(g2);
		
		assertEquals(u1.getPersonalHigh(g1), 0);
		assertEquals(u1.getPersonalHigh(g2), 0);

	}

	@Test
	void testGetGamesPlayed() {
		Game g1 = new Game();
		Game g2 = new Game();
		
		User u1 = new User("Haseeb");
		
		ArrayList<Game> testGameList = new ArrayList<Game>();
		
		u1.addGamesPlayed(g1);
		u1.addGamesPlayed(g2);
		
		testGameList.add(g1);
		testGameList.add(g2);
		
		assertEquals(u1.getGamesPlayed(), testGameList);
	}

}
