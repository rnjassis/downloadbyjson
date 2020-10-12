package br.com.self.downloadbyjson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FolderUtils {
	public static final String downloadedPath = new File("").getAbsolutePath() + "\\downloaded\\";
	public static final String toDownloadPath = new File("").getAbsolutePath() + "\\toDownload\\";

	public static void configure() throws Exception {
		checkIfHasDownloadFolder();
		checkIfHasToDownloadFolder();
	}
	
	public static void checkIfHasDownloadFolder() throws IOException {
		try {
			Path path = Paths.get(downloadedPath);
			if(Files.notExists(path)) {
				Files.createDirectories(path);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkIfHasToDownloadFolder() throws Exception {
		Path path = Paths.get(toDownloadPath);
		if(Files.notExists(path)) {
			throw new Exception("json folder(\"toDownload\") not found. Exiting");
		}
	}
	
	public static void createNewFolder(String folderName) throws IOException {
		Path path = Paths.get(downloadedPath+"\\"+folderName);
		if(Files.notExists(path)) {
			Files.createDirectories(path);
		}
	}
}
