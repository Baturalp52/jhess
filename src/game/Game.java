package game;

import java.util.HashMap;

import classes.Move;
import classes.Player;
import enums.COLOR;
import piece.Piece;

public class Game {

	public static Player currentPlayer;
	private static GameBoard gameBoard;

	public static boolean checkGameState() {

		// checking game state
		// if there is a win returns true
		// if not false

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
