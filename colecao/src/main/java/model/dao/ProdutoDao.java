package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.ProdutoVo;

public class ProdutoDao {
	
	public int cadastrarProdutoDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO produto (nome, marca, peso, preco) values ('" + produtoVo.getNome() + "', '" + produtoVo.getMarca() + "', '" + produtoVo.getPeso() + "', '" + produtoVo.getPreco() + "')";
		
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

	public boolean existeResgistroPorIdProduto(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "select * from produto where idproduto = " + id ;
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next())
				return true;
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query que verifica existencia de Produto por ID");
			return false;
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return false;
	}

	public int atualizarProdutoDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query =  "update produto set nome = '" + produtoVo.getNome() + "', marca = '" + produtoVo.getMarca() + "', peso = '" + produtoVo.getPeso() + "' where idproduto = " + produtoVo.getIdproduto();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de atualização por produto por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public int excluirProdutoDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "delete from produto where idproduto = " + produtoVo.getIdproduto();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de exclusão de produto por ID");
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

	public ProdutoVo consultarProdutoDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ProdutoVo produto = new ProdutoVo();
		String query = "select * from produto where idproduto = " + produtoVo.getIdproduto();
		
		try {
			resultado = stmt.executeQuery(query);
			resultado.next();
			produto.setIdProduto(Integer.parseInt(resultado.getString(1)));
			produto.setNome(resultado.getString(2));
			produto.setMarca(resultado.getString(3));
			produto.setPeso(Double.parseDouble(resultado.getString(4)));
			produto.setPreco(Double.parseDouble(resultado.getString(5)));
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Colecionador por ID");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return produto;
	}
	
	public ArrayList<ProdutoVo> consultarProdutoPorNomeDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ProdutoVo> produtosVo = new ArrayList<ProdutoVo>();
		String query = "select * from produto where nome like '" + produtoVo.getNome() + "%'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ProdutoVo produto = new ProdutoVo();
				produto.setIdProduto(Integer.parseInt(resultado.getString(1)));
				produto.setNome(resultado.getString(2));
				produto.setMarca(resultado.getString(3));
				produto.setPeso(Double.parseDouble(resultado.getString(4)));
				produto.setPreco(Double.parseDouble(resultado.getString(5)));
				produtosVo.add(produto);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Artefatos");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return produtosVo;
	}
	
	public ArrayList<ProdutoVo> consultarProdutoPorMarcaDao(ProdutoVo produtoVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ProdutoVo> produtosVo = new ArrayList<ProdutoVo>();
		String query = "select * from produto where marca like '" + produtoVo.getMarca() + "%'";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ProdutoVo produto = new ProdutoVo();
				produto.setIdProduto(Integer.parseInt(resultado.getString(1)));
				produto.setNome(resultado.getString(2));
				produto.setMarca(resultado.getString(3));
				produto.setPeso(Double.parseDouble(resultado.getString(4)));
				produto.setPreco(Double.parseDouble(resultado.getString(5)));
				produtosVo.add(produto);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Artefatos");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return produtosVo;
	}

	public ArrayList<ProdutoVo> consultarTodosProdutoDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ProdutoVo> produtosVo = new ArrayList<ProdutoVo>();
		String query = "select * from produto";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				ProdutoVo produtoVo = new ProdutoVo();
				produtoVo.setIdProduto(Integer.parseInt(resultado.getString(1)));
				produtoVo.setNome(resultado.getString(2));
				produtoVo.setMarca(resultado.getString(3));
				produtoVo.setPeso(Double.parseDouble(resultado.getString(4)));
				produtoVo.setPreco(Double.parseDouble(resultado.getString(5)));
				produtosVo.add(produtoVo);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a Query de Consulta de Todos os Artefatos");
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return produtosVo;
	}
}
