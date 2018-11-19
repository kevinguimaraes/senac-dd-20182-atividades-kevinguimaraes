package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.CaracImovelDao;
import model.vo.CaracImovelVo;

public class CaracImovelBo {
	
	public static void CadastrarCaracImovelBo(CaracImovelVo caracImovel) {
		CaracImovelDao cadastrarDao = new CaracImovelDao();
		
		int resultado = cadastrarDao.cadastrarCaracImovelDao(caracImovel);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Adicionado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void atualizarCaracImovelBo(CaracImovelVo caracImovelVo) {
		CaracImovelDao caracImovelDao = new CaracImovelDao();
		if(caracImovelDao.existeResgistroPorIdCaracImovel(caracImovelVo.getIdimovel(), caracImovelVo.getIdcaracteristica())) {
			int resultado = caracImovelDao.atualizarCaracImovelDao(caracImovelVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void excluirCaracImovelBo(CaracImovelVo caracImovelVo) {
		CaracImovelDao caracImovelDao = new CaracImovelDao();
		if(caracImovelDao.existeResgistroPorIdCaracImovel(caracImovelVo.getIdimovel(), caracImovelVo.getIdcaracteristica())) {
			int resultado = caracImovelDao.excluirCaracImovelDao(caracImovelVo);
			if(resultado == 1)
				System.out.println("\nCaracImovel excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<CaracImovelVo> consultarCaracImovelsBo() {
		CaracImovelDao caracImovelDao = new CaracImovelDao();
		ArrayList<CaracImovelVo> caracImovelesVo = caracImovelDao.consultarTodosCaracImovelsDao();
		if(caracImovelesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return caracImovelesVo;
	}

	public CaracImovelVo consultarCaracImovelsBo(CaracImovelVo caracImovelVo) {
		CaracImovelDao caracImovelDao = new CaracImovelDao();
		CaracImovelVo caracImovel = caracImovelDao.consultarCaracImovelDao(caracImovelVo);
		if(caracImovel == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return caracImovel;
	}

}
