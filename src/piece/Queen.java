package piece;

import java.util.ArrayList;
import java.util.HashSet;

import classes.Player;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Queen extends Piece {

	public Queen(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.QUEEN, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves(boolean includeOwnPiece) {
		HashSet<String> moves = new HashSet<String>();
		int row = let2Num(position.substring(0, 1));
		int col = Integer.parseInt(position.substring(1, 2));

		int sign[] = { -1, +1 };
		for (int rowSign : sign) {
			for (int colSign : sign) {
				for (int i = 1; i <= 7; i++) {

					int targetRow = row + i * rowSign;
					int targetCol = col + i * colSign;
					if (checkPosition(targetRow, targetCol, includeOwnPiece)) {
						String targetPos = rowColToPos(targetRow, targetCol);
						moves.add(targetPos);
						Piece targetedPiece = gameBoard.getBoard().get(targetPos);
						if (targetedPiece != null) {
							break;
						}
					} else
						break;

				}
			}
		}
		for (int i = 1; i <= 7; i++) {

			int targetRow = (row + i);
			int targetCol = col;
			if (checkPosition(targetRow, targetCol, includeOwnPiece)) {
				String targetPos = rowColToPos(targetRow, targetCol);
				moves.add(targetPos);
				Piece targetedPiece = gameBoard.getBoard().get(targetPos);
				if (targetedPiece != null) {
					break;
				}
			} else
				break;

		}

		for (int i = -1; i >= -7; i--) {
			int targetRow = (row + i);
			int targetCol = col;

			if (checkPosition(targetRow, targetCol, includeOwnPiece)) {
				String targetPos = rowColToPos(targetRow, targetCol);
				moves.add(targetPos);
				Piece targetedPiece = gameBoard.getBoard().get(targetPos);
				if (targetedPiece != null) {
					break;
				}
			} else
				break;

		}
		for (int i = 1; i <= 7; i++) {
			int targetRow = (row);
			int targetCol = col + i;

			if (checkPosition(targetRow, targetCol, includeOwnPiece)) {
				String targetPos = rowColToPos(targetRow, targetCol);
				moves.add(targetPos);
				Piece targetedPiece = gameBoard.getBoard().get(targetPos);
				if (targetedPiece != null) {
					break;
				}
			} else
				break;
		}

		for (int i = -1; i >= -7; i--) {
			int targetRow = row;
			int targetCol = col + i;

			if (checkPosition(targetRow, targetCol, includeOwnPiece)) {
				String targetPos = rowColToPos(targetRow, targetCol);
				moves.add(targetPos);
				Piece targetedPiece = gameBoard.getBoard().get(targetPos);
				if (targetedPiece != null) {
					break;
				}
			} else
				break;
		}

		return moves;
	};
}
