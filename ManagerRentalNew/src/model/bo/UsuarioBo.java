package model.bo;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

public class UsuarioBo {
	
	public static void cadastrarUsuarioBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();


		int resultado = usuarioDao.cadastrarUsuarioDao(usuarioVo);
		if(resultado == 1)
			JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		
	}

	public static void atualizarUsuarioBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.existeResgistroPorIdUsuario(usuarioVo.getIdusuario())) {
			int resultado = usuarioDao.atualizarUsuarioDao(usuarioVo);
			if(resultado == 1)
				JOptionPane.showMessageDialog(null, "OK", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void excluirUsuarioBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.existeResgistroPorIdUsuario(usuarioVo.getIdusuario())) {
			int resultado = usuarioDao.excluirUsuarioDao(usuarioVo);
			if(resultado == 1)
				System.out.println("\nUsuario excluir com Sucesso");
			else
				JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public ArrayList<UsuarioVo> consultarUsuariosBo() {
		UsuarioDao usuarioDao = new UsuarioDao();
		ArrayList<UsuarioVo> usuarioesVo = usuarioDao.consultarTodosUsuariosDao();
		if(usuarioesVo.isEmpty())
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return usuarioesVo;
	}

	public UsuarioVo consultarUsuariosBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		UsuarioVo usuario = usuarioDao.consultarUsuarioDao(usuarioVo);
		if(usuario == null)
			JOptionPane.showMessageDialog(null, "ERRO", "ERROR", JOptionPane.ERROR_MESSAGE);
		return usuario;
	}

}
