package model.vo;

public class Aluno {

	private int id;
	private String nome;
	private String sobrenome;
	private String matricula;
	private double notaProva1;
	private double notaProva2;
	private double peson;
	private double trab1;
	private double trab2;
	private double pesot;
	private String nivel;
	
	
	
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public double getPeson() {
		return peson;
	}
	public void setPeson(double peson) {
		this.peson = peson;
	}
	public double getTrab1() {
		return trab1;
	}
	public void setTrab1(double trab1) {
		this.trab1 = trab1;
	}
	public double getTrab2() {
		return trab2;
	}
	public void setTrab2(double trab2) {
		this.trab2 = trab2;
	}
	public double getPesot() {
		return pesot;
	}
	public void setPesot(double pesot) {
		this.pesot = pesot;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public double getNotaProva1() {
		return notaProva1;
	}
	public void setNotaProva1(double notaProva1) {
		this.notaProva1 = notaProva1;
	}
	public double getNotaProva2() {
		return notaProva2;
	}
	public void setNotaProva2(double notaProva2) {
		this.notaProva2 = notaProva2;
	}
}