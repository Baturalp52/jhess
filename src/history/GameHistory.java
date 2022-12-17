package history;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

import classes.Move;
import classes.Player;

public class GameHistory implements Serializable, Comparable<GameHistory> {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(players);
		result = prime * result + Objects.hash(date, moves, winner);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameHistory other = (GameHistory) obj;
		return Objects.equals(date, other.date) && Objects.equals(moves, other.moves)
				&& Arrays.equals(players, other.players) && Objects.equals(winner, other.winner);
	}

	@Override
	public String toString() {
		return "GameHistory\ndate=" + date + ", winner=" + winner.getName();
	}

	@Override
	public int compareTo(GameHistory o) {
		if (this.moves.size() - o.moves.size() >= 0)
			return 1;
		return -1;
	}

}
