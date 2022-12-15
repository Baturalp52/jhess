package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.LineBorder;

import history.GameHistory;
import history.History;

public class GameHistoryElement extends JPanel implements ListCellRenderer<GameHistory> {
	JLabel winnerIconLabel;
	JLabel winnerNameLabel;
	JLabel lblNewLabel_1_1;

	public GameHistoryElement() {

		setOpaque(true);
		setVisible(true);
		setLayout(null);
		setBounds(0, 0, 525, 735);
		setPreferredSize(new Dimension(90, 100));

		winnerIconLabel = new JLabel("");
		winnerIconLabel.setBounds(10, 10, 27, 27);
		winnerIconLabel.setBorder(new LineBorder(new Color(0)));
		add(winnerIconLabel);

		winnerNameLabel = new JLabel();
		winnerNameLabel.setBounds(45, 10, 190, 19);
		add(winnerNameLabel);

		lblNewLabel_1_1 = new JLabel();
		lblNewLabel_1_1.setBounds(45, 36, 190, 19);
		add(lblNewLabel_1_1);

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
		lblNewLabel_1_1.setText("Date Time: " + gameHistory.getDate());
		winnerNameLabel.setText("Winner Name: " + gameHistory.getWinner().getName());
		winnerIconLabel.setIcon(new ImageIcon("src/GUI/assets/bperson.png"));

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
