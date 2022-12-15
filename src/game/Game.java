package game;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import classes.Move;
import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import history.History;
import piece.Piece;

public class Game {

	public static Player currentPlayer;
	private static GameBoard gameBoard;

	public static boolean checkGameState() {

		Collection<Piece> pieces = gameBoard.getBoard().values();

		if (pieces.size() == 2)
			return true;
		Piece wKing = null;
		Piece bKing = null;

		for (Piece piece : pieces)
			if (piece.getMoveType() == MOVE_TYPE.KING) {
				if (piece.getPlayer().getColor() == COLOR.WHITE)
					wKing = piece;
				else
					bKing = piece;
			}

		HashSet<String> allWhiteMoves = new HashSet<String>();
		HashSet<String> allBlackMoves = new HashSet<String>();

		for (Piece piece : pieces) {
			if (piece.getPlayer().getColor() == COLOR.WHITE && piece.getMoveType() != MOVE_TYPE.KING)
				allWhiteMoves.addAll(piece.availableMoves(true));
			if (piece.getPlayer().getColor() == COLOR.BLACK && piece.getMoveType() != MOVE_TYPE.KING)
				allBlackMoves.addAll(piece.availableMoves(true));
		}
		
		if (allBlackMoves.contains(wKing.getPosition()) && wKing.availableMoves(false).size() == 0)
			return true;
		if (allWhiteMoves.contains(bKing.getPosition()) && bKing.availableMoves(false).size() == 0)
			return true;

		return false;

	}

	public static void makeMove(Move move) {
		Piece p = move.getPiece();
		HashMap<String, Piece> board = gameBoard.getBoard();

		board.remove(p.getPosition());
		board.put(move.getTo(), p);
		p.setPosition(move.getTo());
		History.updateHistory(move);
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
		History.createUnsavedHistory(gameBoard);

	}

	public static GameBoard getGameBoard() {
		return gameBoard;
	}

}
