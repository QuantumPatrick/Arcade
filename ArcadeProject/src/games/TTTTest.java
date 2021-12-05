package games;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import games.tictactoe.TicTacToe;

class TTTTest {

	@Test
	void testPlay() {
		TicTacToe game1 = new TicTacToe();
		game1.setName("Round 1");
		
		game1.placeMarker("X",0,0);
		game1.placeMarker("O",1,0);
		game1.placeMarker("X",2,0);
		game1.placeMarker("O",2,1);
		game1.placeMarker("X",0,1);
		game1.placeMarker("O",0,2);
		game1.placeMarker("X",1,1);
		game1.placeMarker("O",2,2);
		game1.placeMarker("X",1,2);
		assertEquals(game1.checkWinner("X"), false);
		assertEquals(game1.checkWinner("O"), false);
	}

	@Test
	void testPlayAgain() {
		fail("Not yet implemented");
	}

	@Test
	void testReset() {
		TicTacToe g1 = new TicTacToe();
		
		g1.reset();
		
		assertEquals(g1.getScore(), 0);
	}

	@Test
	void testGetScore() {
		TicTacToe game2 = new TicTacToe();
		
		game2.setName("Round 2");
		
		game2.placeMarker("X",0,0);
		game2.placeMarker("O",1,0);
		game2.placeMarker("X",1,1);
		game2.placeMarker("O",2,1);
		game2.placeMarker("X",2,2);
		
		assertEquals(game2.getScore(), 1);
	}

	@Test
	void testComputerMarker() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckWinner() {
		TicTacToe g1 = new TicTacToe();
		
		g1.placeMarker("X", 0, 0);
		g1.placeMarker("O", 1, 1);
		g1.placeMarker("X", 0, 1);
		g1.placeMarker("O", 1, 2);
		g1.placeMarker("X", 0, 2);
		
		assertEquals(g1.checkWinner("X"), true);
		
	}

}
