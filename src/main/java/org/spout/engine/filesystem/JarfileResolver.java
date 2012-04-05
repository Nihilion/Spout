package org.spout.engine.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarfileResolver extends FilepathResolver  {
	public JarfileResolver() {
		super(FileSystem.pluginDirectory.getPath());
		// TODO Auto-generated constructor stub
	}

	File pluginsFolder = FileSystem.pluginDirectory;

	@Override
	public boolean existsInPath(String file, String path) {
		boolean has = false;
		JarFile f = null;
		try {
			f = new JarFile(directory + path);
			JarEntry entry = f.getJarEntry(file);
			has = entry != null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(f != null)
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		return has;
	}


	@Override
	public InputStream getStream(String file, String path) {
		JarFile f = null;
		FileInputStream stream = null;
		try {
			f = new JarFile(directory + path);
			JarEntry entry = f.getJarEntry(file);
			InputStream s = f.getInputStream(entry);
			return s; //TODO close the jar.
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(f != null)
				try {
					f.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		return stream;
	}

	
	
	
	
}