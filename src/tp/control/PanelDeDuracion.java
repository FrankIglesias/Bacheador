package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class PanelDeDuracion extends JPanel {
	GridBagConstraints gbc_panel;

	public PanelDeDuracion(String nombre, int i) {

		setLayout(null);
		gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = i;
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinner_2.setBounds(452, 12, 41, 20);
		add(spinner_2);
		JLabel lblSegundos = new JLabel("Segundos");
		lblSegundos.setBounds(495, 14, 70, 16);
		add(lblSegundos);

		JLabel lblMinutos = new JLabel("Minutos");
		lblMinutos.setBounds(364, 14, 70, 16);
		add(lblMinutos);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(320, 12, 41, 20);
		add(spinner);

		JLabel lblHoras = new JLabel("Horas");
		lblHoras.setBounds(232, 14, 70, 16);
		add(lblHoras);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(173, 12, 41, 20);
		add(spinner_1);

		JLabel label = new JLabel(nombre);
		label.setBounds(28, 14, 80, 16);
		add(label);
	}

}
