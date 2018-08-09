package exercicios.aula4;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args){ 
		Carroceria car = new Carroceria(100, true); 
		
		Carro c1 = new Carro();
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
		
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao meu programa");
		
		c1.setRoda(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas rodas tem o seu carro: ")));
		c1.setCombustivel(JOptionPane.showInputDialog("Digite o combustivel"));
		c1.setPotencia(Double.parseDouble(JOptionPane.showInputDialog("Digite potencia do carro")));
		c1.setTanque(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o tanque")));
		c1.setMarca(JOptionPane.showInputDialog("Digite a marca do carro"));
		c1.setModelo(JOptionPane.showInputDialog("Digite o modelo do carro"));
		c1.setPortamala(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o porta mala")));
		c1.printCarro();
	}

}
