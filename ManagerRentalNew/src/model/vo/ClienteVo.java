package model.vo;

public class ClienteVo {
	
	private int idCliente;
	private int idEstado;
	private int idCidade;
	private String nome;
	private String cpf;
	private String rua;
	private int numero;
	private String telefone;
	private String celular;
	
	
	public ClienteVo() {
		super();
	}

	

	public ClienteVo(int idCliente, int idEstado, int idCidade, String nome, String cpf, String rua, int numero,
			String telefone, String celular) {
		super();
		this.idCliente = idCliente;
		this.idEstado = idEstado;
		this.idCidade = idCidade;
		this.nome = nome;
		this.cpf = cpf;
		this.rua = rua;
		this.numero = numero;
		this.telefone = telefone;
		this.celular = celular;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}



	public int getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}



	public int getIdEstado() {
		return idEstado;
	}



	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}



	public int getIdCidade() {
		return idCidade;
	}



	public void setIdCidade(int idCidade) {
		this.idCidade = idCidade;
	}
	
	public void printCliente() {
		System.out.println("--- Print Cliente ---");
		System.out.println("idCliente: "+this.idCliente);
		System.out.println("idEstado: "+this.idEstado);
		System.out.println("idCidade: "+this.idCidade);
		System.out.println("nome: "+this.nome);
		System.out.println("cpf: "+this.cpf);
		System.out.println("rua: "+this.rua);
		System.out.println("numero: "+this.numero);
		System.out.println("telefone: "+this.telefone);
		System.out.println("celular: "+this.celular);
		System.out.println("---- FIM ----");
	}
	
	

}
