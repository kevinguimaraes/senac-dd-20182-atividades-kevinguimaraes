package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.JButton;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 755, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Home home = new Home();
				frame.setContentPane(home);
				frame.setVisible(true);
			}
		});
		mnHome.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-gr\u00E1fico-combinado-48.png")));
		menuBar.add(mnHome);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-adicionar-48.png")));
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cadastrocliente = new CadastroCliente();
				frame.setContentPane(cadastrocliente);
				frame.setVisible(true);
			}
		});
		mntmCliente.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-adicionar-usu\u00E1rio-masculino-48.png")));
		mnCadastro.add(mntmCliente);
		
		JMenuItem mntmImovel = new JMenuItem("Imovel");
		mntmImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroImovel cadastroimovel = new CadastroImovel();
				frame.setContentPane(cadastroimovel);
				frame.setVisible(true);
			}
		});
		mntmImovel.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-bangal\u00F4-48.png")));
		mnCadastro.add(mntmImovel);
		
		JMenuItem mntmCaracteristica = new JMenuItem("Caracteristica");
		mntmCaracteristica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCarac cadastrocarac = new CadastroCarac();
				frame.setContentPane(cadastrocarac);
				frame.setVisible(true);
			}
		});
		mntmCaracteristica.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-estrela-48.png")));
		mnCadastro.add(mntmCaracteristica);
		
		JMenu mnConsultar = new JMenu("Consultar");
		mnConsultar.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-pesquisar-48.png")));
		menuBar.add(mnConsultar);
		
		JMenuItem mntmPorImovel = new JMenuItem("Por Imovel");
		mntmPorImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaPorImovel consultaporimovel = new ConsultaPorImovel();
				frame.setContentPane(consultaporimovel);
				frame.setVisible(true);
			}
		});
		mntmPorImovel.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-bangal\u00F4-48 (1).png")));
		mnConsultar.add(mntmPorImovel);
		
		JMenuItem mntmPorCliente = new JMenuItem("Por Cliente");
		mntmPorCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarPorCliente consultaporcliente = new ConsultarPorCliente();
				frame.setContentPane(consultaporcliente);
				frame.setVisible(true);
			}
		});
		mntmPorCliente.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-procurar-usu\u00E1rio-masculino-48.png")));
		mnConsultar.add(mntmPorCliente);
		
		JMenu mnAgendar = new JMenu("Agendar");
		mnAgendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agendar agendar = new Agendar();
				frame.setContentPane(agendar);
				frame.setVisible(true);
			}
		});
		mnAgendar.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-mais-calend\u00E1rio-48.png")));
		menuBar.add(mnAgendar);
		
		JMenu mnRelatorio = new JMenu("Relatorio");
		mnRelatorio.setIcon(new ImageIcon(MainMenu.class.getResource("/icons/icons8-documento-48.png")));
		menuBar.add(mnRelatorio);
	}
}
