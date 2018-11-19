package model.vo;

public class UsuarioVo {
	
	private int idusuario;
	private String nome;
	private String cpf;
	private String login;
	private String pass;
	
	public UsuarioVo(int idusuario, String nome, String cpf, String login, String pass) {
		super();
		this.idusuario = idusuario;
		this.nome = nome;
		this.cpf = cpf;
		this.login = login;
		this.pass = pass;
	}

	public UsuarioVo() {
		super();
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
