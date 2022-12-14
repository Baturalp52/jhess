package piece;

import java.io.Serializable;
import java.util.HashSet;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;
import game.GameBoard;

public abstract class Piece implements Serializable, Cloneable {
	protected Player player;
	protected String position;
	protected MOVE_TYPE moveType;
	protected GameBoard gameBoard;

	public Piece(Player player, String position, MOVE_TYPE moveType, GameBoard gameBoard) {
		super();
		this.player = player;
		this.position = position;
		this.moveType = moveType;
		this.gameBoard = gameBoard;
	}

	public abstract HashSet<String> availableMoves(boolean includeOwnPiece);

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Player getPlayer() {
		return player;
	}

	public MOVE_TYPE getMoveType() {
		return moveType;
	}

	protected static int let2Num(String letter) {
		switch (letter) {
		case "A":
			return 1;
		case "B":
			return 2;
		case "C":
			return 3;
		case "D":
			return 4;
		case "E":
			return 5;
		case "F":
			return 6;
		case "G":
			return 7;
		case "H":
			return 8;
		default:
			return -1;
		}
	}

	protected static String num2Let(int num) {
		switch (num) {
		case 1:
			return "A";
		case 2:
			return "B";
		case 3:
			return "C";
		case 4:
			return "D";
		case 5:
			return "E";
		case 6:
			return "F";
		case 7:
			return "G";
		case 8:
			return "H";
		default:
			return null;
		}
	}

	public static String rowColToPos(int row, int col) {
		return num2Let(row) + col;
	}

	protected boolean checkPosition(int targetRow, int targetCol, boolean includeOwnPiece) {
		if (num2Let(targetRow) == null || num2Let(targetCol) == null)
			return false;

		String targetPos = rowColToPos(targetRow, targetCol);
		COLOR playerColor = player.getColor();

		Piece targetPiece = gameBoard.getBoard().get(targetPos);
		if (targetPiece != null) {
			if (targetPiece.getPlayer().getColor() != playerColor || includeOwnPiece)
				return true;
			return false;
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		return "Piece [player=" + player + ", position=" + position + ", moveType=" + moveType + ", gameBoard="
				+ gameBoard + "]";
	}

	public Piece clone() throws CloneNotSupportedException {
		Piece p = (Piece) super.clone();

		return p;
	}

}
