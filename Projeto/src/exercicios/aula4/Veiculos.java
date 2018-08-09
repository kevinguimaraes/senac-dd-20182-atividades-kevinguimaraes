package exercicios.aula4;

public class Veiculos {
	private int id;
	private int roda;
	private String combustivel;
	private double potencia;
	private double tanque;
	private String marca;
	private String modelo;   

	public Veiculos(int roda, String combustivel, double potencia, double tanque, String marca, String modelo) {
		super();
		this.roda = roda;
		this.combustivel = combustivel;
		this.potencia = potencia;
		this.tanque = tanque;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Veiculos() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
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
	
	public String printVeiculo() {
		String tmp =  "Numero de rodas: " + this.getRoda()
			+ "\nCombustivel: " + this.getCombustivel()
			+ "\nLitros tanque: " + this.getTanque()
			+ "\nPotencia: " + this.getPotencia()
			+ "\nMarca: " + this.getMarca()
			+ "\nModelo: " + this.getModelo();
		return tmp;
	}

}
