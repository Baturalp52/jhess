package piece;

import enums.MOVE_TYPE;

public abstract class Queen extends Piece{

	public Queen(String player, String position, MOVE_TYPE moveType, String gameBoard) {
		super(player, position, moveType, gameBoard);
		// TODO Auto-generated constructor stub
	}
	//public abstract String[] availableMoves() {}; 
}
