package game;

import java.io.Serializable;
import java.util.HashMap;

import classes.Player;
import enums.COLOR;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class GameBoard implements Serializable {
	private Player whitePlayer;
	private Player blackPlayer;
	private HashMap<String, Piece> board;

	public GameBoard(Player whitePlayer, Player blackPlayer) {
		super();
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.board = new HashMap<String, Piece>();
		this.createWhitePieces();
		this.createBlackPieces();

	}

	private void createWhitePieces() {
		this.createPieces(COLOR.WHITE, this.whitePlayer);
	}

	private void createBlackPieces() {
		this.createPieces(COLOR.BLACK, this.blackPlayer);
	}

	private void createPieces(COLOR color, Player player) {
		String row = "A";
		String pawnRow = "B";

		if (color == COLOR.BLACK) {
			row = "H";
			pawnRow = "G";

		}

		Rook lRook = new Rook(player, row + 1, this);
		Rook rRook = new Rook(player, row + 8, this);
		Knight lKnight = new Knight(player, row + 2, this);
		Knight rKnight = new Knight(player, row + 7, this);
		Bishop lBishop = new Bishop(player, row + 3, this);
		Bishop rBishop = new Bishop(player, row + 6, this);
		Queen queen = new Queen(player, row + 4, this);
		King king = new King(player, row + 5, this);

		this.board.put(lRook.getPosition(), lRook);
		this.board.put(rRook.getPosition(), rRook);
		this.board.put(lKnight.getPosition(), lKnight);
		this.board.put(rKnight.getPosition(), rKnight);
		this.board.put(lBishop.getPosition(), lBishop);
		this.board.put(rBishop.getPosition(), rBishop);
		this.board.put(queen.getPosition(), queen);
		this.board.put(king.getPosition(), king);

		for (int i = 1; i <= 8; i++) {
			Pawn pawn = new Pawn(player, pawnRow + i, this);
			this.board.put(pawn.getPosition(), pawn);
		}

	}

	public Player getWhitePlayer() {
		return whitePlayer;
	}

	public Player getBlackPlayer() {
		return blackPlayer;
	}

	public HashMap<String, Piece> getBoard() {
		return board;
	}

}
