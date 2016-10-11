package tp.control;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.SpringLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JProgressBar;

public class MainFrame {

	private JFrame mainframe;
	private JTextField textField;
	private JPanel panelFijo;

	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {*/
			//public void run() {
				try {
					//ReadXMLFile.initialize();
					MainFrame window = new MainFrame();
					window.mainframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			//}
		/*});*/
	}

	public MainFrame() {
		initialize();
	}

	// private void cargarImagen() {
	// try {
	// resized = ImageIO
	// .read(new
	// File("C:\\Users\\Wall-E\\Downloads\\I_will_use_Google_before_asking_dumb_questions.jpg"));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	private void initialize() {
		mainframe = new JFrame();
		mainframe.getContentPane().setBackground(new Color(255, 255, 255));
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setSize(new Dimension(660, 400));
		mainframe.setMinimumSize(new Dimension(660, 400));
		crearPanelPrincipal();

		JPanel panelDinamico = new JPanel();
		
		JButton btnNewButton = new JButton("New button");
		
		JProgressBar progressBar = new JProgressBar();
		GroupLayout groupLayout = new GroupLayout(mainframe.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelFijo, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
				.addComponent(panelDinamico, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panelFijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(panelDinamico, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		mainframe.getContentPane().setLayout(groupLayout);

		mainframe.getContentPane().add(panelDinamico);
		panelDinamico.setLayout(null);
		JPanel panelConScroll = new JPanel();
		panelConScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelConScroll.setMaximumSize(new Dimension(10, 10));
		JScrollPane scroll = new JScrollPane(panelConScroll);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(0, 0, 644, 231);
		GridBagLayout gbl_panelConScroll = new GridBagLayout();
		gbl_panelConScroll.columnWidths = new int[]{638, 0};
		gbl_panelConScroll.rowHeights = new int[] {40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 0};
		gbl_panelConScroll.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelConScroll.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelConScroll.setLayout(gbl_panelConScroll);
//		PanelDeArchivo panelDeArchivo = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo = new GridBagConstraints();
//		gbc_panelDeArchivo.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo.gridx = 0;
//		gbc_panelDeArchivo.gridy = 0;
//		panelConScroll.add(panelDeArchivo, gbc_panelDeArchivo);
//		PanelDeArchivo panelDeArchivo_1 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_1 = new GridBagConstraints();
//		gbc_panelDeArchivo_1.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_1.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_1.gridx = 0;
//		gbc_panelDeArchivo_1.gridy = 1;
//		panelConScroll.add(panelDeArchivo_1, gbc_panelDeArchivo_1);
//		PanelDeArchivo panelDeArchivo_2 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_2 = new GridBagConstraints();
//		gbc_panelDeArchivo_2.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_2.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_2.gridx = 0;
//		gbc_panelDeArchivo_2.gridy = 2;
//		panelConScroll.add(panelDeArchivo_2, gbc_panelDeArchivo_2);
//		PanelDeArchivo panelDeArchivo_3 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_3 = new GridBagConstraints();
//		gbc_panelDeArchivo_3.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_3.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_3.gridx = 0;
//		gbc_panelDeArchivo_3.gridy = 3;
//		panelConScroll.add(panelDeArchivo_3, gbc_panelDeArchivo_3);
//		PanelDeArchivo panelDeArchivo_4 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_4 = new GridBagConstraints();
//		gbc_panelDeArchivo_4.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_4.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_4.gridx = 0;
//		gbc_panelDeArchivo_4.gridy = 4;
//		panelConScroll.add(panelDeArchivo_4, gbc_panelDeArchivo_4);
//		PanelDeArchivo panelDeArchivo_5 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_5 = new GridBagConstraints();
//		gbc_panelDeArchivo_5.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_5.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_5.gridx = 0;
//		gbc_panelDeArchivo_5.gridy = 5;
//		panelConScroll.add(panelDeArchivo_5, gbc_panelDeArchivo_5);
//		PanelDeArchivo panelDeArchivo_6 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_6 = new GridBagConstraints();
//		gbc_panelDeArchivo_6.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_6.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_6.gridx = 0;
//		gbc_panelDeArchivo_6.gridy = 6;
//		panelConScroll.add(panelDeArchivo_6, gbc_panelDeArchivo_6);
//		PanelDeArchivo panelDeArchivo_7 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_7 = new GridBagConstraints();
//		gbc_panelDeArchivo_7.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_7.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_7.gridx = 0;
//		gbc_panelDeArchivo_7.gridy = 7;
//		panelConScroll.add(panelDeArchivo_7, gbc_panelDeArchivo_7);
//		PanelDeArchivo panelDeArchivo_8 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_8 = new GridBagConstraints();
//		gbc_panelDeArchivo_8.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_8.insets = new Insets(0, 0, 5, 0);
//		gbc_panelDeArchivo_8.gridx = 0;
//		gbc_panelDeArchivo_8.gridy = 8;
//		panelConScroll.add(panelDeArchivo_8, gbc_panelDeArchivo_8);
//		PanelDeArchivo panelDeArchivo_9 = new PanelDeArchivo();
//		GridBagConstraints gbc_panelDeArchivo_9 = new GridBagConstraints();
//		gbc_panelDeArchivo_9.fill = GridBagConstraints.BOTH;
//		gbc_panelDeArchivo_9.gridx = 0;
//		gbc_panelDeArchivo_9.gridy = 9;
//		panelConScroll.add(panelDeArchivo_9, gbc_panelDeArchivo_9);
		
		panelDinamico.add(scroll);
	}

	private JPanel crearPanelPrincipal() {
		panelFijo = new JPanel();
		panelFijo.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("max(10dlu;default)"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("83px"), ColumnSpec.decode("518px"), },
				new RowSpec[] { RowSpec.decode("17px"), FormSpecs.LINE_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("20px"), FormSpecs.LINE_GAP_ROWSPEC,
						RowSpec.decode("22px"), }));

		JLabel label = new JLabel("");
		panelFijo.add(label, "3, 1, fill, fill");
		Choice choiceAplicacion = new Choice();
		choiceAplicacion.add("Elegí El programa a ser ejecutado");
		choiceAplicacion.add("Hola bebe");
		//ChoiceHandler choiceHandler= new ChoiceHandler();
		//choiceAplicacion.addPropertyChangeListener(choiceHandler);
		
		JLabel Aplicacion = new JLabel("Aplicaci\u00F3n:");
		Aplicacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelFijo.add(Aplicacion, "3, 3, default, fill");
		panelFijo.add(choiceAplicacion, "4, 3, fill, bottom");

		Choice choiceConfiguracion;
		choiceConfiguracion = new Choice();
		choiceConfiguracion.add("Elegí el setup del programa");
		choiceConfiguracion.add("BLAH");

		JLabel Configuracion = new JLabel("Configuraci\u00F3n:");
		Configuracion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panelFijo.add(Configuracion, "3, 5, left, fill");
		panelFijo.add(choiceConfiguracion, "4, 5, fill, bottom");
		//cargarChoiceApps(choiceAplicacion);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		NodeList listaApps;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse("XMLConfigMultiApp.xml");
			listaApps = doc.getElementsByTagName("app");
			for(int i=0;i<listaApps.getLength();i++) {
				Element t = (Element) listaApps.item(i);
				String titulo = t.getAttribute("tittle");
				choiceAplicacion.add(titulo);
				
					
			}
			choiceAplicacion.addItemListener(new ItemListener(){
				@Override
				public void itemStateChanged(ItemEvent e)
				{
					// TODO Leer choiceConfiguracion y generar las opciones	
					System.out.println(choiceAplicacion.getSelectedItem());
					int ind=choiceAplicacion.getSelectedIndex();
					System.out.println(ind);
					Element n1=(Element)listaApps.item(ind+2);//+2 por Elegir y Hola bebe...
					String st=n1.getTagName();
					//TODO Ver como sacar los datos de n1
					//usar listaApps para acceder a los datos.
				}
			});
//			choiceConfiguracion.addItemListener(new ItemListener(){
//				@Override
//				public void itemStateChanged(ItemEvent e)
//				{
//					System.out.println(choiceConfiguracion.getSelectedItem());
//					if(choiceConfiguracion.getSelectedItem().equals("Elegí el setup del programa"))
//						System.out.println("No hago nada");
//					else {
//						System.out.println("Genero el contenido del panelConScroll");
//					}
//				}
//			});
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return panelFijo;
	}

private void generarCampo(Node item)
	{
		// TODO Auto-generated method stub
		System.out.println(item.toString());
	}

private void cargarChoiceApps(Choice choiceApp) { //No se si es mejor hacerlo al momento de parsear el XML
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			try {
				builder = factory.newDocumentBuilder();
				Document doc = builder.parse("XMLConfigMultiApp.xml");
				NodeList listaApps = doc.getElementsByTagName("app");
				for(int i=0;i<listaApps.getLength();i++) {
					Element t = (Element) listaApps.item(i);
					String titulo = t.getAttribute("tittle");
					choiceApp.add(titulo);
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

