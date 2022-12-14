package piece;

import java.util.HashMap;
import java.util.HashSet;

import classes.Player;
import enums.COLOR;
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

		HashMap<String, Piece> board = gameBoard.getBoard();

		COLOR playerColor = getPlayer().getColor();

		int[] steps = { -2, -1, 1, 2 };

		for (int rowStep : steps) {
			for (int colStep : steps) {
				if (Math.abs(col) == Math.abs(row))
					continue;

				String targetRow = num2Let(row + rowStep);
				int targetCol = col + colStep;

				if (targetRow == null || num2Let(targetCol) == null)
					continue;

				String targetPos = targetRow + col;
				Piece targetPiece = board.get(targetPos);

				if (targetPiece == null) {
					moves.add(targetPos);
				} else {
					if (targetPiece.getPlayer().getColor() != playerColor) {
						moves.add(targetPos);
					}
				}

			}
		}

		return moves;
	};

}
