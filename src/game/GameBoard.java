package game;

import java.util.HashMap;

import classes.Player;
import enums.MOVE_TYPE;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Piece;
import piece.Queen;
import piece.Rook;

public class GameBoard {
private Player whitePlayer;
private Player blackPlayer;
private HashMap<String,Piece> board;

public GameBoard(Player whitePlayer, Player blackPlayer) {
	super();
	this.whitePlayer = whitePlayer;
	this.blackPlayer = blackPlayer;
	this.board= new HashMap<String,Piece>();
	
	
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
