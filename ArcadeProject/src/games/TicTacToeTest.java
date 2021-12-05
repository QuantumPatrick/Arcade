package games;


class TicTacToeTest {

	public static void main(String[] args) {
	
	//test case: tie
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
	System.out.println(game1.getName());
	System.out.println(game1.checkWinner("X"));
	System.out.println(game1.checkWinner("O"));
	System.out.println();
	
	//test case: X wins diagonal	
	TicTacToe game2 = new TicTacToe();

	game2.setName("Round 2");
	
	game2.placeMarker("X",0,0);
	game2.placeMarker("O",1,0);
	game2.placeMarker("X",1,1);
	game2.placeMarker("O",2,1);
	game2.placeMarker("X",2,2);
	
	System.out.println(game2.getName());
	System.out.println(game2.checkWinner("X"));
	System.out.println(game2.checkWinner("O"));
	System.out.println();
	
	//test case: O wins row
	
	TicTacToe game3 = new TicTacToe();
	
	game3.setName("Round 3");
	
	game3.placeMarker("X",1,1);
	game3.placeMarker("O",1,0);
	game3.placeMarker("X",1,2);
	game3.placeMarker("O",2,0);
	game3.placeMarker("X",2,2);
	game3.placeMarker("O",0,0);
	System.out.println(game3.getName());
	System.out.println(game3.checkWinner("X"));
	System.out.println(game3.checkWinner("O"));
	System.out.println();
	
	
	
	//test case: computer plays
	
	TicTacToe game4 = new TicTacToe();
	game4.setName("Round 4");
	
	game4.placeMarker("X",0,0);
	game4.computerMarker("O");
	game4.placeMarker("X",1,1);
	game4.computerMarker("O");
	game4.placeMarker("X",2,2);
	
	System.out.println(game4.getName());
	System.out.println(game4.checkWinner("X"));
	System.out.println(game4.checkWinner("O"));
	System.out.println();
	
	
	
	
	game1.reset();
	game2.reset();
	game3.reset();
	
	System.out.println(game1.getName());
	System.out.println(game1.checkWinner("X"));
	System.out.println(game1.checkWinner("O"));
	System.out.println();
	
	System.out.println(game2.getName());
	System.out.println(game2.checkWinner("X"));
	System.out.println(game2.checkWinner("O"));
	System.out.println();
	
	System.out.println(game3.getName());
	System.out.println(game3.checkWinner("X"));
	System.out.println(game3.checkWinner("O"));
	System.out.println();
	
	}

}
