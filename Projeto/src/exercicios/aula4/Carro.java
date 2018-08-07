package exercicios.aula4;

public class Carro extends Veiculos{
	private double portamala;

	public Carro(int roda, String combustivel, double potencia, double tanque, String marca, String modelo,
			double portamala) {
		super(roda, combustivel, potencia, tanque, marca, modelo);
		this.portamala = portamala;
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
