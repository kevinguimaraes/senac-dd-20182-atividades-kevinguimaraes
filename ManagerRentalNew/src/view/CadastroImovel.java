package view;

import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.CaracPerImovelController;
import controller.ControllerCaracImovel;
import controller.ControllerCaracteristica;
import controller.ControllerCidade;
import controller.ControllerCliente;
import controller.ControllerEstado;
import controller.ControllerImovel;
import model.vo.CaracImovelVo;
import model.vo.CaracPerImovelVo;
import model.vo.CidadeVo;
import model.vo.ClienteVo;
import model.vo.EstadoVo;
import model.vo.ImovelVo;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroImovel extends JPanel {

	private JTextField tID;
	private JTextField tValor;
	private JTextField tRua;
	private JTextField tNumero;
	private JTable tbCarac;
	private JTextField tReferencia;
	JComboBox cbCidade = new JComboBox();
	JComboBox cbEstado = new JComboBox();
	JComboBox cbCarac = new JComboBox();
	JButton bAtualizar = new JButton("LIMPAR");
	JButton bAdicionar = new JButton("ADICIONAR");
	JButton bExcluir = new JButton("EXCLUIR");
	JButton bSalvar = new JButton("SALVAR");
	JButton bPesquisar = new JButton("PESQUISAR");

	/**
	 * Create the panel.
	 */
	public CadastroImovel() {
		setForeground(Color.BLACK);
		setLayout(null);
		
		JLabel lblCadastroDeImveis = new JLabel("CADASTRO DE IM\u00D3VEIS");
		lblCadastroDeImveis.setBounds(284, 21, 233, 20);
		lblCadastroDeImveis.setFont(new Font("Tahoma", Font.BOLD, 16));
		add(lblCadastroDeImveis);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 735, 2);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		add(separator);
		
		JLabel lblNewLabel = new JLabel("ID IMOVEL");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(33, 87, 64, 14);
		add(lblNewLabel);
		
		tID = new JTextField();
		tID.setBounds(99, 84, 39, 20);
		add(tID);
		tID.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 142, 346, 2);
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		add(separator_1);
		
		JLabel lblCaracteristicas = new JLabel("CARACTERISTICAS");
		lblCaracteristicas.setBounds(115, 251, 164, 14);
		lblCaracteristicas.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblCaracteristicas);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(366, 66, -5, 335);
		separator_2.setForeground(Color.BLACK);
		separator_2.setOrientation(SwingConstants.VERTICAL);
		add(separator_2);
		
		ControllerCaracteristica carac = new ControllerCaracteristica();

		cbCarac.setEnabled(false);
		cbCarac.setBounds(27, 276, 194, 20);
		cbCarac.setModel(new DefaultComboBoxModel(carac.consultarTodosCaracteristicaController()));
		add(cbCarac);
		
		JLabel lblQdt = new JLabel("Qtd.:");
		lblQdt.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblQdt.setForeground(Color.BLACK);
		lblQdt.setBounds(244, 279, 44, 14);
		add(lblQdt);
		
		tValor = new JTextField();
		tValor.setEnabled(false);
		tValor.setBounds(298, 276, 58, 20);
		add(tValor);
		tValor.setColumns(10);
		bSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerImovel ci = new ControllerImovel();
				ImovelVo imovelvo = getImovelFromScreen();
				if (ci.existeResgistroPorIdImovelController(imovelvo.getIdimovel()))
					ci.atualizarImovelController(imovelvo);
				else {
					ci.cadastrarImovelController(imovelvo);
					tID.setText(ci.consultarTodosImovelController().size()+"");
				}
				
			}
		});
		
		bSalvar.setEnabled(false);
		bSalvar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bSalvar.setForeground(Color.BLACK);
		bSalvar.setBounds(18, 354, 100, 35);
		add(bSalvar);
		
		bExcluir.setEnabled(false);
		bExcluir.setFont(new Font("Tahoma", Font.BOLD, 11));
		bExcluir.setForeground(Color.BLACK);
		bExcluir.setBounds(241, 354, 100, 35);
		add(bExcluir);
		
		bPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerImovel imovelController = new ControllerImovel();
				ImovelVo imovel = new ImovelVo();
				ArrayList<CaracPerImovelVo> caracperimovel = new ArrayList<>();
				imovel.setIdimovel(Integer.parseInt(tID.getText()));
				imovel = imovelController.consultarImovelController(imovel);
				atualizaScreen(imovel);
				enableScreen(true);
			}
		});
		bPesquisar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bPesquisar.setBounds(148, 83, 102, 23);
		add(bPesquisar);
		
		JCheckBox ckNovo = new JCheckBox("Novo");
		ckNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ckNovo.isSelected()) {
					enableScreen(true);
					clearScreen();
				}
				else {
					enableScreen(false);
				}
			}
		});
		ckNovo.setBounds(277, 83, 79, 23);
		add(ckNovo);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUf.setForeground(Color.BLACK);
		lblUf.setBounds(17, 170, 27, 14);
		add(lblUf);
		
		cbEstado.setEnabled(false);
		cbEstado.setBounds(54, 167, 80, 20);
		ControllerEstado est = new ControllerEstado();
		cbEstado.setModel(new DefaultComboBoxModel(est.getEstadosController()));
		add(cbEstado);
		
		ControllerCidade cid = new ControllerCidade();
		cbEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbCidade.setModel(new DefaultComboBoxModel(cid.getCidadesController(cbEstado.getSelectedIndex()+1)));
			}
		});
		
		JLabel lblCidade = new JLabel("CIDADE");
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCidade.setForeground(Color.BLACK);
		lblCidade.setBounds(171, 170, 46, 14);
		add(lblCidade);
		
		cbCidade.setEnabled(false);
		cbCidade.setBounds(227, 167, 115, 20);
		ControllerCidade cidcontr = new ControllerCidade();
		cbCidade.setModel(new DefaultComboBoxModel(cidcontr.getCidadesController(cbEstado.getSelectedIndex()+1)));
		add(cbCidade);
		
		JLabel lblRua = new JLabel("RUA");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRua.setForeground(Color.BLACK);
		lblRua.setBounds(10, 213, 39, 14);
		add(lblRua);
		
		tRua = new JTextField();
		tRua.setEnabled(false);
		tRua.setBounds(57, 210, 174, 20);
		add(tRua);
		tRua.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00B0");
		lblN.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblN.setForeground(Color.BLACK);
		lblN.setBounds(242, 213, 27, 14);
		add(lblN);
		
		tNumero = new JTextField();
		tNumero.setEnabled(false);
		tNumero.setBounds(266, 210, 44, 20);
		add(tNumero);
		tNumero.setColumns(10);
		
		JLabel lblEndereo = new JLabel("ENDERE\u00C7O");
		lblEndereo.setBounds(134, 142, 108, 14);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(lblEndereo);
		bAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerCaracImovel cicontroller = new ControllerCaracImovel();
				CaracImovelVo civo = new CaracImovelVo();
				
				civo.setIdcaracteristica(cbCarac.getSelectedIndex()+1);
				civo.setIdimovel(Integer.parseInt(tID.getText()));
				civo.setValor(Integer.parseInt(tValor.getText()));
				cicontroller.cadastrarCaracImovelController(civo);
				atualizaScreen(getImovelFromScreen());
				
			}
		});
	
		bAdicionar.setEnabled(false);
		bAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		bAdicionar.setForeground(Color.BLACK);
		bAdicionar.setBounds(54, 307, 299, 23);
		add(bAdicionar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.BLACK);
		separator_3.setForeground(Color.BLACK);
		separator_3.setBounds(10, 238, 351, 2);
		add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.BLACK);
		separator_4.setForeground(Color.BLACK);
		separator_4.setBounds(5, 341, 351, 2);
		add(separator_4);
		bAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearScreen();
			}
		});
		
		bAtualizar.setEnabled(false);
		bAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		bAtualizar.setForeground(Color.BLACK);
		bAtualizar.setBounds(131, 354, 100, 35);
		add(bAtualizar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(378, 65, 359, 335);
		add(scrollPane);
		
		tbCarac = new JTable();
		tbCarac.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "VALOR"
			}
		));
		scrollPane.setViewportView(tbCarac);
		
		JLabel lblReferencia = new JLabel("Referencia");
		lblReferencia.setBounds(33, 112, 64, 14);
		add(lblReferencia);
		
		tReferencia = new JTextField();
		tReferencia.setEnabled(false);
		tReferencia.setBounds(99, 109, 86, 20);
		add(tReferencia);
		tReferencia.setColumns(10);

	}
	
	private void enableScreen(boolean chk) {
		cbEstado.setEnabled(chk);
		cbCidade.setEnabled(chk);
		tRua.setEnabled(chk);
		tNumero.setEnabled(chk);
		cbCarac.setEnabled(chk);
		tValor.setEnabled(chk);
		tReferencia.setEnabled(chk);
		bAdicionar.setEnabled(chk);
		bAtualizar.setEnabled(chk);
		bExcluir.setEnabled(chk);
		bSalvar.setEnabled(chk);
		bPesquisar.setEnabled(!chk);
		tID.setEnabled(!chk);
	}
	
	private void atualizaScreen(ImovelVo imovel) {
		ControllerCidade cid = new ControllerCidade();
		ControllerEstado est = new ControllerEstado();
		CaracPerImovelController cicontroller = new CaracPerImovelController();
		ArrayList<CaracPerImovelVo> caracperimovel = cicontroller.getrCaracPerImovelsController(imovel.getIdimovel());
		
		
		tRua.setText(imovel.getRua());
		cbEstado.setModel(new DefaultComboBoxModel(est.getEstadosController()));
		cbCidade.setModel(new DefaultComboBoxModel(cid.getCidadesController(cbEstado.getSelectedIndex()+1)));
		cbEstado.setSelectedIndex(imovel.getIdestado()-1);
		cbCidade.setSelectedIndex(imovel.getIdcidade()-1);
		tNumero.setText(imovel.getNumero()+"");
		tID.setText(imovel.getIdimovel()+"");
		tReferencia.setText(imovel.getReferencia()+"");
		
		tbCarac.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"NOME", "VALOR"
				}
			));
		DefaultTableModel modelo = (DefaultTableModel) tbCarac.getModel();
		
		for(CaracPerImovelVo item: caracperimovel)
		{
			Object[] novaLinha = new Object[] {
					item.getCaracteristica(),
					item.getValor()
			};
			modelo.addRow(novaLinha);
		}
	}
	
	private void clearScreen () {
		tID.setText("");
		tRua.setText("");
		tNumero.setText("");
		cbEstado.setSelectedIndex(0);
		cbCidade.setSelectedIndex(0);
		cbCarac.setSelectedIndex(0);
		tValor.setText("");
		tReferencia.setText("");
	}
	
	private ImovelVo getImovelFromScreen() {
		ImovelVo imovel = new ImovelVo();
		try {
			imovel.setIdimovel(Integer.parseInt(tID.getText()));
		} catch (Exception e) {
			// TODO: handle exception
		}
		imovel.setRua(tRua.getText());
		imovel.setIdcidade(cbCidade.getSelectedIndex()+1);
		imovel.setIdestado(cbEstado.getSelectedIndex()+1);
		imovel.setNumero(Integer.parseInt(tNumero.getText()));
		imovel.setReferencia(tReferencia.getText());
		
		
		return imovel;
	}
}
