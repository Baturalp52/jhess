package piece;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public class King extends Piece {

	public King(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.KING, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public String[] availableMoves() {
		String[] out = null;
		return out;
	};
}
