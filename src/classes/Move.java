package classes;

import piece.Piece;

public class Move {
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
	
	

} 
