
import java.util.Arrays;
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
	public void testObtenerComando() {
		Assert.assertTrue(ReadXMLFile.getCommand("Audio To Video").contains(
				"-i [AUDIO] -max [TIEMPO] -loop 1 -i [IMAGE] -vcodec libx264 -preset slow -crf 20 -threads 0 -acodec copy -shortest [VIDEO]"));
	}

	@Test
	public void testreplace() {
		String str  = "1,2,3,4,5";
		List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
		Assert.assertTrue(items.contains("1"));
		
	}
}
