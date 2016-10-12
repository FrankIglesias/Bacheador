package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import tp.control.AyEDPanel;
import javax.swing.JTextPane;

public class MainFrame {
	private String appName;
	private JFrame mainframe;
	private JPanel panelSuperior;
	private JPanel panelConScroll;
	private JPanel panelInferior;
	public String command;
	JTextPane ventanaModal;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		ReadXMLFile.initialize();
		mainframe = new JFrame();
		mainframe.getContentPane().setBackground(new Color(255, 255, 255));
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setSize(new Dimension(660, 400));
		mainframe.setMinimumSize(new Dimension(660, 400));
		mainframe.setMaximumSize(new Dimension(660, 400));
		crearPanelSuperior();
		crearPanelInferior();
		JPanel panelDinamico = new JPanel();
		panelDinamico.setBounds(0, 92, 644, 232);
		appName = ReadXMLFile.cargarTituloApp();
		mainframe.setTitle(appName);
		mainframe.getContentPane().setLayout(null);
		
		ventanaModal = new JTextPane();
		ventanaModal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ventanaModal.setEnabled(false);
		ventanaModal.setEditable(false);
		ventanaModal.setVisible(false);
		ventanaModal.setOpaque(false);
		ventanaModal.setBounds(0, 92, 644, 232);
		mainframe.getContentPane().add(ventanaModal);
		mainframe.getContentPane().add(panelDinamico);
		panelDinamico.setLayout(null);
		panelConScroll = new JPanel();
		panelConScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelConScroll.setMaximumSize(new Dimension(10, 10));
		JScrollPane scroll = new JScrollPane(panelConScroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 0, 644, 231);
		GridBagLayout gbl_panelConScroll = new GridBagLayout();
		gbl_panelConScroll.columnWidths = new int[] { 638, 0 };
		gbl_panelConScroll.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0 };
		gbl_panelConScroll.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panelConScroll.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelConScroll.setLayout(gbl_panelConScroll);

		panelDinamico.add(scroll);
		mainframe.getContentPane().add(panelDinamico);
		mainframe.getContentPane().add(panelSuperior);
		mainframe.getContentPane().add(panelInferior);

	}

	private void crearPanelSuperior() {
		panelSuperior = new JPanel();
		panelSuperior.setBounds(0, 0, 644, 93);
		panelSuperior.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(10dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("83px"), FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("464px:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { RowSpec.decode("17px"), FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"), }));

		JLabel Aplicacion = new JLabel("Aplicaci\u00F3n:");
		Aplicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSuperior.add(Aplicacion, "3, 3, left, fill");
		JLabel Configuracion = new JLabel("Configuraci\u00F3n:");
		Configuracion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSuperior.add(Configuracion, "3, 5, left, fill");
		JComboBox<String> comboBoxConfiguraciones = new JComboBox<String>();
		JComboBox<String> comboBoxAplicaciones = new JComboBox<String>();
		panelSuperior.add(comboBoxAplicaciones, "6, 3, fill, default");
		panelSuperior.add(comboBoxConfiguraciones, "6, 5, fill, default");
		ReadXMLFile.cargarAplicaciones(comboBoxAplicaciones);
		comboBoxAplicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainframe.getTitle().length() > 5) {
					panelConScroll.removeAll();
					comboBoxConfiguraciones.removeAllItems();
				}
				command = ReadXMLFile.getCommand(comboBoxAplicaciones.getSelectedItem().toString());
				mainframe.setTitle(appName + " - " + comboBoxAplicaciones.getSelectedItem().toString());
				comboBoxConfiguraciones.addItem(ReadXMLFile
						.cargarConfiguracion(comboBoxAplicaciones.getSelectedItem().toString(), panelConScroll));
			}
		});
	}

	private void crearPanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setBounds(0, 321, 644, 40);
		panelInferior.setLayout(null);
		JButton botonComenzar = new JButton("Comenzar");
		botonComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int temp = 0; temp < panelConScroll.getComponentCount(); temp++) {
					AyEDPanel panel = (AyEDPanel) panelConScroll.getComponent(temp);
					String nombre = "[" + panel.getNombre() + "]";
					String value = panel.getValue();
					command = command.replace(nombre," "+ value+ " ");
				}
				ventanaModal.setVisible(true);
				ventanaModal.setOpaque(true);
				JOptionPane.showMessageDialog(null, command);
			}

		});
		botonComenzar.setBounds(534, 7, 98, 26);
		panelInferior.add(botonComenzar);
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 7, 510, 26);
		panelInferior.add(progressBar);

	}
}
