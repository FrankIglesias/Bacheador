package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class PanelDeRotacion extends JPanel implements AyEDPanel {
	public GridBagConstraints gbc_panel;
	JSpinner spinner;
	String nombre;

	public PanelDeRotacion(String nombre, int i) {
		this.nombre = nombre;
		setLayout(null);
		gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = i;
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 360, 1));
		spinner.setBounds(305, 7, 40, 20);
		add(spinner);
		JLabel lblSeleccioneElAngul = new JLabel("Seleccione el angulo de rotaci\u00F3n deseado");
		lblSeleccioneElAngul.setBounds(37, 9, 262, 16);
		add(lblSeleccioneElAngul);

	}

	public String getValue() {
		return spinner.getValue().toString();
	}

	@Override
	public String getNombre() {
		return nombre;
	}
}
