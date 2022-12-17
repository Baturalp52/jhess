import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import GUI.GetPlayerNameDialog;
import GUI.MainFrame;
import classes.Player;
import enums.COLOR;

public class Main {

	public static void main(String[] args) {

		Player wPlayer = new Player(COLOR.WHITE, "");
		Player bPlayer = new Player(COLOR.BLACK, "");

		GetPlayerNameDialog getPlayerName = new GetPlayerNameDialog(wPlayer);
		getPlayerName.lblNewLabel.setText("Enter white player's name:");
		getPlayerName.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				for (WindowListener wl : getPlayerName.getWindowListeners())
					getPlayerName.removeWindowListener(wl);

				getPlayerName.player = bPlayer;
				getPlayerName.lblNewLabel.setText("Enter black player's name:");
				getPlayerName.setVisible(true);

				getPlayerName.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) {
						for (WindowListener wl : getPlayerName.getWindowListeners())
							getPlayerName.removeWindowListener(wl);
						try {
							MainFrame main = new MainFrame(wPlayer.getName(), bPlayer.getName());
							main.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				});

			}
		});
		getPlayerName.setVisible(true);

	}

}
