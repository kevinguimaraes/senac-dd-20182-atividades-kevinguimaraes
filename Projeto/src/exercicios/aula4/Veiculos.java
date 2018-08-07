package exercicios.aula4;

public class Veiculos {
	private int roda;
	private String combustivel;
	private double potencia;
	private double tanque;
	
	public Veiculos(int roda, String combustivel, double potencia) {
		super();
		this.roda = roda;
		this.combustivel = combustivel;
		this.potencia = potencia;
	}

	public Veiculos() {
		super();
	}

	public int getRoda() {
		return roda;
	}

	public void setRoda(int roda) {
		this.roda = roda;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
	public double getTanque() {
		return tanque;
	}

	public void setTanque(double tanque) {
		this.tanque = tanque;
	}

	public void acelera() {
		System.out.println("Vruuuum!");
	}
	
	public void freia() {
		System.out.println("Schiiiii");
	}
	
	public void abastecer(int litros) {
		if(litros < this.tanque)
			System.out.println("Abastecendo");
		else
			System.out.println("Tanque cheio");
	}

}
