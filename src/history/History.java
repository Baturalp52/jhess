package history;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
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
	private static ArrayList<GameHistory> history;

	public static void updateHistory(Move move) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(UNSAVED_FILE_NAME)));
			unsavedHistory = (GameHistory) ois.readObject();
			ois.close();

			unsavedHistory.getMoves().add(move);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(UNSAVED_FILE_NAME)));
			oos.writeObject(unsavedHistory);
			oos.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

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

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(UNSAVED_FILE_NAME)));
			oos.writeObject(unsavedHistory);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(HISTORY_FILE_NAME)));
			history = (ArrayList<GameHistory>) ois.readObject();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void saveUnsavedHistory() {
		try {
			history.add(unsavedHistory);

			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(HISTORY_FILE_NAME)));
			oos.writeObject(history);
			oos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
