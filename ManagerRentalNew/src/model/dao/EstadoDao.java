package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ControllerEstado;
import model.Banco;
import model.vo.EstadoVo;

public class EstadoDao {
	
	public int cadastrarEstadoDao(EstadoVo estadoVo) {
		int resultado = 0;

		String sql = " INSERT INTO estado (nome) "
				+ " VALUES (?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, estadoVo.getNome());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Estado. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdEstado(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from estado where idestado = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Estado por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarEstadoDao(EstadoVo estadoVo) {
		int resultado = 0;
		String query = " update estado set nome = ? where idestado = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, estadoVo.getNome());
			prepStmt.setInt(2, estadoVo.getIdestado());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Estado. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirEstadoDao(EstadoVo estadoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from estado where idestado = " + estadoVo.getIdestado();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Estado por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public EstadoVo consultarEstadoDao(EstadoVo estadoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		EstadoVo estado = new EstadoVo();

		String query = "select * from estado where idestado = " + estadoVo.getIdestado();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			estado.setIdestado(resultado.getInt(1));
			estado.setNome(resultado.getString(2));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Estado por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return estado;
	}

	public ArrayList<EstadoVo> consultarTodosEstadosDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<EstadoVo> estadosVo = new ArrayList<EstadoVo>();
		String query = "select * from estado";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				EstadoVo estadoVo = new EstadoVo();
				estadoVo.setIdestado(resultado.getInt(1));
				estadoVo.setNome(resultado.getString(2));
				estadosVo.add(estadoVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Estado");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return estadosVo;
	}
	
	public String[] getEstadosDao() {
		ArrayList<String> estados = new ArrayList<>();
		ArrayList<EstadoVo> ae = new ArrayList<>();
		ae = this.consultarTodosEstadosDao();
		for (int i = 0; i < ae.size(); i++) {
			estados.add(ae.get(i).getNome());
		}
		
		return estados.toArray(new String[0]);
	}

}
