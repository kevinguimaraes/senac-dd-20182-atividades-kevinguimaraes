package controller;

import java.util.ArrayList;

import model.bo.ImovelBo;
import model.vo.ImovelVo;

public class ControllerImovel {
	
	public void cadastrarImovelController(ImovelVo imovelVo) {
		//ImovelBo imovelBo = new ImovelBo();
		ImovelBo.cadastrarImovelBo(imovelVo);
		
	}
		
	public void excluirImovelController(ImovelVo imovelVo) {
		//ImovelBo imovelBo = new ImovelBo();
		ImovelBo.excluirImovelBo(imovelVo);
	}
	
	public void atualizarImovelController(ImovelVo imovelVo) {
		//ImovelBo imovelBo = new ImovelBo();
		ImovelBo.atualizarImovelBo(imovelVo);
	}
	
	public ArrayList<ImovelVo> consultarTodosImovelController() {
		ImovelBo imovelBo = new ImovelBo();
		return imovelBo.consultarImovelsBo();
	}
	
	public ImovelVo consultarImovelController(ImovelVo imovelVo) {
		ImovelBo imovelBo = new ImovelBo();
		return imovelBo.consultarImovelsBo(imovelVo);
	}
	
	public boolean existeResgistroPorIdImovelController(int id) {
		//ClienteBo clienteBo = new ClienteBo();
		return ImovelBo.existeResgistroPorIdImovelBo(id);
		
	}
	
	public String[] getReferenciasController() {
		ImovelBo imovelBo = new ImovelBo();
		return imovelBo.getReferenciasBo();
	}

}
