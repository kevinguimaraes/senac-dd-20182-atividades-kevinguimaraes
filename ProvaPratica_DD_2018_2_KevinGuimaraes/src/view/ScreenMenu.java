package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControladorAluno;
import model.vo.Aluno;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class ScreenMenu {

	private JFrame frmCursoCaminhoSuave;
	private JTextField tNome;
	private JTextField tMatricula;
	private JTextField tSobrenome;
	private JTextField tNota1;
	private JTextField tNota2;
	private JTextField tPesop;
	private JTextField tTrab1;
	private JTextField tTrab2;
	private JTextField tPesot;
	JComboBox tNivel = new JComboBox();
	JLabel tSituacao = new JLabel("");
	JLabel tMedia = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenMenu window = new ScreenMenu();
					window.frmCursoCaminhoSuave.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCursoCaminhoSuave = new JFrame();
		frmCursoCaminhoSuave.setTitle("Curso Caminho Suave");
		frmCursoCaminhoSuave.setBounds(100, 100, 401, 300);
		frmCursoCaminhoSuave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCursoCaminhoSuave.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 29, 37, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblNome);
		
		tNome = new JTextField();
		tNome.setBounds(68, 26, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tNome);
		tNome.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 54, 62, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblMatricula);
		
		tMatricula = new JTextField();
		tMatricula.setBounds(68, 51, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tMatricula);
		tMatricula.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setBounds(190, 29, 73, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblSobrenome);
		
		tSobrenome = new JTextField();
		tSobrenome.setBounds(267, 26, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tSobrenome);
		tSobrenome.setColumns(10);
		
		
		tNivel.setModel(new DefaultComboBoxModel(new String[] {"Basico", "Intermediario", "Avancado"}));
		tNivel.setBounds(240, 51, 113, 20);
		frmCursoCaminhoSuave.getContentPane().add(tNivel);
		
		JLabel lblNivel = new JLabel("Nivel:");
		lblNivel.setBounds(201, 54, 46, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblNivel);
		
		JLabel lblNp = new JLabel("NP1:");
		lblNp.setBounds(10, 99, 46, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblNp);
		
		JLabel lblNp_1 = new JLabel("NP2:");
		lblNp_1.setBounds(10, 121, 46, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblNp_1);
		
		JLabel lblPesoProvas = new JLabel("Peso P:");
		lblPesoProvas.setBounds(10, 146, 86, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblPesoProvas);
		
		JLabel lblT = new JLabel("T1:");
		lblT.setBounds(201, 99, 46, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblT);
		
		JLabel lblT_1 = new JLabel("T2:");
		lblT_1.setBounds(201, 121, 46, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblT_1);
		
		JLabel lblPesoTrab = new JLabel("Peso T:");
		lblPesoTrab.setBounds(201, 146, 62, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblPesoTrab);
		
		tNota1 = new JTextField();
		tNota1.setBounds(68, 96, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tNota1);
		tNota1.setColumns(10);
		
		tNota2 = new JTextField();
		tNota2.setBounds(68, 121, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tNota2);
		tNota2.setColumns(10);
		
		tPesop = new JTextField();
		tPesop.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				double aux;
				try {
					aux = 100 - Double.parseDouble(tPesop.getText()); 
				}catch(Exception e) {
					aux = 0;
				}
				
				
				tPesot.setText(aux + "");
			}
		});
		tPesop.setBounds(68, 143, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tPesop);
		tPesop.setColumns(10);
		
		tTrab1 = new JTextField();
		tTrab1.setBounds(267, 96, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tTrab1);
		tTrab1.setColumns(10);
		
		tTrab2 = new JTextField();
		tTrab2.setBounds(267, 118, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tTrab2);
		tTrab2.setColumns(10);
		
		tPesot = new JTextField();
		tPesot.setEditable(false);
		tPesot.setBounds(267, 143, 86, 20);
		frmCursoCaminhoSuave.getContentPane().add(tPesot);
		tPesot.setColumns(10);
		
		JLabel lblMediaFinal = new JLabel("Media Final:");
		lblMediaFinal.setBounds(10, 192, 86, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblMediaFinal);
		
		
		tMedia.setBounds(92, 192, 62, 14);
		frmCursoCaminhoSuave.getContentPane().add(tMedia);
		
		JLabel lblSituacao = new JLabel("Situacao:");
		lblSituacao.setBounds(201, 192, 62, 14);
		frmCursoCaminhoSuave.getContentPane().add(lblSituacao);
		
		
		tSituacao.setBounds(267, 192, 86, 14);
		frmCursoCaminhoSuave.getContentPane().add(tSituacao);
		
		JButton bSalvar = new JButton("Salvar e Calcular");
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControladorAluno controladoraluno = new ControladorAluno();
				boolean aux_erro = false;
				Aluno a = new Aluno();
				try {
					a.setNome(tNome.getText());
					a.setSobrenome(tSobrenome.getText());
					a.setMatricula(tMatricula.getText());
					a.setNivel((String)tNivel.getSelectedItem());
					a.setNotaProva1(Double.parseDouble(tNota1.getText()));
					a.setNotaProva2(Double.parseDouble(tNota2.getText()));
					a.setTrab1(Double.parseDouble(tTrab1.getText()));
					a.setTrab2(Double.parseDouble(tTrab2.getText()));
					a.setPeson(Double.parseDouble(tPesop.getText()));
					a.setPesot(Double.parseDouble(tPesot.getText()));	
				}catch(Exception e){
					aux_erro = true;
				}
				if (a.getNome().equals("")) {
					aux_erro = true;
				}
				else if(a.getSobrenome().equals("")) {
					aux_erro = true;
				}
				else if(a.getNotaProva1() < 0) {
					aux_erro = true;
				}
				else if(a.getNotaProva2() < 0) {
					aux_erro = true;
				}
				else if(a.getTrab1() < 0) {
					aux_erro = true;
				}
				else if(a.getTrab2() < 0) {
					aux_erro = true;
				}
				else if(a.getPeson() < 0 || a.getPeson() > 99) {
					aux_erro = true;
				}
				
				if (!aux_erro)
				{
					if (controladoraluno.verificaPorMatricula(a.getMatricula())) {
						JOptionPane.showMessageDialog(null, "Matricula ja existe", "ERROR", JOptionPane.ERROR_MESSAGE);
						limpartela();
					}
					else
					{
						if(controladoraluno.cadastrarAlunoController(a) > 0)
						{
							tMedia.setText(controladoraluno.calcularMediaFinal(a) + "");
							int situacao = controladoraluno.calcularSituacao(a);
							switch(situacao) {
								case 1: 
									tSituacao.setText("Aprovado");
									tSituacao.setForeground(Color.GREEN);
									break;
								case 2:
									tSituacao.setText("Recuperacao");
									tSituacao.setForeground(Color.YELLOW);
									break;
								case 3:
									tSituacao.setText("Reprovado");
									tSituacao.setForeground(Color.RED);
									break;
								default:
									break;
										
							}
						}
						else
							JOptionPane.showMessageDialog(null, "Erro ao gravar Aluno", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					aux_erro = false;
					JOptionPane.showMessageDialog(null, "Erro de digitação", "ERROR", JOptionPane.ERROR_MESSAGE);
					limpartela();
				}
				
			}
		});
		bSalvar.setBounds(10, 227, 144, 23);
		frmCursoCaminhoSuave.getContentPane().add(bSalvar);
		
		JButton bLimpar = new JButton("Limpar");
		bLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpartela();
			}
		});
		bLimpar.setBounds(201, 227, 152, 23);
		frmCursoCaminhoSuave.getContentPane().add(bLimpar);
	}
	
	public void limpartela() {
		tNome.setText("");
		tSobrenome.setText("");
		tMatricula.setText("");
		tNivel.setSelectedIndex(0);
		tNota1.setText("");
		tNota2.setText("");
		tTrab1.setText("");
		tTrab2.setText("");
		tPesop.setText("");
		tPesot.setText("");
		tSituacao.setText("");
		tMedia.setText("");
	}
}
