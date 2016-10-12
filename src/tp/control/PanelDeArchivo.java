package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.MainFrame;

@SuppressWarnings("serial")
public class PanelDeArchivo extends JPanel {
	public GridBagConstraints gbc_panelDeArchivo;

	public PanelDeArchivo(String tipo, int i) {
		gbc_panelDeArchivo = new GridBagConstraints();
		gbc_panelDeArchivo.fill = GridBagConstraints.BOTH;
		gbc_panelDeArchivo.insets = new Insets(0, 0, 5, 0);
		gbc_panelDeArchivo.gridx = 0;
		gbc_panelDeArchivo.gridy = i;
		setBounds(2, 2, 638, 37);
		setLayout(null);
		JTextField textField = new JTextField("Ruta del archivo " + tipo.toUpperCase());
		textField.setBounds(10, 8, 559, 20);
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(573, 4, 49, 27);
		add(button);
	}
}
