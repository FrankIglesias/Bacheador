package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tp.control.PanelDeArchivo;
import tp.control.PanelDeDuracion;

public class ReadXMLFile {
	private static File fXmlFile = new File("XMLConfigMultiApp.xml");
	private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder dBuilder;
	private static Document doc;
	private List<String> lista = new ArrayList<String>();

	public static void initialize() {
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static String cargarTituloApp() {
		return doc.getDocumentElement().getNodeName();
	}

	public static void cargarAplicaciones(JComboBox<String> chooser) {
		NodeList listaDeApps = doc.getElementsByTagName("app");
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			Element eElement = (Element) listaDeApps.item(temp);
			chooser.addItem(eElement.getAttribute("tittle"));
		}
	}

	public static List<String> obtenerNobreDeAplicaciones() {
		List<String> nombres = new ArrayList<>();
		NodeList listaDeApps = doc.getElementsByTagName("app");
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			Element eElement = (Element) listaDeApps.item(temp);
			nombres.add(eElement.getAttribute("tittle"));
		}
		return nombres;
	}

	public static String cargarConfigs(String app) {
		NodeList listaDeApps = doc.getElementsByTagName("app");
		Element aplicacionElegida = null;
		Element eElement;
		String retorno = "";
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			eElement = (Element) listaDeApps.item(temp);
			if (eElement.getAttribute("tittle").equals(app))
				aplicacionElegida = eElement;
		}
		NodeList controles = aplicacionElegida.getElementsByTagName("control");
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("label").equals("INPUT")) {
				retorno += "[" + eElement.getAttribute("name") + "]";

			}
		}
		retorno += "=";
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("label").equals("OUTPUT"))
				retorno += "[" + eElement.getAttribute("name") + "]";

		}
		return retorno;
	}

	public static String cargarConfiguracion(String app, JPanel panel) {
		NodeList listaDeApps = doc.getElementsByTagName("app");
		Element aplicacionElegida = null;
		Element eElement;
		String retorno = "";
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			eElement = (Element) listaDeApps.item(temp);
			if (eElement.getAttribute("tittle").equals(app))
				aplicacionElegida = eElement;
		}
		NodeList controles = aplicacionElegida.getElementsByTagName("control");
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("label").equals("INPUT")) {
				retorno += "[" + eElement.getAttribute("name") + "]";
			}
		}
		retorno += "=";
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("label").equals("OUTPUT"))
				retorno += "[" + eElement.getAttribute("name") + "]";

		}
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("class").equals("tp.control.PanelDeArchivo")) {
				PanelDeArchivo panelDeArchivo = new PanelDeArchivo(temp);
				panel.add(panelDeArchivo, panelDeArchivo.gbc_panelDeArchivo);
			} else if (eElement.getAttribute("class").equals("tp.control.PanelDeDuracion")) {
				PanelDeDuracion panelcito = new PanelDeDuracion(eElement.getAttribute("name"), 2);
				panel.add(panelcito, panelcito.gbc_panel);
			}
		}
		return retorno;
	}

	public static void joinControls(JComboBox<String> combo) {
	}
}