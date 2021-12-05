package peopleTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import people.Guest;

class GuestTest {

	@Test
	void testGuest() {
		Guest g1 = new Guest();
		
		assertEquals(g1.getIsGuest(), true);
	}

}
