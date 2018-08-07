package exercicios.aula4;

public class Moto extends Veiculos { 
	
	public Moto(int roda, String combustivel, double potencia, double tanque, String marca, String modelo) {
		super(roda, combustivel, potencia, tanque, marca, modelo);
	}
	
	public void empinar() {
		System.out.println("Empinando");
	}
}
