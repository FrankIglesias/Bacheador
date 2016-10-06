package tp.control;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelDeArchivo extends JPanel {
	
	public PanelDeArchivo() {

		setBounds(2, 2, 638, 37);
		setLayout(null);
		JTextField textField = new JTextField("Ruta del archivo wav");
		textField.setBounds(10, 8, 559, 20);
		textField.setEditable(false);
		add(textField);
		textField.setColumns(10);
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(579, 4, 49, 27);
		add(button);
	}
}
