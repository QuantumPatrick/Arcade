package screen;

import javax.swing.*;

public class SignInScreen extends Screen{
	JFrame frame;
	
	public SignInScreen() {
		frame = new JFrame();
		
		JLabel text = new JLabel("Choose Your Profile", SwingConstants.CENTER);
		
		JButton b1 = new JButton("Jason");
		JButton b2 = new JButton("Haseeb");
		JButton b3 = new JButton("Patrick");
		JButton b4 = new JButton("Steve");
		JButton b5 = new JButton("Guest");
		JButton b6 = new JButton("Rusty");
		JButton b7 = new JButton("Isabel");
		JButton b8 = new JButton("Ary");
		JButton b9 = new JButton("Chris");
		JButton b10 = new JButton("New User");
		
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
	
	public static void main(String args[]) {
		new SignInScreen();
	}
}
