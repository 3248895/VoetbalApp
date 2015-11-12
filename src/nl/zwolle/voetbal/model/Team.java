package nl.zwolle.voetbal.model;

import java.util.ArrayList;

public class Team {
	
	String name;
	String level;
	ArrayList<Player> players = new ArrayList<Player>(40);
	
	public Team(String name, String level, ArrayList<Player> players) {
		this.name = name;
		this.level = level;
		this.players = players;
	}
	
}

