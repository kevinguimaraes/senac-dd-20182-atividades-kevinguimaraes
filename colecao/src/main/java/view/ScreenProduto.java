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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private JButton bLimpar;
	private JButton btnDelete;

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
		frmCadastrarProduto.setBounds(100, 100, 247, 259);
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
		txtNome.setBounds(100, 38, 122, 20);
		frmCadastrarProduto.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(100, 63, 122, 20);
		frmCadastrarProduto.getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtPreco = new JTextField();
		txtPreco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
								
					
			}
		});
		txtPreco.setBounds(100, 113, 122, 20);
		frmCadastrarProduto.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		JButton bSalvar = new JButton("Salvar");
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutoVo produto = new ProdutoVo();
				ProdutoVo produtoaux = new ProdutoVo();
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
						produtoaux = controladoraProduto.consultarProdutoController(produto);
						txtId.setText(produtoaux.getIdproduto() + "");
						txtNome.setText(produtoaux.getNome());
						txtMarca.setText(produtoaux.getMarca());
						txtPreco.setText(produtoaux.getPreco()+ "");
						txtPeso.setText(produtoaux.getPeso()+"");
						if (JOptionPane.showConfirmDialog(null, "Deseja Atualizar") == JOptionPane.YES_OPTION)
							controladoraProduto.atualizarProdutoController(produto);
					}
					else
						controladoraProduto.cadastrarProdutoController(produto);
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
		bSalvar.setBounds(10, 186, 94, 23);
		frmCadastrarProduto.getContentPane().add(bSalvar);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(100, 88, 122, 20);
		frmCadastrarProduto.getContentPane().add(txtPeso);
		txtPeso.setColumns(10);
		
		lblId = new JLabel("ID");
		lblId.setBounds(10, 11, 72, 14);
		frmCadastrarProduto.getContentPane().add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(100, 11, 122, 20);
		frmCadastrarProduto.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JButton bBuscar = new JButton("Buscar");
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					final ScreenListarProdutos frame = new ScreenListarProdutos();
					frame.setVisible(true);
					
					frame.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosing(WindowEvent arg0) {
							ProdutoVo produto = frame.getProdutoSelecionado();
							preencherTela(produto);
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		bBuscar.setBounds(128, 152, 94, 23);
		frmCadastrarProduto.getContentPane().add(bBuscar);
		
		bLimpar = new JButton("Limpar");
		bLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparTela();
			}
		});
		bLimpar.setBounds(10, 152, 94, 23);
		frmCadastrarProduto.getContentPane().add(bLimpar);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProdutoVo produto = new ProdutoVo();
				ControladoraProduto controladoraProduto = new ControladoraProduto();
				
				produto.setIdProduto(Integer.parseInt(txtId.getText()));
				produto.setNome(txtNome.getText());
				produto.setMarca(txtMarca.getText());
				try {
				produto.setPeso(Double.parseDouble(txtPeso.getText()));
				produto.setPreco(Double.parseDouble(txtPreco.getText()));
				}catch(Exception d) {
					produto.setPeso(0);
					produto.setPreco(0);
					
				}
				produto = controladoraProduto.consultarProdutoController(produto);
				preencherTela(produto);
				
				if (JOptionPane.showConfirmDialog(null, "Deseja Excluir") == JOptionPane.YES_OPTION)
					controladoraProduto.excluirProdutoController(produto);
				
				limparTela();
				
			}
		});
		btnDelete.setBounds(129, 186, 93, 23);
		frmCadastrarProduto.getContentPane().add(btnDelete);
	}

	protected void limparTela() {
		txtId.setText("");
		txtNome.setText("");
		txtMarca.setText("");
		txtPreco.setText("");
		txtPeso.setText("");
	}
	
	protected void preencherTela(ProdutoVo produto) {
		txtId.setText(produto.getIdproduto() + "");
		txtNome.setText(produto.getNome());
		txtMarca.setText(produto.getMarca());
		txtPreco.setText(produto.getPreco()+ "");
		txtPeso.setText(produto.getPeso()+"");
	}
	
	
}
