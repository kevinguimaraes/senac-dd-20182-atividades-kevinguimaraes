package view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import controller.ControladoraFuncionario;
import model.vo.FuncionarioVo;

public class MenuFuncionario {
	Scanner teclado = new Scanner(System.in);

	public void apresentaMenuFuncionario() {
		
		int opcao = 0;
		String title = "Sistema Gerenciador de Coleções "
				+ "\n-------- Menu Funcionario --------"
				+ "\nOpções"
				+ "\n1 - Cadastrar Funcionario"
				+ "\n2 - Consultar Funcionario"
				+ "\n3 - Atualizar Funcionario"
				+ "\n4 - Excluir Funcionario"
				+ "\n5 - Voltar";
		
		while (opcao != 5) {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(title));

			switch (opcao) {
			
			case 1: {				
				this.cadastrarFuncionario();
				break;
			}
			case 2: {				
				this.consultarFuncionario();				
				break;
			}
			case 3: {					
				this.atualizarFuncionario();
				break;
			}
			case 4: {				
				this.excluirFuncionario();
				break;
			}
			default: {
				JOptionPane.showMessageDialog(null, "Opção Invalida", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
			
		}
	}
	
	private void cadastrarFuncionario() {
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		
		funcionarioVo.setNome(JOptionPane.showInputDialog("Digite o nome do funcionario"));
		
		funcionarioVo.setCpf(JOptionPane.showInputDialog("Digite o CPF do funcionario"));
		
		funcionarioVo.setCargo(JOptionPane.showInputDialog("Digite o cargo do funcionario"));
				
		ControladoraFuncionario controladoraFuncionario = new ControladoraFuncionario();
		controladoraFuncionario.cadastrarFuncionarioController(funcionarioVo);
	}
	
	private void consultarFuncionario() {
		
		int opcao = 0;
		String title = "\n-------- Menu Funcionario --------"
				+ "\nOpções"
				+ "\n1 - Consultar todos"
				+ "\n2 - Consultar específico"
				+ "\n3 - Sair";
		
		while (opcao != 3) {	
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(title)); 
			
			ControladoraFuncionario controladoraFuncionario = new ControladoraFuncionario();			
			
			switch (opcao) {
			
			case 1: {
				opcao = 3;
				ArrayList<FuncionarioVo> funcionarioesVo = controladoraFuncionario.consultarTodosFuncionariosController();
				for(int i = 0; i < funcionarioesVo.size(); i++) {
					funcionarioesVo.get(i).imprimir();
				}				
				break;
			}
			case 2: {				
				opcao = 3;
				FuncionarioVo funcionarioVo = new FuncionarioVo();
				funcionarioVo.setIdfuncionario(Integer.parseInt(JOptionPane.showInputDialog("Informe o código do Funcionario")));
				FuncionarioVo funcionario = controladoraFuncionario.consultarFuncionarioController(funcionarioVo);

				funcionario.imprimir();
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
	
	private void atualizarFuncionario() {
		
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		
		funcionarioVo.setIdfuncionario(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do funcionario")));
		
		funcionarioVo.setNome(JOptionPane.showInputDialog("Digite o codigo do funcionario"));
		
		funcionarioVo.setCpf(JOptionPane.showInputDialog("Digite o CPF do funcionario"));
		
		funcionarioVo.setCargo(JOptionPane.showInputDialog("Digite o cargo do funcionario"));
				
		ControladoraFuncionario controladoraFuncionario = new ControladoraFuncionario();
		controladoraFuncionario.atualizarFuncionarioController(funcionarioVo);	
		
	}

	private void excluirFuncionario() {
		
		FuncionarioVo funcionarioVo = new FuncionarioVo();
		
		funcionarioVo.setIdfuncionario(Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do funcionario")));
		
		ControladoraFuncionario controladoraFuncionario = new ControladoraFuncionario();
		controladoraFuncionario.excluirFuncionarioController(funcionarioVo);			
		
	}

}
