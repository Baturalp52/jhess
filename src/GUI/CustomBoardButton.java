package GUI;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import enums.COLOR;
import game.Game;
import piece.Piece;

public class CustomBoardButton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4643577542624494036L;
	private Piece piece;
	private String position;
	Color bgColor;
	LineBorder activeBorder = new LineBorder(new Color(0, 0, 0), 4, false);

	public String getPosition() {
		return position;
	}

	public Piece getPiece() {
		return piece;
	}

	public CustomBoardButton(Color bgColor, String position) throws IOException {
		super();
		setBorder(null);
		this.position = position;
		this.bgColor = bgColor;
		this.refreshButton();

	}

	private void retrievePiece() {
		this.piece = Game.getGameBoard().getBoard().get(position);
	}

	public void refreshButton() throws IOException {
		retrievePiece();
		if (piece != null) {
			String colorCode = "w";
			if (piece.getPlayer().getColor() == COLOR.BLACK)
				colorCode = "b";
			Image image = ImageIO.read(new File("src/GUI/assets/" + colorCode + getPhotoName())).getScaledInstance(60,
					60, Image.SCALE_DEFAULT);

			setIcon(new ImageIcon(image));
			if (piece.getPlayer().getColor() == Game.currentPlayer.getColor()) {
				setEnabled(true);
			} else {
				setEnabled(false);
			}
		} else {
			setIcon(null);
			setEnabled(false);

		}
		setBackground(bgColor);
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		super.setEnabled(b);
		if (b) {
			setBorder(this.activeBorder);
		} else {
			setBorder(null);
		}
	}

	private String getPhotoName() {
		switch (this.piece.getMoveType()) {
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
