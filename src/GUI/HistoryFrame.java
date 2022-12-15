package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.event.ListSelectionListener;

import history.GameHistory;
import history.History;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JFrame parentFrame;

	/**
	 * Create the frame.
	 */
	public HistoryFrame(JFrame parentFrame) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				History.readFromFile();
			}
		});

		this.parentFrame = parentFrame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		Button button = new Button("Close");
		button.setBounds(380, 647, 121, 41);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);

		ArrayList<GameHistoryElement> history = new ArrayList<GameHistoryElement>();

		for (GameHistory gh : History.getHistory()) {
			history.add(new GameHistoryElement(gh));
		}

		JLabel lblNewLabel = new JLabel("No History Data!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 279, 491, 86);

		JList list = new JList(history.toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println(e);
			}
		});
		list.setBounds(10, 10, 491, 628);

		if (history.size() > 0)
			contentPane.add(list);
		else
			contentPane.add(lblNewLabel);

	}

}
