package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import history.GameHistory;

public class GameHistoryElement extends JPanel {
	GameHistory gameHistory;

	public GameHistoryElement(GameHistory gameHistory) {
		super();
		this.gameHistory = gameHistory;
		setLayout(null);

		JLabel winnerIconLabel = new JLabel("");
		winnerIconLabel.setIcon(new ImageIcon("src/GUI/assets/" + getPhotoName()));
		winnerIconLabel.setBounds(10, 10, 45, 45);
		add(winnerIconLabel);

		JLabel winnerNameLabel = new JLabel("Winner Name: " + gameHistory.getWinner().getName());
		winnerNameLabel.setBounds(45, 10, 190, 19);
		add(winnerNameLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Date Time: " + gameHistory.getDate());
		lblNewLabel_1_1.setBounds(45, 36, 190, 19);
		add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("View Moves");
		btnNewButton.setBounds(233, 9, 113, 46);
		add(btnNewButton);
	}

	private String getPhotoName() {
		switch (this.gameHistory.getWinner().getColor()) {
		case WHITE:
			return "wperson.png";
		case BLACK:
			return "bperson.png";
		default:
			return "";
		}
	}

}
