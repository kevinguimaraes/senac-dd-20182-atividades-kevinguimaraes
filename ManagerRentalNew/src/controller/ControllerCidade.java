package controller;

import java.util.ArrayList;

import model.bo.CidadeBo;
import model.vo.CidadeVo;

public class ControllerCidade {
	
	public void cadastrarCidadeController(CidadeVo cidadeVo) {
		//CidadeBo cidadeBo = new CidadeBo();
		CidadeBo.cadastrarCidadeBo(cidadeVo);
		
	}
		
	public void excluirCidadeController(CidadeVo cidadeVo) {
		//CidadeBo cidadeBo = new CidadeBo();
		CidadeBo.excluirCidadeBo(cidadeVo);
	}
	
	public void atualizarCidadeController(CidadeVo cidadeVo) {
		//CidadeBo cidadeBo = new CidadeBo();
		CidadeBo.atualizarCidadeBo(cidadeVo);
	}
	
	public ArrayList<CidadeVo> consultarTodosCidadeController() {
		CidadeBo cidadeBo = new CidadeBo();
		return cidadeBo.consultarCidadesBo();
	}
	
	public ArrayList<CidadeVo> consultarTodosCidadeByEstadoController(int idestado) {
		CidadeBo cidadeBo = new CidadeBo();
		return cidadeBo.consultarCidadesByEstadoBo(idestado);
	}
	
	public CidadeVo consultarCidadeController(CidadeVo cidadeVo) {
		CidadeBo cidadeBo = new CidadeBo();
		return cidadeBo.consultarCidadesBo(cidadeVo);
	}
	
	public String[] getCidadesController(int estado) {
		CidadeBo cidadeBo = new CidadeBo();
		String[] cidades = cidadeBo.getCidadesBo(estado);
		
		return cidades;
	}

}
