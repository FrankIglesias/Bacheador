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
import tp.control.PanelDeRotacion;
import tp.control.PanelVariosArchivos;

class ReadXMLFile {
	private static File fXmlFile = new File("XMLConfigMultiApp.xml");
	private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder dBuilder;
	private static Document doc;

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
				retorno += " [" + eElement.getAttribute("name") + "] +";
			}
		}

		retorno = retorno.substring(0, retorno.lastIndexOf("+"));
		retorno += "=";
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("label").equals("OUTPUT"))
				retorno += " [" + eElement.getAttribute("name") + "] +";
		}
		retorno = retorno.substring(0, retorno.lastIndexOf("+"));
		for (int temp = 0; temp < controles.getLength(); temp++) {
			eElement = (Element) controles.item(temp);
			if (eElement.getAttribute("class").equals("tp.control.PanelDeArchivo")) {
				PanelDeArchivo panelDeArchivo = new PanelDeArchivo(eElement, temp);
				panel.add(panelDeArchivo, panelDeArchivo.gbc_panelDeArchivo);
			} else if (eElement.getAttribute("class").equals("tp.control.PanelDeDuracion")) {
				PanelDeDuracion panelcito = new PanelDeDuracion(eElement.getAttribute("name"), temp);
				panel.add(panelcito, panelcito.gbc_panel);
			} else if (eElement.getAttribute("class").equals("tp.control.PanelDeRotacion")) {
				PanelDeRotacion panelcito = new PanelDeRotacion(eElement.getAttribute("name").toString(), temp);
				panel.add(panelcito, panelcito.gbc_panel);
			} else if (eElement.getAttribute("class").equals("tp.control.PanelVariosArchivos")) {
				PanelVariosArchivos panelcito = new PanelVariosArchivos(eElement, temp);
				panel.add(panelcito, panelcito.gbc_panelDeArchivo);
			
			}

		}

		return retorno;
	}

	public static String getCommand(String string) {
		NodeList listaDeApps = doc.getElementsByTagName("app");
		Element aplicacionElegida = null;
		Element eElement = null;
		String retorno = "";
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			eElement = (Element) listaDeApps.item(temp);
			if (eElement.getAttribute("tittle").equals(string))
				aplicacionElegida = eElement;
		}
		aplicacionElegida = (Element) aplicacionElegida.getElementsByTagName("command").item(0);
		retorno = aplicacionElegida.getAttribute("name");
		retorno += aplicacionElegida.getAttribute("params");
		return retorno;
	}
}