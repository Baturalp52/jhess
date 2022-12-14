package piece;

import java.util.ArrayList;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Rook extends Piece {

	public Rook(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.ROOK, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> availableMoves() {
		ArrayList<String> moves = new ArrayList<String>();
		return moves;
	};
}
