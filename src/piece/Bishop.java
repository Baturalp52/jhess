package piece;

import java.util.HashMap;
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

		int row = let2Num(position.substring(0, 1));
		int col = Integer.parseInt(position.substring(1, 2));

		int sign[] = { -1, +1 };
		for (int rowSign : sign) {
			for (int colSign : sign) {
				for (int i = 1; i <= 7; i++) {

					int targetRow = row + i * rowSign;
					int targetCol = col + i * colSign;
					if (checkPosition(targetRow, targetCol))
						moves.add(rowColToPos(targetRow, targetCol));
					else
						break;

				}
			}
		}

		return moves;
	};
}
