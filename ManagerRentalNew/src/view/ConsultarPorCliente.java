package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;

import controller.ControllerAlugado;
import controller.ControllerCliente;
import model.vo.AlugadoVo;
import model.vo.CaracPerImovelVo;
import model.vo.ClienteVo;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultarPorCliente extends JPanel {
	private JTextField tCpf;
	private JTextField tNome;
	private JTextField tTelefone;
	private JTextField tCelular;
	private JTable tAlugados;

	/**
	 * Create the panel.
	 */
	public ConsultarPorCliente() {
		setLayout(null);
		
		JLabel lblConsultarPorCliente = new JLabel("Consultar por Cliente");
		lblConsultarPorCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultarPorCliente.setBounds(251, 11, 261, 68);
		add(lblConsultarPorCliente);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 77, 727, 2);
		add(separator);
		
		JLabel lblCpfCliente = new JLabel("CPF Cliente:");
		lblCpfCliente.setBounds(10, 90, 110, 14);
		add(lblCpfCliente);
		
		tCpf = new JTextField();
		tCpf.setBounds(85, 87, 154, 20);
		add(tCpf);
		tCpf.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaScreen();
				
			}
		});
		btnPesquisar.setBounds(261, 86, 133, 23);
		add(btnPesquisar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 115, 75, 14);
		add(lblNome);
		
		tNome = new JTextField();
		tNome.setEditable(false);
		tNome.setBounds(85, 112, 154, 20);
		add(tNome);
		tNome.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 140, 75, 14);
		add(lblTelefone);
		
		tTelefone = new JTextField();
		tTelefone.setEditable(false);
		tTelefone.setBounds(85, 137, 154, 20);
		add(tTelefone);
		tTelefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 165, 75, 14);
		add(lblCelular);
		
		tCelular = new JTextField();
		tCelular.setEditable(false);
		tCelular.setBounds(85, 162, 154, 20);
		add(tCelular);
		tCelular.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 190, 717, 219);
		add(scrollPane);
		
		tAlugados = new JTable();
		tAlugados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Referencia imovel", "Data Inicio", "Data Saida", "Valor diaria"
			}
		));
		tAlugados.getColumnModel().getColumn(0).setPreferredWidth(117);
		scrollPane.setViewportView(tAlugados);

	}
	
	void paintUsedDays(JCalendar c, int inicio, int fim) {
		JButton btn = new JButton();
		int i;
        JPanel jpanel = c.getDayChooser().getDayPanel();
        Component compo[] = jpanel.getComponents();
        
        for (i = 0; i < compo.length; i++) {
        	Component comp = compo[i];
            if (!(comp instanceof JButton))
                continue;

            btn = (JButton) comp;
            if (btn.getText().equals(String.valueOf(inicio)))
        	   break;
        }
        for(int k = inicio; k <= fim; k++) {
        	btn = (JButton) compo[i++];
        	btn.setForeground(Color.red);
        }
	}
	
	void atualizaScreen() {
		ControllerAlugado controlleralugado = new ControllerAlugado();
		ControllerCliente controllercliente = new ControllerCliente();
		ArrayList<AlugadoVo> alugados = new ArrayList<>();
		ClienteVo cliente = new ClienteVo();
		cliente = controllercliente.consultarClientePorCpfController(tCpf.getText());
		alugados = controlleralugado.consultarTodosNextMonthAlugadoController(cliente.getIdCliente());
		tTelefone.setText(cliente.getTelefone());
		tCelular.setText(cliente.getCelular());
		tNome.setText(cliente.getNome());
		
		tAlugados.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Referencia imovel", "Data Inicio", "Data Saida", "Valor diaria"
				}
			));
		DefaultTableModel modelo = (DefaultTableModel) tAlugados.getModel();
		
		for(AlugadoVo item: alugados)
		{
			Object[] novaLinha = new Object[] {
					item.getRef(),
					item.getDt_inicio(),
					item.getDt_final(),
					item.getValor()
			};
			modelo.addRow(novaLinha);
		}
		
	}
}
