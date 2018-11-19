package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import controller.ControllerCaracteristica;
import model.vo.CaracteristicaVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroCarac extends JPanel {
	private JTextField tCaracteristica;

	/**
	 * Create the panel.
	 */
	public CadastroCarac() {
		setLayout(null);
		
		JLabel lblCadastroCaracteristica = new JLabel("Cadastro Caracteristica");
		lblCadastroCaracteristica.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroCaracteristica.setBounds(224, 11, 247, 53);
		add(lblCadastroCaracteristica);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 70, 727, 2);
		add(separator);
		
		JLabel lblNomeCaracteristica = new JLabel("Nome caracteristica:");
		lblNomeCaracteristica.setBounds(41, 108, 148, 14);
		add(lblNomeCaracteristica);
		
		tCaracteristica = new JTextField();
		tCaracteristica.setBounds(185, 105, 86, 20);
		add(tCaracteristica);
		tCaracteristica.setColumns(10);
		
		JButton bSalvar = new JButton("Salvar");
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCaracteristica cc = new ControllerCaracteristica();
				CaracteristicaVo cv = new CaracteristicaVo();
				cv.setNome(tCaracteristica.getText());
				cc.cadastrarCaracteristicaController(cv);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				tCaracteristica.setText("");
			}
		});
		bSalvar.setBounds(100, 133, 89, 23);
		add(bSalvar);

	}
}
