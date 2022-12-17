package classes;

import java.io.Serializable;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(color, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return color == other.color && Objects.equals(name, other.name);
	}
	
	

}
