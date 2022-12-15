package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class AlertDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel messageLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AlertDialog dialog = new AlertDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlertDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton okButton = new JButton("OK");
			okButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
				}
			});
			okButton.setBounds(149, 189, 120, 21);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}

		messageLabel = new JLabel("New label");
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(61, 46, 305, 117);
		contentPanel.add(messageLabel);
	}

	public JLabel getMessageLabel() {
		return messageLabel;
	}

}
