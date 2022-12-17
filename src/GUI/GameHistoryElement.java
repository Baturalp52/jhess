package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

import enums.COLOR;
import history.GameHistory;

public class GameHistoryElement extends JPanel implements ListCellRenderer<GameHistory> {
	JLabel winnerIconLabel;
	JLabel winnerNameLabel;
	JLabel dateAndTimeLabel;
	JLabel moveCountLabel;

	public GameHistoryElement() {

		setOpaque(true);
		setVisible(true);
		setLayout(null);
		setBounds(0, 0, 525, 735);
		setPreferredSize(new Dimension(90, 100));

		winnerIconLabel = new JLabel("");
		winnerIconLabel.setOpaque(true);
		winnerIconLabel.setBounds(10, 10, 27, 27);
		winnerIconLabel.setBorder(new LineBorder(new Color(0)));
		add(winnerIconLabel);

		winnerNameLabel = new JLabel();
		winnerNameLabel.setBounds(45, 10, 190, 19);
		add(winnerNameLabel);

		dateAndTimeLabel = new JLabel();
		dateAndTimeLabel.setBounds(45, 36, 190, 19);
		add(dateAndTimeLabel);

		moveCountLabel = new JLabel();
		moveCountLabel.setBounds(45, 62, 190, 19);
		add(moveCountLabel);

	}

	private String getPhotoName(GameHistory gh) {
		switch (gh.getWinner().getColor()) {
		case WHITE:
			return "wperson.png";
		case BLACK:
			return "bperson.png";
		default:
			return "";
		}
	}

	@Override
	public Component getListCellRendererComponent(JList<? extends GameHistory> list, GameHistory gameHistory, int index,
			boolean isSelected, boolean cellHasFocus) {
		dateAndTimeLabel.setText("Date Time: " + gameHistory.getDate());
		winnerNameLabel.setText("Winner Name: " + gameHistory.getWinner().getName());
		moveCountLabel.setText("Move Count: " + gameHistory.getMoves().size());
		Image image;
		try {
			image = ImageIO.read(new File("src/GUI/assets/" + getPhotoName(gameHistory))).getScaledInstance(23, 23,
					Image.SCALE_DEFAULT);
			winnerIconLabel.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		winnerIconLabel.setBackground(new Color(255, 255, 255));
		if (gameHistory.getWinner().getColor() == COLOR.WHITE)
			winnerIconLabel.setBackground(new Color(0, 0, 0));

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		return this;
	}

}
