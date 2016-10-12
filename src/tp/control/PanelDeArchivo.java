package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tp.MainFrame;

@SuppressWarnings("serial")
public class PanelDeArchivo extends JPanel {
	public GridBagConstraints gbc_panelDeArchivo;
	String nombre;
	String value;

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
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(abrirArchivo());
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(573, 4, 49, 27);
		add(button);
	}

	private String abrirArchivo() {
		String texto = "";
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(this);
		texto = file.getSelectedFile().getAbsolutePath();
		return texto;
	}
}
