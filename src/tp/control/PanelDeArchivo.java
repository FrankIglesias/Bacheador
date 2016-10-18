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

	public PanelDeArchivo(Element eElement, int i) {
		this.tipoArch = eElement.getElementsByTagName("tipo-arch").item(0).getTextContent();
		this.nombre = eElement.getAttribute("name").toString();
		this.ruta = eElement.getElementsByTagName("def-dir").item(0).getTextContent();
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
				textField.setText(aux);
			}
		});
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(573, 4, 49, 27);
		add(button);
	}

	private String abrirArchivo() {
		String texto = "";
		JFileChooser file = new JFileChooser(
				System.getProperty("user.home") + System.getProperty("file.separator") + ruta);
		List<String> listaExtensiones = Arrays.asList(tipoArch.split(","));
		listaExtensiones.forEach(s -> file.addChoosableFileFilter(new FiltroDeArchivos(s)));
		file.showOpenDialog(this);
		texto = file.getSelectedFile().getAbsolutePath();
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
