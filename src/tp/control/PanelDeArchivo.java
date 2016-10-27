package tp.control;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.Element;

import tp.MainFrame;

@SuppressWarnings("serial")
public class PanelDeArchivo extends JPanel implements AyEDPanel {
	public GridBagConstraints gbc_panelDeArchivo;
	private String nombre;
	private JTextField textField;
	private String tipoArch;
	private String ruta;
	private String tipoCampo;

	public PanelDeArchivo(Element eElement, int i) {
		this.tipoArch = eElement.getElementsByTagName("tipo-arch").item(0).getTextContent();
		this.nombre = eElement.getAttribute("name").toString();
		this.ruta = eElement.getElementsByTagName("def-dir").item(0).getTextContent();
		this.tipoCampo = eElement.getAttribute("label").toString();
		gbc_panelDeArchivo = new GridBagConstraints();
		gbc_panelDeArchivo.fill = GridBagConstraints.BOTH;
		gbc_panelDeArchivo.insets = new Insets(0, 0, 5, 0);
		gbc_panelDeArchivo.gridx = 0;
		gbc_panelDeArchivo.gridy = i;
		setBounds(2, 2, 638, 37);
		setLayout(null);
		textField = new JTextField("Seleccione un archivo del tipo: " + tipoArch.toUpperCase());
		textField.setBounds(10, 8, 559, 20);
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String aux = abrirArchivo();
				if (!aux.equals(""))
					textField.setText(aux);
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(573, 4, 49, 27);
		add(button);
	}

	private String abrirArchivo() {
		Boolean result = true;
		int seleccion = 0;
		String texto = "";
		while (result) {
			JFileChooser file = new JFileChooser(
					System.getProperty("user.home") + System.getProperty("file.separator") + ruta);
			List<String> listaExtensiones = Arrays.asList(tipoArch.split(","));
			file.removeChoosableFileFilter(file.getFileFilter());
			listaExtensiones.forEach(s -> file.addChoosableFileFilter(new FiltroDeArchivos(s, nombre)));
			if (tipoCampo.equals("INPUT"))
				seleccion = file.showOpenDialog(this);
			else if (tipoCampo.equals("OUTPUT")) {
				seleccion = file.showSaveDialog(this);
				if (file.getSelectedFile().exists() && seleccion != JFileChooser.CANCEL_OPTION) {
					int i = JOptionPane.showConfirmDialog(file,
							"El archivo que ud seleccionó ya existe por favor ingrese otro", "New File Name",
							JOptionPane.OK_CANCEL_OPTION);
					if (i == JOptionPane.CANCEL_OPTION) {
						file.cancelSelection();
						return "";
					}
				}
			} else {
			}
			if (seleccion == JFileChooser.CANCEL_OPTION) {
				return "";
			}
			if (!listaExtensiones.stream().anyMatch(e -> file.getSelectedFile().getAbsolutePath().endsWith(e))) {
				JOptionPane.showMessageDialog(file, "Extension invalida del archivo");
			} else {

				texto = file.getSelectedFile().getAbsolutePath();
				result = false;
			}
		}
		return texto;

	}

	public String getValue() {
		return textField.getText();
	}

	@Override
	public String getNombre() {
		return nombre;
	}
}
