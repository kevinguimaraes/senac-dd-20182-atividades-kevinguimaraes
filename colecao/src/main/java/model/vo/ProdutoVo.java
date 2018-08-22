package model.vo;

import javax.swing.JOptionPane;

public class ProdutoVo 
{
	private int idproduto;
	private String nome;
	private String marca;
	private double peso;
	private double preco;
	
	public ProdutoVo(String nome, String marca, double peso, double preco) 
	{
		super();
		this.nome = nome;
		this.marca = marca;
		this.peso = peso;
		this.preco = preco;
	}

	public ProdutoVo() 
	{
		super();
	}
	
	public int getIdproduto() {
		return idproduto;
	}

	public void setIdProduto(int idproduto) {
		this.idproduto = idproduto;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getMarca() 
	{
		return marca;
	}

	public void setMarca(String marca) 
	{
		this.marca = marca;
	}

	public double getPeso() 
	{
		return peso;
	}

	public void setPeso(double peso) 
	{
		this.peso = peso;
	}

	public double getPreco() 
	{
		return preco;
	}

	public void setPreco(double preco) 
	{
		this.preco = preco;
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "\nID: " + this.idproduto
				+ "\nNome: " + this.nome
				+ "\nMarca: " + this.marca
				+ "\nPeso: " + this.peso
				+ "\nPreco: " + this.preco);
	}
	
	

}
