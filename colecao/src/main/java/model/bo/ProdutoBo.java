package model.bo;

import java.util.ArrayList;

import model.dao.ProdutoDao;
import model.vo.ProdutoVo;

public class ProdutoBo {
	
	public static void cadastrarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao artefatoDao = new ProdutoDao();
		
		int resultado = artefatoDao.cadastrarProdutoDao(produtoVo);
		if(resultado == 1)
			System.out.println("\nProduto Cadastrado com Sucesso");
		else
			System.out.println("\nNão foi possivel cadastrar Produto");
		
	}

	public static void atualizarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao artefatoDao = new ProdutoDao();
		if(artefatoDao.existeResgistroPorIdproduto(produtoVo.getIdproduto())) {
			int resultado = artefatoDao.atualizarProdutoDao(produtoVo);
			if(resultado == 1)
				System.out.println("\nProduto atualizado com Sucesso");
			else
				System.out.println("\nNão foi possivel atualizar Produto");
		}
	}

	public static void excluirProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao artefatoDao = new ProdutoDao();
		if(artefatoDao.existeResgistroPorIdproduto(produtoVo.getIdproduto())) {
			int resultado = artefatoDao.excluirProdutoDao(produtoVo);
			if(resultado == 1)
				System.out.println("\nProduto excluir com Sucesso");
			else
				System.out.println("\nNão foi possivel excluir Produto");
		}
	}

	public ArrayList<ProdutoVo> consultarProdutoBo() {
		ProdutoDao artefatoDao = new ProdutoDao();
		ArrayList<ProdutoVo> artefatoesVo = artefatoDao.consultarTodosProdutoDao();
		if(artefatoesVo.isEmpty())
			System.out.println("\nNão foram localizados artefato na base de daos");
		return artefatoesVo;
	}

	public ProdutoVo consultarProdutoBo(ProdutoVo produtoVo) {
		ProdutoDao artefatoDao = new ProdutoDao();
		ProdutoVo artefato = artefatoDao.consultarProdutoDao(produtoVo);
		if(artefato == null)
			System.out.println("\nProduto não localizado na base de dados");
		return artefato;
	}

}
