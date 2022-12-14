package classes;

import enums.COLOR;

public class Player {

	private COLOR color;
private  String name;

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


}
