package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.ControllerCidade;
import model.Banco;
import model.vo.CidadeVo;

public class CidadeDao {
	
	public int cadastrarCidadeDao(CidadeVo cidadeVo) {
		int resultado = 0;

		String sql = " INSERT INTO cidade (idestado, nome) "
				+ " VALUES (?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, cidadeVo.getIdestado());
			prepStmt.setString(2, cidadeVo.getNome());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cidade. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdCidade(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from cidade where idcidade = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Cidade por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarCidadeDao(CidadeVo cidadeVo) {
		int resultado = 0;
		String query = " update cidade set idestado = ?, nome = ? where idcidade = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, cidadeVo.getIdestado());
			prepStmt.setString(2, cidadeVo.getNome());
			prepStmt.setInt(3, cidadeVo.getIdcidade());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cidade. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirCidadeDao(CidadeVo cidadeVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from cidade where idcidade = " + cidadeVo.getIdcidade();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Cidade por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public CidadeVo consultarCidadeDao(CidadeVo cidadeVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		CidadeVo cidade = new CidadeVo();

		String query = "select * from cidade where idcidade = " + cidadeVo.getIdcidade();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			cidade.setIdcidade(resultado.getInt(1));
			cidade.setIdestado(resultado.getInt(2));
			cidade.setNome(resultado.getString(3));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Cidade por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cidade;
	}

	public ArrayList<CidadeVo> consultarTodosCidadesDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<CidadeVo> cidadesVo = new ArrayList<CidadeVo>();
		String query = "select * from cidade";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CidadeVo cidadeVo = new CidadeVo();
				cidadeVo.setIdcidade(resultado.getInt(1));
				cidadeVo.setIdestado(resultado.getInt(2));
				cidadeVo.setNome(resultado.getString(3));
				cidadesVo.add(cidadeVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Cidade");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cidadesVo;
	}
	
	public ArrayList<CidadeVo> consultarTodosCidadesByEstadoDao(int idestado) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<CidadeVo> cidadesVo = new ArrayList<CidadeVo>();
		String query = "select * from cidade where idestado = " + idestado;
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CidadeVo cidadeVo = new CidadeVo();
				cidadeVo.setIdcidade(resultado.getInt(1));
				cidadeVo.setIdestado(resultado.getInt(2));
				cidadeVo.setNome(resultado.getString(3));
				cidadesVo.add(cidadeVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Cidade");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cidadesVo;
	}
	
	public String[] getCidadesDao(int estado) {
		ArrayList<String> estados = new ArrayList<>();
		ArrayList<CidadeVo> ae = new ArrayList<>();
		ae = this.consultarTodosCidadesByEstadoDao(estado);
		for (int i = 0; i < ae.size(); i++) {
			estados.add(ae.get(i).getNome());
		}
		
		return estados.toArray(new String[0]);
	}

}
