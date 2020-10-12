package br.com.self.downloadbyjson;

import org.json.simple.JSONArray;

public class App {
	public static void main(String args[]) {
		try {
			FolderUtils.configure();

			ReadJson readJsonFiles = new ReadJson();
			DownloadFiles downloadFiles = new DownloadFiles();
			String[] JsonFiles = readJsonFiles.getListOfFiles();

			for (String file : JsonFiles) {
				JSONArray jsonLoaded = readJsonFiles.loadFile(file);
				downloadFiles.download(jsonLoaded, file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
