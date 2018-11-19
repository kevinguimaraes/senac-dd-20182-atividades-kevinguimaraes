package controller;

import java.util.ArrayList;

import model.bo.AlugadoBo;
import model.vo.AlugadoVo;

public class ControllerAlugado {
	
	public void cadastrarAlugadoController(AlugadoVo alugadoVo) {
		//AlugadoBo alugadoBo = new AlugadoBo();
		AlugadoBo.CadastrarAlugadoBo(alugadoVo);
		
	}
		
	public void excluirAlugadoController(AlugadoVo alugadoVo) {
		//AlugadoBo alugadoBo = new AlugadoBo();
		AlugadoBo.excluirAlugadoBo(alugadoVo);
	}
	
	public void atualizarAlugadoController(AlugadoVo alugadoVo) {
		//AlugadoBo alugadoBo = new AlugadoBo();
		AlugadoBo.atualizarAlugadoBo(alugadoVo);
	}
	
	public ArrayList<AlugadoVo> consultarTodosAlugadoController() {
		AlugadoBo alugadoBo = new AlugadoBo();
		return alugadoBo.consultarAlugadosBo();
	}
	
	public ArrayList<AlugadoVo> consultarTodosNextMonthAlugadoController(int id) {
		AlugadoBo alugadoBo = new AlugadoBo();
		return alugadoBo.consultarAlugadosNextMonthBo(id);
	}
	
	public ArrayList<AlugadoVo> consultarTodosAlugadosPerIdAndDateController(int id) {
		AlugadoBo alugadoBo = new AlugadoBo();
		return alugadoBo.consultarTodosAlugadosPerIdAndDateBo(id);
	}
	
	public AlugadoVo consultarAlugadoController(AlugadoVo alugadoVo) {
		AlugadoBo alugadoBo = new AlugadoBo();
		return alugadoBo.consultarAlugadosBo(alugadoVo);
	}

}
