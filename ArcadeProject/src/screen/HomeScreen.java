package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HomeScreen {
	JFrame frame;
	
	JButton leaderboard;
	JButton library;
	JButton profile;
	
	public HomeScreen(JFrame frame) {
		this.frame = frame;
		
		JLabel text = new JLabel("Welcome!", SwingConstants.CENTER);
		
		leaderboard = new JButton("View Leaderboards");
		library = new JButton("Game Library");
		profile = new JButton("View Profile");
		
		leaderboard.addActionListener(new ButtonListener());
		library.addActionListener(new ButtonListener());
		profile.addActionListener(new ButtonListener());
		
		frame.add(text);
		frame.add(leaderboard);
		frame.add(library);
		frame.add(profile);
		
		text.setBounds(200,0,200,50);
		leaderboard.setBounds(200,50,200,100);
		library.setBounds(200,200,200,100);
		profile.setBounds(200,350,200,100);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	public static void main(String args[]) {
		//new HomeScreen();
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if (source.equals(library)) {
				Screen.goToLibrary();
				frame.setVisible(false); //FIXME: this is a terrible solution
			}
			else if (source.equals(profile)) {
				Screen.goToProfile();
				frame.setVisible(false); //FIXME: this is a terrible solution
			}
			else if (source.equals(leaderboard)) {
				Screen.goToLeaderboard();
				frame.setVisible(false); //FIXME: this is a terrible solution
			}
		}
	}
}
