package controller;

import java.util.ArrayList;

import model.bo.FuncionarioBo;
import model.vo.FuncionarioVo;

public class ControladoraFuncionario {
	public void cadastrarFuncionarioController(FuncionarioVo funcionarioVo) {
		//FuncionarioBo funcionarioBo = new FuncionarioBo();
		FuncionarioBo.cadastrarFuncionarioBo(funcionarioVo);
		
	}
		
	public void excluirFuncionarioController(FuncionarioVo funcionarioVo) {
		//FuncionarioBo funcionarioBo = new FuncionarioBo();
		FuncionarioBo.excluirFuncionarioBo(funcionarioVo);
	}
	
	public void atualizarFuncionarioController(FuncionarioVo funcionarioVo) {
		//FuncionarioBo funcionarioBo = new FuncionarioBo();
		FuncionarioBo.atualizarFuncionarioBo(funcionarioVo);
	}
	
	public ArrayList<FuncionarioVo>  consultarTodosFuncionariosController() {
		FuncionarioBo funcionarioBo = new FuncionarioBo();
		return funcionarioBo.consultarFuncionariosBo();
	}
	
	public FuncionarioVo  consultarFuncionarioController(FuncionarioVo funcionarioVo) {
		FuncionarioBo funcionarioBo = new FuncionarioBo();
		return funcionarioBo.consultarFuncionariosBo(funcionarioVo);
	}
}
