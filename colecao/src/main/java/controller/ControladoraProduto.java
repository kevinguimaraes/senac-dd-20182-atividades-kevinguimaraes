package controller;

import java.util.ArrayList;

import model.bo.ProdutoBo;
import model.vo.ProdutoVo;

public class ControladoraProduto {
	public void cadastrarProdutoController(ProdutoVo produtoVo) {
		//ProdutoBo produtoBo = new ProdutoBo();
		ProdutoBo.cadastrarProdutoBo(produtoVo);
		
	}
		
	public void excluirProdutoController(ProdutoVo produtoVo) {
		//ProdutoBo produtoBo = new ProdutoBo();
		ProdutoBo.excluirProdutoBo(produtoVo);
	}
	
	public void atualizarProdutoController(ProdutoVo produtoVo) {
		//ProdutoBo produtoBo = new ProdutoBo();
		ProdutoBo.atualizarProdutoBo(produtoVo);
	}
	
	public ArrayList<ProdutoVo>  consultarTodosProdutoController() {
		ProdutoBo produtoBo = new ProdutoBo();
		return produtoBo.consultarProdutoBo();
	}
	
	public ProdutoVo  consultarProdutoController(ProdutoVo produtoVo) {
		ProdutoBo produtosBo = new ProdutoBo();
		return produtosBo.consultarProdutoBo(produtoVo);
	}
}
