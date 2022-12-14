package game;

import classes.Player;
import enums.COLOR;
import enums.MOVE_TYPE;

public class Game {
	
	public static Player currentPlayer;
	private static GameBoard gameBoard;
	
	
	public static boolean checkGameState() {
		
		// checking game state
		// if there is a win returns true
		// if not false
		
		return false;
		
	}
	
	public static void makeMove(MOVE_TYPE move) {
		
		// make move
		
		
		
	}
	
	public static void initializeGame(String whitePlayerName,String blackPlayerName) {
		Player whitePlayer = new Player(COLOR.WHITE,whitePlayerName);
		Player blackPlayer = new Player(COLOR.BLACK,blackPlayerName);
		
		currentPlayer = whitePlayer;
		
		// TODO :: edit constructor
		
		gameBoard = new GameBoard();
		
	}

}
