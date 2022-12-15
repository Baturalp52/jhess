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

import classes.Move;
import enums.MOVE_TYPE;
import history.GameHistory;
import history.History;
import piece.Piece;

public class MoveHistoryElement extends JPanel implements ListCellRenderer<Move> {
	JLabel pieceIconLabel;
	JLabel moveLabel;

	public MoveHistoryElement() {

		setOpaque(true);
		setVisible(true);
		setLayout(null);
		setBounds(0, 0, 525, 735);
		setPreferredSize(new Dimension(90, 100));

		pieceIconLabel = new JLabel("");
		pieceIconLabel.setBounds(10, 10, 27, 27);
		pieceIconLabel.setBorder(new LineBorder(new Color(0)));
		add(pieceIconLabel);

		moveLabel = new JLabel();
		moveLabel.setBounds(45, 36, 190, 19);
		add(moveLabel);

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
	public Component getListCellRendererComponent(JList<? extends Move> list, Move move, int index, boolean isSelected,
			boolean cellHasFocus) {
		System.out.println(move.getPiece().getPosition()+" "+move.getTo());
		moveLabel.setText(move.getTo() + " -> " + move.getPiece().getPosition());
		pieceIconLabel.setIcon(new ImageIcon("src/GUI/assets/" + getPhotoName(move.getPiece())));

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}

		return this;
	}

	private String getPhotoName(Piece piece) {
		switch (piece.getMoveType()) {
		case BISHOP:
			return "bishop.png";
		case KING:
			return "king.png";
		case QUEEN:
			return "queen.png";
		case KNIGHT:
			return "knight.png";
		case ROOK:
			return "rook.png";
		case PAWN:
			return "pawn.png";
		default:
			return "";
		}
	}

}
