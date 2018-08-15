package view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.ControladoraProduto;
import model.vo.ProdutoVo;

public class MenuProduto {
	
	public void apresentaMenuProduto() {
		int opcao = 0;
		String title = "Sistema Gerenciador de Coleções "
				+ "\n-------- Menu Produto --------"
				+ "\nOpções"
				+ "\n1 - Cadastrar Produto"
				+ "\n2 - Consultar Produto"
				+ "\n3 - Atualizar Produto"
				+ "\n4 - Excluir Produto"
				+ "\n5 - Voltar";
		
		while (opcao != 5) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(title));
	
			switch (opcao) {
			
			case 1: {				
				this.cadastrarProduto();
				break;
			}
			case 2: {				
				this.consultarProduto();				
				break;
			}
			case 3: {					
				this.atualizarProduto();
				break;
			}
			case 4: {				
				this.excluirProduto();
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
	
			}
			
		}
	}
	
	private void cadastrarProduto() {
		ProdutoVo produtoVo = new ProdutoVo();
		
		produtoVo.setNome(JOptionPane.showInputDialog("Digite o nome do produto"));
		
		produtoVo.setMarca(JOptionPane.showInputDialog("Digite o marca do produto"));
		
		produtoVo.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso do produto")));
		
		produtoVo.setPreco(Integer.parseInt(JOptionPane.showInputDialog("Digite o preco do produto")));
				
		ControladoraProduto controladoraColecionadro = new ControladoraProduto();
		controladoraColecionadro.cadastrarProdutoController(produtoVo);
	}
	
	private void consultarProduto() {
		
		int opcao = 0;
		String title = "\n-------- Menu Produto --------"
				+ "\nOpções"
				+ "\n1 - Consultar todos"
				+ "\n2 - Consultar específico"
				+ "\n3 - Sair";
		
		while (opcao != 3) {	
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(title)); 
			
			ControladoraProduto controladoraProduto = new ControladoraProduto();			
			
			switch (opcao) {
			
			case 1: {
				opcao = 3;
				ArrayList<ProdutoVo> produtoesVo = controladoraProduto.consultarTodosProdutoController();
				for(int i = 0; i < produtoesVo.size(); i++) {
					produtoesVo.get(i).imprimir();
				}				
				break;
			}
			case 2: {				
				opcao = 3;
				ProdutoVo produtoVo = new ProdutoVo();
				produtoVo.setIdproduto(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do Produto")));
				ProdutoVo produto = controladoraProduto.consultarProdutoController(produtoVo);
	
				produto.imprimir();
				break;
			}			
			case 3:
				break;
			default: {
				JOptionPane.showMessageDialog(null, "Opção Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
	
			}
			
		}
		
	}
	
	private void atualizarProduto() {
		
		ProdutoVo produtoVo = new ProdutoVo();
		
		produtoVo.setIdproduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
		
		produtoVo.setNome(JOptionPane.showInputDialog("Digite o codigo do produto"));
		
		produtoVo.setMarca(JOptionPane.showInputDialog("Digite o marca do produto"));
		
		produtoVo.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Digite o peso do produto")));
		
		produtoVo.setPreco(Integer.parseInt(JOptionPane.showInputDialog("Digite o preco do produto")));
				
		ControladoraProduto controladoraColecionadro = new ControladoraProduto();
		controladoraColecionadro.atualizarProdutoController(produtoVo);	
		
	}
	
	private void excluirProduto() {
		
		ProdutoVo produtoVo = new ProdutoVo();
		
		produtoVo.setIdproduto(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do produto")));
		
		ControladoraProduto controladoraProduto = new ControladoraProduto();
		controladoraProduto.excluirProdutoController(produtoVo);			
		
	}
}
