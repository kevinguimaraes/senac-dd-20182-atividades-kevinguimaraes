package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.CaracImovelVo;

public class CaracImovelDao {
	
	public int cadastrarCaracImovelDao(CaracImovelVo caracImovelVo) {
		int resultado = 0;

		String sql = " INSERT INTO carac_imovel (idimovel, idcaracteristica,  valor) "
				+ " VALUES (?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, caracImovelVo.getIdimovel());
			prepStmt.setInt(2, caracImovelVo.getIdcaracteristica());
			prepStmt.setInt(3, caracImovelVo.getValor());
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir CaracImovel. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}


	public int atualizarCaracImovelDao(CaracImovelVo caracImovelVo) {
		int resultado = 0;
		String query = "update carac_imovel set valor = ? where idimovel = ? and idcaracteristica = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, caracImovelVo.getValor());
			prepStmt.setInt(2, caracImovelVo.getIdimovel());
			prepStmt.setInt(3, caracImovelVo.getIdcaracteristica());
			
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar CaracImovel. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public boolean existeResgistroPorIdCaracImovel(int id, int id2) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from carac_imovel idimovel = " + id + " and idcaracteristica = " + id2;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de CaracImovel por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}
	
	public int excluirCaracImovelDao(CaracImovelVo caracImovelVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from carac_imovel where idimovel = " + caracImovelVo.getIdimovel() + " and idcliente = " + caracImovelVo.getIdcaracteristica();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de CaracImovel por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public CaracImovelVo consultarCaracImovelDao(CaracImovelVo caracImovelVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		CaracImovelVo caracImovel = new CaracImovelVo();

		String query = "select * from carac_imovel where idimovel = " + caracImovelVo.getIdimovel() + " and idcliente = " + caracImovelVo.getIdcaracteristica();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			caracImovel.setIdimovel(resultado.getInt(1));
			caracImovel.setIdcaracteristica(resultado.getInt(2));
			caracImovel.setValor(resultado.getInt(3));
			
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de CaracImovel por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return caracImovel;
	}

	public ArrayList<CaracImovelVo> consultarTodosCaracImovelsDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<CaracImovelVo> caracImovelsVo = new ArrayList<CaracImovelVo>();
		String query = "select * from caracImovel";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				CaracImovelVo caracImovelVo = new CaracImovelVo();
				caracImovelVo.setIdimovel(resultado.getInt(1));
				caracImovelVo.setIdcaracteristica(resultado.getInt(2));
				caracImovelVo.setValor(resultado.getInt(3));
				caracImovelsVo.add(caracImovelVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os CaracImovel");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return caracImovelsVo;
	}
	
}
