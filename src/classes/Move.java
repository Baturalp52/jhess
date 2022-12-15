package classes;

import java.io.Serializable;

import piece.Piece;

public class Move implements Serializable {
	private Piece piece;
	private String to;

	public Move(Piece piece, String to) {
		super();
		this.piece = piece;
		this.to = to;
	}

	public Piece getPiece() {
		return piece;
	}

	public String getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "Move [piece=" + piece + ", to=" + to + "]";
	}

}
