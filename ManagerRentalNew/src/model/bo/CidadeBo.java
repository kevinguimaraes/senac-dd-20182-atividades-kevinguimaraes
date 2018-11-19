package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.CidadeDao;
import model.vo.CidadeVo;

public class CidadeBo {
	
	public static void cadastrarCidadeBo(CidadeVo cidadeVo) {
		CidadeDao cidadeDao = new CidadeDao();


		int resultado = cidadeDao.cadastrarCidadeDao(cidadeVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public static void atualizarCidadeBo(CidadeVo cidadeVo) {
		CidadeDao cidadeDao = new CidadeDao();
		if(cidadeDao.existeResgistroPorIdCidade(cidadeVo.getIdcidade())) {
			int resultado = cidadeDao.atualizarCidadeDao(cidadeVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirCidadeBo(CidadeVo cidadeVo) {
		CidadeDao cidadeDao = new CidadeDao();
		if(cidadeDao.existeResgistroPorIdCidade(cidadeVo.getIdcidade())) {
			int resultado = cidadeDao.excluirCidadeDao(cidadeVo);
			if(resultado == 1)
				System.out.println("\nCidade excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<CidadeVo> consultarCidadesBo() {
		CidadeDao cidadeDao = new CidadeDao();
		ArrayList<CidadeVo> cidadeesVo = cidadeDao.consultarTodosCidadesDao();
		if(cidadeesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cidadeesVo;
	}
	
	public ArrayList<CidadeVo> consultarCidadesByEstadoBo(int idestado) {
		CidadeDao cidadeDao = new CidadeDao();
		ArrayList<CidadeVo> cidadeesVo = cidadeDao.consultarTodosCidadesByEstadoDao(idestado);
		if(cidadeesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cidadeesVo;
	}

	public CidadeVo consultarCidadesBo(CidadeVo cidadeVo) {
		CidadeDao cidadeDao = new CidadeDao();
		CidadeVo cidade = cidadeDao.consultarCidadeDao(cidadeVo);
		if(cidade == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cidade;
	}
	
	public String[] getCidadesBo(int estado) {
		CidadeDao cidadeDao = new CidadeDao();
		String[] cidades = cidadeDao.getCidadesDao(estado);
		if(cidades == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cidades;
	}

}
