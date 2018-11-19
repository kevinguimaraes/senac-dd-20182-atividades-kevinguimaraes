package model.vo;

public class EstadoVo {
	private int idestado;
	private String nome;
	
	public EstadoVo(int idestado, String nome) {
		super();
		this.idestado = idestado;
		this.nome = nome;
	}

	public EstadoVo() {
		super();
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
