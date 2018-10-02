package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JLabel;

public class Teste extends JFrame {

	private JPanel contentPane;
	TesteInternal internal = new TesteInternal();
	Sobre sobre = new Sobre();
	Listar listar = new Listar();
	Alterar alterar = new Alterar();
	Excluir excluir = new Excluir();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teste frame = new Teste();
					//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public Teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 501);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-stress-50.png")));
		menuBar.add(mnCadastro);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 651, 399);
		contentPane.add(desktopPane);
		desktopPane.add(internal);
		desktopPane.add(alterar);
		desktopPane.add(excluir);
		desktopPane.add(listar);
		
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro1");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(!internal.isVisible())
				{
					internal.setClosable(true);
					internal.setVisible(true);
				}
					
			}
		});
		mntmCadastro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmCadastro.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-life-cycle-50.png")));
		mnCadastro.add(mntmCadastro);
		
		JMenuItem mntmCadastro_1 = new JMenuItem("Cadastro2");
		mntmCadastro_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mntmCadastro_1.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-administrator-male-2-50.png")));
		mnCadastro.add(mntmCadastro_1);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!sobre.isVisible())
				{
					sobre.setVisible(true);
				}
					
			}
		});
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!listar.isVisible())
					listar.setVisible(true);
			}
		});
		mntmListar.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-checklist-50.png")));
		menuBar.add(mntmListar);
		
		JMenuItem mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!alterar.isVisible())
					alterar.setVisible(true);
			}
		});
		mntmAlterar.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-transfer-50.png")));
		menuBar.add(mntmAlterar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!excluir.isVisible())
					excluir.setVisible(true);
			}
		});
		mntmExcluir.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-cancel-50.png")));
		menuBar.add(mntmExcluir);
		mntmSobre.setIcon(new ImageIcon(Teste.class.getResource("/icons/icons8-about-50.png")));
		menuBar.add(mntmSobre);
		
	}
}
