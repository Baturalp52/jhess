package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.COLOR;
import game.Game;
import history.History;
import piece.Piece;

import java.awt.GridLayout;
import java.io.IOException;
import java.util.HashSet;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import classes.Move;
import classes.Player;

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6493647612031495185L;

	private JPanel contentPane;

	public final Color whiteEnabledBackgroundColor = new Color(255, 236, 179);
	public final Color blackEnabledBackgroundColor = new Color(121, 85, 72);
	public final Color whiteDisabledBackgroundColor = new Color(255, 236, 179, 128);
	public final Color blackDisabledBackgroundColor = new Color(121, 85, 72, 128);
	private JFrame historyFrame;
	JPanel panel = new JPanel();
	CustomBoardButton selectedButton;
	private JLabel currentPlayerNameLabel;
	private AlertDialog alertDialog = new AlertDialog();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game.initializeGame("White", "Black");
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		this.historyFrame = new HistoryFrame(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel.setBounds(80, 100, 640, 640);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 8, 0, 0));

		currentPlayerNameLabel = new JLabel(Game.currentPlayer.getName() + "'s turn!");
		currentPlayerNameLabel.setOpaque(true);
		currentPlayerNameLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		currentPlayerNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPlayerNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 44));
		currentPlayerNameLabel.setBackground(Game.currentPlayer.getColor() == COLOR.BLACK ? blackEnabledBackgroundColor
				: whiteEnabledBackgroundColor);
		currentPlayerNameLabel.setBounds(218, 10, 366, 60);
		contentPane.add(currentPlayerNameLabel);

		Button button = new Button("Show History");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				historyFrame.setVisible(true);
			}
		});
		button.setBounds(726, 100, 145, 46);
		contentPane.add(button);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(0, 101, 80, 639);
		contentPane.add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(8, 8, 0, 0));

		JLabel lblNewLabel_8 = new JLabel("A");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_8);

		JLabel lblNewLabel_1_1 = new JLabel("B");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("C");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("D");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_4_1 = new JLabel("E");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_1 = new JLabel("F");
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_5_1);

		JLabel lblNewLabel_6_1 = new JLabel("G");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_6_1);

		JLabel lblNewLabel_7_1 = new JLabel("H");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_7_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(80, 74, 640, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 8, 0, 0));

		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("6");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("7");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("8");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_7);

		Button button_1 = new Button("Clear History");
		button_1.setActionCommand("Clear History");
		button_1.setBounds(726, 152, 145, 46);
		contentPane.add(button_1);

		addButtons();

	}

	private void addButtons() throws IOException {
		for (int row = 1; row <= 8; row++)
			for (int col = 1; col <= 8; col++) {
				int colorFlag = ((row % 2) + col) % 2;
				Color bgColor = whiteEnabledBackgroundColor;
				if (colorFlag == 0) {
					bgColor = blackEnabledBackgroundColor;
				}
				CustomBoardButton btnNewButton = new CustomBoardButton(bgColor, Piece.rowColToPos(row, col));
				bindAvailableMoves(btnNewButton);
				panel.add(btnNewButton);
			}
	}

	private void moveTo(String position) throws IOException {
		if (selectedButton == null || !selectedButton.isEnabled())
			refreshAllButtons();
		Move newMove = new Move(selectedButton.getPiece(), position);
		Game.makeMove(newMove);
		currentPlayerNameLabel.setText(Game.currentPlayer.getName() + "'s turn!");
		refreshAllButtons();
		boolean isGameFinished = Game.checkGameState();
		if (isGameFinished) {
			Player winner;
			if (Game.currentPlayer.getColor() == COLOR.BLACK)
				winner = Game.getGameBoard().getWhitePlayer();
			else
				winner = Game.getGameBoard().getBlackPlayer();

			alertDialog.getMessageLabel().setText(winner.getName() + " has won the game!");
			alertDialog.setVisible(true);
			History.saveUnsavedHistory();
			Game.getGameBoard().getBoard().clear();
			Game.initializeGame("White", "Black");
			refreshAllButtons();
			currentPlayerNameLabel.setText(Game.currentPlayer.getName() + "'s turn!");
		}

	}

	private void bindMoveTo(CustomBoardButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomBoardButton pButton = (CustomBoardButton) e.getComponent();
				if (!pButton.isEnabled()) {
					try {
						unbindMouseListeners(button);
						refreshAllButtons();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return;
				}

				try {
					moveTo(pButton.getPosition());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				unbindMouseListeners(button);
				bindAvailableMoves(button);
			}
		});
	}

	private void showAvailableMoves(Piece piece) throws IOException {
		refreshAllButtons();
		HashSet<String> availableMoves = piece.availableMoves(false);
		System.out.println(availableMoves + " " + piece.getMoveType());

		for (Component component : this.panel.getComponents()) {
			CustomBoardButton button = (CustomBoardButton) component;
			if (availableMoves.contains(button.getPosition())) {
				button.setEnabled(true);
				unbindMouseListeners(button);
				bindMoveTo(button);
			} else {
				button.setEnabled(false);
			}
		}
	}

	private void bindAvailableMoves(CustomBoardButton button) {
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomBoardButton pButton = (CustomBoardButton) e.getComponent();
				if (!pButton.isEnabled()) {
					try {
						refreshAllButtons();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					return;
				}
				try {
					showAvailableMoves(pButton.getPiece());
					selectedButton = button;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	private void unbindMouseListeners(CustomBoardButton button) {
		for (MouseListener ml : button.getMouseListeners())
			button.removeMouseListener(ml);

	}

	private void refreshAllButtons() throws IOException {

		for (Component component : this.panel.getComponents()) {
			CustomBoardButton button = (CustomBoardButton) component;
			button.refreshButton();
		}
	}
}
