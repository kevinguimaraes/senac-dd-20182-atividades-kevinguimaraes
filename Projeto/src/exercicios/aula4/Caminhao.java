package exercicios.aula4;

public class Caminhao extends Veiculos {
	private int eixos;
	private Carroceria carroceria; 

	public Caminhao(int roda, String combustivel, double potencia, double tanque, String marca, String modelo, int eixos, Carroceria carroceria) {
		super(roda, combustivel, potencia, tanque, marca, modelo);
		this.eixos = eixos;
		this.carroceria = carroceria;
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	
	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}

	
	public void carregar() {
		System.out.println("Carregando");
	}
	
	public void descarregar(){
		System.out.println("Descarregando");
	}
}
