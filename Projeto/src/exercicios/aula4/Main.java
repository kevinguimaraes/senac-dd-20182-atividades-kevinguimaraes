package exercicios.aula4;


public class Main {

	public static void main(String[] args){
		Carroceria car = new Carroceria(100, true);
		
		Carro c1 = new Carro(4,"Gasolina",120, 45,"Citroen", "C3", 400);
		Moto m1 = new Moto(2, "Gasolina", 600, 20, "Kawasaki", "Ninja");
		Caminhao cam1 = new Caminhao(10, "Disel", 200, 100, "Volvo", "F1000", 2, car);
		
		System.out.println("Carro acelerando: ");
		c1.acelera();
		
		System.out.println("Moto freiando: ");
		m1.freia();
		
		System.out.println("Caminhao abastecendo");
		cam1.abastecer(50);
		
		System.out.println("Moto empinando");
		m1.empinar();
		
		System.out.println("Caminhao carregando e descarregando");
		cam1.carregar();
		cam1.descarregar();
		
		System.out.println("Carroceria esta: ");
		cam1.getCarroceria().status();
	}

}
