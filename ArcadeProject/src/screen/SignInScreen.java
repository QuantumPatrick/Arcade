package screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SignInScreen extends Screen{
	
	//declare frame and buttons as fields so whole class can access
	JFrame frame;
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
	
	public SignInScreen() {
		
		frame = new JFrame();
		
		JLabel text = new JLabel("Choose Your Profile", SwingConstants.CENTER);
		
		//button instantiation
		b1 = new JButton("Jason");
		b2 = new JButton("Haseeb");
		b3 = new JButton("Patrick");
		b4 = new JButton("Steve");
		b5 = new JButton("Guest");
		b6 = new JButton("Rusty");
		b7 = new JButton("Isabel");
		b8 = new JButton("Ary");
		b9 = new JButton("Chris");
		b10 = new JButton("New User");
		
		//add listener items to each button
		b1.addActionListener(new ClickListener());
		b2.addActionListener(new ClickListener());
		b3.addActionListener(new ClickListener());
		b4.addActionListener(new ClickListener());
		b5.addActionListener(new ClickListener());
		b6.addActionListener(new ClickListener());
		b7.addActionListener(new ClickListener());
		b8.addActionListener(new ClickListener());
		b9.addActionListener(new ClickListener());
		b10.addActionListener(new ClickListener());

		//add buttons to frame
		frame.add(text);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(b6);
		frame.add(b7);
		frame.add(b8);
		frame.add(b9);
		frame.add(b10);
		//System.out.println(b1.getLabel()); // USE THIS TO GET PROFILE NAMES
		
		//set button parameters
		text.setBounds(200,0,200,50);
		b1.setBounds(150,50,100,50);
		b2.setBounds(150,150,100,50);
		b3.setBounds(150,250,100,50);
		b4.setBounds(150,350,100,50);
		b5.setBounds(150,450,100,50);
		b6.setBounds(350,50,100,50);
		b7.setBounds(350,150,100,50);
		b8.setBounds(350,250,100,50);
		b9.setBounds(350,350,100,50);
		b10.setBounds(350,450,100,50);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600,600);
		frame.setLayout(null);
		frame.setVisible(true);
	}
	
	private class ClickListener implements ActionListener {

		//test if action happens
		public void actionPerformed(ActionEvent e){
			
			//check if action is button being clicked
			if (e.getSource() == b1) {
				
				//if so, hide current screen
				frame.setVisible(false);
			}
			else if (e.getSource() == b2) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b3) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b4) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b5) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b6) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b7) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b8) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b9) {
				frame.setVisible(false);
			}
			else if (e.getSource() == b10) {
				frame.setVisible(false);
			}
		}
	}
	
	public static void main(String args[]) {
		new SignInScreen();
	}
}
