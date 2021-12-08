package games.tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;

import games.Game;
import people.User;
import system.Arcade;
import system.Leaderboard;

public class TicTacToe extends Game implements ActionListener{

	//private ArrayList<ArrayList<String>> board;				//declares board
	//private boolean won = false;
	private int streak = 0;
	private boolean playerTurn;
	private int numSelected;
	
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JPanel streakPanel = new JPanel();
	private JButton[] buttons = new JButton[9];
	private JLabel streakLabel = new JLabel();
	private User u = new User();
	private Game g = new Game();
	private Leaderboard l = new Leaderboard("TicTacToe");
	
	public TicTacToe() {
		
	}
	
	public void play(User u, Game g, Leaderboard l) {
		this.u = u;
		this.g = g;
		this.l = l;
		frame.setTitle("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(600,600);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		System.out.println("make visible");
		
		streakLabel.setBackground(Color.WHITE);
		streakLabel.setForeground(Color.BLACK);
		streakLabel.setHorizontalAlignment(JLabel.CENTER);
		streakLabel.setText("Streak: " + streak);
		
		
		streakPanel.setLayout(new BorderLayout());
		streakPanel.setBounds(0,0,600,50);
		streakPanel.add(streakLabel);
		
		playerTurn = true;
		numSelected = 0;
		
		panel.setLayout(new GridLayout(3,3));
		panel.setBackground(Color.BLACK);
		frame.add(streakPanel, BorderLayout.NORTH);
		frame.add(panel);
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			panel.add(buttons[i]);
			buttons[i].setFont(new Font("Comic Sans", Font.BOLD, 100));
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
			buttons[i].setEnabled(true);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) { //searches through all the buttons to see if any buttons are clicked
			if(e.getSource() == buttons[i]) {
				if(playerTurn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(Color.BLUE);
						buttons[i].setText("X");
						System.out.println("Button clicked");
						playerTurn = false;
						numSelected = numSelected + 1;
						checkWinner();
						if (numSelected <= 8) {
							computerMarker();
							checkWinner();
						}
					}
				}
			}
		}
	}
	
//	public void play() { // FIXME:? should the constructor just call this function?
//		Scanner xCoord = new Scanner(System.in);
//		Scanner yCoord = new Scanner(System.in);
//		Scanner mark = new Scanner(System.in);
//		int x;
//		int y;
//		String marker;
//		String compMarker;
//		System.out.println("Welcome to TicTacToe");
//		
//		while(win == 0) {
//			System.out.println("Enter your marker (X or O): "); //Doesn't check if marker is the same yet. Doesn't check for characters not X or O
//			marker = mark.nextLine();
//			System.out.println("Enter your x coordinate (number): ");
//			x = xCoord.nextInt();
//			System.out.println("Enter your y coordinate (number): ");
//			y = yCoord.nextInt();
//			
//			if(marker.toUpperCase().equals("X")) {
//				compMarker = "O";
//			} 
//			
//			else {
//				compMarker = "X";
//			}
//			
//			placeMarker(marker.toUpperCase(), x, y);
//			if ((checkWinner(marker) || checkWinner(compMarker)) && win != 1) {
//				win = 1;
//				if (checkWinner(marker) == true) {
//					System.out.println("Player wins"); //Need to access name of player
//					numWins = numWins + 1;
//				} 
//				
//				else {
//					System.out.println("Computer wins");
//				}
//			}
//			
//			computerMarker(compMarker);
//			if ((checkWinner(marker) || checkWinner(marker)) && win != 1) {
//				win = 1;
//				if (checkWinner(marker) == true) {
//					System.out.println("Player wins"); //Need to access name of player
//					numWins = numWins + 1;
//				} else {
//					System.out.println("Computer wins");
//				}
//			}
//			
//		}
//	}
	
