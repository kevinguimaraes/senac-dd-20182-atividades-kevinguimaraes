package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.CaracPerImovelController;
import controller.ControllerAlugado;
import controller.ControllerImovel;
import model.vo.AlugadoVo;
import model.vo.CaracPerImovelVo;
import model.vo.ImovelVo;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

public class ConsultaPorImovel extends JPanel {

	private JTable tbCarac;
	private JTextField tRua;
	private JTextField tNumero;
	int dia_inicio = 0;
	int dia_fim = 0;
	JCalendar cCalendar1 = new JCalendar();
	JCalendar cCalendar2 = new JCalendar();
	JCalendar cCalendar3 = new JCalendar();
	
	public ConsultaPorImovel() {
		setLayout(null);
		
		JLabel lblConsultaPorImovel = new JLabel("Consulta por Imovel");
		lblConsultaPorImovel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConsultaPorImovel.setBounds(263, 0, 311, 63);
		add(lblConsultaPorImovel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 52, 727, 2);
		add(separator);
		
		cCalendar1.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar1.setBounds(34, 247, 191, 153);
		add(cCalendar1);
		
		cCalendar2.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar2.setBounds(260, 247, 191, 153);
		add(cCalendar2);
		
		cCalendar3.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar3.setBounds(495, 247, 191, 153);
		add(cCalendar3);
		
		if (cCalendar1.getMonthChooser().getMonth()+1 > 11) {
			cCalendar2.getYearChooser().setYear(cCalendar1.getYearChooser().getYear()+1);
			cCalendar2.getMonthChooser().setMonth(1);
		}else
			cCalendar2.getMonthChooser().setMonth(cCalendar1.getMonthChooser().getMonth()+1);
			
		if (cCalendar1.getMonthChooser().getMonth()+2 > 11) {
			cCalendar3.getYearChooser().setYear(cCalendar1.getYearChooser().getYear()+1);
			cCalendar3.getMonthChooser().setMonth(cCalendar1.getMonthChooser().getMonth()-9);
		}else
			cCalendar3.getMonthChooser().setMonth(cCalendar1.getMonthChooser().getMonth()+2);
		
		cCalendar3.getYearChooser().setYear(cCalendar1.getYearChooser().getYear()+1);
		cCalendar3.getMonthChooser().setMonth(cCalendar1.getMonthChooser().getMonth()-10);
		
		tRua = new JTextField();
		tRua.setEditable(false);
		tRua.setBounds(88, 145, 247, 20);
		add(tRua);
		tRua.setColumns(10);
		
		tNumero = new JTextField();
		tNumero.setEditable(false);
		tNumero.setBounds(88, 170, 86, 20);
		add(tNumero);
		tNumero.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(378, 65, 359, 133);
		add(scrollPane);
		
		tbCarac = new JTable();
		tbCarac.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NOME", "QTD"
			}
		));
		scrollPane.setViewportView(tbCarac);
		
		ControllerImovel ci = new ControllerImovel();
		JComboBox cbImovel = new JComboBox();
		cbImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImovelVo i = new ImovelVo();
				
				i.setIdimovel(cbImovel.getSelectedIndex()+1);
				i = ci.consultarImovelController(i);
				atualizaScreenConsulta(i);
			}
		});
		cbImovel.setModel(new DefaultComboBoxModel(ci.getReferenciasController()));
		cbImovel.setBounds(119, 120, 216, 20);
		add(cbImovel);
		
		ImovelVo i = new ImovelVo();
		
		i.setIdimovel(cbImovel.getSelectedIndex()+1);
		i = ci.consultarImovelController(i);
		atualizaScreenConsulta(i);
		
		JLabel lblImovel = new JLabel("Referencia Imovel:");
		lblImovel.setBounds(10, 123, 115, 14);
		add(lblImovel);
		
		JLabel lblRua = new JLabel("Rua: ");
		lblRua.setBounds(10, 148, 46, 14);
		add(lblRua);
		
		JLabel lblNumero = new JLabel("Numero: ");
		lblNumero.setBounds(10, 173, 61, 14);
		add(lblNumero);
		
		
		
	}
	
	void atualizaScreenConsulta(ImovelVo imovel) {
		CaracPerImovelController cicontroller = new CaracPerImovelController();
		ArrayList<CaracPerImovelVo> caracperimovel = cicontroller.getrCaracPerImovelsController(imovel.getIdimovel());
		
		clearAllCalendars(cCalendar1, cCalendar2, cCalendar3);
		tNumero.setText(imovel.getNumero()+"");
		tRua.setText(imovel.getRua());
		
		tbCarac.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"NOME", "QTD"
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
		
		ControllerAlugado ca = new ControllerAlugado();
		ArrayList<AlugadoVo> alugados = new ArrayList<>();
		alugados = ca.consultarTodosAlugadosPerIdAndDateController(imovel.getIdimovel());
		
		Date dataatual = new Date(System.currentTimeMillis());
		int mes;
		for (int i = 0; i < alugados.size(); i++) {
			mes = dataatual.getMonth();
			if(alugados.get(i).getDt_inicio().getMonth() == mes++) 
				paintUsedDays(cCalendar1, Integer.parseInt(alugados.get(i).getDt_inicio().toString().split("-")[2]), Integer.parseInt(alugados.get(i).getDt_final().toString().split("-")[2]));
			if (mes > 11)
				mes = 0;
			if (alugados.get(i).getDt_inicio().getMonth() == mes++)
				paintUsedDays(cCalendar2, Integer.parseInt(alugados.get(i).getDt_inicio().toString().split("-")[2]), Integer.parseInt(alugados.get(i).getDt_final().toString().split("-")[2]));
			if (mes > 11)
				mes = 0;
			if (alugados.get(i).getDt_inicio().getMonth() == mes)
				paintUsedDays(cCalendar3, Integer.parseInt(alugados.get(i).getDt_inicio().toString().split("-")[2]), Integer.parseInt(alugados.get(i).getDt_final().toString().split("-")[2]));
		}
	}
	
	JButton getDayButton(JCalendar c) {
		JButton btn = new JButton();
        JPanel jpanel = c.getDayChooser().getDayPanel();
        Component compo[] = jpanel.getComponents();
        for (Component comp : compo) {
            if (!(comp instanceof JButton))
                continue;

            btn = (JButton) comp;
           if (btn.getText().equals(String.valueOf(c.getDayChooser().getDay())))
        	   return btn;
        }
        return btn;
	}
	
	void clearCalendar(JCalendar c) {
		JButton btn = new JButton();
        JPanel jpanel = c.getDayChooser().getDayPanel();
        Component compo[] = jpanel.getComponents();
        for (Component comp : compo) {
            if (!(comp instanceof JButton))
                continue;

            btn = (JButton) comp;
            btn.setForeground(Color.black);
          // if (btn.getText().equals(String.valueOf(c.getDayChooser().getDay())))
        	   
        }
	}
	
	void clearAllCalendars(JCalendar c1, JCalendar c2, JCalendar c3) {
		 clearCalendar(c1);
		 clearCalendar(c2);
		 clearCalendar(c3);
		 dia_inicio = 0;
		 dia_fim = 0;
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
}
