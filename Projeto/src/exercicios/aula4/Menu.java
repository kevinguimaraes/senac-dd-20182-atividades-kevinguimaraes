package exercicios.aula4;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
	private static int main_id;
	
	public int showMainMenu() 
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null, "1 - Cadastrar Carro"
				+ "\n2 - Cadastrar Caminhao"
				+ "\n3 - Cadastrar Moto"
				+ "\n4 - Ver caminhao e carro"
				+ "\n5 - Ver moto "
				+ "\n6 - Ver por ID"
				+ "\n7 - Sair", "Gerenciador de Veiculos", JOptionPane.PLAIN_MESSAGE));
	}
	
	public Carro cadastrarCarro() 
	{
		Carro c1 = new Carro();
		c1.setId(main_id++);
		c1.setRoda(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas rodas tem seu veiculo: ")));
		c1.setCombustivel(JOptionPane.showInputDialog("Digite o combustivel"));
		c1.setPotencia(Double.parseDouble(JOptionPane.showInputDialog("Digite potencia do veiculo")));
		c1.setTanque(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o tanque")));
		c1.setMarca(JOptionPane.showInputDialog("Digite a marca do veiculo"));
		c1.setModelo(JOptionPane.showInputDialog("Digite o modelo do veiculo"));
		c1.setPortamala(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o porta mala")));
		
		return c1;
	}
	
	public Caminhao cadastrarCaminhao() 
	{
		Caminhao c = new Caminhao();
		c.setId(main_id++);
		c.setRoda(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas rodas tem o seu veiculo: ")));
		c.setCombustivel(JOptionPane.showInputDialog("Digite o combustivel"));
		c.setPotencia(Double.parseDouble(JOptionPane.showInputDialog("Digite potencia do veiculo")));
		c.setTanque(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o tanque")));
		c.setMarca(JOptionPane.showInputDialog("Digite a marca do veiculo"));
		c.setModelo(JOptionPane.showInputDialog("Digite o modelo do veiculo"));
		c.setEixos(Integer.parseInt(JOptionPane.showInputDialog("Digite quantos eixos")));
		c.getCarroceria().setTamanho(Double.parseDouble(JOptionPane.showInputDialog("Digite qual tamanho da carroceria")));
		
		return c;
	}
	
	public Moto cadastrarMoto() 
	{
		Moto m = new Moto();
		m.setId(main_id++);
		m.setRoda(Integer.parseInt(JOptionPane.showInputDialog("Digite quantas rodas tem o seu veiculo: ")));
		m.setCombustivel(JOptionPane.showInputDialog("Digite o combustivel"));
		m.setPotencia(Double.parseDouble(JOptionPane.showInputDialog("Digite potencia do veiculo")));
		m.setTanque(Double.parseDouble(JOptionPane.showInputDialog("Digite quantos litros tem o tanque")));
		m.setMarca(JOptionPane.showInputDialog("Digite a marca do veiculo"));
		m.setModelo(JOptionPane.showInputDialog("Digite o modelo do veiculo"));

		
		return m;
	}
	
	public int selectId()
	{
		return Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ID", "VER POR ID", JOptionPane.INFORMATION_MESSAGE));
	}
	
	public void MainMenu()
	{
		Menu m = new Menu();
		ArrayList<Veiculos> v = new ArrayList<>();
		int aux = 1;
		while(aux > 0)
		{
			switch(m.showMainMenu())
			{
				case 1: //CADASTRAR CARRO
				{
					v.add(m.cadastrarCarro());
					break;
				}
				case 2: //CADASTRAR CAMINHAO
				{
					v.add(m.cadastrarCaminhao());
					break;
				}
				case 3: //CADASTRAR MOTO
				{
					v.add(m.cadastrarMoto());
					break;
				}
				case 4: //Ver caminhao e carro
				{
					for(int i = 0; i < v.size(); i++)
					{
						if ((v.get(i) instanceof  Carro) || (v.get(i) instanceof  Caminhao))
							JOptionPane.showMessageDialog(null, v.get(i).printVeiculo());
					}
					break;
				}
				case 5: //Ver moto
				{
					break;
				}
				case 6: //Ver por ID
				{
					JOptionPane.showMessageDialog(null, v.get(m.selectId()).printVeiculo(), "VER POR ID", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
				case 7: //Sair
				{
					aux = 0;
					break;
				}
				default:
				{
					JOptionPane.showMessageDialog(null, "Opção Invalida!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
