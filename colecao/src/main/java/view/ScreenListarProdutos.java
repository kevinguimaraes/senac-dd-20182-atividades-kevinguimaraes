package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControladoraProduto;
import model.vo.ProdutoVo;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScreenListarProdutos extends JDialog {

	private JPanel contentPane;
	private JTable tProdutos;
	private JTextField tID;
	private JTextField tNome;
	private JTextField tMarca;
	private ProdutoVo produtoSelecionado;
	private ArrayList<ProdutoVo> produtos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScreenListarProdutos frame = new ScreenListarProdutos();
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
	public ScreenListarProdutos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tProdutos = new JTable();
		tProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tProdutos.getSelectedRow();
				produtoSelecionado = produtos.get(linha);
				
			}
		});
		tProdutos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nome", "Marca", "Preco", "Peso"
			}
		));
		tProdutos.setBounds(10, 59, 414, 191);
		contentPane.add(tProdutos);
		
		JButton bBuscar = new JButton("Buscar");
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProdutoVo produto = new ProdutoVo();
				produtos = new ArrayList<ProdutoVo>();
				ControladoraProduto controladoraProduto = new ControladoraProduto();
				
				try {
				produto.setIdProduto(Integer.parseInt(tID.getText()));
				}catch (Exception e) {
					produto.setIdProduto(0);
				}
				
				produto.setNome(tNome.getText());
				produto.setMarca(tMarca.getText());
				
				if (produto.getIdproduto() > 0) {
					produto = controladoraProduto.consultarProdutoController(produto);
					produtos.add(produto);
					System.out.println("id");
				}
				else if (!produto.getNome().equals("")) {
					produtos = controladoraProduto.consultarProdutoPorNomeController(produto);
					System.out.println("nome");
				}
				else if (!produto.getMarca().equals("")) {
					produtos = controladoraProduto.consultarProdutoPorMarcaController(produto);
					System.out.println("marca");
				}
				else {
					produtos = controladoraProduto.consultarTodosProdutoController();
					System.out.println("todos");
				}
				if(produto.getIdproduto() < 0)
				{
					JOptionPane.showMessageDialog(null, "Produto não encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
					tID.setText("");
					tNome.setText("");
					tMarca.setText("");
				} 
				else
				{
					atualizarTabelaProdutos(produtos);
				}
				
				
			}
		});
		bBuscar.setBounds(335, 25, 89, 23);
		contentPane.add(bBuscar);
		
		tID = new JTextField();
		tID.setBounds(10, 26, 86, 20);
		contentPane.add(tID);
		tID.setColumns(10);
		
		tNome = new JTextField();
		tNome.setBounds(106, 26, 86, 20);
		contentPane.add(tNome);
		tNome.setColumns(10);
		
		tMarca = new JTextField();
		tMarca.setBounds(202, 26, 86, 20);
		contentPane.add(tMarca);
		tMarca.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(39, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(125, 11, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(220, 11, 46, 14);
		contentPane.add(lblMarca);
	}

	protected void atualizarTabelaProdutos(ArrayList<ProdutoVo> produtoesVo) {

		tProdutos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Nome", "Marca", "Preco", "Peso"
				}
			));
		DefaultTableModel modelo = (DefaultTableModel) tProdutos.getModel();
		
		for(ProdutoVo produto: produtoesVo)
		{
			Object[] novaLinha = new Object[] {
					produto.getIdproduto(),
					produto.getNome(),
					produto.getMarca(),
					produto.getPreco(),
					produto.getPeso()
			};
			modelo.addRow(novaLinha);
		}
	}

	public ProdutoVo getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(ProdutoVo produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
}
