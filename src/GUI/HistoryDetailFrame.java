package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import classes.Move;
import history.GameHistory;

import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;

public class HistoryDetailFrame extends JFrame {

	private JPanel contentPane;
	private JFrame parentFrame;
	private JScrollPane scrollPane;
	private GameHistory history;
	JList list;
	private JLabel lblNewLabel;
	private JLabel winnerPlayerName;

	public void setHistory(GameHistory history) {
		this.history = history;
	}

	/**
	 * Create the frame.
	 */
	public HistoryDetailFrame(JFrame parentFrame) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateContent();
			}
		});

		this.parentFrame = parentFrame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 785, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Button button = new Button("Close");
		button.setBounds(640, 647, 121, 41);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 491, 627);
		scrollPane.setBorder(null);
		scrollPane.setViewportView(list);
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Winner:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(521, 30, 240, 58);
		contentPane.add(lblNewLabel);

		winnerPlayerName = new JLabel("Player Name");
		winnerPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		winnerPlayerName.setBounds(521, 98, 240, 58);
		contentPane.add(winnerPlayerName);

		updateContent();

	}

	private void updateContent() {
		if (history == null)
			return;
		DefaultListModel<Move> listModel = new DefaultListModel<Move>();
		for (Move g : history.getMoves())
			listModel.addElement(g);

		list = new JList(listModel);
		list.setVisibleRowCount(5);
		list.setBounds(10, 10, 491, 628);
		list.setCellRenderer(new MoveHistoryElement());

		scrollPane.add(list);
		scrollPane.setViewportView(list);

		winnerPlayerName.setText(history.getWinner().getName());

	}
}
