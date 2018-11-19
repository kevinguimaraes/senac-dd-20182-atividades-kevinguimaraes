package model.vo;

public class CidadeVo {
	private int idcidade;
	private int idestado;
	private String nome;
	
	public CidadeVo(int idcidade, int idestado, String nome) {
		super();
		this.idcidade = idcidade;
		this.nome = nome;
	}

	public CidadeVo() {
		super();
	}

	
	public int getIdcidade() {
		return idcidade;
	}

	public void setIdcidade(int idcidade) {
		this.idcidade = idcidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdestado() {
		return idestado;
	}

	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
	
	

}
