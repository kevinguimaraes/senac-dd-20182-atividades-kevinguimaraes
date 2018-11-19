package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Banco;
import model.vo.AlugadoVo;

public class AlugadoDao {
	
	public int cadastrarAlugadoDao(AlugadoVo alugadoVo) {
		int resultado = 0;

		String sql = " INSERT INTO alugado (idimovel, idcliente, dt_inicio, dt_final, valor) "
				+ " VALUES (?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {			
			prepStmt.setInt(1, alugadoVo.getIdimovel());
			prepStmt.setInt(2, alugadoVo.getIdcliente());
			prepStmt.setDate(3, alugadoVo.getDt_inicio());
			prepStmt.setDate(4, alugadoVo.getDt_final());
			prepStmt.setDouble(5, alugadoVo.getValor());
			
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Alugado. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}


	public int atualizarAlugadoDao(AlugadoVo alugadoVo) {
		int resultado = 0;
		String query = "update alugado set dt_inicio = ?, dt_final = ? where idimovel = ? and idcliente = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setDate(1, alugadoVo.getDt_inicio());
			prepStmt.setDate(2, alugadoVo.getDt_final());
			prepStmt.setInt(3, alugadoVo.getIdimovel());
			prepStmt.setInt(4, alugadoVo.getIdcliente());
			prepStmt.setDouble(5, alugadoVo.getValor());
			
			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Alugado. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public boolean existeResgistroPorIdAlugado(int id, int id2) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from alugado idimovel = " + id + " and idcliente = " + id2;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Alugado por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}
	
	public int excluirAlugadoDao(AlugadoVo alugadoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from alugado where idimovel = " + alugadoVo.getIdimovel() + " and idcliente = " + alugadoVo.getIdcliente();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Alugado por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public AlugadoVo consultarAlugadoDao(AlugadoVo alugadoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		AlugadoVo alugado = new AlugadoVo();

		String query = "select * from alugado where idimovel = " + alugadoVo.getIdimovel() + " and idcliente = " + alugadoVo.getIdcliente();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			alugado.setIdimovel(Integer.parseInt(resultado.getString(1)));
			alugado.setIdcliente(Integer.parseInt(resultado.getString(2)));
			alugado.setDt_inicio(resultado.getDate(3));
			alugado.setDt_final(resultado.getDate(4));
			alugado.setValor(resultado.getDouble(5));
			
			
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Alugado por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return alugado;
	}

	public ArrayList<AlugadoVo> consultarTodosAlugadosDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AlugadoVo> alugadosVo = new ArrayList<AlugadoVo>();
		String query = "select * from alugado";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				AlugadoVo alugadoVo = new AlugadoVo();
				alugadoVo.setIdimovel(Integer.parseInt(resultado.getString(2)));
				alugadoVo.setIdcliente(Integer.parseInt(resultado.getString(3)));
				alugadoVo.setDt_inicio(resultado.getDate(4));
				alugadoVo.setDt_final(resultado.getDate(5));
				alugadoVo.setValor(resultado.getDouble(6));
				alugadosVo.add(alugadoVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Alugado");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return alugadosVo;
	}
	
	public ArrayList<AlugadoVo> consultarTodosAlugadosPorClienteDao(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AlugadoVo> alugadosVo = new ArrayList<AlugadoVo>();
		Date date = new Date(System.currentTimeMillis());
		
		String query = "select i.referencia, a.dt_inicio, a.dt_final, a.valor from alugado as a inner join imovel as i on a.idimovel = i.idimovel where (idcliente = "+ id +") and dt_inicio between '" + date + "' and " + "DATE_ADD('" + date + "', interval 3 month)";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				AlugadoVo alugadoVo = new AlugadoVo();
				alugadoVo.setRef(resultado.getString(1));
				alugadoVo.setDt_inicio(resultado.getDate(2));
				alugadoVo.setDt_final(resultado.getDate(3));
				alugadoVo.setValor(resultado.getDouble(4));
				alugadosVo.add(alugadoVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Alugado");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return alugadosVo;
	}
	
	public ArrayList<AlugadoVo> consultarTodosAlugadosPerIdAndDate(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<AlugadoVo> alugadosVo = new ArrayList<AlugadoVo>();
		Date date = new Date(System.currentTimeMillis());
		
		String query = "select * from alugado where (idimovel = "+ id +") and dt_inicio between '" + date + "' and " + "DATE_ADD('" + date + "', interval 3 month)";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				AlugadoVo alugadoVo = new AlugadoVo();
				alugadoVo.setIdimovel(Integer.parseInt(resultado.getString(2)));
				alugadoVo.setIdcliente(Integer.parseInt(resultado.getString(3)));
				alugadoVo.setDt_inicio(resultado.getDate(4));
				alugadoVo.setDt_final(resultado.getDate(5));
				alugadoVo.setValor(resultado.getDouble(6));
				alugadosVo.add(alugadoVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Alugado");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}

		return alugadosVo;
	}

}
