package history;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;

import classes.Move;
import classes.Player;

public class GameHistory implements Serializable {
	private Player[] players;
	private String date;
	private LinkedList<Move> moves;
	private Player winner;

	public GameHistory(Player[] players) {
		super();
		this.players = players;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		this.date = dtf.format(LocalDateTime.now());
		this.moves = new LinkedList<Move>();
		this.winner = null;
	}

	public Player[] getPlayers() {
		return players;
	}

	public String getDate() {
		return date;
	}

	public LinkedList<Move> getMoves() {
		return moves;
	}

	public Player getWinner() {
		return winner;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMoves(LinkedList<Move> moves) {
		this.moves = moves;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "GameHistory\ndate=" + date  + ", winner="
				+ winner.getName();
	}

}
