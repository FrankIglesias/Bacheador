package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import tp.control.PanelDeArchivo;
import tp.control.PanelDeDuracion;

public class MainFrame {
	private String appName;
	private JFrame mainframe;
	private JPanel panelFijo;
	private JPanel panelConScroll;

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
		crearPanelPrincipal();
		JPanel panelDinamico = new JPanel();
		appName = ReadXMLFile.cargarTituloApp();
		mainframe.setTitle(appName);
		JButton botonComenzar = new JButton("New button");
		JProgressBar progressBar = new JProgressBar();
		GroupLayout groupLayout = new GroupLayout(mainframe.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelFijo, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelDinamico, GroupLayout.PREFERRED_SIZE, 644,
						GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
								.addComponent(botonComenzar).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panelFijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup().addGap(92).addComponent(panelDinamico,
										GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(botonComenzar)
								.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		mainframe.getContentPane().setLayout(groupLayout);
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
		gbl_panelConScroll.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelConScroll.setLayout(gbl_panelConScroll);
		panelDinamico.add(scroll);
	}

	private JPanel crearPanelPrincipal() {
		panelFijo = new JPanel();
		panelFijo.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(10dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("83px"), FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("464px:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { RowSpec.decode("17px"), FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"), }));

		JLabel Aplicacion = new JLabel("Aplicaci\u00F3n:");
		Aplicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelFijo.add(Aplicacion, "3, 3, left, fill");
		JLabel Configuracion = new JLabel("Configuraci\u00F3n:");
		Configuracion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelFijo.add(Configuracion, "3, 5, left, fill");
		JComboBox<String> comboBoxConfiguraciones = new JComboBox<String>();
		JComboBox<String> comboBoxAplicaciones = new JComboBox<String>();
		panelFijo.add(comboBoxAplicaciones, "6, 3, fill, default");
		panelFijo.add(comboBoxConfiguraciones, "6, 5, fill, default");
		ReadXMLFile.cargarAplicaciones(comboBoxAplicaciones);
		comboBoxAplicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mainframe.getTitle().length() > 5) {
					panelConScroll.removeAll();
					comboBoxConfiguraciones.removeAllItems();
				}
				mainframe.setTitle(appName + " - " + comboBoxAplicaciones.getSelectedItem().toString());
				comboBoxConfiguraciones.addItem(ReadXMLFile
						.cargarConfiguracion(comboBoxAplicaciones.getSelectedItem().toString(), panelConScroll));
			}
		});

		return panelFijo;
	}
}
