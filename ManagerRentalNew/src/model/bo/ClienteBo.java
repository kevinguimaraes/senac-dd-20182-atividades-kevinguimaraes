package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.ClienteDao;
import model.vo.ClienteVo;

public class ClienteBo {
	
	public static void cadastrarClienteBo(ClienteVo clienteVo) {
		ClienteDao clienteDao = new ClienteDao();


		int resultado = clienteDao.cadastrarClienteDao(clienteVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static boolean existeResgistroPorIdClienteBo(int id) {
		ClienteDao clienteDao = new ClienteDao();


		return clienteDao.existeResgistroPorIdCliente(id);
		
	}

	public static void atualizarClienteBo(ClienteVo clienteVo) {
		ClienteDao clienteDao = new ClienteDao();
		if(clienteDao.existeResgistroPorIdCliente(clienteVo.getIdCliente())) {
			int resultado = clienteDao.atualizarClienteDao(clienteVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "Atualizado com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
				
		}
	}

	public static void excluirClienteBo(ClienteVo clienteVo) {
		ClienteDao clienteDao = new ClienteDao();
		if(clienteDao.existeResgistroPorIdCliente(clienteVo.getIdCliente())) {
			int resultado = clienteDao.excluirClienteDao(clienteVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "Excluido com Sucesso", "Message", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<ClienteVo> consultarClientesBo() {
		ClienteDao clienteDao = new ClienteDao();
		ArrayList<ClienteVo> clienteesVo = clienteDao.consultarTodosClientesDao();
		if(clienteesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return clienteesVo;
	}

	public ClienteVo consultarClientesBo(ClienteVo clienteVo) {
		ClienteDao clienteDao = new ClienteDao();
		ClienteVo cliente = clienteDao.consultarClienteDao(clienteVo);
		if(cliente == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cliente;
	}
	
	public ClienteVo consultarClientesPorCpfBo(String cpf) {
		ClienteDao clienteDao = new ClienteDao();
		ClienteVo cliente = clienteDao.ConsultaClientePorCpf(cpf);
		if(cliente == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return cliente;
	}

}
