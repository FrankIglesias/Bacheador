package tp.control;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FiltroDeArchivos extends FileFilter {
	private String extension;
	private String description;

	public FiltroDeArchivos(String extension) {
		this.extension = extension;
		this.description = "Archivo del  tipo" + extension;
	}

	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}

	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}
