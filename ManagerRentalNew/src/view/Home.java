package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class Home extends JPanel {

	/**
	 * Create the panel.
	 */
	public Home() {
		setLayout(null);
		
		JLabel lblHome = new JLabel("home");
		lblHome.setBounds(91, 118, 46, 14);
		add(lblHome);

	}
}
