package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class PanelDeDuracion extends JPanel implements AyEDPanel {
	public GridBagConstraints gbc_panel;
	String nombre;
	JSpinner spinner_segundos;
	JSpinner spinner_minutos;
	JSpinner spinner_horas;

	public PanelDeDuracion(String nombre, int i) {
		this.nombre = nombre;
		setLayout(null);
		gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = i;
		spinner_segundos = new JSpinner();
		spinner_segundos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_segundos.setBounds(452, 12, 41, 20);
		add(spinner_segundos);
		JLabel lblSegundos = new JLabel("Segundos");
		lblSegundos.setBounds(495, 14, 70, 16);
		add(lblSegundos);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(364, 14, 70, 16);
		add(lblMinutos);

		spinner_minutos = new JSpinner();
		spinner_minutos.setBounds(320, 12, 41, 20);
		spinner_minutos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		add(spinner_minutos);

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(232, 14, 70, 16);
		add(lblHoras);

		spinner_horas = new JSpinner();
		spinner_horas.setBounds(173, 12, 41, 20);
		spinner_horas.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		add(spinner_horas);
		JLabel label = new JLabel(nombre);
		label.setBounds(28, 14, 80, 16);
		add(label);
		spinner_horas.setEditor(new JSpinner.DefaultEditor(spinner_horas));
		spinner_minutos.setEditor(new JSpinner.DefaultEditor(spinner_minutos));
		spinner_segundos.setEditor(new JSpinner.DefaultEditor(spinner_segundos));
	}

	public String getValue() {
		String horas, minutos, segundos;
		if ((int) spinner_horas.getValue() >= 10) {
			horas = spinner_horas.getValue().toString();
		} else {
			horas = "0" + spinner_horas.getValue().toString();
		}
		if ((int) spinner_minutos.getValue() >= 10) {
			minutos = spinner_minutos.getValue().toString();
		} else {
			minutos = "0" + spinner_minutos.getValue().toString();
		}
		if ((int) spinner_segundos.getValue() >= 10) {
			segundos = spinner_segundos.getValue().toString();
		} else {
			segundos = "0" + spinner_segundos.getValue().toString();
		}

		return horas + ":" + minutos + ":" + segundos;
	}

	@Override
	public String getNombre() {

		return nombre;
	}

}
