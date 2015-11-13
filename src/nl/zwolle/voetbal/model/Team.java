package nl.zwolle.voetbal.model;

import java.util.ArrayList;

public class Team {
	
	String name;
	String level;
	Player player;
	
	public Team(String name, String level, Player player) {
		this.name = name;
		this.level = level;
		this.player = player;
	}
	
}

