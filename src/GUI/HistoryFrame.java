package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

import history.GameHistory;
import history.History;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JFrame parentFrame;
	private HistoryDetailFrame historyDetailFrame;
	private JScrollPane scrollPane;
	JList list;
	private Button viewHistoryButton;

	public static void main(String[] args) {
		HistoryFrame ghe = new HistoryFrame(new JFrame());
		ghe.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public HistoryFrame(JFrame parentFrame) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateContent();
			}
		});

		this.historyDetailFrame = new HistoryDetailFrame(this);

		this.parentFrame = parentFrame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Button button = new Button("Close");
		button.setBounds(600, 647, 121, 41);
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
		contentPane.add(scrollPane);

		viewHistoryButton = new Button("View Selected History");
		viewHistoryButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				historyDetailFrame.setHistory((GameHistory) list.getSelectedValue());
				historyDetailFrame.setVisible(true);
			}
		});
		viewHistoryButton.setBounds(507, 10, 214, 41);
		viewHistoryButton.setEnabled(false);
		contentPane.add(viewHistoryButton);

		updateContent();

	}

	private void updateContent() {
		History.readFromFile();
		JLabel lblNewLabel = new JLabel("No History Data!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 279, 491, 86);
		DefaultListModel<GameHistory> listModel = new DefaultListModel<GameHistory>();
		for (GameHistory g : History.getHistory())
			listModel.addElement(g);

		list = new JList(listModel);
		list.setVisibleRowCount(5);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				viewHistoryButton.setEnabled(true);
			}
		});
		list.setBounds(10, 10, 491, 628);
		list.setCellRenderer(new GameHistoryElement());

		if (History.getHistory().size() > 0) {
			scrollPane.add(list);
			scrollPane.setViewportView(list);
		} else
			scrollPane.add(lblNewLabel);
	}
}
