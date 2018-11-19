package model.vo;

public class CaracteristicaVo {
	private int idcaracteristica;
	private String nome;
	
	public CaracteristicaVo(int idcaracteristica, String nome) {
		super();
		this.idcaracteristica = idcaracteristica;
		this.nome = nome;
	}

	public CaracteristicaVo() {
		super();
	}

	public int getIdcaracteristica() {
		return idcaracteristica;
	}

	public void setIdcaracteristica(int idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
