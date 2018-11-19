package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.CaracteristicaDao;
import model.vo.CaracteristicaVo;

public class CaracteristicaBo {
	
	public static void cadastrarCaracteristicaBo(CaracteristicaVo caracteristicaVo) {
		CaracteristicaDao caracteristicaDao = new CaracteristicaDao();


		int resultado = caracteristicaDao.cadastrarCaracteristicaDao(caracteristicaVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public static void atualizarCaracteristicaBo(CaracteristicaVo caracteristicaVo) {
		CaracteristicaDao caracteristicaDao = new CaracteristicaDao();
		if(caracteristicaDao.existeResgistroPorIdCaracteristica(caracteristicaVo.getIdcaracteristica())) {
			int resultado = caracteristicaDao.atualizarCaracteristicaDao(caracteristicaVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirCaracteristicaBo(CaracteristicaVo caracteristicaVo) {
		CaracteristicaDao caracteristicaDao = new CaracteristicaDao();
		if(caracteristicaDao.existeResgistroPorIdCaracteristica(caracteristicaVo.getIdcaracteristica())) {
			int resultado = caracteristicaDao.excluirCaracteristicaDao(caracteristicaVo);
			if(resultado == 1)
				System.out.println("\nCaracteristica excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public String[] consultarCaracteristicasBo() {
		CaracteristicaDao caracteristicaDao = new CaracteristicaDao();
		String[] caracteristicaesVo = caracteristicaDao.consultarTodosCaracteristicasDao();
		if(caracteristicaesVo == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return caracteristicaesVo;
	}

	public CaracteristicaVo consultarCaracteristicasBo(CaracteristicaVo caracteristicaVo) {
		CaracteristicaDao caracteristicaDao = new CaracteristicaDao();
		CaracteristicaVo caracteristica = caracteristicaDao.consultarCaracteristicaDao(caracteristicaVo);
		if(caracteristica == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return caracteristica;
	}

}
