package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menu {
	
	Scanner teclado = new Scanner(System.in);

	public void apresentaMenu() {		

		int opcao = 0;

		while (opcao != 3) {
			
			String title = "Sistema Gerenciador de Coleções"
					+ "\nOpções"
					+ "\n1 - Menu Funcionario"
					+ "\n2 - Menu Produto"
					+ "\n3 - Sair";
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(title));
			
			
			switch (opcao) {
			case 1: {
				MenuFuncionario menuFuncionario = new MenuFuncionario();
				menuFuncionario.apresentaMenuFuncionario();
				break;
			}
			case 2: {
				MenuProduto menuProduto = new MenuProduto();
				menuProduto.apresentaMenuProduto();
				break;
			}
			case 3: {
				System.out.println("Saindo...");
			}
			default: {
				System.out.println("\nOpção Inválida.");
			}
			}
			
		}

	}

}
