package history;

interface HistoryFileReader {
	public static final String HISTORY_FILE_NAME = "game_history.burcu";
	public static final String UNSAVED_FILE_NAME = "unsaved_game.burcu";

	void readFromFile();

}
