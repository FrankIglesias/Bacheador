
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import tp.ReadXMLFile;

public class XMLParserTest {
	@BeforeClass
	public static void init() {
		ReadXMLFile.initialize();
	}

	@Test
	public void testObtenerNombreDeApps() {
		List<String> nombres = ReadXMLFile.obtenerNobreDeAplicaciones();
		Assert.assertTrue(nombres.contains("Audio To Video"));
	}

	@Test
	public void testObtenerListasConjuntas() {
		Assert.assertTrue(ReadXMLFile.cargarConfigs("Audio To Video").contains("["));
	}
}
