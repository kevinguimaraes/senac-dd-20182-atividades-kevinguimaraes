package controller;

import java.util.ArrayList;

import model.bo.UsuarioBo;
import model.vo.UsuarioVo;

public class ControllerUsuario {
	
	public void cadastrarUsuarioController(UsuarioVo usuarioVo) {
		//UsuarioBo usuarioBo = new UsuarioBo();
		UsuarioBo.cadastrarUsuarioBo(usuarioVo);
		
	}
		
	public void excluirUsuarioController(UsuarioVo usuarioVo) {
		//UsuarioBo usuarioBo = new UsuarioBo();
		UsuarioBo.excluirUsuarioBo(usuarioVo);
	}
	
	public void atualizarUsuarioController(UsuarioVo usuarioVo) {
		//UsuarioBo usuarioBo = new UsuarioBo();
		UsuarioBo.atualizarUsuarioBo(usuarioVo);
	}
	
	public ArrayList<UsuarioVo> consultarTodosUsuarioController() {
		UsuarioBo usuarioBo = new UsuarioBo();
		return usuarioBo.consultarUsuariosBo();
	}
	
	public UsuarioVo consultarUsuarioController(UsuarioVo usuarioVo) {
		UsuarioBo usuarioBo = new UsuarioBo();
		return usuarioBo.consultarUsuariosBo(usuarioVo);
	}

}
