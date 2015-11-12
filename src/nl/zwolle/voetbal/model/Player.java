package nl.zwolle.voetbal.model;

import com.orm.SugarRecord;

import android.content.Context;

public class Player extends SugarRecord<Player> {

	private String username;
	private String firstName;
	private String lastName;
	private String password;
	
	public Player() {
    }
	
	public Player(String userName, String firstName, String lastName, String password) {
		this.username = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
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

}

