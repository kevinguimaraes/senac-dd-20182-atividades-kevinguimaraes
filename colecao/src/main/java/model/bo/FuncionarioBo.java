package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.FuncionarioDao;
import model.vo.FuncionarioVo;

public class FuncionarioBo {
	
	public static void cadastrarFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeRegistroPorCpf(funcionarioVo.getCpf()))
			JOptionPane.showMessageDialog(null, "Ja cadastrado", "ERROR", JOptionPane.ERROR_MESSAGE);
		else {
			int resultado = funcionarioDao.cadastrarFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public static void atualizarFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeResgistroPorIdFuncionario(funcionarioVo.getIdFuncionario())) {
			int resultado = funcionarioDao.atualizarFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeResgistroPorIdFuncionario(funcionarioVo.getIdFuncionario())) {
			int resultado = funcionarioDao.excluirFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				System.out.println("\nFuncionario excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<FuncionarioVo> consultarFuncionariosBo() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		ArrayList<FuncionarioVo> funcionarioesVo = funcionarioDao.consultarTodosFuncionariosDao();
		if(funcionarioesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return funcionarioesVo;
	}

	public FuncionarioVo consultarFuncionariosBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		FuncionarioVo funcionario = funcionarioDao.consultarFuncionarioDao(funcionarioVo);
		if(funcionario == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return funcionario;
	}
}
