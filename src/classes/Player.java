package classes;

import java.io.Serializable;

import enums.COLOR;

public class Player implements Serializable {

	private COLOR color;
	private String name;

	public Player(COLOR color, String name) {
		super();
		this.color = color;
		this.name = name;
	}

	public COLOR getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
