package piece;

import java.util.Collection;
import java.util.HashSet;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import game.GameBoard;

public class King extends Piece {

	public King(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.KING, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves(boolean includeOwnPiece) {
		HashSet<String> allMoves = new HashSet<String>();
		COLOR oppositeColor = COLOR.WHITE;
		if (player.getColor() == COLOR.WHITE)
			oppositeColor = COLOR.BLACK;

		Collection<Piece> allPieces = gameBoard.getBoard().values();

		for (Piece piece : allPieces)
			if (piece.player.getColor() == oppositeColor && piece.moveType != MOVE_TYPE.KING)
				allMoves.addAll(piece.availableMoves(true));
		HashSet<String> moves = new HashSet<String>();

		int row = let2Num(this.position.substring(0, 1));
		int col = Integer.parseInt(this.position.substring(1));

		int[] steps = { -1, 0, +1 };

		for (int rowStep : steps)
			for (int colStep : steps) {
				if (rowStep == 0 && colStep == 0)
					continue;
				int targetRow = row + rowStep;
				int targetCol = col + colStep;

				if (checkPosition(targetRow, targetCol, includeOwnPiece)
						&& !allMoves.contains(rowColToPos(targetRow, targetCol)))
					moves.add(rowColToPos(targetRow, targetCol));
			}
		return moves;
	};
}
