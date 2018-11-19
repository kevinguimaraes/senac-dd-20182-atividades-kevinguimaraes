package controller;

import java.util.ArrayList;

import model.bo.ClienteBo;
import model.vo.ClienteVo;

public class ControllerCliente {
	
	public void cadastrarClienteController(ClienteVo clienteVo) {
		//ClienteBo clienteBo = new ClienteBo();
		ClienteBo.cadastrarClienteBo(clienteVo);
		
	}
	
	public boolean existeResgistroPorIdClienteController(int id) {
		//ClienteBo clienteBo = new ClienteBo();
		return ClienteBo.existeResgistroPorIdClienteBo(id);
		
	}
		
	public void excluirClienteController(ClienteVo clienteVo) {
		//ClienteBo clienteBo = new ClienteBo();
		ClienteBo.excluirClienteBo(clienteVo);
	}
	
	public void atualizarClienteController(ClienteVo clienteVo) {
		//ClienteBo clienteBo = new ClienteBo();
		ClienteBo.atualizarClienteBo(clienteVo);
	}
	
	public ArrayList<ClienteVo> consultarTodosClienteController() {
		ClienteBo clienteBo = new ClienteBo();
		return clienteBo.consultarClientesBo();
	}
	
	public ClienteVo consultarClienteController(ClienteVo clienteVo) {
		ClienteBo clienteBo = new ClienteBo();
		return clienteBo.consultarClientesBo(clienteVo);
	}
	
	public ClienteVo consultarClientePorCpfController(String cpf) {
		ClienteBo clienteBo = new ClienteBo();
		return clienteBo.consultarClientesPorCpfBo(cpf);
	}

}
