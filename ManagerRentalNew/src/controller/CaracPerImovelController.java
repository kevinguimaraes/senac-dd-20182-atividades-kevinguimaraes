package controller;

import java.util.ArrayList;

import model.bo.CaracPerImovelBo;
import model.vo.CaracPerImovelVo;

public class CaracPerImovelController {
	public ArrayList<CaracPerImovelVo>  getrCaracPerImovelsController(int idimovel) {
		CaracPerImovelBo caracPerImovelBo = new CaracPerImovelBo();
		return caracPerImovelBo.getrCaracPerImovelsBo(idimovel);
	}

}
