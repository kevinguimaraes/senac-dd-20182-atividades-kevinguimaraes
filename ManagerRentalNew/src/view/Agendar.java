package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

import controller.ControllerAlugado;
import controller.ControllerCliente;
import controller.ControllerImovel;
import model.vo.AlugadoVo;
import model.vo.ClienteVo;

import com.toedter.calendar.JCalendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Agendar extends JPanel {

	JButton bDataInicio;
	JButton bDataFim;
	int dataselect = 0;
	int dia_inicio = 0;
	int dia_fim = 0;
	Date data_inicio;
	Date data_fim;
	ClienteVo cliente;
	private JTextField tValor;
	private JTextField tCpf;
	private JTextField tCelular;
	private JTextField tTelefone;
	private JTextField tNome;
	JComboBox cbImovel = new JComboBox();
	JCalendar cCalendar1 = new JCalendar();
	JCalendar cCalendar2 = new JCalendar();
	JCalendar cCalendar3 = new JCalendar();
	
	public Agendar() {
		setLayout(null);
		
		JLabel lblAgendar = new JLabel("Agendar");
		lblAgendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAgendar.setBounds(300, 11, 206, 45);
		add(lblAgendar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 54, 735, 2);
		add(separator);
		
		
		ControllerImovel ci = new ControllerImovel();
		
		cbImovel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearAllCalendars(cCalendar1, cCalendar2, cCalendar3);
				atualizaScreen();
			}
		});

		cbImovel.setModel(new DefaultComboBoxModel(ci.getReferenciasController()));
		cbImovel.setBounds(147, 70, 141, 20);
		add(cbImovel);
		
		
		JLabel lblImovel = new JLabel("Referencia Imovel:");
		lblImovel.setBounds(20, 73, 120, 14);
		add(lblImovel);
		
		cCalendar1.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar1.setWeekOfYearVisible(false);
		cCalendar1.setBounds(20, 211, 191, 153);
		add(cCalendar1);
		
		cCalendar1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
		    	if (dataselect == 0) {
		    		 if (dia_inicio != 0) {
		    			 clearAllCalendars(cCalendar1, cCalendar2, cCalendar3);
		    		 }
		    		bDataInicio = getDayButton(cCalendar1);//(JButton) cCalendar1.getDayChooser().getDayPanel().getComponent(10 + cCalendar1.getDayChooser().getDay());
			    	bDataInicio.setForeground(Color.green);
			        dia_inicio =  (int)e.getNewValue();
			        java.util.Date dataUtil = cCalendar1.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			        data_inicio =  dataSql;
			        dataselect = 1;
		    	}
		    	else if (dataselect == 1){
		    		bDataFim = getDayButton(cCalendar1);//(JButton) cCalendar1.getDayChooser().getDayPanel().getComponent(10 + cCalendar1.getDayChooser().getDay());
		    		bDataFim.setForeground(Color.red);
		    		dia_fim =  (int)e.getNewValue();
		    		java.util.Date dataUtil = cCalendar1.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		    		data_fim = dataSql;
		    		dataselect = 0;
		    	}
		    	if ((dia_inicio != 0)&&(dia_fim != 0))
		    		paintSelectedDays(cCalendar1, dia_inicio, dia_fim);
		    		
		    }
		});
		
		
		cCalendar2.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar2.setWeekOfYearVisible(false);
		cCalendar2.setBounds(264, 211, 191, 153);
		add(cCalendar2);
		
		cCalendar2.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
		    	if (dataselect == 0) {
		    		 if (dia_inicio != 0) {
		    			 clearAllCalendars(cCalendar1, cCalendar2, cCalendar3);
		    		 }
		    		bDataInicio = getDayButton(cCalendar2); //(JButton) cCalendar2.getDayChooser().getDayPanel().getComponent(10 + cCalendar2.getDayChooser().getDay());
			    	bDataInicio.setForeground(Color.green);
			        dia_inicio =  (int)e.getNewValue();
			        java.util.Date dataUtil = cCalendar2.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			        data_inicio = dataSql;
			        dataselect = 1;
		    	}
		    	else if (dataselect == 1){
		    		bDataFim = getDayButton(cCalendar2); //(JButton) cCalendar2.getDayChooser().getDayPanel().getComponent(10 + cCalendar2.getDayChooser().getDay());
		    		bDataFim.setForeground(Color.red);
		    		dia_fim =  (int)e.getNewValue();
		    		java.util.Date dataUtil = cCalendar2.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			        data_fim = dataSql;
		    		dataselect = 0;
		    	}
		    	if ((dia_inicio != 0)&&(dia_fim != 0))
		    		paintSelectedDays(cCalendar2, dia_inicio, dia_fim);
		    		
		    }
		});
		
		
		cCalendar3.setBorder(new LineBorder(Color.LIGHT_GRAY, 3));
		cCalendar3.setWeekOfYearVisible(false);
		cCalendar3.setTodayButtonText("teste3");
		cCalendar3.setBounds(512, 211, 191, 153);
		add(cCalendar3);
		
		JLabel lblValor = new JLabel("Valor diaria:");
		lblValor.setBounds(310, 73, 90, 14);
		add(lblValor);
		
		tValor = new JTextField();
		tValor.setBounds(392, 70, 86, 20);
		add(tValor);
		tValor.setColumns(10);
		
		JLabel lblCliente = new JLabel("CPF Cliente:");
		lblCliente.setBounds(20, 111, 98, 14);
		add(lblCliente);
		
		tCpf = new JTextField();
		tCpf.setBounds(147, 108, 95, 20);
		add(tCpf);
		tCpf.setColumns(10);
		
		JButton bPesquisar = new JButton("Pesquisar");
		bPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerCliente cc = new ControllerCliente();
				cliente = cc.consultarClientePorCpfController(tCpf.getText());
				tNome.setText(cliente.getNome());
				tTelefone.setText(cliente.getTelefone());
				tCelular.setText(cliente.getCelular());
			}
		});
		bPesquisar.setBounds(252, 107, 120, 23);
		add(bPesquisar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(20, 136, 46, 14);
		add(lblNome);
		
		JLabel lblRua = new JLabel("Celular: ");
		lblRua.setBounds(20, 161, 64, 14);
		add(lblRua);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setBounds(20, 186, 98, 14);
		add(lblTelefone);
		
		tCelular = new JTextField();
		tCelular.setEditable(false);
		tCelular.setBounds(147, 158, 225, 20);
		add(tCelular);
		tCelular.setColumns(10);
		
		tTelefone = new JTextField();
		tTelefone.setEditable(false);
		tTelefone.setBounds(147, 183, 225, 20);
		add(tTelefone);
		tTelefone.setColumns(10);
		
		tNome = new JTextField();
		tNome.setEditable(false);
		tNome.setBounds(147, 133, 225, 20);
		add(tNome);
		tNome.setColumns(10);
		
		JButton bAgendar = new JButton("Agendar");
		bAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ControllerAlugado ca = new ControllerAlugado();
				AlugadoVo alugado = new AlugadoVo();
				alugado.setDt_final(data_fim);
				alugado.setDt_inicio(data_inicio);
				alugado.setIdcliente(cliente.getIdCliente());
				alugado.setIdimovel(cbImovel.getSelectedIndex()+1);
				alugado.setValor(Double.parseDouble(tValor.getText()));
				ca.cadastrarAlugadoController(alugado);
				tValor.setText("");
				tCpf.setText("");
				tNome.setText("");
				tCelular.setText("");
				tTelefone.setText("");
			}
		});
		bAgendar.setBounds(170, 375, 389, 23);
		add(bAgendar);
		
		cCalendar3.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener() {
		    public void propertyChange(PropertyChangeEvent e) {
		    	if (dataselect == 0) {
		    		 if (dia_inicio != 0) {
		    			 clearAllCalendars(cCalendar1, cCalendar2, cCalendar3);
		    		 }
		    		bDataInicio = getDayButton(cCalendar3);
			    	bDataInicio.setForeground(Color.green);
			        dia_inicio =  (int)e.getNewValue();
			        dataselect = 1;
			        java.util.Date dataUtil = cCalendar3.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			        data_inicio = dataSql;
		    	}
		    	else if (dataselect == 1){
		    		bDataFim = getDayButton(cCalendar3);
		    		bDataFim.setForeground(Color.red);
		    		dia_fim =  (int)e.getNewValue();
		    		java.util.Date dataUtil = cCalendar3.getDate();
			        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		    		data_fim = dataSql;
		    		dataselect = 0;
		    	}
		    	if ((dia_inicio != 0)&&(dia_fim != 0))
			    	paintSelectedDays(cCalendar3, dia_inicio, dia_fim);
		    		
		    }
		});
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
		
		atualizaScreen();
		
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
	
	void paintSelectedDays(JCalendar c, int inicio, int fim) {
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
        for(int k = inicio+1; k < fim; k++) {
        	btn = (JButton) compo[++i];
        	btn.setForeground(Color.blue);
        }
        
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
		ControllerAlugado ca = new ControllerAlugado();
		ArrayList<AlugadoVo> alugados = new ArrayList<>();
		alugados = ca.consultarTodosAlugadosPerIdAndDateController(cbImovel.getSelectedIndex()+1);
		
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
	
}
