package exercicios.aula4;

public class Carroceria { 
	private double tamanho;
	private boolean cheio;
	
	public Carroceria(double tamanho, boolean cheio) {
		super();
		this.tamanho = tamanho;
		this.cheio = cheio;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isCheio() {
		return cheio;
	}
	public void setCheio(boolean cheio) {
		this.cheio = cheio;
	}
	
	public void status() {
		if(this.cheio)
			System.out.println("Cheio");
		else
			System.out.println("Vazio");
	}

}
