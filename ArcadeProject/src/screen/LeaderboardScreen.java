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
	
	JButton back = new JButton();
	
	public LeaderboardScreen(JFrame frame) {
		super(frame);
		scorers = new ArrayList<User>();
		
		heading.setText("Leaderboard Screen");
		heading.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		
		back.setText("Back");
		
		p1.setText("Jason: \t Total 0 points");
		p2.setText("Patrick: \t Total 0 points");
		p3.setText("Haseeb: \t Total 0 points");
		p4.setText("Ary: \t Total 0 points");
		p5.setText("Chris: \t Total 0 points");
		p6.setText("Rusty: \t Total 0 points");
		p7.setText("Isabel: \t Total 0 points");
		p8.setText("Steve: \t Total 0 points");
			
		back.setBounds(25,25,100,50);
		
		heading.setBounds(200, 50, 400, 100);
		p1.setBounds(200, 100, 200, 100);
		p2.setBounds(200, 150, 200, 100);
		p3.setBounds(200, 200, 200, 100);
		p4.setBounds(200, 250, 200, 100);
		p5.setBounds(200, 300, 200, 100);
		p6.setBounds(200, 350, 200, 100);
		p7.setBounds(200, 400, 200, 100);
		p8.setBounds(200, 450, 200, 100);
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
