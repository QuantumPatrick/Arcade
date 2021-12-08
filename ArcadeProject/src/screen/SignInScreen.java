package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import people.User;
import system.Arcade;

public class SignInScreen extends Screen{
	
	//declare frame and buttons as fields so whole class can access
	JPanel panel;
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;
	JButton b8;
	JButton b9;
	JButton b10;
	
	JButton addNewUser;
	JButton newUserButton;
	
	JTextField newUserName;
	
	public SignInScreen(JFrame frame) {
		super(frame);
				
		panel = new JPanel();
		
		for (int i = 0; i < Arcade.getUserList().size(); i++) {
			JButton temp = new JButton(Arcade.getUserList().get(i).getName());
			
			if (i % 2 == 0) {
				temp.setBounds(150,50 + 100*(i/2),100,50);
			}
			else {
				temp.setBounds(350,50 + 100*(i/2),100,50);
			}
			if (i == 0) {
				b1 = temp;
				b1.addActionListener(new ClickListener());
				panel.add(b1);
			}
			else if (i == 1) {
				b2 = temp;
				b2.addActionListener(new ClickListener());
				panel.add(b2);
			}
			else if (i == 2) {
				b3 = temp;
				b3.addActionListener(new ClickListener());
				panel.add(b3);
			}
			else if (i == 3) {
				b4 = temp;
				b4.addActionListener(new ClickListener());
				panel.add(b4);
			}
			else if (i == 4) {
				b5 = temp;
				b5.addActionListener(new ClickListener());
				panel.add(b5);
			}
			else if (i == 5) {
				b6 = temp;
				b6.addActionListener(new ClickListener());
				panel.add(b6);
			}
			else if (i == 6) {
				b7 = temp;
				b7.addActionListener(new ClickListener());
				panel.add(b7);
			}
			else if (i == 7) {
				b8 = temp;
				b8.addActionListener(new ClickListener());
				panel.add(b8);
			}
			else if (i == 8) {
				b9 = temp;
				b9.addActionListener(new ClickListener());
				panel.add(b9);
			}
			else if (i == 9) {
				b10 = temp;
				b10.addActionListener(new ClickListener());
				panel.add(b10);
			}			
		}
		
		addNewUser = new JButton("New User");
		addNewUser.addActionListener(new ClickListener());
		panel.add(addNewUser);
		
		JLabel text = new JLabel("Choose Your Profile", SwingConstants.CENTER);

		//add buttons to frame
		panel.add(text);
		
		//System.out.println(b1.getLabel()); // USE THIS TO GET PROFILE NAMES
		
		//set button parameters
		text.setBounds(200,0,200,50);
		addNewUser.setBounds(200,500,200,50);
		
		frame.add(panel);
		panel.setVisible(true);
		panel.setSize(600, 600);
		panel.setLayout(null);
		
	}
	
	void handleToHome() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToHome();
	}
	void handleToLeader() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToLeaderboard();
	}
	void handleToLibrary() {
		frame.getContentPane().removeAll();
		frame.repaint();
		super.goToLibrary();
	}
	
	private class ClickListener implements ActionListener {

		//test if action happens
		public void actionPerformed(ActionEvent e){
			
			//check if action is button being clicked
			if (e.getSource() == addNewUser) {
				frame.remove(panel);
				frame.repaint();
				panel.removeAll();
				newUserName = new JTextField(100);
				panel.add(newUserName);
				newUserName.setBounds(250,200,100,25);
				
				newUserButton = new JButton("Create New User");
				newUserButton.setBounds(200,300,200,25);
				newUserButton.addActionListener(new ClickListener());
				panel.add(newUserButton);
				
				frame.add(panel);
			}
			else if (e.getSource() == newUserButton) {
				User u = new User(newUserName.getText());
				Arcade.getUserList().add(u);
				frame.getContentPane().removeAll();
				frame.repaint();
				goToSignIn();
			}
			else if (e.getSource() == b1) {
				frame.remove(panel);
				User u1 = new User();
				u1.setName(b1.getText());
				Arcade.setCurrentUser(u1);
				handleToHome();
			}
			else if (e.getSource() == b2) {
				frame.remove(panel);
				User u2 = new User();
				u2.setName(b2.getText());
				Arcade.setCurrentUser(u2);
				handleToHome();
			}
			else if (e.getSource() == b3) {
				frame.remove(panel);
				User u3 = new User();
				u3.setName(b3.getText());
				Arcade.setCurrentUser(u3);
				handleToHome();
			}
			else if (e.getSource() == b4) {
				frame.remove(panel);
				User u4 = new User();
				u4.setName(b4.getText());
				Arcade.setCurrentUser(u4);
				handleToHome();
			}
			else if (e.getSource() == b5) {
				frame.remove(panel);
				User u5 = new User();
				u5.setName(b5.getText());
				Arcade.setCurrentUser(u5);
				handleToHome();
			}
			else if (e.getSource() == b6) {
				frame.remove(panel);
				User u6 = new User();
				u6.setName(b6.getText());
				Arcade.setCurrentUser(u6);
				handleToHome();
			}
			else if (e.getSource() == b7) {
				frame.remove(panel);
				User u7 = new User();
				u7.setName(b7.getText());
				Arcade.setCurrentUser(u7);
				handleToHome();
			}
			else if (e.getSource() == b8) {
				frame.remove(panel);
				User u8 = new User();
				u8.setName(b8.getText());
				Arcade.setCurrentUser(u8);
				handleToHome();
			}
			else if (e.getSource() == b9) {
				frame.remove(panel);
				User u9 = new User();
				u9.setName(b9.getText());
				Arcade.setCurrentUser(u9);
				handleToHome();
			}
			else if (e.getSource() == b10) {
				frame.remove(panel);
				User u10 = new User();
				u10.setName(b10.getText());
				Arcade.setCurrentUser(u10);
				handleToHome();
			}
		}
		
	}
	
	public static void main(String args[]) {
		//new SignInScreen();
	}
}
