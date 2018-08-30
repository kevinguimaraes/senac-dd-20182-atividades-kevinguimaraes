package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.ControladoraProduto;
import model.vo.ProdutoVo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScreenProduto {

	private JFrame frmCadastrarProduto;
	private JTextField txtNome;
	private JTextField txtMarca;
	private JTextField txtPreco;
	private JTextField txtPeso;
	private JLabel lblId;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenProduto window = new ScreenProduto();
					window.frmCadastrarProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ScreenProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastrarProduto = new JFrame();
		frmCadastrarProduto.setTitle("Cadastrar Produto");
		frmCadastrarProduto.setBounds(100, 100, 295, 211);
		frmCadastrarProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastrarProduto.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 41, 100, 14);
		frmCadastrarProduto.getContentPane().add(lblNome);
		
		JLabel lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(10, 66, 46, 14);
		frmCadastrarProduto.getContentPane().add(lblNewLabel);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(10, 91, 46, 14);
		frmCadastrarProduto.getContentPane().add(lblPeso);
		
		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(10, 116, 46, 14);
		frmCadastrarProduto.getContentPane().add(lblPreo);
		
		txtNome = new JTextField();
		txtNome.setBounds(100, 38, 170, 20);
		frmCadastrarProduto.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(100, 63, 170, 20);
		frmCadastrarProduto.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
								
					
			}
		});
		txtPreco.setBounds(100, 113, 170, 20);
		frmCadastrarProduto.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton bSalvar = new JButton("Salvar");
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoVo produto = new ProdutoVo();
				try {
					produto.setIdProduto(Integer.parseInt(txtId.getText()));
				} catch(Exception e){
					produto.setIdProduto(0);
				}
			
				produto.setNome(txtNome.getText());
				produto.setMarca(txtMarca.getText());
				produto.setPeso(Double.parseDouble(txtPeso.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				
				ControladoraProduto controladoraProduto = new ControladoraProduto();
				if (produto.getIdproduto() > 0)
				{
					if(controladoraProduto.existeResgistroPorIdProdutoController(produto.getIdproduto()))
					{
						produto = controladoraProduto.consultarProdutoController(produto);
						txtId.setText(produto.getIdproduto() + "");
						txtNome.setText(produto.getNome());
						txtMarca.setText(produto.getMarca());
						txtPreco.setText(produto.getPreco()+ "");
						txtPeso.setText(produto.getPeso()+"");
						if (JOptionPane.showConfirmDialog(null, "Deseja Atualizar") == JOptionPane.YES_OPTION)
							controladoraProduto.atualizarProdutoController(produto);
					}
				}
				else
					controladoraProduto.cadastrarProdutoController(produto);
				
				txtId.setText("");
				txtNome.setText("");
				txtMarca.setText("");
				txtPreco.setText("");
				txtPeso.setText("");
			}
		});
		bSalvar.setBounds(10, 144, 260, 23);
		frmCadastrarProduto.getContentPane().add(bSalvar);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(100, 88, 170, 20);
		frmCadastrarProduto.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 72, 14);
		frmCadastrarProduto.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(100, 11, 170, 20);
		frmCadastrarProduto.getContentPane().add(txtId);
		txtId.setColumns(10);
	}
}
