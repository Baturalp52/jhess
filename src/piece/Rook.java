package piece;

import java.util.HashMap;
import java.util.HashSet;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Rook extends Piece {

	public Rook(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.ROOK, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves() {
		HashSet<String> moves = new HashSet<String>();
		HashMap<String, Piece> board = gameBoard.getBoard();
		COLOR playerColor = getPlayer().getColor();
		int row = let2Num(position.substring(0, 1));
		int col = Integer.parseInt(position.substring(1, 2));

		for (int i = 1; i <= 7; i++) {
			String targetRow = num2Let(row + i);
			int targetCol = col;
			if (targetRow == null || num2Let(targetCol) == null)
				break;
			String targetPos = targetRow + targetCol;
			Piece targetPiece = board.get(targetPos);

			if (targetPiece == null)
				moves.add(targetPos);
			else {
				if (targetPiece.getPlayer().getColor() == playerColor)
					break;
				else {
					moves.add(targetPos);
					break;
				}

			}
		}
		for (int i = -1; i >= -7; i--) {
			String targetRow = num2Let(row + i);
			int targetCol = col;
			if (targetRow == null || num2Let(targetCol) == null)
				break;
			String targetPos = targetRow + targetCol;
			Piece targetPiece = board.get(targetPos);
			if (targetPiece == null)
				moves.add(targetPos);
			else {
				if (targetPiece.getPlayer().getColor() == playerColor)
					break;
				else {
					moves.add(targetPos);
					break;
				}
			}
		}
		for (int i = 1; i <= 7; i++) {
			String targetRow = num2Let(row);
			int targetCol = col + i;
			String targetPos = targetRow + targetCol;
			Piece targetPiece = board.get(targetPos);
			if (targetRow == null || num2Let(targetCol) == null)
				break;
			if (targetPiece == null)
				moves.add(targetPos);
			else {
				if (targetPiece.getPlayer().getColor() == playerColor)
					break;
				else {
					moves.add(targetPos);
					break;
				}
			}

		}
		for (int i = -1; i >= -7; i--) {
			String targetRow = num2Let(row);
			int targetCol = col + i;
			String targetPos = targetRow + targetCol;
			Piece targetPiece = board.get(targetPos);
			if (targetRow == null || num2Let(targetCol) == null)
				break;
			if (targetPiece == null)
				moves.add(targetPos);
			else {
				if (targetPiece.getPlayer().getColor() == playerColor)
					break;
				else {
					moves.add(targetPos);
					break;
				}
			}
		}

		return moves;
	};
}
