package piece;

import java.util.HashSet;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Pawn extends Piece {

	public Pawn(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.PAWN, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves() {
		HashSet<String> moves = new HashSet<String>();

		int row = let2Num(this.position.substring(0, 1));
		int col = Integer.parseInt(this.position.substring(1));
		int step = -1;

		COLOR playerColor = getPlayer().getColor();

		boolean isFirstMove = false;
		if (playerColor == COLOR.BLACK) {
			if (row == 7)
				isFirstMove = true;
			step = 1;

		} else if (row == 2) {
			isFirstMove = true;
		}

		if (num2Let(row + step) == null)
			return new HashSet<String>();

		do {
			if (Math.abs(step) == 2)
				isFirstMove = false;
			int targetRow = row + step;
			int targetCol = col;
			if (checkPosition(targetRow, targetCol))
				moves.add(rowColToPos(targetRow, targetCol));

			step *= 2;
		} while (isFirstMove);

		int targetRow = row + step;
		int targetCol = col - 1;
		if (checkPosition(targetRow, targetCol))
			moves.add(rowColToPos(targetRow, targetCol));

		targetCol = col + 1;
		if (checkPosition(targetRow, targetCol))
			moves.add(rowColToPos(targetRow, targetCol));

		return moves;
	};

}
