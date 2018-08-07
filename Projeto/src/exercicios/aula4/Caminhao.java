package exercicios.aula4;

public class Caminhao extends Veiculos {
	private int eixos;

	public Caminhao(int roda, String combustivel, double potencia, int eixos) {
		super(roda, combustivel, potencia);
		this.eixos = eixos;
	}

	public Caminhao(int roda, String combustivel, double potencia) {
		super(roda, combustivel, potencia);
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
