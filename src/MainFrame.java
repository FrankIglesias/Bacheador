import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JTextPane;

public class MainFrame {

	private JFrame frmAgyeda;
	private JTextField textField;
	private BufferedImage resized;
	private JTextField textoAngulo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frmAgyeda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		initialize();
	}

	private void cargarImagen() {
		try {
			resized = ImageIO
					.read(new File("C:\\Users\\Wall-E\\Downloads\\I_will_use_Google_before_asking_dumb_questions.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initialize() {
		frmAgyeda = new JFrame();
		frmAgyeda.getContentPane().setBackground(new Color(255, 255, 255));
		frmAgyeda.setTitle("AyEDA");
		frmAgyeda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dimensionMinima = new Dimension(660, 400);
		frmAgyeda.setSize(dimensionMinima);
		frmAgyeda.setMinimumSize(dimensionMinima);
		frmAgyeda.getContentPane().setLayout(null);
		JPanel panelFijo = new JPanel();
		panelFijo.setBounds(0, 0, 645, 96);
		frmAgyeda.getContentPane().add(panelFijo);
		SpringLayout sl_panelFijo = new SpringLayout();
		panelFijo.setLayout(sl_panelFijo);

		JLabel Aplicacion = new JLabel("Aplicaci\u00F3n");
		panelFijo.add(Aplicacion);

		Choice choiceAplicacion = new Choice();

		choiceAplicacion.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
			}
		});

		choiceAplicacion.add("Elegí El programa a ser ejecutado");
		choiceAplicacion.add("Hola bebe");
		panelFijo.add(choiceAplicacion);

		JLabel Configuracion = new JLabel("Configuraci\u00F3n");
		sl_panelFijo.putConstraint(SpringLayout.NORTH, Configuracion, 55, SpringLayout.NORTH, panelFijo);
		sl_panelFijo.putConstraint(SpringLayout.SOUTH, Aplicacion, -11, SpringLayout.NORTH, Configuracion);
		sl_panelFijo.putConstraint(SpringLayout.WEST, Configuracion, 10, SpringLayout.WEST, panelFijo);
		sl_panelFijo.putConstraint(SpringLayout.WEST, Aplicacion, 0, SpringLayout.WEST, Configuracion);
		panelFijo.add(Configuracion);

		Choice choiceConfiguracion = new Choice();
		choiceConfiguracion.add("Elegí el setup del programa");
		sl_panelFijo.putConstraint(SpringLayout.NORTH, choiceConfiguracion, 50, SpringLayout.NORTH, panelFijo);
		sl_panelFijo.putConstraint(SpringLayout.SOUTH, choiceConfiguracion, -27, SpringLayout.SOUTH, panelFijo);
		sl_panelFijo.putConstraint(SpringLayout.WEST, choiceAplicacion, 0, SpringLayout.WEST, choiceConfiguracion);
		sl_panelFijo.putConstraint(SpringLayout.SOUTH, choiceAplicacion, -6, SpringLayout.NORTH, choiceConfiguracion);
		sl_panelFijo.putConstraint(SpringLayout.EAST, choiceAplicacion, 0, SpringLayout.EAST, choiceConfiguracion);
		sl_panelFijo.putConstraint(SpringLayout.WEST, choiceConfiguracion, 10, SpringLayout.EAST, Configuracion);
		sl_panelFijo.putConstraint(SpringLayout.EAST, choiceConfiguracion, -10, SpringLayout.EAST, panelFijo);
		panelFijo.add(choiceConfiguracion);

		JPanel panel = new JPanel();
		panel.setBounds(0, 310, 644, 51);
		frmAgyeda.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JProgressBar BarraProgreso = new JProgressBar();
		sl_panel.putConstraint(SpringLayout.NORTH, BarraProgreso, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, BarraProgreso, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, BarraProgreso, -10, SpringLayout.SOUTH, panel);
		panel.add(BarraProgreso);
		BarraProgreso.setStringPainted(true);
		cargarImagen();
		JButton btnNewButton = new JButton(new ImageIcon(resized));
		sl_panel.putConstraint(SpringLayout.EAST, BarraProgreso, -6, SpringLayout.WEST, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 482, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -6, SpringLayout.EAST, panel);
		panel.add(btnNewButton);
		// EL TAMAÑO INICIAL DEL PRIMER BLOQUE ES 95 Y LUEGO SE LE VAN SUMANDO
		// DE A 40
		panelFijo.setAutoscrolls(true);
		
		JTextPane textoConsola = new JTextPane();
		textoConsola.setEnabled(false);
		textoConsola.setEditable(false);
		textoConsola.setBounds(0, 94, 644, 215);
		frmAgyeda.getContentPane().add(textoConsola);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 96, 644, 40);
		frmAgyeda.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		JButton rotarDerecha = new JButton("");
		rotarDerecha.setBounds(306, 8, 24, 24);
		panel_1.add(rotarDerecha);
		textoAngulo = new JTextField();
		textoAngulo.setHorizontalAlignment(SwingConstants.CENTER);
		textoAngulo.setBounds(341, 8, 35, 24);
		panel_1.add(textoAngulo);
		textoAngulo.setColumns(10);	
		JButton rotarIzquierda = new JButton("");
		rotarIzquierda.setBounds(273, 8, 24, 24);
		panel_1.add(rotarIzquierda);
		
	}

	private JPanel GenerarPanelDeArchivo(int height) {
		JPanel PanelDeArchivo = new JPanel();
		PanelDeArchivo.setBounds(0, height, 644, 40);
		PanelDeArchivo.setLayout(null);
		textField = new JTextField();
		textField.setBounds(10, 10, 585, 20);
		textField.setEditable(false);
		PanelDeArchivo.add(textField);
		textField.setColumns(10);
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(MainFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		button.setBounds(601, 10, 33, 20);
		PanelDeArchivo.add(button);
		return PanelDeArchivo;
	}
}
