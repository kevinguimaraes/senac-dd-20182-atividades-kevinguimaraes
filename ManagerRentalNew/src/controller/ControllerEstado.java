package controller;

import java.util.ArrayList;

import model.bo.EstadoBo;
import model.vo.EstadoVo;

public class ControllerEstado {
	
	public void cadastrarEstadoController(EstadoVo estadoVo) {
		//EstadoBo estadoBo = new EstadoBo();
		EstadoBo.cadastrarEstadoBo(estadoVo);
		
	}
		
	public void excluirEstadoController(EstadoVo estadoVo) {
		//EstadoBo estadoBo = new EstadoBo();
		EstadoBo.excluirEstadoBo(estadoVo);
	}
	
	public void atualizarEstadoController(EstadoVo estadoVo) {
		//EstadoBo estadoBo = new EstadoBo();
		EstadoBo.atualizarEstadoBo(estadoVo);
	}
	
	public ArrayList<EstadoVo> consultarTodosEstadoController() {
		EstadoBo estadoBo = new EstadoBo();
		return estadoBo.consultarEstadosBo();
	}
	
	public EstadoVo consultarEstadoController(EstadoVo estadoVo) {
		EstadoBo estadoBo = new EstadoBo();
		return estadoBo.consultarEstadosBo(estadoVo);
	}
	
	public String[] getEstadosController() {
		EstadoBo estadoBo = new EstadoBo();
		return estadoBo.getEstadosBo();
	}
	

}
