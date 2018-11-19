package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.AlugadoDao;
import model.vo.AlugadoVo;

public class AlugadoBo {
	public static void CadastrarAlugadoBo(AlugadoVo alugado) {
		AlugadoDao cadastrarDao = new AlugadoDao();
		
		int resultado = cadastrarDao.cadastrarAlugadoDao(alugado);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Agendado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void atualizarAlugadoBo(AlugadoVo alugadoVo) {
		AlugadoDao alugadoDao = new AlugadoDao();
		if(alugadoDao.existeResgistroPorIdAlugado(alugadoVo.getIdcliente(), alugadoVo.getIdimovel())) {
			int resultado = alugadoDao.atualizarAlugadoDao(alugadoVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirAlugadoBo(AlugadoVo alugadoVo) {
		AlugadoDao alugadoDao = new AlugadoDao();
		if(alugadoDao.existeResgistroPorIdAlugado(alugadoVo.getIdcliente(), alugadoVo.getIdimovel())) {
			int resultado = alugadoDao.excluirAlugadoDao(alugadoVo);
			if(resultado == 1)
				System.out.println("\nAlugado excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<AlugadoVo> consultarAlugadosBo() {
		AlugadoDao alugadoDao = new AlugadoDao();
		ArrayList<AlugadoVo> alugadoesVo = alugadoDao.consultarTodosAlugadosDao();
		if(alugadoesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "Casa não alugada", "Casa não alugada", JOptionPane.ERROR_MESSAGE);
		return alugadoesVo;
	}
	
	public ArrayList<AlugadoVo> consultarAlugadosNextMonthBo(int id) {
		AlugadoDao alugadoDao = new AlugadoDao();
		ArrayList<AlugadoVo> alugadoesVo = alugadoDao.consultarTodosAlugadosPorClienteDao(id);
		if(alugadoesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "Casa não alugada", "Casa não alugada", JOptionPane.ERROR_MESSAGE);
		return alugadoesVo;
	}
	
	public ArrayList<AlugadoVo> consultarTodosAlugadosPerIdAndDateBo(int id) {
		AlugadoDao alugadoDao = new AlugadoDao();
		ArrayList<AlugadoVo> alugadoesVo = alugadoDao.consultarTodosAlugadosPerIdAndDate(id);
		if(alugadoesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "Casa não alugada", "Casa não alugada", JOptionPane.ERROR_MESSAGE);
		return alugadoesVo;
	}

	public AlugadoVo consultarAlugadosBo(AlugadoVo alugadoVo) {
		AlugadoDao alugadoDao = new AlugadoDao();
		AlugadoVo alugado = alugadoDao.consultarAlugadoDao(alugadoVo);
		if(alugado == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return alugado;
	}

}
