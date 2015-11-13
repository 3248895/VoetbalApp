package nl.zwolle.voetbal.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

public class Player extends SugarRecord<Player> implements Serializable {

	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private boolean loggedIn;
	
	public Player() {
    }
	
	public Player(	String userName, String firstName, String lastName, 
					String password, boolean loggedIn) {
		this.username = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.loggedIn = true;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return "This is " + this.username;
	}

}

