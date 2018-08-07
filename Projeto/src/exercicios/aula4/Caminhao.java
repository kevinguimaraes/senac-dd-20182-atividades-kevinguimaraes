package exercicios.aula4;

public class Caminhao extends Veiculos {
	private int eixos;

	public Caminhao(int roda, String combustivel, double potencia, double tanque, String marca, String modelo,
			int eixos) {
		super(roda, combustivel, potencia, tanque, marca, modelo);
		this.eixos = eixos;
	}

	public int getEixos() {
		return eixos;
	}

	public void setEixos(int eixos) {
		this.eixos = eixos;
	}
	
	public void carregar() {
		System.out.println("Carregando");
	}
	
	public void descarregar(){
		System.out.println("Descarregando");
	}
	

}
