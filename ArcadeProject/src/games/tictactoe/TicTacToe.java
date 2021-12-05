package games.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

import games.Game;

public class TicTacToe extends Game {

	private ArrayList<ArrayList<String>> board;				//declares board
	private int win = 0;
	private int numWins = 0;
	
	public TicTacToe() {
		this.board = new ArrayList<ArrayList<String>>();	//initializes board for game
		
		for (int i = 0; i < 3; i++) {						//creates 3 columns
			this.board.add(new ArrayList<String>());
			
			for (int j = 0; j < 3; j++) {					//creates 3 rows
				this.board.get(i).add("");
				
			} 
		} 
	}
	
	public void play() { // FIXME:? should the constructor just call this function?
		Scanner xCoord = new Scanner(System.in);
		Scanner yCoord = new Scanner(System.in);
		Scanner mark = new Scanner(System.in);
		int x;
		int y;
		String marker;
		String compMarker;
		System.out.println("Welcome to TicTacToe");
		
		while(win == 0) {
			System.out.println("Enter your marker (X or O): "); //Doesn't check if marker is the same yet. Doesn't check for characters not X or O
			marker = mark.nextLine();
			System.out.println("Enter your x coordinate (number): ");
			x = xCoord.nextInt();
			System.out.println("Enter your y coordinate (number): ");
			y = yCoord.nextInt();
			
			if(marker.toUpperCase().equals("X")) {
				compMarker = "O";
			} 
			
			else {
				compMarker = "X";
			}
			
			placeMarker(marker.toUpperCase(), x, y);
			if ((checkWinner(marker) || checkWinner(compMarker)) && win != 1) {
				win = 1;
				if (checkWinner(marker) == true) {
					System.out.println("Player wins"); //Need to access name of player
					numWins = numWins + 1;
				} 
				
				else {
					System.out.println("Computer wins");
				}
			}
			
			computerMarker(compMarker);
			if ((checkWinner(marker) || checkWinner(marker)) && win != 1) {
				win = 1;
				if (checkWinner(marker) == true) {
					System.out.println("Player wins"); //Need to access name of player
					numWins = numWins + 1;
				} else {
					System.out.println("Computer wins");
				}
			}
			
		}
	}
	
	public void placeMarker(String marker, int x, int y) {
		
		if ((x > 2) || (y > 2) || (x < 0) || (y < 0)) { 	//error detection for out of bound index
			System.out.println("Error detection for out of bound index");
		}
		else if (!(this.board.get(x).get(y).isBlank())) {	//error detection for overwriting position
			System.out.println("Error detection for overwriting position");
		}
		else {
			this.board.get(x).set(y,marker);				//set board to marker at position
		}
	}
	
	public void computerMarker(String marker) {
		
		int x = (int)(3*Math.random());						//sets random to x and y coordinates
		int y = (int)(3*Math.random());
		
		while (true){
			if (this.board.get(x).get(y).isBlank()) {	//error detection for overwriting position
				this.board.get(x).set(y,marker);
				System.out.println("Computer places x = " + x + ", y = " + y);
				break;
			}
		}
	}
	
	
	public Boolean checkWinner(String marker) {
		
		Boolean totalChecker = false;						//assumes no winner unless winning line is found
		Boolean leftDiagonalChecker = true;					//assume left diagonal will win unless break in line is found
		Boolean rightDiagonalChecker = true;				//assume right diagonal will win unless break in line is found
		
		for (int i = 0; i < 3; i++) {	//cycle through rows, columns, and diagonals
			Boolean rowChecker = true;	//assume row will win unless break in line is found
			Boolean colChecker = true;	//assume column will win unless break in line is found
			
			
			for (int j = 0; j < 3; j++) {												//cycle through each entry in row or column
				rowChecker = rowChecker && this.board.get(i).get(j).equals(marker);		//make sure current entry continues current streak (col)
				colChecker = colChecker && this.board.get(j).get(i).equals(marker);		//make sure current entry continues current streak (row)
			}
			
			totalChecker = totalChecker || rowChecker || colChecker;					//sees if any row or column has a winning line
			
			leftDiagonalChecker = leftDiagonalChecker && this.board.get(i).get(i).equals(marker);			//check if each entry in diagonal left continues streak
			rightDiagonalChecker = rightDiagonalChecker && this.board.get(2-i).get(i).equals(marker);		//check if each entry in diagonal left continues streak
		}
		
		return totalChecker || leftDiagonalChecker || rightDiagonalChecker;				//check if any straight line wins
		
	}
	
	public void playAgain() {
		for (int i = 0; i < 3; i++) {						//creates 3 columns
			
			for (int j = 0; j < 3; j++) {					//creates 3 rows
				this.board.get(i).set(j,"");
				
			} 
		} 
	}
	
	public void reset() {
		for (int i = 0; i < 3; i++) {						//creates 3 columns
			
			for (int j = 0; j < 3; j++) {					//creates 3 rows
				this.board.get(i).set(j,"");
				
			} 
		} 
		numWins = 0;
	}
	
	public int getScore() {
		return numWins;
	}
}
