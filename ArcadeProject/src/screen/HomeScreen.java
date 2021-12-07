package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen extends Screen{
	JFrame frame;
	
	JButton leaderboard;
	JButton library;
	JButton profile;
	JButton back;
	
	public HomeScreen(JFrame frame) {
		super(frame);
		this.frame = frame;
		
		JLabel text = new JLabel("Welcome!", SwingConstants.CENTER);
		
		leaderboard = new JButton("View Leaderboards");
		library = new JButton("Game Library");
		profile = new JButton("View Profile");
		back = new JButton("Back");
		
		leaderboard.addActionListener(new ButtonListener());
		library.addActionListener(new ButtonListener());
		profile.addActionListener(new ButtonListener());
		back.addActionListener(new ButtonListener());
		
		frame.add(text);
		frame.add(leaderboard);
		frame.add(library);
		frame.add(profile);
		frame.add(back);
		
		text.setBounds(200,0,200,50);
		leaderboard.setBounds(200,50,200,100);
		library.setBounds(200,200,200,100);
		profile.setBounds(200,350,200,100);
		back.setBounds(25,25,100,50);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public void handleToLibrary() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToLibrary();
	}

	public void handleToLeaderboard() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToLeaderboard();
	}
	
	public void handleToProfile() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToProfile();
	}

	public void handleToBack() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToSignIn();
	}
	
	public static void main(String args[]) {
		//new HomeScreen();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (e.getSource() == leaderboard) {
				handleToLeaderboard();
			}
			else if (e.getSource() == library) {
				handleToLibrary();
			}
			else if (e.getSource() == profile) {
				handleToProfile();
			}
			else if (e.getSource() == back) {
				handleToBack();
			}

		}
	}
}
