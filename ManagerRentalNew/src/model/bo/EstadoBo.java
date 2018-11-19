package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.EstadoDao;
import model.vo.EstadoVo;

public class EstadoBo {
	
	public static void cadastrarEstadoBo(EstadoVo estadoVo) {
		EstadoDao estadoDao = new EstadoDao();


		int resultado = estadoDao.cadastrarEstadoDao(estadoVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public static void atualizarEstadoBo(EstadoVo estadoVo) {
		EstadoDao estadoDao = new EstadoDao();
		if(estadoDao.existeResgistroPorIdEstado(estadoVo.getIdestado())) {
			int resultado = estadoDao.atualizarEstadoDao(estadoVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirEstadoBo(EstadoVo estadoVo) {
		EstadoDao estadoDao = new EstadoDao();
		if(estadoDao.existeResgistroPorIdEstado(estadoVo.getIdestado())) {
			int resultado = estadoDao.excluirEstadoDao(estadoVo);
			if(resultado == 1)
				System.out.println("\nEstado excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<EstadoVo> consultarEstadosBo() {
		EstadoDao estadoDao = new EstadoDao();
		ArrayList<EstadoVo> estadoesVo = estadoDao.consultarTodosEstadosDao();
		if(estadoesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return estadoesVo;
	}

	public EstadoVo consultarEstadosBo(EstadoVo estadoVo) {
		EstadoDao estadoDao = new EstadoDao();
		EstadoVo estado = estadoDao.consultarEstadoDao(estadoVo);
		if(estado == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return estado;
	}
	
	public String[] getEstadosBo() {
		
		EstadoDao estadoDao = new EstadoDao();
		String[] estados = estadoDao.getEstadosDao();
		if(estados == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return estados;
		
	}


}
