package br.com.self.downloadbyjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class DownloadFiles {
	
    public void download(JSONArray toDownload, String folderPath) {
        for(int i = 0; i < toDownload.size(); i++){
            try {
                JSONObject obj = (JSONObject)toDownload.get(i);
                String jsonNome = (String)obj.get("name");
                String jsonLink = (String)obj.get("link");
                
                URL url = new URL(jsonLink);
                ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
                
                FolderUtils.createNewFolder(folderPath);
                
                File fileSaved = new File(FolderUtils.downloadedPath+"\\"+folderPath+"\\"+jsonNome+getExtension(jsonLink));
                
                FileOutputStream fileOutputStream = new FileOutputStream(fileSaved);
                FileChannel fileChannel = fileOutputStream.getChannel();
                
                fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
                
                fileChannel.close();
                fileOutputStream.close();
            } catch(IOException e) {
                System.out.println("falha ioexception " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    private String getExtension(String link) {
    	String[] linkSplitted =  link.split("\\.");
    	return String.format(".%s",linkSplitted[linkSplitted.length-1]);
    }
}
