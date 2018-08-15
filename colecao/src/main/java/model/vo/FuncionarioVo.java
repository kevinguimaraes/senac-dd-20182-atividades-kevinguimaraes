package model.vo;

import javax.swing.JOptionPane;

public class FuncionarioVo {
	private int idfuncionario;
	private String nome;
	private String cpf;
	private String cargo;
	
	public FuncionarioVo(String nome, String cpf, String cargo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cargo = cargo;
	}

	public FuncionarioVo() {
		super();
	}
	
	public int getIdfuncionario() {
		return idfuncionario;
	}

	public void setIdfuncionario(int idfuncionario) {
		this.idfuncionario = idfuncionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public void imprimir() {
		JOptionPane.showMessageDialog(null, "\nID: " + this.idfuncionario
				+ "\nNome: " + this.nome
				+ "\nCPF: " + this.cpf
				+ "\nCargo: " + this.cargo);
	}
	

}
