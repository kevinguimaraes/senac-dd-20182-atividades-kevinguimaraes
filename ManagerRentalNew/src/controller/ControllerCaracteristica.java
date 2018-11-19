package controller;

import java.util.ArrayList;

import model.bo.CaracteristicaBo;
import model.vo.CaracteristicaVo;

public class ControllerCaracteristica {
	
	public void cadastrarCaracteristicaController(CaracteristicaVo caracteristicaVo) {
		//CaracteristicaBo caracteristicaBo = new CaracteristicaBo();
		CaracteristicaBo.cadastrarCaracteristicaBo(caracteristicaVo);
		
	}
		
	public void excluirCaracteristicaController(CaracteristicaVo caracteristicaVo) {
		//CaracteristicaBo caracteristicaBo = new CaracteristicaBo();
		CaracteristicaBo.excluirCaracteristicaBo(caracteristicaVo);
	}
	
	public void atualizarCaracteristicaController(CaracteristicaVo caracteristicaVo) {
		//CaracteristicaBo caracteristicaBo = new CaracteristicaBo();
		CaracteristicaBo.atualizarCaracteristicaBo(caracteristicaVo);
	}
	
	public String[]  consultarTodosCaracteristicaController() {
		CaracteristicaBo caracteristicaBo = new CaracteristicaBo();
		return caracteristicaBo.consultarCaracteristicasBo();
	}
	
	public CaracteristicaVo  consultarCaracteristicaController(CaracteristicaVo caracteristicaVo) {
		CaracteristicaBo caracteristicaBo = new CaracteristicaBo();
		return caracteristicaBo.consultarCaracteristicasBo(caracteristicaVo);
	}

}
