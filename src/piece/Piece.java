package piece;
import enums.MOVE_TYPE;

public abstract class Piece {
private String player;
private String position; 
private MOVE_TYPE moveType; 
private String gameBoard;
public Piece(String player, String position, MOVE_TYPE moveType, String gameBoard) {
	super();
	this.player = player;
	this.position = position;
	this.moveType = moveType;
	this.gameBoard = gameBoard;
}

public abstract String[] availableMoves() ;


}
