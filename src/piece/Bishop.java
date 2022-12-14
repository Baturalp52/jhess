package piece;

import java.util.HashSet;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import game.GameBoard;

public class Bishop extends Piece {

	public Bishop(Player player, String position, GameBoard gameBoard) {
		super(player, position, MOVE_TYPE.BISHOP, gameBoard);
		// TODO Auto-generated constructor stub
	}

	public HashSet<String> availableMoves() {
		HashSet<String> moves = new HashSet<String>();
		HashMap<String, Piece> board = gameBoard.getBoard();
		COLOR playerColor = getPlayer().getColor();
		int row = let2Num(position.substring(0, 1));
		int col = Integer.parseInt(position.substring(1, 2));

		int sign[] = { -1, +1 };
		for (int rowSign : sign) {
			for (int colSign : sign) {
				for (int i = 1; i <= 7; i++) {

					String targetRow = num2Let(row + i * rowSign);
					int targetCol = col + i * colSign;
					if (targetRow == null || num2Let(targetCol) == null)
						continue;
					String targetPos = targetRow + targetCol;
					Piece targetPiece = board.get(targetPos);

					if (targetPiece == null)
						moves.add(targetPos);
					else {
						if (targetPiece.getPlayer().getColor() == playerColor)
							continue;
						else {
							moves.add(targetPos);
							continue;
						}

					}

				}
			}
		}

		return moves;
	};
}
