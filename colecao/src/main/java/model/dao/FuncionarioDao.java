package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.FuncionarioVo;

public class FuncionarioDao {
	public boolean existeRegistroPorCpf(String cpf) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from funcionario where cpf like '" + cpf + "'";
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Funcionario por CPF");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int cadastrarFuncionarioDao(FuncionarioVo funcionarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO funcionario (nome, cpf, cargo) values ('" + funcionarioVo.getNome() + "', '" + funcionarioVo.getCpf() + "', '" + funcionarioVo.getCargo() + "')";
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de Cadastro");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return resultado;
	}

	public boolean existeResgistroPorIdfuncionario(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from funcionario where idfuncionario = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Funcionario por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarFuncionarioDao(FuncionarioVo funcionarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query =  "update funcionario set nome = '" + funcionarioVo.getNome() + "', cpf = '" + funcionarioVo.getCpf() + "', telefone = '" + funcionarioVo.getCargo() + "' where idfuncionario = " + funcionarioVo.getIdfuncionario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de atualização por Funcionario por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirFuncionarioDao(FuncionarioVo funcionarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from funcionario where idfuncionario = " + funcionarioVo.getIdfuncionario();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de Funcionario por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public FuncionarioVo consultarFuncionarioDao(FuncionarioVo funcionarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		FuncionarioVo funcionario = new FuncionarioVo();

		String query = "select * from funcionario where idfuncionario = " + funcionarioVo.getIdfuncionario();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			funcionario.setIdfuncionario(Integer.parseInt(resultado.getString(1)));
			funcionario.setNome(resultado.getString(2));
			funcionario.setCpf(resultado.getString(3));
			funcionario.setCargo(resultado.getString(4));
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Funcionario por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionario;
	}

	public ArrayList<FuncionarioVo> consultarTodosFuncionariosDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<FuncionarioVo> funcionariosVo = new ArrayList<FuncionarioVo>();
		String query = "select * from funcionario";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				FuncionarioVo funcionarioVo = new FuncionarioVo();
				funcionarioVo.setIdfuncionario(Integer.parseInt(resultado.getString(1)));
				funcionarioVo.setNome(resultado.getString(2));
				funcionarioVo.setCpf(resultado.getString(3));
				funcionarioVo.setCargo(resultado.getString(4));
				funcionariosVo.add(funcionarioVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Funcionario");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return funcionariosVo;
	}

}
