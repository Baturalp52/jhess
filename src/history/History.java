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

import classes.Move;
import classes.Player;
import game.GameBoard;

public class History implements HistoryFileReader {
	private static GameHistory unsavedHistory;
	private static ArrayList<GameHistory> history = new ArrayList<GameHistory>();

	public static void updateHistory(Move move) {

		unsavedHistory.getMoves().add(move);

	}

	public static void clearHistory() throws IOException {
		history.clear();

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(HISTORY_FILE_NAME)));
		oos.writeObject(history);
		oos.close();

	}

	public static ArrayList<GameHistory> getHistory() {
		return history;
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
