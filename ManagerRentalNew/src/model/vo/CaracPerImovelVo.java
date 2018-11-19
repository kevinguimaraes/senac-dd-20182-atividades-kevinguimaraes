package model.vo;

public class CaracPerImovelVo {
	private String caracteristica;
	private int valor;
		
	public CaracPerImovelVo() {
		super();
	}
	public CaracPerImovelVo(String caracteristica, int valor) {
		super();
		this.caracteristica = caracteristica;
		this.valor = valor;
	}
	public String getCaracteristica() {
		return caracteristica;
	}
	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
