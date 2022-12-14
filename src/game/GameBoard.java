package game;

import java.util.HashMap;

import classes.Player;
import piece.Piece;

public class GameBoard {
private Player whitePlayer;
private Player blackPlayer;
private HashMap<String,Piece> board;

public GameBoard(Player whitePlayer, Player blackPlayer) {
	super();
	this.whitePlayer = whitePlayer;
	this.blackPlayer = blackPlayer;
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
