package exercicios.aula4;

public class Moto extends Veiculos {
	
	public Moto(int roda, String combustivel, double potencia) {
		super(roda, combustivel, potencia);
	}
	
	public Moto() {
		
	}
	
	public void empinar() {
		System.out.println("Empinando");
	}
}
