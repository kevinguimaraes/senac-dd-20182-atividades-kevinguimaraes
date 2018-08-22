package model.bo;

import java.util.ArrayList;

import model.dao.ProdutoDao;
import model.vo.ProdutoVo;

public class ProdutoBo {
	
	public static void cadastrarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao produtoDao = new ProdutoDao();
		
		int resultado = produtoDao.cadastrarProdutoDao(produtoVo);
		if(resultado == 1)
			System.out.println("\nProduto Cadastrado com Sucesso");
		else
			System.out.println("\nNão foi possivel cadastrar Produto");
		
	}

	public static void atualizarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao produtoDao = new ProdutoDao();
		if(produtoDao.existeResgistroPorIdProduto(produtoVo.getIdproduto())) {
			int resultado = produtoDao.atualizarProdutoDao(produtoVo);
			if(resultado == 1)
				System.out.println("\nProduto atualizado com Sucesso");
			else
				System.out.println("\nNão foi possivel atualizar Produto");
		}
	}

	public static void excluirProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao produtoDao = new ProdutoDao();
		if(produtoDao.existeResgistroPorIdProduto(produtoVo.getIdproduto())) {
			int resultado = produtoDao.excluirProdutoDao(produtoVo);
			if(resultado == 1)
				System.out.println("\nProduto excluir com Sucesso");
			else
				System.out.println("\nNão foi possivel excluir Produto");
		}
	}

	public ArrayList<ProdutoVo> consultarProdutoBo() {
		ProdutoDao produtoDao = new ProdutoDao();
		ArrayList<ProdutoVo> produtoesVo = produtoDao.consultarTodosProdutoDao();
		if(produtoesVo.isEmpty())
			System.out.println("\nNão foram localizados produto na base de daos");
		return produtoesVo;
	}

	public ProdutoVo consultarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao produtoDao = new ProdutoDao();
		ProdutoVo produto = produtoDao.consultarProdutoDao(produtoVo);
		if(produto == null)
			System.out.println("\nProduto não localizado na base de dados");
		return produto;
	}

}
