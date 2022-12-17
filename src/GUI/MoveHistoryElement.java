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
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import classes.Move;
import enums.COLOR;
import history.GameHistory;
import piece.Piece;

public class MoveHistoryElement extends JPanel implements ListCellRenderer<Move> {
	JLabel pieceIconLabel;
	JLabel moveNumLabel;
	JLabel moveLabel;

	public MoveHistoryElement() {

		setOpaque(true);
		setVisible(true);
		setLayout(null);
		setBounds(0, 0, 525, 735);
		setPreferredSize(new Dimension(90, 100));

		moveNumLabel = new JLabel("");
		moveNumLabel.setBounds(10, 10, 27, 27);
		moveNumLabel.setBorder(new LineBorder(new Color(0)));
		moveNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(moveNumLabel);

		pieceIconLabel = new JLabel("");
		pieceIconLabel.setBounds(40, 10, 27, 27);
		pieceIconLabel.setBorder(new LineBorder(new Color(0)));
		add(pieceIconLabel);

		moveLabel = new JLabel();
		moveLabel.setBounds(75, 36, 190, 19);
		add(moveLabel);

	}

	@Override
	public Component getListCellRendererComponent(JList<? extends Move> list, Move move, int index, boolean isSelected,
			boolean cellHasFocus) {
		moveLabel.setText(move.getTo() + " -> " + move.getPiece().getPosition());
		String colorCode = "w";
		pieceIconLabel.setOpaque(true);
		pieceIconLabel.setBackground(new Color(0, 0, 0));
		if (move.getPiece().getPlayer().getColor() == COLOR.BLACK) {
			pieceIconLabel.setBackground(new Color(255, 255, 255));
			colorCode = "b";
		}
		Image image;
		try {
			image = ImageIO.read(new File("src/GUI/assets/" + colorCode + getPhotoName(move.getPiece())))
					.getScaledInstance(23, 23, Image.SCALE_DEFAULT);
			pieceIconLabel.setIcon(new ImageIcon(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		moveNumLabel.setText(index + 1 + "");

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
