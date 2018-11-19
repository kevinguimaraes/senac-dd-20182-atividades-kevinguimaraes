package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Banco;
import model.vo.ClienteVo;

public class ClienteDao {
	
	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from cliente where cpf like '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Cliente por CPF");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarClienteDao(ClienteVo clienteVo) {
		int resultado = 0;

		String sql = " INSERT INTO cliente (idestado, idcidade, nome, cpf, rua, numero, telefone, celular) "
				+ " VALUES (?,?,?,?,?,?,?,?) ";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, sql, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, clienteVo.getIdEstado());
			prepStmt.setInt(2, clienteVo.getIdCidade());
			prepStmt.setString(3, clienteVo.getNome());
			prepStmt.setString(4, clienteVo.getCpf());
			prepStmt.setString(5, clienteVo.getRua());
			prepStmt.setInt(6, clienteVo.getNumero());
			prepStmt.setString(7, clienteVo.getTelefone());
			prepStmt.setString(8, clienteVo.getCelular());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cliente. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdCliente(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from cliente where idcliente = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Cliente por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarClienteDao(ClienteVo clienteVo) {
		int resultado = 0;
		String query = " update cliente set idestado = ?, idcidade = ?, nome = ?, cpf = ?, rua = ?, numero = ?, telefone = ?, celular = ? where idcliente = ?";

		Connection conexao = Banco.getConnection();
		PreparedStatement prepStmt = Banco.getPreparedStatement(conexao, query, 
				java.sql.Statement.RETURN_GENERATED_KEYS);

		try {
			prepStmt.setInt(1, clienteVo.getIdEstado());
			prepStmt.setInt(2, clienteVo.getIdCidade());
			prepStmt.setString(3, clienteVo.getNome());
			prepStmt.setString(4, clienteVo.getCpf());
			prepStmt.setString(5, clienteVo.getRua());
			prepStmt.setInt(6, clienteVo.getNumero());
			prepStmt.setString(7, clienteVo.getTelefone());
			prepStmt.setString(8, clienteVo.getCelular());
			prepStmt.setInt(9, clienteVo.getIdCliente());

			prepStmt.execute();

			ResultSet generatedKeys = prepStmt.getGeneratedKeys();
			if (generatedKeys.next()) {
				resultado = generatedKeys.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Cliente. Causa: \n:" + e.getCause());
		} finally{
			Banco.closePreparedStatement(prepStmt);
			Banco.closeConnection(conexao);
		}
		return resultado;
	}

	public int excluirClienteDao(ClienteVo clienteVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from cliente where idcliente = " + clienteVo.getIdCliente();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Cliente por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ClienteVo consultarClienteDao(ClienteVo clienteVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVo cliente = new ClienteVo();

		String query = "select * from cliente where idcliente = " + clienteVo.getIdCliente();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
			cliente.setIdCidade(Integer.parseInt(resultado.getString(2)));
			cliente.setIdEstado(Integer.parseInt(resultado.getString(3)));
			cliente.setNome(resultado.getString(4));
			cliente.setCpf(resultado.getString(5));
			cliente.setRua(resultado.getString(6));
			cliente.setNumero(Integer.parseInt(resultado.getString(7)));
			cliente.setTelefone(resultado.getString(8));
			cliente.setCelular(resultado.getString(9));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Cliente por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cliente;
	}

	public ArrayList<ClienteVo> consultarTodosClientesDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ClienteVo> clientesVo = new ArrayList<ClienteVo>();
		String query = "select * from cliente";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ClienteVo clienteVo = new ClienteVo();
				clienteVo.setIdCliente(Integer.parseInt(resultado.getString(1)));
				clienteVo.setIdCidade(Integer.parseInt(resultado.getString(2)));
				clienteVo.setIdEstado(Integer.parseInt(resultado.getString(3)));
				clienteVo.setNome(resultado.getString(4));
				clienteVo.setCpf(resultado.getString(5));
				clienteVo.setRua(resultado.getString(6));
				clienteVo.setNumero(Integer.parseInt(resultado.getString(7)));
				clienteVo.setTelefone(resultado.getString(8));
				clienteVo.setCelular(resultado.getString(9));
				clientesVo.add(clienteVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Cliente");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return clientesVo;
	}
	
	public ClienteVo ConsultaClientePorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ClienteVo cliente = new ClienteVo();
		String query = "select * from cliente where cpf like '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			cliente.setIdCliente(Integer.parseInt(resultado.getString(1)));
			cliente.setIdCidade(Integer.parseInt(resultado.getString(2)));
			cliente.setIdEstado(Integer.parseInt(resultado.getString(3)));
			cliente.setNome(resultado.getString(4));
			cliente.setCpf(resultado.getString(5));
			cliente.setRua(resultado.getString(6));
			cliente.setNumero(Integer.parseInt(resultado.getString(7)));
			cliente.setTelefone(resultado.getString(8));
			cliente.setCelular(resultado.getString(9));
			
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Cliente por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return cliente;
	}


}
