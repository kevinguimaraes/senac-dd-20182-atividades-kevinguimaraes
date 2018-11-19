package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ClienteDao;
import model.dao.ImovelDao;
import model.vo.ImovelVo;

public class ImovelBo {
	
	public static void cadastrarImovelBo(ImovelVo imovelVo) {
		ImovelDao imovelDao = new ImovelDao();


		int resultado = imovelDao.cadastrarImovelDao(imovelVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public static void atualizarImovelBo(ImovelVo imovelVo) {
		ImovelDao imovelDao = new ImovelDao();
		if(imovelDao.existeResgistroPorIdImovel(imovelVo.getIdimovel())) {
			int resultado = imovelDao.atualizarImovelDao(imovelVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void excluirImovelBo(ImovelVo imovelVo) {
		ImovelDao imovelDao = new ImovelDao();
		if(imovelDao.existeResgistroPorIdImovel(imovelVo.getIdimovel())) {
			int resultado = imovelDao.excluirImovelDao(imovelVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static boolean existeResgistroPorIdImovelBo(int id) {
		ImovelDao imovelDao = new ImovelDao();


		return imovelDao.existeResgistroPorIdImovel(id);
	}
	
	public ArrayList<ImovelVo> consultarImovelsBo() {
		ImovelDao imovelDao = new ImovelDao();
		ArrayList<ImovelVo> imovelesVo = imovelDao.consultarTodosImovelsDao();
		if(imovelesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return imovelesVo;
	}

	public ImovelVo consultarImovelsBo(ImovelVo imovelVo) {
		ImovelDao imovelDao = new ImovelDao();
		ImovelVo imovel = imovelDao.consultarImovelDao(imovelVo);
		if(imovel == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return imovel;
	}
	
	public String[] getReferenciasBo() {
		ArrayList<String> refs = new ArrayList<>();
		ArrayList<ImovelVo> imov = new ArrayList<>();
		imov = this.consultarImovelsBo();
		for (int i = 0; i < imov.size(); i++) {
			refs.add(imov.get(i).getReferencia()+"");
		}
		
		return refs.toArray(new String[0]);
	}

}
