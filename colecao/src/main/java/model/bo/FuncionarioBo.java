package model.bo;

import java.util.ArrayList;

import model.dao.FuncionarioDao;
import model.vo.FuncionarioVo;

public class FuncionarioBo {
	
	public static void cadastrarFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeRegistroPorCpf(funcionarioVo.getCpf()))
			System.out.println("\nFuncionario já Cadastrado");
		else {
			int resultado = funcionarioDao.cadastrarFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				System.out.println("\nFuncionario Cadastrado com Sucesso");
			else
				System.out.println("\nNão foi possivel cadastrar funcionario");
		}
		
	}

	public static void atualizarFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeResgistroPorIdfuncionario(funcionarioVo.getIdfuncionario())) {
			int resultado = funcionarioDao.atualizarFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				System.out.println("\nFuncionario atualizado com Sucesso");
			else
				System.out.println("\nNão foi possivel atualizar funcionario");
		}
	}

	public static void excluirFuncionarioBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		if(funcionarioDao.existeResgistroPorIdfuncionario(funcionarioVo.getIdfuncionario())) {
			int resultado = funcionarioDao.excluirFuncionarioDao(funcionarioVo);
			if(resultado == 1)
				System.out.println("\nFuncionario excluir com Sucesso");
			else
				System.out.println("\nNão foi possivel excluir funcionario");
		}
	}

	public ArrayList<FuncionarioVo> consultarFuncionariosBo() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		ArrayList<FuncionarioVo> funcionarioesVo = funcionarioDao.consultarTodosFuncionariosDao();
		if(funcionarioesVo.isEmpty())
			System.out.println("\nNão foram localizados funcionarioes na base de daos");
		return funcionarioesVo;
	}

	public FuncionarioVo consultarFuncionariosBo(FuncionarioVo funcionarioVo) {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		FuncionarioVo funcionario = funcionarioDao.consultarFuncionarioDao(funcionarioVo);
		if(funcionario == null)
			System.out.println("\nFuncionario não localizado na base de dados");
		return funcionario;
	}
}
