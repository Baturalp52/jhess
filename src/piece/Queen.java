package piece;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Queen extends Piece {

	public Queen(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.QUEEN, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public String[] availableMoves() {
		String[] out = null;
		return out;
	};
}
