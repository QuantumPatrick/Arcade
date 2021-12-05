package system;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import people.User;

class ArcadeTest {

	@Test
	void testArcade() {
		Arcade testArcade = new Arcade();
		
		assertEquals(testArcade, new Arcade());
	}

	@Test
	void testGetUserList() {
		Arcade testArcade = new Arcade();
		
		ArrayList<User> testList = new ArrayList<User>();
		
		User testUser1 = new User("Jason");
		User testUser2 = new User("Haseeb");
		
		testArcade.addUser(testUser1);
		testArcade.addUser(testUser2);
		
		testList.add(testUser1);
		testList.add(testUser2);
		
		assertEquals(testArcade.getUserList(), testList);
	}

	@Test
	void testLoadArcadeState() {
		Arcade testArcade = new Arcade();
				
		User testUser1 = new User("Jason");
		User testUser2 = new User("Haseeb");
		
		testArcade.addUser(testUser1);
		
		Arcade.saveArcadeState(testArcade);
		testArcade.printUsers();
		testArcade.addUser(testUser2);
		testArcade.printUsers();
		testArcade = Arcade.loadArcadeState();
		testArcade.printUsers();
	}

}
