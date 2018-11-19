package model.vo;

public class CaracImovelVo {
	private int idimovel;
	private int idcaracteristica;
	private int valor;
	
	public CaracImovelVo(int idimovel, int idcaracteristica, int valor) {
		super();
		this.idimovel = idimovel;
		this.idcaracteristica = idcaracteristica;
		this.valor = valor;
	}

	public CaracImovelVo() {
		super();
	}

	public int getIdimovel() {
		return idimovel;
	}

	public void setIdimovel(int idimovel) {
		this.idimovel = idimovel;
	}

	public int getIdcaracteristica() {
		return idcaracteristica;
	}

	public void setIdcaracteristica(int idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	

}
