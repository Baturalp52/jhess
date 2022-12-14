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
import game.GameBoard;

public class History implements HistoryFileReader {
	private GameBoard unsavedHistory;
	private ArrayList<GameHistory> history;

	public void updateHistory(Move move) {

	}

	public void clearHistory() throws IOException {
		this.history.clear();
		ObjectOutputStream oos;

		oos = new ObjectOutputStream(new FileOutputStream(new File(this.HISTORY_FILE_NAME)));
		oos.writeObject(this.history);
		oos.close();

	}

	public ArrayList<GameHistory> getHistory() {
		return this.history;
	}

	@SuppressWarnings("unchecked")
	public void readFromFile() {
		File f = new File(this.HISTORY_FILE_NAME);
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream(f));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			this.history = (ArrayList<GameHistory>) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveHistory() {

	}

}
