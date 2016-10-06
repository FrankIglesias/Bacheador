package tp.control;

import java.awt.Choice;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLFile {
	private static final File fXmlFile = new File("/Users/mkyong/staff.xml");
	private static final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder dBuilder;
	private static Document doc;

	public static void initialize() {
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
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

	public static void cargarTituloApp(JFrame frame) {

		frame.setTitle(doc.getDocumentElement().getNodeName());

	}

	public void cargarAplicaciones(Choice chooser) {

		NodeList listaDeApps = doc.getElementsByTagName("app");

		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			Element eElement = (Element) listaDeApps.item(temp);
			chooser.add(eElement.getAttribute("tittle"));
		}
	}

	public void cargarConfiguraciones(Choice chooser) {

		NodeList listaDeApps = doc.getElementsByTagName("app");
		for (int temp = 0; temp < listaDeApps.getLength(); temp++) {
			Node config_app  =  listaDeApps.item(temp);
		}
	}
	// System.out
	// .println("First Name : " +
	// eElement.getElementsByTagName("firstname").item(0).getTextContent());
	// System.out.println("Last Name : " +
	// eElement.getElementsByTagName("lastname").item(0).getTextContent());
	// System.out.println("Nick Name : " +
	// eElement.getElementsByTagName("nickname").item(0).getTextContent());
	// System.out.println("Salary : " +
	// eElement.getElementsByTagName("salary").item(0).getTextContent());

}
