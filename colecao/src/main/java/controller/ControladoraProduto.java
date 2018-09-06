package controller;

import java.util.ArrayList;

import model.bo.ProdutoBo;
import model.dao.ProdutoDao;
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
	
	public ArrayList<ProdutoVo>  consultarProdutoPorNomeController(ProdutoVo produtoVo) {
		ProdutoBo produtosBo = new ProdutoBo();
		return produtosBo.consultarProdutoPorNomeBo(produtoVo);
	}
	
	public ArrayList<ProdutoVo>  consultarProdutoPorMarcaController(ProdutoVo produtoVo) {
		ProdutoBo produtosBo = new ProdutoBo();
		return produtosBo.consultarProdutoPorMarcaBo(produtoVo);
	}
	
	public boolean existeResgistroPorIdProdutoController(int id) {
		ProdutoDao produtodDao = new ProdutoDao();
		return produtodDao.existeResgistroPorIdProduto(id);
	}
}
