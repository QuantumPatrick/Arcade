package system;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import people.*;

public class Arcade implements Serializable {
	private static ArrayList<User> userList;
	
	private static Leaderboard lbTTT;
	private static Leaderboard lbSnake;
	private static User currentUser;

	public Arcade(Leaderboard lbTTT, Leaderboard lbSnake) {
		userList = new ArrayList<User>();
		this.lbTTT = lbTTT;
		this.lbSnake = lbSnake;
	}
	
	public static void setCurrentUser(User userIn) {
		currentUser = userIn;
	}
	
	public static User getCurrentUser() {
		return currentUser;
	}
	
	public static Leaderboard getLeaderboard(String s) {
		if (s.equals("TicTacToe")) {
			return lbTTT;
		} else if (s.equals("Snake")) {
			return lbSnake;
		} else {
			return null;
		}
	}
	
	public static User checkList(String userName) {
		for (User i: userList) {
			if (i.getName().equals(userName) && ((i.getSnakeHighScore() != 0) || (i.getTicTacToeHighScore() != 0))) {
				return i;
			}
		}
		return null;
	}
	
	public static ArrayList<User> getUserList(){
		return userList;
	}
	
	public void setUserList(ArrayList<User> list) {
		userList = list;
	}
	
	public void addUser(User u) {
		userList.add(u);
		if (u.getIsGuest() == true) {
			System.out.println("Guest is added to the database");
		} else if (u.getIsGuest() == false) {
			System.out.println("Player " + u.getName() + " is added to the database");
		}
		
	}
	
	public static void saveArcadeState(Arcade arc) {
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut= null;

		try 
		{
			fileOut = new FileOutputStream("Arcade.ser");
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(arc);
			objOut.close();
			fileOut.close();
	     }	
		
		catch(IOException i)
	    {
			i.printStackTrace();
	    }		
 	}
	
	public static Arcade loadArcadeState() {
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;
		Arcade arc=null;
			
		try {
			fileIn = new FileInputStream("Arcade.ser");
			objIn = new ObjectInputStream(fileIn);
			arc = (Arcade) objIn.readObject();
			objIn.close();
			fileIn.close();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}  
		return arc;
	}
	
	public void printUsers() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getName());
		}
		System.out.println();
		System.out.println();
	}
}
