package piece;

import java.util.HashSet;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Knight extends Piece {

	public Knight(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.KNIGHT, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves() {
		HashSet<String> moves = new HashSet<String>();

		int row = let2Num(this.position.substring(0, 1));
		int col = Integer.parseInt(this.position.substring(1));

		int[] steps = { -2, -1, 1, 2 };

		for (int rowStep : steps) {
			for (int colStep : steps) {
				if (Math.abs(col) == Math.abs(row))
					continue;

				int targetRow = row + rowStep;
				int targetCol = col + colStep;

				if (checkPosition(targetRow, targetCol)) {
					moves.add(rowColToPos(targetRow, targetCol));
				}
			}
		}

		return moves;
	};

}
