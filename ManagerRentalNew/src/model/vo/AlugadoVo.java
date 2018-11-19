package model.vo;

import java.sql.Date;

import javax.swing.JOptionPane;

public class AlugadoVo {
	private int idimovel;
	private int idcliente;
	private Date dt_inicio;
	private Date dt_final;
	private double valor;
	private String ref;
	

	public AlugadoVo(int idimovel, int idcliente, Date dt_inicio, Date dt_final, double valor) {
		super();
		this.idimovel = idimovel;
		this.idcliente = idcliente;
		this.dt_inicio = dt_inicio;
		this.dt_final = dt_final;
		this.valor = valor;
	}

	public AlugadoVo() {
		super();
	}
	
	
	
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public int getIdimovel() {
		return idimovel;
	}

	public void setIdimovel(int idimovel) {
		this.idimovel = idimovel;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public Date getDt_inicio() {
		return dt_inicio;
	}

	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}

	public Date getDt_final() {
		return dt_final;
	}

	public void setDt_final(Date dt_final) {
		this.dt_final = dt_final;
	}
	
	
	public void printAlugado() {
		JOptionPane.showMessageDialog(null, "IdImovel: " + this.idimovel + "\n"
				+ "idcliente: " + this.idcliente + "\n"
				+ "dt_inicio: " + this.dt_inicio + "\n"
				+ "dt_final: " + this.dt_final + "\n"
				);
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}
