package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.UsuarioVo;

public class UsuarioDao {
	
	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from usuario where cpf like '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Usuario por CPF");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarUsuarioDao(UsuarioVo usuarioVo) {
		int resultado = 0;

		String sql = " INSERT INTO usuario (nome, cpf, login, pass) "
				+ " VALUES (?,?,?,?) ";
		

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, usuarioVo.getNome());
			prepStmt.setString(2, usuarioVo.getCpf());
			prepStmt.setString(3, usuarioVo.getLogin());
			prepStmt.setString(4, usuarioVo.getPass());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Usuario. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdUsuario(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from usuario where idusuario = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Usuario por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarUsuarioDao(UsuarioVo usuarioVo) {
		int resultado = 0;
		String query = " update usuario set nome = ?, cpf = ?, login = ?, pass = ? where idusuario = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, usuarioVo.getNome());
			prepStmt.setString(2, usuarioVo.getCpf());
			prepStmt.setString(3, usuarioVo.getLogin());
			prepStmt.setString(4, usuarioVo.getPass());
			prepStmt.setInt(5, usuarioVo.getIdusuario());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Usuario. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirUsuarioDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from usuario where idusuario = " + usuarioVo.getIdusuario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Usuario por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public UsuarioVo consultarUsuarioDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVo usuario = new UsuarioVo();

		String query = "select * from usuario where idusuario = " + usuarioVo.getIdusuario();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			usuario.setIdusuario(resultado.getInt(1));
			usuario.setNome(resultado.getString(2));
			usuario.setCpf(resultado.getString(3));
			usuario.setLogin(resultado.getString(4));
			usuario.setPass(resultado.getString(5));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Usuario por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	public ArrayList<UsuarioVo> consultarTodosUsuariosDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVo> usuariosVo = new ArrayList<UsuarioVo>();
		String query = "select * from usuario";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				UsuarioVo usuarioVo = new UsuarioVo();
				usuarioVo.setIdusuario(resultado.getInt(1));
				usuarioVo.setNome(resultado.getString(2));
				usuarioVo.setCpf(resultado.getString(3));
				usuarioVo.setLogin(resultado.getString(4));
				usuarioVo.setPass(resultado.getString(5));
				usuariosVo.add(usuarioVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Usuario");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuariosVo;
	}

}
