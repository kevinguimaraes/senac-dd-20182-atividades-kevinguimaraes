package controller;

import java.util.ArrayList;

import model.bo.CaracImovelBo;
import model.vo.CaracImovelVo;

public class ControllerCaracImovel {
	
	public void cadastrarCaracImovelController(CaracImovelVo caracImovelVo) {
		//CaracImovelBo caracImovelBo = new CaracImovelBo();
		CaracImovelBo.CadastrarCaracImovelBo(caracImovelVo);
		
	}
		
	public void excluirCaracImovelController(CaracImovelVo caracImovelVo) {
		//CaracImovelBo caracImovelBo = new CaracImovelBo();
		CaracImovelBo.excluirCaracImovelBo(caracImovelVo);
	}
	
	public void atualizarCaracImovelController(CaracImovelVo caracImovelVo) {
		//CaracImovelBo caracImovelBo = new CaracImovelBo();
		CaracImovelBo.atualizarCaracImovelBo(caracImovelVo);
	}
	
	public ArrayList<CaracImovelVo>  consultarTodosCaracImovelController() {
		CaracImovelBo caracImovelBo = new CaracImovelBo();
		return caracImovelBo.consultarCaracImovelsBo();
	}
	
	public CaracImovelVo  consultarCaracImovelController(CaracImovelVo caracImovelVo) {
		CaracImovelBo caracImovelBo = new CaracImovelBo();
		return caracImovelBo.consultarCaracImovelsBo(caracImovelVo);
	}

}
