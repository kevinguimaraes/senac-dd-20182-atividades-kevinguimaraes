package model.vo;

import javax.swing.JOptionPane;

public class ImovelVo {
	private int idimovel;
	private int idestado;
	private int idcidade;
	private int idcaracteristica;
	private String referencia;
	private String rua;
	private int numero;
		
	public ImovelVo() {
		super();
	}

	public ImovelVo(int idimovel, int idestado, int idcidade, String referencia, String rua,
			int numero) {
		super();
		this.idimovel = idimovel;
		this.idestado = idestado;
		this.idcidade = idcidade;
		this.referencia = referencia;
		this.rua = rua;
		this.numero = numero;
	}
	
	public int getIdimovel() {
		return idimovel;
	}
	public void setIdimovel(int idimovel) {
		this.idimovel = idimovel;
	}
	public int getIdestado() {
		return idestado;
	}
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	public int getIdcidade() {
		return idcidade;
	}
	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void printImovel() {
		JOptionPane.showMessageDialog(null, "IdImovel: " + this.idimovel + "\n"
				+ "IdEstado: " + this.idestado + "\n"
				+ "IdCidade: " + this.idcidade + "\n"
				+ "idcaracteristica: " + this.idcaracteristica + "\n"
				+ "referencia: " + this.referencia + "\n"
				+ "rua: " + this.rua + "\n"
				+ "numero: " + this.numero
				);
	}
	

}
