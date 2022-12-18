package GUI;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import enums.FILTER_WINNER;
import enums.ORDER_HISTORY;
import history.GameHistory;
import history.History;
import history.HistoryFilterAndOrder;

public class HistoryFrame extends JFrame {

	private JPanel contentPane;
	private JFrame parentFrame;
	private HistoryDetailFrame historyDetailFrame;
	private JScrollPane scrollPane;
	private JList list;
	private Button viewHistoryButton;
	private Choice choice;
	private Checkbox wWinnerCheckBox;
	private Checkbox bWinnerCheckBox;
	private JPanel orderByPanel;
	private final ButtonGroup orderByBG = new ButtonGroup();
	private JRadioButton orderByDate_DESC_RB;
	private JRadioButton orderByDate_ASC_RB;
	private JRadioButton orderByMoveCount_DESC_RB;
	private JRadioButton orderByMoveCount_ASC_RB;

	/**
	 * Create the frame.
	 */
	public HistoryFrame(JFrame parentFrame) {
		setTitle("JHess - Match History");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon.png"));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				refreshContent();
			}
		});

		this.historyDetailFrame = new HistoryDetailFrame(this);

		this.parentFrame = parentFrame;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		list = new JList();
		list.setVisibleRowCount(5);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				viewHistoryButton.setEnabled(true);
			}
		});
		list.setBounds(10, 10, 491, 628);
		list.setCellRenderer(new GameHistoryElement());

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
		viewHistoryButton.setBounds(507, 334, 214, 41);
		viewHistoryButton.setEnabled(false);
		contentPane.add(viewHistoryButton);

		JPanel filterPanel = new JPanel();
		filterPanel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Filter", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		filterPanel.setBounds(511, 10, 210, 147);
		contentPane.add(filterPanel);
		filterPanel.setLayout(null);

		choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		choice.add("None");
		choice.add("0-10");
		choice.add("11-25");
		choice.add("26-50");
		choice.setBounds(119, 23, 81, 18);
		filterPanel.add(choice);

		JLabel lblNewLabel_1 = new JLabel("Move Count:");
		lblNewLabel_1.setBounds(10, 23, 103, 18);
		filterPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Winner:");
		lblNewLabel_1_1.setBounds(10, 51, 103, 18);
		filterPanel.add(lblNewLabel_1_1);

		wWinnerCheckBox = new Checkbox("White");
		wWinnerCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		wWinnerCheckBox.setState(true);
		wWinnerCheckBox.setBounds(10, 75, 60, 21);
		filterPanel.add(wWinnerCheckBox);

		bWinnerCheckBox = new Checkbox("Black");
		bWinnerCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		bWinnerCheckBox.setState(true);
		bWinnerCheckBox.setBounds(10, 102, 60, 21);
		filterPanel.add(bWinnerCheckBox);

		orderByPanel = new JPanel();
		orderByPanel.setLayout(null);
		orderByPanel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Order By",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		orderByPanel.setBounds(511, 167, 210, 147);
		contentPane.add(orderByPanel);

		orderByDate_ASC_RB = new JRadioButton("Date (ASC)");
		orderByDate_ASC_RB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		orderByBG.add(orderByDate_ASC_RB);
		orderByDate_ASC_RB.setBounds(6, 53, 198, 21);
		orderByPanel.add(orderByDate_ASC_RB);

		orderByMoveCount_ASC_RB = new JRadioButton("Move Count (ASC)");
		orderByMoveCount_ASC_RB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		orderByBG.add(orderByMoveCount_ASC_RB);
		orderByMoveCount_ASC_RB.setBounds(6, 99, 198, 21);
		orderByPanel.add(orderByMoveCount_ASC_RB);

		orderByDate_DESC_RB = new JRadioButton("Date (DESC)");
		orderByDate_DESC_RB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		orderByDate_DESC_RB.setSelected(true);
		orderByBG.add(orderByDate_DESC_RB);
		orderByDate_DESC_RB.setBounds(6, 30, 198, 21);
		orderByPanel.add(orderByDate_DESC_RB);

		orderByMoveCount_DESC_RB = new JRadioButton("Move Count (DESC)");
		orderByMoveCount_DESC_RB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				filterAndOrderResults();
			}
		});
		orderByBG.add(orderByMoveCount_DESC_RB);
		orderByMoveCount_DESC_RB.setBounds(6, 76, 198, 21);
		orderByPanel.add(orderByMoveCount_DESC_RB);

		refreshContent();

	}

	private void refreshContent() {
		History.readFromFile();
		JLabel lblNewLabel = new JLabel("No History Data!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 279, 491, 86);
		DefaultListModel<GameHistory> listModel = new DefaultListModel<GameHistory>();
		for (GameHistory g : History.getHistory())
			listModel.addElement(g);
		list.setModel(listModel);

		if (History.getHistory().size() > 0) {
			orderByDate_DESC_RB.setSelected(true);
			orderByDate_ASC_RB.setSelected(false);
			orderByMoveCount_DESC_RB.setSelected(false);
			orderByMoveCount_ASC_RB.setSelected(false);

			choice.select(0);
			wWinnerCheckBox.setState(true);
			bWinnerCheckBox.setState(true);

			scrollPane.add(list);
			scrollPane.setViewportView(list);
		} else
			scrollPane.add(lblNewLabel);
	}

	private void filterAndOrderResults() {
		if (orderByBG.getSelection() == null)
			return;
		History.readFromFile();
		String numRange = choice.getSelectedItem();
		boolean whiteChecked = wWinnerCheckBox.getState();
		boolean blackChecked = bWinnerCheckBox.getState();

		HistoryFilterAndOrder filter = new HistoryFilterAndOrder();

		if (numRange.equalsIgnoreCase("None"))
			filter.setMoveRange(null);
		else {
			String[] ranges = numRange.split("-");
			int min = Integer.parseInt(ranges[0]);
			int max = Integer.parseInt(ranges[1]);
			int moveRange[] = { min, max };
			filter.setMoveRange(moveRange);
		}

		if (!whiteChecked && !blackChecked) {
			JOptionPane.showMessageDialog(null, "At least one option must be checked!");
			wWinnerCheckBox.setState(true);
			bWinnerCheckBox.setState(true);
			refreshContent();
			return;
		}
		if (whiteChecked) {
			filter.setFilterWinner(FILTER_WINNER.WHITE);
			if (blackChecked)
				filter.setFilterWinner(FILTER_WINNER.ALL);
		} else
			filter.setFilterWinner(FILTER_WINNER.BLACK);

		if (orderByDate_DESC_RB.isSelected())
			filter.setOrderBy(ORDER_HISTORY.DATE_DESC);
		if (orderByDate_ASC_RB.isSelected())
			filter.setOrderBy(ORDER_HISTORY.DATE_ASC);
		if (orderByMoveCount_DESC_RB.isSelected())
			filter.setOrderBy(ORDER_HISTORY.MOVE_COUNT_DESC);
		if (orderByMoveCount_ASC_RB.isSelected())
			filter.setOrderBy(ORDER_HISTORY.MOVE_COUNT_ASC);

		DefaultListModel<GameHistory> listModel = new DefaultListModel<GameHistory>();
		ArrayList<GameHistory> filteredHistory = History.getFilteredAndOrderedHistory(filter);
		if (filteredHistory.size() == 0) {
			JOptionPane.showMessageDialog(null, "No history record found!");
			refreshContent();
			return;
		}

		for (GameHistory g : filteredHistory)
			listModel.addElement(g);
		list.setModel(listModel);

	}
}
