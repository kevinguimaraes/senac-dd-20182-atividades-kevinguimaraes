package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.CaracteristicaVo;

public class CaracteristicaDao {
	
	public int cadastrarCaracteristicaDao(CaracteristicaVo caracteristicaVo) {
		int resultado = 0;

		String sql = " INSERT INTO caracteristica (nome) "
				+ " VALUES (?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, caracteristicaVo.getNome());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Caracteristica. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdCaracteristica(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from caracteristica where idcaracteristica = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Caracteristica por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarCaracteristicaDao(CaracteristicaVo caracteristicaVo) {
		int resultado = 0;
		String query = " update caracteristica set nome = ? where idcaracteristica = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setString(1, caracteristicaVo.getNome());
			prepStmt.setInt(2, caracteristicaVo.getIdcaracteristica());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Caracteristica. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirCaracteristicaDao(CaracteristicaVo caracteristicaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from caracteristica where idcaracteristica = " + caracteristicaVo.getIdcaracteristica();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Caracteristica por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public CaracteristicaVo consultarCaracteristicaDao(CaracteristicaVo caracteristicaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		CaracteristicaVo caracteristica = new CaracteristicaVo();

		String query = "select * from caracteristica where idcaracteristica = " + caracteristicaVo.getIdcaracteristica();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			caracteristica.setIdcaracteristica(resultado.getInt(1));
			caracteristica.setNome(resultado.getString(2));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Caracteristica por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return caracteristica;
	}

	public String[] consultarTodosCaracteristicasDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<String> caracteristicasVo = new ArrayList<String>();
		String query = "select nome from caracteristica";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CaracteristicaVo caracteristicaVo = new CaracteristicaVo();
				caracteristicaVo.setNome(resultado.getString(1));
				caracteristicasVo.add(caracteristicaVo.getNome());
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Caracteristica");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return caracteristicasVo.toArray(new String[0]);
	}

}
