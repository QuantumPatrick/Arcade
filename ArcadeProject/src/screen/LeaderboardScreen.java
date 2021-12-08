package screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import people.*;
import system.Arcade;

public class LeaderboardScreen extends Screen{
	private ArrayList<User> scorers;
	
	JLabel heading = new JLabel();
	JLabel p1 = new JLabel();
	JLabel p2 = new JLabel();
	JLabel p3 = new JLabel();
	JLabel p4 = new JLabel();
	JLabel p5 = new JLabel();
	JLabel p6 = new JLabel();
	JLabel p7 = new JLabel();
	JLabel p8 = new JLabel();
	JLabel p9 = new JLabel();
	JLabel p10 = new JLabel();
	
	JButton back = new JButton();
	
	public LeaderboardScreen(JFrame frame) {
		super(frame);
		scorers = new ArrayList<User>();
		
		heading.setText("Leaderboard Screen");
		heading.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		
		back.setText("Back");
		
		int tttlen = Arcade.getLeaderboard("TicTacToe").getScorers().size();
		
		
		if (tttlen == 0) {
			p1.setText("The Tic-Tac-Toe leaderboard is empty");
		}
		if(tttlen >= 1) {
			p1.setText("#1) " + Arcade.getLeaderboard("TicTacToe").getScorers().get(0).getName() +": "+ Arcade.getLeaderboard("TicTacToe").getScorers().get(0).getTicTacToeHighScore());
		}
		if(tttlen >= 2) {
			p2.setText("#2) " + Arcade.getLeaderboard("TicTacToe").getScorers().get(1).getName() +": "+ Arcade.getLeaderboard("TicTacToe").getScorers().get(1).getTicTacToeHighScore());
		}
		if(tttlen >= 3) {
			p3.setText("#3) " + Arcade.getLeaderboard("TicTacToe").getScorers().get(2).getName() +": "+ Arcade.getLeaderboard("TicTacToe").getScorers().get(2).getTicTacToeHighScore());
		}
		if(tttlen >= 4) {
			p4.setText("#4) " + Arcade.getLeaderboard("TicTacToe").getScorers().get(3).getName() +": "+ Arcade.getLeaderboard("TicTacToe").getScorers().get(3).getTicTacToeHighScore());
		}
		if(tttlen >= 5) {
			p5.setText("#5) " + Arcade.getLeaderboard("TicTacToe").getScorers().get(4).getName() +": "+ Arcade.getLeaderboard("TicTacToe").getScorers().get(4).getTicTacToeHighScore());
		}
		
		int slen = Arcade.getLeaderboard("Snake").getScorers().size();
		
		
		if (slen == 0) {
			p6.setText("The Snake leaderboard is empty");
		}
		if(slen >= 1) {
			p6.setText("#1) " + Arcade.getLeaderboard("Snake").getScorers().get(0).getName() +": "+ Arcade.getLeaderboard("Snake").getScorers().get(0).getSnakeHighScore());
		}
		if(slen >= 2) {
			p7.setText("#2) " + Arcade.getLeaderboard("Snake").getScorers().get(1).getName() +": "+ Arcade.getLeaderboard("Snake").getScorers().get(1).getSnakeHighScore());
		}
		if(slen >= 3) {
			p8.setText("#3) " + Arcade.getLeaderboard("Snake").getScorers().get(2).getName() +": "+ Arcade.getLeaderboard("Snake").getScorers().get(2).getSnakeHighScore());
		}
		if(slen >= 4) {
			p9.setText("#4) " + Arcade.getLeaderboard("Snake").getScorers().get(3).getName() +": "+ Arcade.getLeaderboard("Snake").getScorers().get(3).getSnakeHighScore());
		}
		if(slen >= 5) {
			p10.setText("#5) " + Arcade.getLeaderboard("Snake").getScorers().get(4).getName() +": "+ Arcade.getLeaderboard("Snake").getScorers().get(4).getSnakeHighScore());
		}
		
		
			
		back.setBounds(25,25,100,50);
		
		heading.setBounds(150, 50, 400, 100);
		p1.setBounds(150, 100, 300, 100);
		p2.setBounds(150, 150, 300, 100);
		p3.setBounds(150, 200, 300, 100);
		p4.setBounds(150, 250, 300, 100);
		p5.setBounds(150, 300, 300, 100);
		p6.setBounds(150, 350, 300, 100);
		p7.setBounds(150, 400, 300, 100);
		p8.setBounds(150, 450, 300, 100);
		p9.setBounds(150, 500, 300, 100);
		p10.setBounds(150, 550, 300, 100);
		back.addActionListener(new leaderboardButtonListener());
		
		frame.add(back);
		frame.add(heading);
		frame.add(p1);
		frame.add(p2);
		frame.add(p3);
		frame.add(p4);
		frame.add(p5);
		frame.add(p6);
		frame.add(p7);
		frame.add(p8);
		frame.add(p9);
		frame.add(p10);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	public ArrayList<User> getScorers(){
		return scorers;
	}
	
	public void setScorers(ArrayList<User> scorerList) {
		scorers = scorerList;
	}
		
	private void handleGoToHome() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToHome();
	}
	
	
		
	private class leaderboardButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
				
			if (source.equals(back)) { //FIXME: Still needs to implemented
				handleGoToHome();
			}
		}
		
	}
	
	
}
