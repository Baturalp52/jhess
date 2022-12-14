package game;

import java.util.Collection;
import java.util.HashMap;

import classes.Move;
import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import piece.Piece;

public class Game {

	public static Player currentPlayer;
	private static GameBoard gameBoard;

	public static boolean checkGameState() {
		Piece wKing = null;
		Piece bKing = null;

		Collection<Piece> pieces = gameBoard.getBoard().values();

		if (pieces.size() == 2)
			return true;

		for (Piece piece : pieces) {
			if (piece.getMoveType() == MOVE_TYPE.KING) {
				if (piece.getPlayer().getColor() == COLOR.BLACK)
					wKing = piece;
				else
					bKing = piece;
			}
		}

		if (wKing.availableMoves().size() == 0)
			return true;

		if (bKing.availableMoves().size() == 0)
			return true;

		return false;

	}

	public static void makeMove(Move move) {
		Piece p = move.getPiece();
		HashMap<String, Piece> board = gameBoard.getBoard();

		board.remove(p.getPosition());
		board.put(move.getTo(), p);

		if (currentPlayer.getColor() == COLOR.BLACK) {
			currentPlayer = gameBoard.getWhitePlayer();
		} else {
			currentPlayer = gameBoard.getBlackPlayer();
		}

	}

	public static void initializeGame(String whitePlayerName, String blackPlayerName) {
		Player whitePlayer = new Player(COLOR.WHITE, whitePlayerName);
		Player blackPlayer = new Player(COLOR.BLACK, blackPlayerName);

		currentPlayer = whitePlayer;

		gameBoard = new GameBoard(whitePlayer, blackPlayer);

	}

}
