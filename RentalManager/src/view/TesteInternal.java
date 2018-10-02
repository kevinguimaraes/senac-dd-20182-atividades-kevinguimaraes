package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class TesteInternal extends JInternalFrame {
	private JTextField txtAsdasd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteInternal frame = new TesteInternal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TesteInternal() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 332, 250);
		getContentPane().setLayout(null);
		
		JLabel lblAsdsad = new JLabel("asdsad");
		lblAsdsad.setBounds(75, 135, 46, 14);
		getContentPane().add(lblAsdsad);
		
		txtAsdasd = new JTextField();
		txtAsdasd.setText("asdasd");
		txtAsdasd.setBounds(204, 132, 86, 20);
		getContentPane().add(txtAsdasd);
		txtAsdasd.setColumns(10);

	}
}
