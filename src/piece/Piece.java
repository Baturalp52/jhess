package piece;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public abstract class Piece {
	protected Player player;
	protected String position;
	protected MOVE_TYPE moveType;
	protected GameBoard gameBoard;

	public Piece(Player player, String position, MOVE_TYPE moveType, GameBoard gameBoard) {
		super();
		this.player = player;
		this.position = position;
		this.moveType = moveType;
		this.gameBoard = gameBoard;
	}

	public abstract String[] availableMoves();

	public String getPosition() {
		return position;
	}

}
