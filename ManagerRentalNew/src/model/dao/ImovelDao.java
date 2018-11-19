package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.CidadeVo;
import model.vo.ImovelVo;

public class ImovelDao {
	
	public int cadastrarImovelDao(ImovelVo imovelVo) {
		int resultado = 0;

		String sql = " INSERT INTO imovel (idestado, idcidade, referencia, rua, numero) "
				+ " VALUES (?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, imovelVo.getIdestado());
			prepStmt.setInt(2, imovelVo.getIdcidade());
			prepStmt.setString(3, imovelVo.getReferencia());
			prepStmt.setString(4, imovelVo.getRua());
			prepStmt.setInt(5, imovelVo.getNumero());
			
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Imovel. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdImovel(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from imovel where idimovel = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Imovel por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarImovelDao(ImovelVo imovelVo) {
		int resultado = 0;
		String query = "update imovel set idestado = ?, idcidade = ?, referencia = ?, rua = ?, numero = ? where idimovel = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, imovelVo.getIdestado());
			prepStmt.setInt(2, imovelVo.getIdcidade());
			prepStmt.setString(3, imovelVo.getReferencia());
			prepStmt.setString(4, imovelVo.getRua());
			prepStmt.setInt(5, imovelVo.getNumero());
			prepStmt.setInt(6, imovelVo.getIdimovel());
						
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Imovel. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirImovelDao(ImovelVo imovelVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from imovel where idimovel = " + imovelVo.getIdimovel();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Imovel por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ImovelVo consultarImovelDao(ImovelVo imovelVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ImovelVo imovel = new ImovelVo();

		String query = "select * from imovel where idimovel = " + imovelVo.getIdimovel();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			imovel.setIdimovel(Integer.parseInt(resultado.getString(1)));
			imovel.setIdestado(Integer.parseInt(resultado.getString(2)));
			imovel.setIdcidade(Integer.parseInt(resultado.getString(3)));
			imovel.setReferencia(resultado.getString(4));
			imovel.setRua(resultado.getString(5));
			imovel.setNumero(Integer.parseInt(resultado.getString(6)));
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Imovel por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return imovel;
	}

	public ArrayList<ImovelVo> consultarTodosImovelsDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ImovelVo> imovelsVo = new ArrayList<ImovelVo>();
		String query = "select * from imovel";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ImovelVo imovelVo = new ImovelVo();
				imovelVo.setIdimovel(Integer.parseInt(resultado.getString(1)));
				imovelVo.setIdestado(Integer.parseInt(resultado.getString(2)));
				imovelVo.setIdcidade(Integer.parseInt(resultado.getString(3)));
				imovelVo.setReferencia(resultado.getString(4));
				imovelVo.setRua(resultado.getString(5));
				imovelVo.setNumero(Integer.parseInt(resultado.getString(6)));
				imovelsVo.add(imovelVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Imovel");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return imovelsVo;
	}
	

}
