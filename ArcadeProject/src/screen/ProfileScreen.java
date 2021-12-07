package screen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import system.Arcade;

public class ProfileScreen extends Screen {

	JLabel heading = new JLabel();
	JLabel name = new JLabel();
	JLabel tttScore = new JLabel();
	JLabel snakeScore = new JLabel();
	JButton back = new JButton();
	
	public ProfileScreen(JFrame frame) {
		super(frame);

		heading.setText("Profile Screen");
		heading.setFont(new Font("Comic Sans", Font.PLAIN, 30));
		
		back.setText("Back");
		
		name.setText(Arcade.getCurrentUser().getName());
		tttScore.setText("Tic-Tac-Toe Score: 0 points");
		snakeScore.setText("Snake Score: 0 points");
	
		back.setBounds(25,25,100,50);
		
		heading.setBounds(200, 50, 400, 100);
		name.setBounds(200, 200, 200, 100);
		tttScore.setBounds(200, 250, 200, 100);
		snakeScore.setBounds(200, 300, 200, 100);
		
		back.addActionListener(new profileButtonListener());
		
		frame.add(back);
		frame.add(heading);
		frame.add(name);
		frame.add(tttScore);
		frame.add(snakeScore);
	}
		
	private void handleGoToHome() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToHome();
	}
	
	
		
	private class profileButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
				
			if (source.equals(back)) { //FIXME: Still needs to implemented
				handleGoToHome();
			}
		}
		
	}
	
	
	
}
