package history;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import classes.Move;
import classes.Player;
import enums.COLOR;
import enums.FILTER_WINNER;
import enums.ORDER_HISTORY;
import game.GameBoard;

public class History implements HistoryFileReader {
	private static GameHistory unsavedHistory;
	private static ArrayList<GameHistory> history = new ArrayList<GameHistory>();

	public static void updateHistory(Move move) {
		Move _move = null;
		try {
			_move = new Move(move.getPiece().clone(), move.getTo());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		unsavedHistory.getMoves().add(_move);

	}

	public static void clearHistory() {
		history.clear();

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(HISTORY_FILE_NAME)));
			oos.writeObject(history);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ArrayList<GameHistory> getHistory() {
		return history;
	}

	public static ArrayList<GameHistory> getFilteredAndOrderedHistory(HistoryFilterAndOrder filter) {

		ArrayList<GameHistory> filteredHistory = new ArrayList<GameHistory>();

		if (filter.getFilterWinner() != FILTER_WINNER.ALL) {
			COLOR color = filter.getFilterWinner() == FILTER_WINNER.WHITE ? COLOR.WHITE : COLOR.BLACK;

			for (GameHistory gh : history)
				if (gh.getWinner().getColor() == color)
					filteredHistory.add(gh);

		} else {
			filteredHistory.addAll(history);
		}

		if (filter.getMoveRange() != null) {
			ArrayList<GameHistory> _filtered = new ArrayList<GameHistory>();
			for (GameHistory gh : filteredHistory) {

				int min = filter.getMoveRange()[0];
				int max = filter.getMoveRange()[1];
				int count = gh.getMoves().size();
				if (count >= min && count <= max) {
					_filtered.add(gh);
				}
			}

			filteredHistory = new ArrayList<GameHistory>(_filtered);
		}

		if (filter.getOrderBy() == ORDER_HISTORY.DATE_DESC) {
			Collections.reverse(filteredHistory);
			return filteredHistory;
		}
		if (filter.getOrderBy() == ORDER_HISTORY.MOVE_COUNT_ASC)
			return new ArrayList<GameHistory>(new TreeSet<GameHistory>(filteredHistory));
		if (filter.getOrderBy() == ORDER_HISTORY.MOVE_COUNT_DESC) {
			ArrayList<GameHistory> ordered = new ArrayList<GameHistory>(new TreeSet<GameHistory>(filteredHistory));
			Collections.reverse(ordered);
			return ordered;
		}

		return filteredHistory;
	}

	public static void createUnsavedHistory(GameBoard gameBoard) {

		Player[] players = { gameBoard.getWhitePlayer(), gameBoard.getBlackPlayer() };

		unsavedHistory = new GameHistory(players);

	}

	@SuppressWarnings("unchecked")
	public static void readFromFile() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(HISTORY_FILE_NAME)));
			history = (ArrayList<GameHistory>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			File f = new File(HISTORY_FILE_NAME);
			try {
				f.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (EOFException e) {

			history = new ArrayList<GameHistory>();

		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void saveUnsavedHistory() {
		try {
			unsavedHistory.setWinner(unsavedHistory.getMoves().getLast().getPiece().getPlayer());
			history.add(unsavedHistory);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(HISTORY_FILE_NAME)));
			oos.writeObject(history);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
