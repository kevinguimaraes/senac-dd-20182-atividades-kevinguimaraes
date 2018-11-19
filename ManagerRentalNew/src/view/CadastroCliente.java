package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerEstado;
import model.vo.CidadeVo;
import model.vo.ClienteVo;
import model.vo.EstadoVo;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class CadastroCliente extends JPanel {
	private JTextField tNome;
	private JTextField tCPF;
	private JTextField tRua;
	private JTextField tNumero;
	private JTextField tTelefone;
	private JTextField tCelular;
	private JTextField tID;
	JComboBox cbEstado = new JComboBox();
	JComboBox cbCidade = new JComboBox();
	JButton bPesquisar = new JButton("Pesquisar");
	JButton bSalvar = new JButton("Salvar");
	JButton bExcluir = new JButton("Excluir");

	/**
	 * Create the panel.
	 */
	public CadastroCliente() {
		setLayout(null);
		
		JLabel lblCadastroCliente = new JLabel("Cadastro Cliente");
		lblCadastroCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCadastroCliente.setBounds(287, 11, 180, 25);
		add(lblCadastroCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(113, 127, 56, 14);
		add(lblNome);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(432, 130, 46, 14);
		add(lblNewLabel);
		
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setBounds(113, 231, 46, 14);
		add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(113, 276, 56, 14);
		add(lblNumero);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(113, 315, 71, 14);
		add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular: ");
		lblCelular.setBounds(432, 312, 56, 14);
		add(lblCelular);
		
		tNome = new JTextField();
		tNome.setEnabled(false);
		tNome.setBounds(162, 124, 86, 20);
		add(tNome);
		tNome.setColumns(10);
		
		tCPF = new JTextField();
		tCPF.setEnabled(false);
		tCPF.setBounds(481, 127, 86, 20);
		add(tCPF);
		tCPF.setColumns(10);
		
		tRua = new JTextField();
		tRua.setEnabled(false);
		tRua.setBounds(162, 228, 405, 20);
		add(tRua);
		tRua.setColumns(10);
		
		tNumero = new JTextField();
		tNumero.setEnabled(false);
		tNumero.setBounds(162, 273, 86, 20);
		add(tNumero);
		tNumero.setColumns(10);
		
		tTelefone = new JTextField();
		tTelefone.setEnabled(false);
		tTelefone.setBounds(162, 312, 86, 20);
		add(tTelefone);
		tTelefone.setColumns(10);
		
		tCelular = new JTextField();
		tCelular.setEnabled(false);
		tCelular.setBounds(481, 309, 86, 20);
		add(tCelular);
		tCelular.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Estado:");
		lblNewLabel_1.setBounds(113, 181, 46, 14);
		add(lblNewLabel_1);
		ControllerEstado est = new ControllerEstado();
		ControllerCidade cid = new ControllerCidade();
		cbEstado.setModel(new DefaultComboBoxModel(est.getEstadosController()));
				
		cbEstado.setEnabled(false);
		cbEstado.setBounds(162, 175, 86, 20);
		add(cbEstado);
		
		cbCidade.setEnabled(false);
		cbCidade.setBounds(481, 175, 86, 20);
		cbCidade.setModel(new DefaultComboBoxModel(cid.getCidadesController(cbEstado.getSelectedIndex()+1)));
		add(cbCidade);
		
		
		cbEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCidade.setModel(new DefaultComboBoxModel(cid.getCidadesController(cbEstado.getSelectedIndex()+1)));
			}
		});
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(432, 178, 46, 14);
		add(lblCidade);
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCliente controllercliente = new ControllerCliente();
				ClienteVo cliente = getClienteFromScreen();
				if (!controllercliente.existeResgistroPorIdClienteController(cliente.getIdCliente())){
					controllercliente.cadastrarClienteController(cliente);
				}
				else {
					controllercliente.atualizarClienteController(cliente);
				}
					
				
			}
		});
		
		
		
		bSalvar.setEnabled(false);
		bSalvar.setBounds(183, 360, 142, 23);
		add(bSalvar);
		
		JLabel lblMatricula = new JLabel("ID:");
		lblMatricula.setBounds(113, 58, 56, 14);
		add(lblMatricula);
		
		tID = new JTextField();
		tID.setBounds(162, 55, 86, 20);
		add(tID);
		tID.setColumns(10);
				
		bPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCliente clienteController = new ControllerCliente();
				ClienteVo cliente = new ClienteVo();
				cliente.setIdCliente(Integer.parseInt(tID.getText()));
				cliente = clienteController.consultarClienteController(cliente);
				atualizaScreen(cliente);
				enableScreen(true);
				
			}
		});
		bPesquisar.setBounds(294, 52, 115, 23);
		add(bPesquisar);
		
		bExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCliente controllercliente = new ControllerCliente();
				ClienteVo cliente = getClienteFromScreen();
				if (controllercliente.existeResgistroPorIdClienteController(cliente.getIdCliente())){
					controllercliente.excluirClienteController(cliente);
				}
				else {
					JOptionPane.showMessageDialog(null, "ERRO", "ID Nçã", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		bExcluir.setEnabled(false);
		bExcluir.setBounds(432, 360, 142, 23);
		add(bExcluir);
		
		JCheckBox chckbxNovoUsuario = new JCheckBox("Novo Usuario");
		chckbxNovoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNovoUsuario.isSelected()) {
					enableScreen(true);
					clearScreen();
				}
				else {
					enableScreen(false);
				}
			}

			
		});
		chckbxNovoUsuario.setBounds(449, 52, 128, 23);
		add(chckbxNovoUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 97, 577, 2);
		add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 39, 735, 2);
		add(separator_1);

	}
	private void enableScreen(boolean chk) {
		tNome.setEnabled(chk);
		tRua.setEnabled(chk);
		tCPF.setEnabled(true);
		cbEstado.setEnabled(chk);
		cbCidade.setEnabled(chk);
		tNumero.setEnabled(chk);
		tTelefone.setEnabled(chk);
		tCelular.setEnabled(chk);
		bSalvar.setEnabled(chk);
		bExcluir.setEnabled(chk);
		tID.setEnabled(!chk);
		bPesquisar.setEnabled(!chk);
	}
	
	private void atualizaScreen(ClienteVo cliente) {
		tNome.setText(cliente.getNome());
		tRua.setText(cliente.getRua());
		tCPF.setText(cliente.getCpf());
		cbEstado.setSelectedIndex(cliente.getIdEstado()-1);
		cbCidade.setSelectedIndex(cliente.getIdCidade()-1);
		tNumero.setText(cliente.getNumero()+"");
		tTelefone.setText(cliente.getTelefone());
		tCelular.setText(cliente.getCelular());
		tID.setText(cliente.getIdCliente()+"");
	}
	
	private void clearScreen () {
		tID.setText("");
		tNome.setText("");
		tRua.setText("");
		tNumero.setText("");
		tTelefone.setText("");
		tCelular.setText("");
		tCPF.setText("");
		cbEstado.setSelectedIndex(0);
		cbCidade.setSelectedIndex(0);
	}	
	
	private ClienteVo getClienteFromScreen() {
		ClienteVo cliente = new ClienteVo();
		try {
			cliente.setIdCliente(Integer.parseInt(tID.getText()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		cliente.setNome(tNome.getText());
		cliente.setRua(tRua.getText());
		cliente.setCpf(tCPF.getText());
		cliente.setIdCidade(cbCidade.getSelectedIndex()+1);
		cliente.setIdEstado(cbEstado.getSelectedIndex()+1);
		cliente.setCelular(tCelular.getText());
		cliente.setTelefone(tTelefone.getText());
		cliente.setNumero(Integer.parseInt(tNumero.getText()));
		
		return cliente;
	}
}