//	public void placeMarker(String marker, int x, int y) {
//		
//		if ((x > 2) || (y > 2) || (x < 0) || (y < 0)) { 	//error detection for out of bound index
//			System.out.println("Error detection for out of bound index");
//		}
//		else if (!(this.board.get(x).get(y).isBlank())) {	//error detection for overwriting position
//			System.out.println("Error detection for overwriting position");
//		}
//		else {
//			this.board.get(x).set(y,marker);				//set board to marker at position
//		}
//	}
	
	public void computerMarker() {
		
		int i = (int)(9*Math.random());						//sets random to x and y coordinates
		//int y = (int)(3*Math.random());
		
		while(buttons[i].getText() != "") {
			i = (int)(9*Math.random());	
		}
		buttons[i].setForeground(Color.RED);
		buttons[i].setText("O");
		System.out.println("Computer chose");
		playerTurn = true;
		numSelected = numSelected + 1;
		
//		while (true){
//			if (this.board.get(x).get(y).isBlank()) {	//error detection for overwriting position
//				this.board.get(x).set(y,marker);
//				System.out.println("Computer places x = " + x + ", y = " + y);
//				break;
//			}
//		}
	}
	
	public void checkWinner() {
		//Rows
		if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
			playerWins(0,1,2);
		}
		if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))) {
			playerWins(3,4,5);
		}
		if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			playerWins(6,7,8);
		}
		//Diags
		if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			playerWins(0,4,8);
		}
		if((buttons[6].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[2].getText().equals("X"))) {
			playerWins(6,4,2);
		}
		//Cols
		if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))) {
			playerWins(0,3,6);
		}
		if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))) {
			playerWins(1,4,7);
		}
		if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))) {
			playerWins(2,5,8);
		}
		
		
		//Rows
		if((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
			computerWins(0,1,2);
		}
		if((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))) {
			computerWins(3,4,5);
		}
		if((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			computerWins(6,7,8);
		}
		//Diags
		if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			computerWins(0,4,8);
		}
		if((buttons[6].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[2].getText().equals("O"))) {
			computerWins(6,4,2);
		}
		//Cols
		if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))) {
			computerWins(0,3,6);
		}
		if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))) {
			computerWins(1,4,7);
		}
		if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))) {
			computerWins(2,5,8);
		}
		
		
		if (!buttons[0].getText().equals("") && !buttons[1].getText().equals("") && !buttons[2].getText().equals("") &&
				!buttons[3].getText().equals("") && !buttons[4].getText().equals("") && !buttons[5].getText().equals("") &&
				!buttons[6].getText().equals("") && !buttons[7].getText().equals("") && !buttons[8].getText().equals("")){
			int option = JOptionPane.showConfirmDialog(null, "Tie! \n" + "Want to play again?", "Tie Game!", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION) {
				playAgain();
			} else if(option == JOptionPane.NO_OPTION){
				panel.removeAll();
				frame.dispose();
			}
		}

	}
	
	public void playerWins(int a, int b, int c) {
		buttons[a].setBackground(Color.BLUE);
		buttons[b].setBackground(Color.BLUE);
		buttons[c].setBackground(Color.BLUE);
		
		for(int i = 0; i <9; i++) {
			buttons[i].setEnabled(false);
		}
		streak = streak + 1;
		streakLabel.setText("Streak: " + streak);
		int option = JOptionPane.showConfirmDialog(null, "You Win \n" + "Want to play again?", "Player wins!", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			playAgain();
		} else if(option == JOptionPane.NO_OPTION){
			numSelected = 99;
			panel.removeAll();
			frame.dispose();
		}
	}
	
	public void computerWins(int a, int b, int c) {
		buttons[a].setBackground(Color.RED);
		buttons[b].setBackground(Color.RED);
		buttons[c].setBackground(Color.RED);
		
		for(int i = 0; i <9; i++) {
			buttons[i].setEnabled(false);
		}
		streak = 0;
		streakLabel.setText("Streak: " + streak);
		int option = JOptionPane.showConfirmDialog(null, "You lose! \n" + "Want to play again?", "Computer wins!", JOptionPane.YES_NO_OPTION);
		if (option == JOptionPane.YES_OPTION) {
			playAgain();
		}
		else if(option == JOptionPane.NO_OPTION){
			numSelected = 99;
			panel.removeAll();
			frame.dispose();
			detectPersonalHigh(streak, g, u);
			detectHighScore(streak, g, u, l);
		}
	}
	
//	public Boolean checkWinner(String marker) {
//		
//		Boolean totalChecker = false;						//assumes no winner unless winning line is found
//		Boolean leftDiagonalChecker = true;					//assume left diagonal will win unless break in line is found
//		Boolean rightDiagonalChecker = true;				//assume right diagonal will win unless break in line is found
//		
//		for (int i = 0; i < 3; i++) {	//cycle through rows, columns, and diagonals
//			Boolean rowChecker = true;	//assume row will win unless break in line is found
//			Boolean colChecker = true;	//assume column will win unless break in line is found
//			
//			
//			for (int j = 0; j < 3; j++) {												//cycle through each entry in row or column
//				rowChecker = rowChecker && this.board.get(i).get(j).equals(marker);		//make sure current entry continues current streak (col)
//				colChecker = colChecker && this.board.get(j).get(i).equals(marker);		//make sure current entry continues current streak (row)
//			}
//			
//			totalChecker = totalChecker || rowChecker || colChecker;					//sees if any row or column has a winning line
//			
//			leftDiagonalChecker = leftDiagonalChecker && this.board.get(i).get(i).equals(marker);			//check if each entry in diagonal left continues streak
//			rightDiagonalChecker = rightDiagonalChecker && this.board.get(2-i).get(i).equals(marker);		//check if each entry in diagonal left continues streak
//		}
//		
//		return totalChecker || leftDiagonalChecker || rightDiagonalChecker;				//check if any straight line wins
//		
//	}
	
	public void playAgain() {
		playerTurn = true;
		numSelected = 0;
		for(int i = 0; i < 9; i++) {
			buttons[i].setText("");
			buttons[i].setBackground(Color.BLACK);
			buttons[i].setEnabled(true);
		}

//		for (int i = 0; i < 3; i++) {						//creates 3 columns
//			
//			for (int j = 0; j < 3; j++) {					//creates 3 rows
//				this.board.get(i).set(j,"");
//				
//			} 
//		} 
	}
	
//	public void reset() {
//		for (int i = 0; i < 3; i++) {						//creates 3 columns
//			
//			for (int j = 0; j < 3; j++) {					//creates 3 rows
//				this.board.get(i).set(j,"");
//				
//			} 
//		} 
//		streak = 0;
//	}
	
	public int getScore() {
		return streak;
	}
}
