package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.CaracImovelDao;
import model.dao.CaracPerImovelDao;
import model.vo.CaracImovelVo;
import model.vo.CaracPerImovelVo;

public class CaracPerImovelBo {
	public ArrayList<CaracPerImovelVo> getrCaracPerImovelsBo(int idimovel) {
		CaracPerImovelDao caracPerImovelDao = new CaracPerImovelDao();
		ArrayList<CaracPerImovelVo> caracPerImovelesVo = caracPerImovelDao.getCarcPerImovelDao(idimovel);
		if(caracPerImovelesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "Imovel sem Caracteristicas", "Imovel", JOptionPane.ERROR_MESSAGE);
		return caracPerImovelesVo;
	}
}
