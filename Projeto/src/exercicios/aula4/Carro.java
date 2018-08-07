package exercicios.aula4;

public class Carro extends Veiculos{
	private double portamala;

	public Carro(int roda, String combustivel, double potencia, double portamala) {
		super(roda, combustivel, potencia);
		this.portamala = portamala;
	}

	public Carro(int roda, String combustivel, double potencia) {
		super(roda, combustivel, potencia);
	}

	public double getPortamala() {
		return portamala;
	}

	public void setPortamala(double portamala) {
		this.portamala = portamala;
	}
	
	public void passear() {
		System.out.println("Passeando");
	}
}
