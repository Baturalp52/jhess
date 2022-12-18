package GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import classes.Player;
import enums.COLOR;

public class GetPlayerNameDialog extends JFrame {

	private final JPanel contentPanel = new JPanel();
	public Player player;
	private JTextField playerName;
	public JLabel lblNewLabel;

	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Create the dialog.
	 */
	public GetPlayerNameDialog(Player player) {
		setTitle("JHess");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if (player.getColor() == COLOR.WHITE)
					lblNewLabel.setText("Enter white player's name:");
				else
					lblNewLabel.setText("Enter black player's name:");
			}
		});

		this.player = player;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JButton okButton = new JButton("OK");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setPlayerNameEvent();
			}
		});
		okButton.setBounds(142, 176, 161, 36);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		lblNewLabel = new JLabel("Enter white player's name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 35, 357, 53);
		contentPanel.add(lblNewLabel);

		playerName = new JTextField();
		playerName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == 10)
					setPlayerNameEvent();
			}
		});
		playerName.setBounds(57, 100, 334, 36);
		contentPanel.add(playerName);
		playerName.setColumns(10);
	}

	private void setPlayerNameEvent() {
		player.setName(playerName.getText());
		playerName.setText("");
		dispose();
	}
}
