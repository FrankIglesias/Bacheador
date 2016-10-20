package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import tp.control.AyEDPanel;

public class MainFrame {
	private String appName;
	private JFrame mainframe;
	private JPanel panelSuperior;
	private JPanel panelConScroll;
	private JPanel panelInferior;
	public String command;
	private static JTextArea ventanaModal;
	JScrollPane scrollModal;
	JButton backButton;

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

		scrollModal = new JScrollPane();
		scrollModal.setOpaque(false);
		scrollModal.setVisible(false);
		scrollModal.setBounds(0, 92, 644, 232);
		mainframe.getContentPane().add(scrollModal);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventanaModal = new JTextArea();
		scrollModal.setViewportView(ventanaModal);
		ventanaModal.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		ventanaModal.setEnabled(false);
		ventanaModal.setEditable(false);
		ventanaModal.setVisible(false);
		ventanaModal.setOpaque(false);
		ventanaModal.setDisabledTextColor(new Color(100, 100, 100));
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

		backButton = new JButton("Atrás");
		backButton.setEnabled(false);
		backButton.setOpaque(false);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				backButton.setEnabled(false);
				backButton.setOpaque(false);
				ventanaModal.setEnabled(false);
				ventanaModal.setEditable(false);
				ventanaModal.setVisible(false);
				ventanaModal.setOpaque(false);
				scrollModal.setOpaque(false);
				scrollModal.setVisible(false);
				ventanaModal.setText("");
			}
		});
		backButton.setBounds(12, 7, 98, 26);
		panelInferior.add(backButton);

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
		JLabel configuraciones = new JLabel("");
		panelSuperior.add(configuraciones, "6, 5");
		JLabel Aplicacion = new JLabel("Aplicaci\u00F3n:");
		Aplicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSuperior.add(Aplicacion, "3, 3, left, fill");
		JLabel Configuracion = new JLabel("Configuraci\u00F3n:");
		Configuracion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelSuperior.add(Configuracion, "3, 5, left, fill");
		JComboBox<String> comboBoxAplicaciones = new JComboBox<String>();
		panelSuperior.add(comboBoxAplicaciones, "6, 3, fill, default");
		comboBoxAplicaciones.addItem("Elija un Programa");
		ReadXMLFile.cargarAplicaciones(comboBoxAplicaciones);
		comboBoxAplicaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxAplicaciones.getItemAt(0).equals("Elija un Programa"))
					comboBoxAplicaciones.removeItemAt(0);
				if (mainframe.getTitle().length() > 5) {
					panelConScroll.removeAll();
					panelConScroll.setVisible(false);
					panelConScroll.setVisible(true);
				}
				command = ReadXMLFile.getCommand(comboBoxAplicaciones.getSelectedItem().toString());
				mainframe.setTitle(appName + " - " + comboBoxAplicaciones.getSelectedItem().toString());
				configuraciones.setText(ReadXMLFile
						.cargarConfiguracion(comboBoxAplicaciones.getSelectedItem().toString(), panelConScroll));
			}
		});
	}

	private void crearPanelInferior() {
		panelInferior = new JPanel();
		panelInferior.setBounds(0, 321, 644, 40);
		panelInferior.setLayout(null);
		JButton botonComenzar = new JButton("Comenzar");
		JProgressBar progressBar = new JProgressBar();
		Thread threadBar = new Thread(new Runnable() {

			@Override
			public void run() {
				Boolean flag = true;
				while (flag) {
					for (int i = 0; i <= 100 && i >= 0; i++) {
						progressBar.setValue(i);
						if (Thread.currentThread().isInterrupted()) {
							return;
						}
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							return;
						}

					}
					for (int i = 100; i >= 0 && i <= 100; i--) {
						progressBar.setValue(i);
						if (Thread.currentThread().isInterrupted()) {
							return;
						}
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							return;
						}
					}
				}

			}
		});
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ventanaModal.setAutoscrolls(true);
					threadBar.start();
					ProcessBuilder builder = new ProcessBuilder(Arrays.asList(command.split(" ")));
					builder.redirectErrorStream(true);
					Process p = builder.start();
					BufferedReader readBuffer = new BufferedReader(new InputStreamReader(p.getInputStream()));
					ventanaModal.append(command + "\n");
					String line = null;
					while ((line = readBuffer.readLine()) != null) {
						ventanaModal.append(line + "\n");
						scrollModal.getVerticalScrollBar().setValue(scrollModal.getVerticalScrollBar().getMaximum());
					}
					if (p.exitValue() == 0) {
						threadBar.interrupt();
						ventanaModal.append("Proceso Finalizado con Exito! \n");
						scrollModal.getVerticalScrollBar().setValue(scrollModal.getVerticalScrollBar().getMaximum());

					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		botonComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int temp = 0; temp < panelConScroll.getComponentCount(); temp++) {
					AyEDPanel panel = (AyEDPanel) panelConScroll.getComponent(temp);
					String nombre = "[" + panel.getNombre() + "]";
					String value = panel.getValue();
					command = command.replace(nombre, " " + value + " ");
				}
				backButton.setEnabled(true);
				backButton.setOpaque(true);
				scrollModal.setVisible(true);
				scrollModal.setOpaque(true);
				ventanaModal.setVisible(true);
				ventanaModal.setOpaque(true);
				ventanaModal.setAutoscrolls(true);
				ventanaModal.setEditable(true);
				thread.start();
			}
		});

		progressBar.setBounds(120, 7, 404, 26);
		panelInferior.add(progressBar);
		botonComenzar.setBounds(534, 7, 98, 26);
		panelInferior.add(botonComenzar);
	}
}
